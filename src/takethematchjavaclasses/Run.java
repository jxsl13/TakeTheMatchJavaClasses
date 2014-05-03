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
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating game engine  
        // settings: maximum matches to draw at once, max matches, playerStart: whether the player or the ai starts, inverse gameplay?, hardness 1~3 
        //
        //
        int maxMatchesToDrawAtOnce = 3;
        int matchesLimit = 20;
        boolean playStarts = true;
        boolean inversedGameplay = false;
        byte hardness = 3;
        boolean useRandomFactor = true;
                
        TakeTheMatchEngine Game = new TakeTheMatchEngine(maxMatchesToDrawAtOnce, matchesLimit, playStarts, inversedGameplay, hardness, useRandomFactor);
        System.out.println("New Game Created Successfully!");

        if (inversedGameplay == false) {
            if (maxMatchesToDrawAtOnce > 1) {
                System.out.println("Draw up to " + maxMatchesToDrawAtOnce + " matches at once, but at least 1. The first one to reach 0 matches wins.");
            } else {
                System.out.println("Draw up to " + maxMatchesToDrawAtOnce + " match at once, but at least 1. The first one to reach 0 matches wins.");

            }
        } else {
            if (inversedGameplay == false) {
                if (maxMatchesToDrawAtOnce > 1) {
                    System.out.println("Draw up to " + maxMatchesToDrawAtOnce + " matches at once, but at least 1. The first one to reach 0 matches looses.");
                } else {
                    System.out.println("Draw up to " + maxMatchesToDrawAtOnce + " match at once, but at least 1. The first one to reach 0 matches looses.");

                }
            }
        }
        if (Game.getInvertedStart()) {
            System.out.println("Matches: " + Game.getMatchesLeft());
            Game.playInverseStart();
            IO.ausgabe("Your opponent drew: " + Game.getAiPlayerMatchesDrawn());
        }

        while (Game.getGameRunStatus()) {
            System.out.println("Matches left: " + Game.getMatchesLeft());
            try {
                int draw = IO.eingabeInteger("Input the number of matches you want to draw:");
                Game.play(draw);
                if (Game.checkMatchesToDraw(draw)) {

                    IO.ausgabe("You drew: " + Game.getPlayerMatchesDrawn());
                    IO.ausgabe("Your opponent drew: " + Game.getAiPlayerMatchesDrawn());

                }

                if (!Game.getGameRunStatus()) {
                    if (Game.getPlayerWonTheGame()) {
                        System.out.println("You won!");
                    } else {
                        System.out.println("Your opponent won!");
                    }
                    break;
                }

            } catch (Exception ex) {
                System.out.println("Enter a valid number!");
            }

        }

    }

}
