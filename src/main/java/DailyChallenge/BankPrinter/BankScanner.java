package DailyChallenge.BankPrinter;

import java.util.Scanner;
import java.util.ArrayList;

public class BankScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] makeUp = new String[][]{
                {" _ ", "| |", "|_|"},  // 0
                {"   ", "  |", "  |"},  // 1
                {" _ ", " _|", "|_ "},  // 2
                {" _ ", " _|", " _|"},  // 3
                {"   ", "|_|", "  |"},  // 4
                {" _ ", "|_ ", " _|"},  // 5
                {" _ ", "|_ ", "|_|"},  // 6
                {" _ ", "  |", "  |"},  // 7
                {" _ ", "|_|", "|_|"},  // 8
                {" _ ", "|_|", " _|"}   // 9
        };

        String top = scan.nextLine();
        String mid = scan.nextLine();
        String bot = scan.nextLine();

        String[][] nums = new String[3][9];
        for(int i=0; i<9*3; i+=3){
            nums[0][i/3] = top.substring(i, i+3);
            nums[1][i/3] = mid.substring(i, i+3);
            nums[2][i/3] = bot.substring(i, i+3);
        }

        ArrayList<ArrayList<Integer>> possible = new ArrayList();
        for(int i=0; i<9; i++){
            possible.add(new ArrayList());
            for(int j=0; j<=9; j++){
                possible.get(i).add(j);
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<9; j++){
                for(int k=0; k<possible.get(j).size(); k++){
                    if(!makeUp[possible.get(j).get(k)][i].equals(nums[i][j])){
                        possible.get(j).remove(k);
                        k--;
                    }
                }
            }
        }

        for(int i=0; i<9; i++){
            System.out.print(possible.get(i).get(0));
        }
    }
}