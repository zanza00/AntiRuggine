package DailyChallenge.WordBattle;

import java.util.Scanner;

/**
 * Created by @Simone on 23/01/2015.
 * r/dailyprogrammer Challenge #198 [easy]
 * redd.it/2syz7y
 */

public class BattleFor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("write two words separated by space or \"exit\"");
        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit"))  break;



            String[] str_array = input.split(" ");
            String firstString = str_array[0];
            String secondString = str_array[1];

            for(int i = 0; i < firstString.length(); i++) {
                for(int j = 0; j < secondString.length(); j++) {
                    if (firstString.charAt(i) == secondString.charAt(j)) {
                        firstString = firstString.substring(0, i) + firstString.substring(i + 1);
                        secondString = secondString.substring(0, j) + secondString.substring(j + 1);
                    }
                }
            }

//          scoring system
            if (firstString.length() == secondString.length()) {
                System.out.println("draw");
            } else {
                System.out.println(firstString.length() > secondString.length() ? "first win" : "second win");
            }

                System.out.println("enter another two words or \"exit\"");
            } while (!input.equalsIgnoreCase("exit"));



    }



}
