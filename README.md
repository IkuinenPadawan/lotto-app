# lotto-app
A simple lottery application that calculates how many years it takes to win the lottery. Each raffle takes one week and goal is to win the lottery within a lifetime (120 years). 

## Motivation
A school project to create a lottery application that calculates how many years it takes to win the lottery with user's given numbers. In addition, besides getting the application to function properly, goal was to learn javadoc and to create and import packages.

## Features
User can give the lottery numbers in the command line when running the program. Program then checks if those numbers are usable and runs the lottery. If numbers were unusable the application will ask for the numbers until they are unique and withing the range of the usable numbers of the lottery.

Each raffle takes one week and lottery will be run until user wins the lottery. App then prints out how many years it took to get each lottery number right. If it took more than a person's lifetime (120 years) to win the lottery, application will run the lottery again.

App is scaleable. User can change how many lottery numbers there is or what the numerical range of the lottery is by changing static variables in the Main class.

## Screenshots
Application running using the command line argument as user's lottery numbers. "Calculating lottery..." line is printed if command line argument is usable to inform the user that the application is running and working as it takes a moment to win the lottery the first time.
![ex1](https://user-images.githubusercontent.com/52252895/67207110-96095880-f41b-11e9-8054-676c0eac6f17.PNG)

Example 2 - Application asks user for unique lottery numbers as no numbers were given as command line argument or the numbers given were incorrect. As shown in the screenshot, application takes into account incorrect user inputs.
![ex2](https://user-images.githubusercontent.com/52252895/67207523-732b7400-f41c-11e9-8da4-ee9917775768.PNG)

Example 3 - Main method is fairly short. It checks whether command line argument is usable with a method, if not it invokes a different method to ask for unique numbers and then runs the lottery.
![exMain](https://user-images.githubusercontent.com/52252895/67207920-32802a80-f41d-11e9-896c-61724ad9320f.PNG)

Example 4 - Static variable where user can change lottery parameters and some wordings.
![exStatic](https://user-images.githubusercontent.com/52252895/67207921-32802a80-f41d-11e9-8031-8286d3dd1c39.PNG)

## Code Examples
It took a while to figure out how to add scaleability. Especially when the app prints out how many years it took to get each number right. For example if user wanted to use 9 lottery numbers instead of 7. Solution was to save the years passed inside an array (yearsLotto) for each lottery number and use for loop for printing.

    for (int i = 1; i <= LOTTONUMS; i++) {
        if(yearsLotto[i - 1] > -1) {
            System.out.println("Got " + i + " right! Took " + yearsLotto[i - 1] + " years");
        }
    }
