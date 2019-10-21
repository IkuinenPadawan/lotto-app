
package fi.tuni.tamk.tiko.melentjeffjuuso.util;
/**
 * The class Math contains methods for performing basic mathematical functions. 
 * 
 * @author Juuso Melentjeff
*/
public class Math {
    /**
     * getRandom method returns a random number betweem min and max arguments.
     * 
     * @param min Argument for determining minimum possible number to be returned.
     * @param max Argument for determining maximum possible number to be returned.
     * @return Random number between the arguments.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
 /**
 * removeIndex method removes a certain index from given array.
 * 
 * @param arr Array from which the index will be removed.
 * @param index Index to be removed from.
 * @return Returns the array with the given index removed.
 */
    public static int[] removeIndex(int[] arr, int index) {
        int[] removedIdx = new int [arr.length -1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            removedIdx[k++] = arr[i];
        }
         return removedIdx;
    }
}
