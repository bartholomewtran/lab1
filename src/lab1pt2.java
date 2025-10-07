/*
Bartholomew Tran
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 1
Due Date: October 12, 2025
Date Submitted: October 8, 2025
*/

/*

1. DESIGN

The purpose of this program is to approximate the square root of an inputted number using
the Babylonian method. This program involves a simple scanner input and multiple steps
of mathematical calculations to approximate the square root.
 */

import java.util.Scanner;


public class lab1pt2 {
    public static void main(String[] args) {

/*

2. INPUT + VARIABLES

Here, the input and variables are created and declared. the variables rely on the input
to work. n is considered the number inputted. "guess" and "lastGuess" are variables
that the program uses to store its mathematical approximations, which means its data is
meant to change.

 */
        System.out.println("Enter number that you want to find the square root of: ");
        Scanner input = new Scanner(System.in); //Scanner to input number

        double n = input.nextDouble();
        // Variables with math
        double guess = n / 2;

        double pctDiff = Double.MAX_VALUE;
        double lastGuess = guess;

/*

3. PROCESSING

The processing is multiple steps of math. The math is enclosed in a while-loop where numbers are processed until
the margin of error is less than 0.0001. The loop will allow for the guesses to repeat until a suitable guess is
generated.

 */
        while (Math.abs(pctDiff) >= 0.0001) //Margin of error <= 0.0001
        {
            double r = n / guess;
            guess = (guess + r) / 2;
            pctDiff = ((guess-lastGuess)/lastGuess); // normally, multiply by 100, but don't need to necessarily
            lastGuess = guess;
            System.out.println(guess);
        }

/*

4. PRINTING

The program prints the output, which is the approximated square root of the inputted number. Assuming absolute values
so no negatives.

 */
        System.out.printf("-----------------------------------------------------------------------------\n");
        System.out.println("The following output is the square root of your input: " + guess);
        System.out.printf("-----------------------------------------------------------------------------");
    }
}

/*

5. OUTPUT

The following is the output for the following:

Number: 54

Enter number that you want to find the square root of:
54
14.5
9.112068965517242
7.51913760480214
7.350406132303943
7.348469483546109
7.348469228349538
-----------------------------------------------------------------------------
The following output is the square root of your input: 7.348469228349538
-----------------------------------------------------------------------------

Number: 14353

Enter number that you want to find the square root of:
14353
3589.25
1796.6244427805252
902.3066566373382
459.1068327588834
245.18485439763603
151.86217967855842
123.18775384337988
119.850479352514
119.80401562083952
119.80400661079779
-----------------------------------------------------------------------------
The following output is the square root of your input: 119.80400661079779
-----------------------------------------------------------------------------

 */