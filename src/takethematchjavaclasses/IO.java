/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package takethematchjavaclasses;

/**
 *
 * @author John
 */
import java.io.*;
public class IO {

    public static void ausgabe(Object line) {
        System.out.println(line);
    }

    public static String eingabe(String message) {
        String eingabe = null;
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        ausgabe(message);
        try {
            eingabe = in.readLine();
        } catch (IOException ex) {
        }
        return eingabe;
    }

    public static int eingabeInteger(String message) {
        int eingabe;
        eingabe = Integer.parseInt(eingabe(message));
        return eingabe;
    }

    public static double eingabeDouble(String message) {
        Double eingabe;
        eingabe = Double.parseDouble(eingabe(message));
        return eingabe;
    }
}

