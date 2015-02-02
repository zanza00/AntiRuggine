package DailyChallenge.WordBattle;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by @Simone on 23/01/2015.
 * r/dailyprogrammer Challenge #198 [easy]
 * redd.it/2syz7y
 */

public class BattleFor {

    private static PrintStream ps = new PrintStream(System.out);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        ps.println("write two words separated by space or \"exit\"");
        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] str_array = input.split(" ");

            WordBattle wordBattle = new WordBattle(str_array[0], str_array[1]).battle();

            wordBattle.scoringSystem();

            ps.println("enter another two words or \"exit\"");
        } while (!input.equalsIgnoreCase("exit"));


    }

    private static class WordBattle {
        private String firstString;
        private String secondString;

        public WordBattle(String firstString, String secondString) {
            this.firstString = firstString;
            this.secondString = secondString;
        }

        public WordBattle battle() {
            battle(firstString, secondString);
            return this;
        }

        public void battle(String string1, String string2) {
            for (int i = 0; i < string1.length(); i++) {
                for (int j = 0; j < string2.length(); j++) {
                    if (string1.charAt(i) == string2.charAt(j)) {
                        firstString = string1.substring(0, i) + string1.substring(i + 1);
                        secondString = string2.substring(0, j) + string2.substring(j + 1);
                        battle(firstString, secondString);
                        return;
                    }
                }
            }
        }

        private void scoringSystem() {
            if (firstString.length() == secondString.length()) {
                ps.println("draw");
            } else {
                ps.println(firstString.length() > secondString.length() ? "first win" : "second win");
            }
        }
    }
}
