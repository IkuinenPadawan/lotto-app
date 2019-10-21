
package fi.tuni.tamk.tiko.melentjeffjuuso.util;

import java.util.Scanner;
/**
 * The class Console contains methods to ask certain types of inputs from end user and see that input is correct.
 * 
 * @author Juuso Melentjeff
 */

public class Console {
    /**
     * readInt method prompts user to give an integer. If input is not an integer, method will ask it until an integer is given
     * 
     * @param errorMessage argument defines the error message to be printed in case of incorrect input.
     * @return integer value given.
     */
    public static int readInt(String errorMessage) {
        Scanner s = new Scanner(System.in);
        boolean incorrectInput = true;
        int input = 0;
        
        while (incorrectInput) {
            try {
            input = Integer.parseInt(s.nextLine());
                if (input == (int)input) {
                    incorrectInput = false;
                }
            } catch(NumberFormatException e) {
            System.out.println(errorMessage);
            }
        }
        return input;
    }
/**
 * readIntMinMax method asks an integer from end user between minimum and maximum values.
 * 
 * @param min minimum number allowed.
 * @param max maximux number allowed.
 * @param errorMessageNonMinAndMax prints an error message if input is not between minimum and maximum values.
 * @param errorMessageNonNumeric prints an error message if input is not numeric.
 * @return Returns end user's number if it is between minimum and maximum values.
 */
    public static int readIntMinMax(int min, int max, String errorMessageNonMinAndMax, String errorMessageNonNumeric) {
        boolean incorrectInput = true;
        int input = 0;

        while (incorrectInput) {
            input = Console.readInt(errorMessageNonNumeric);
            if (input >= min && input <= max) {
                incorrectInput = false;
            } else {
                System.out.println(errorMessageNonMinAndMax);
            }
        }
        return input;
    }
}