package DailyChallenge.WordBattle;

/**
 * Created by @Simone on 23/01/2015.
 * r/dailyprogrammer Challenge #198 [easy]
 * redd.it/2syz7y
 */
public class BattleFor {

    public static void main(String[] args) {
        //TODO insert scanner
        String firstString = "hello";
        String secondString = "below";

        for(int i = 0; i < firstString.length(); i++) {
            for(int j = 0; j < secondString.length(); j++) {
                if (firstString.charAt(i) == secondString.charAt(j)) {
                    firstString = firstString.substring(0, i) + firstString.substring(i + 1);
                    secondString = secondString.substring(0, j) + secondString.substring(j + 1);
                }
            }
        }


        System.out.println(firstString);
        System.out.println(secondString);

        if (firstString.length() == secondString.length()) System.out.println("draw");
        System.out.println(firstString.length() > secondString.length() ? "first win" : "second win");



    }



}
