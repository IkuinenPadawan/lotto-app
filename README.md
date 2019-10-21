# lotto-app
A simple lottery application that calculates how many years it takes to win the lottery. Each raffle takes one week and goal is to win the lottery within a lifetime (120 years). 

## Motivation
A school project to create a lottery application that calculates how many years it takes to win the lottery with user's given numbers. In addition, besides getting the application to function properly, goal was to learn javadoc and to create and import packages.

## Features
User can give the lottery numbers in the command line when running the program. Program then checks if those numbers are usable and runs the lottery. If numbers were unusable the application will ask for the numbers until they are unique and withing the range of the usable numbers of the lottery.

Each raffle takes one week and lottery will be run until user wins the lottery. App then prints out how many years it took to get each lottery number right. If it took more than a person's lifetime (120 years) to win the lottery, application will run the lottery again.

App is scaleable. User can change how many lottery numbers there is or what the numerical range of the lottery is by changing static variables in the Main class.

## Code Examples
It took a while to figure out how to add scaleability. Especially when the app prints out how many years it took to get each number right. For example if user wanted to use 9 lottery numbers instead of 7. Solution was to save the years passed inside an array for each lottery number and use for loop to print.

    for (int i = 1; i <= LOTTONUMS; i++) {
        if(yearsLotto[i - 1] > -1) {
            System.out.println("Got " + i + " right! Took " + yearsLotto[i - 1] + " years");
        }
    }
