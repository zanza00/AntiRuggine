package DailyChallenge.BankPrinter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by @Simone on 27/01/2015.
 * <p>
 * http://redd.it/2tr6yn
 */

//  _  _     _  _  _  _  _
//| _| _||_||_ |_   ||_||_|
//||_  _|  | _||_|  ||_| _|

public class BankPrinter {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("write number");
        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("exit"))  break;

            ArrayList<Integer> intNum = new ArrayList<>();
            for (char e : input.toCharArray()) if (Character.isDigit(e)) intNum.add(Character.getNumericValue(e));

            BigDigit[] result = BigDigit.getBigDigitArrays(intNum);
            BigDigit.printNumberArray(result);
            System.out.println("enter another");
        } while (!input.equalsIgnoreCase("exit"));
    }
}

    class BigDigit {

        int digit;
        String upperLine, middleLine, bottomLine;

        public BigDigit(int digit) {
            this.digit = digit;
            processNumber();
        }



        private void processNumber() {
            switch (digit) {
                case 0:
                    upperLine   = " _ ";
                    middleLine  = "| |";
                    bottomLine  = "|_|";
                    break;
                case 1:
                    upperLine   = "   ";
                    middleLine  = " | ";
                    bottomLine  = " | ";
                    break;
                case 2:
                    upperLine   = " _ ";
                    middleLine  = " _|";
                    bottomLine  = "|_ ";
                    break;
                case 3:
                    upperLine   = " _ ";
                    middleLine  = " _|";
                    bottomLine  = " _|";
                    break;
                case 4:
                    upperLine   = "   ";
                    middleLine  = "|_|";
                    bottomLine  = "  |";
                    break;
                case 5:
                    upperLine   = " _ ";
                    middleLine  = "|_ ";
                    bottomLine  = " _|";
                    break;
                case 6:
                    upperLine   = " _ ";
                    middleLine  = "|_ ";
                    bottomLine  = "|_|";
                    break;
                case 7:
                    upperLine   = " _ ";
                    middleLine  = "  |";
                    bottomLine  = "  |";
                    break;
                case 8:
                    upperLine   = " _ ";
                    middleLine  = "|_|";
                    bottomLine  = "|_|";
                    break;
                case 9:
                    upperLine   = " _ ";
                    middleLine  = "|_|";
                    bottomLine  = " _|";
                    break;
            }
            upperLine   += " ";
            middleLine  += " ";
            bottomLine  += " ";

        }

        public String getUpperLine() {
            return upperLine;
        }

        public String getMiddleLine() {
            return middleLine;
        }

        public String getBottomLine() {
            return bottomLine;
        }

        public static BigDigit[] getBigDigitArrays(ArrayList<Integer> array) {
            int[] intArray = new int[array.size()];
            for (int i = 0; i < intArray.length; i++) intArray[i] = array.get(i);
            return getBigDigitArray(intArray);
        }

        private static BigDigit[] getBigDigitArray(int[] array) {
            BigDigit[] result = new BigDigit[array.length];
            for (int i = 0; i < result.length; i++) result[i] = new BigDigit(array[i]);
            return result;
        }

        public static void printNumberArray(BigDigit[] result) {
            String upperLine = "", middleLine ="", bottomLine = "";
            for (BigDigit e : result) {
                upperLine   += e.getUpperLine();
                middleLine  += e.getMiddleLine();
                bottomLine  += e.getBottomLine();
            }
            System.out.println(upperLine + "\n" + middleLine + "\n" + bottomLine);
        }
    }

