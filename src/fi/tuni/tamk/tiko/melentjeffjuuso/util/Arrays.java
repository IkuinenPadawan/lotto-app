
package fi.tuni.tamk.tiko.melentjeffjuuso.util;
/**
 * The class Arrays contains methods to handle different tasks regarding arrays.
 * 
 * @author Juuso Melentjeff
 */
public class Arrays {
/**
 * toIntArray method converts a string array into an int array.
 * It also will give an error message if given string array does not contain numbers.
 * 
 * @param array Argument gives the method a string array to be converted to int array.
 * @return Converted array.
 */
    public static int [] toIntArray(String [] array) {
        int[] intArray = new int [array.length];
        for(int i = 0; i < array.length; i++) {
            try {
            intArray[i] = Integer.parseInt(array[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a number: " + array[i]);
        }
    }
    return intArray;
    }
/**
 * contains method for checking if certain value can be found from a certain array.
 * 
 * @param value value to be searched.
 * @param array array to be searched from.
 * @return true or false depending on if given value was found
 */
    public static boolean contains(int value, int [] array) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                contains = true;
            }
        }
        return contains;
    }
/**
* containsSameValues method checks how many same values given arrays with unique numbers contain.
* 
* @param array1 array to be checked from.
* @param array2 array to be checked from.
* @return how many numbers are the same in given arrays.
*/
    public static int containsSameValues(int [] array1, int [] array2) { 
        int sameNums = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    sameNums++;
                }
            }
        }
        return sameNums;
    }
/**
 * sort method sorts the array in descending order.
 * 
 * @param array Array to be sorted.
 * @return Returns a sorted array in descending order.
 */
    public static int [] sort(int [] array) {
        int i;
        for (i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
        return array;
    }
/**
 * addPrefix Method adds leading zeros to array's numbers.
 * 
 * @param array To which leading zeros are to be added.
 * @param leadingZeros Defines how many leading zeros are to be added. (1 means: 01 and 10, 2 means: 001 and 010)
 * @return Returns a String array where leading zeros have been added.
 */
    public static String [] addPrefix (String [] array, int leadingZeros) {
        
        for(int j = 0; j < leadingZeros; j++) {
            for(int i = 0; i < array.length; i++) {
                int length = Integer.parseInt(String.valueOf(array[i].length()));
                if(length < leadingZeros + 1) {
                array[i] = 0 + array[i];
                }
            }
        }
        return array;
    }
/**
 * toStringArray method converts int arrays to String arrays.
 * 
 * @param array Array to be converted.
 * @return Returns a converted array.
 */
    public static String [] toStringArray (int [] array) {
        
        String [] stringArray = new String [array.length];
        for(int i = 0; i < array.length; i++) {
            try {
            stringArray[i] = Integer.toString(array[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error" + array[i]);
        }
    }
    return stringArray;
    }
}
