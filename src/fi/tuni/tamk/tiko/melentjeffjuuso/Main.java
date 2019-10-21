
package fi.tuni.tamk.tiko.melentjeffjuuso;
import fi.tuni.tamk.tiko.melentjeffjuuso.util.Math;
import fi.tuni.tamk.tiko.melentjeffjuuso.util.Arrays;
import fi.tuni.tamk.tiko.melentjeffjuuso.util.Console;

/**
 * The class Main contains the main method to run the lottery application.
 * 
 * LottoApp is scalable. You can choose the parameters by adjusting static variables.
 * 
 * @author Juuso Melentjeff
 */
public class Main {
    //MINLOTTONUM: minimum possible lottery number.
    //MAXLOTTONUM: maximum possible lottery number. 
    //LOTTONUMS: how many lottery numbers will be calculated and asked from the end user.
    //YEARS: keeps track of years passed. Static as two different methods use this.
    static int MINLOTTONUM = 1;
    static int MAXLOTTONUM = 40;
    static int LOTTONUMS = 7;
    static int YEARS = 0;
    static final String INPUTERROR = "Not a unique number.";
    static final String ASKNUMBERS = "Please give a unique number between [" + MINLOTTONUM + "," + MAXLOTTONUM +"]";
    static final String WINOVERTIME = "Although it took more than a lifetime, let's try it again...";
    static final String WINMSG = "You won in a lifetime!";
    static final String CMDARGUMENTINCORRECT = "Either command line argument was incorrect or not given.";
    static final String INDICATEAPPWORKS = "Calculating lottery...";

    public static void main(String [] args) {

        int [] lottoArr = new int [LOTTONUMS];
        args = Arrays.addPrefix(args,1);
        int [] cmdArgument = Arrays.toIntArray(args);

        //if-else checks whether command line input is correct and usable for lottery.
        //If CMD line is usable INDICATEAPPWORKS message is given to inform end user the app is running
        //as it takes a while to calculate the lottery.
        //If cmd line is not usable, program uses a method to ask numbers.
        //When correct input is given runLottery method is called which runs the lottery application.
        if (!checkCmdInput(cmdArgument) ) {
            System.out.println(CMDARGUMENTINCORRECT);
            lottoArr = askNumbersFromUser();
            runLottery(lottoArr);
        } else {
            System.out.println(INDICATEAPPWORKS);
            runLottery(cmdArgument);
        }
    }
/**
 * calculateLottery method will create an array with random unique integers. 
 * How many numbers it generates depends on how many lottery numbers are give in static LOTTONUMS variable.
 * 
 * @return returns an array of randomized unique lotto numbers.
 */
    private static int[] calculateLottery() {
        int [] numbers = new int[MAXLOTTONUM];
        int [] lottoArray = new int[LOTTONUMS];
        int j = MINLOTTONUM;

        //First for-loop creates an array of possible lottery numbers automatically.
        for (int i = 0; i < MAXLOTTONUM; i++) {
            numbers[i] = j;
            j++;
        }
        //Second for-loop randomizes an index from numbers array, puts it into lotto array
        //and removes that said index from numbers array so a same number couldn't come up twice.
        for (int k = 0; k < lottoArray.length; k++) {
            int index = Math.getRandom(0, numbers.length - 1);
            int randomNumber = numbers[index];
            lottoArray[k] = randomNumber;
            numbers = Math.removeIndex(numbers,index);
        }
        return lottoArray;
    }
/**
 * howManyYearsToWin method calculates lottery until all the lottery numbers are the same.
 * 
 * Each iteration takes one week. Method is scalable: all you have to modify is the static variable
 * LOTTONUMS.
 * 
 * When all lottery numbers are the same, the method will print out how many years it took to 
 * get given numbers right.
 *
 * @param userLotto is the array given by the end user which this method compares to the 
 *                  randomized lottery.
 */
    public static void howManyYearsToWin(int[] userLotto) {
        int [] yearsLotto = new int[LOTTONUMS];

        //This for-loop initializes yearsLotto array with values of -1. Otherwise this method
        //would print at minimum that it took 1 year to get numbers right even if in some
        //cases it takes 0 years.
        for (int j = 0; j < yearsLotto.length; j++) {
            yearsLotto[j] = -1;
        }

        int weeks = 0;
        boolean win = false;

        //This loop calculates lottery until all lottery numbers are correct. Each iteration
        //takes one week so the loop will also keep track of weeks and years and saves them in
        //static int YEARS.
        while (!win) {
            int [] lot = calculateLottery();
            int sameValues = Arrays.containsSameValues(userLotto,lot);
            weeks++;
            if (sameValues > 0 && yearsLotto[sameValues - 1] == -1) {
                yearsLotto[sameValues - 1] = YEARS;
            } 
            if (sameValues == LOTTONUMS) {
                win = true;
            }
            if (weeks == 52) {
                weeks = 0;
                YEARS++;
            }
        }
        //This for-loop prints how many years it took to get given numbers right.
        for (int i = 1; i <= LOTTONUMS; i++) {
            if(yearsLotto[i - 1] > -1) {
                System.out.println("Got " + i + " right! Took " + yearsLotto[i - 1] + " years");
            }
        }
        System.out.println("You won!");
    }
/**
 * askNumberFromUser method asks unique lottery numbers from the end user and saves them into an array.
 * 
 * Method uses other methods to check that user input is correct and all the numbers given are unique.
 * 
 * @return returns user's chosen numbers in an array.
 */
    public static int [] askNumbersFromUser() {
        int i = 0;
        int [] lottoArr = new int[LOTTONUMS]; 

        //Loop to ask numbers from the user until numbers are correct and unique.
        while (!(i == LOTTONUMS)) {
            System.out.println(ASKNUMBERS);
            int lottoNumber = Console.readIntMinMax(MINLOTTONUM,MAXLOTTONUM,"Number has to be between " + MINLOTTONUM + "-" + MAXLOTTONUM,"Please give a number.");
            if (!Arrays.contains(lottoNumber,lottoArr)){
                lottoArr[i] = lottoNumber; 
                i++;
           } else {
               System.out.println(INPUTERROR);
           }
        }
        lottoArr = Arrays.sort(lottoArr);
        return lottoArr;
    }
    /**
     * checkCmdInput method checks if command line argument is given and usable i.e. numbers are unique.
     * 
     * @param cmdArr This is the command line argument.
     * @return returns TRUE if command line argument is usable. 
     */
    public static boolean checkCmdInput(int [] cmdArr) {
        int isUsable = ( Arrays.containsSameValues(cmdArr,cmdArr) );
        return (isUsable == LOTTONUMS);
    }
/**
 * runLottery method runs lottery until user has won in a lifetime.
 * 
 * If a win happens in less than 120 years program stops and prints victory message.
 * If it takes over 120 years it starts again and prints an appropriate message.
 * 
 * @param userInput array of user's unique lottery numbers taken either from command line or from prompted input.
 */
    public static void runLottery (int [] userInput) {
        //Loop to run the lottery app until 7 right in a lifetime (120 years).
        boolean wonInLifetime = false;
        while (!wonInLifetime) {
            howManyYearsToWin(userInput);
            if (YEARS > 120) {
                System.out.println(WINOVERTIME);
                YEARS = 0;
            } else {
                System.out.println(WINMSG);
                wonInLifetime = true;
            }
        }
    }
}