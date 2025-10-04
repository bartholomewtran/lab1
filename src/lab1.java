

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class lab1 {
    public static void main(String[] args) {
        //int[] inputArr = new int[3]; // There are 3 item types to count, so it's made it into a fillable array.
        Scanner inputL = new Scanner(System.in);

        //double loanAmt = inputArr[0];
        //int loanYear = inputArr[1];
        //float loanRate = inputArr[2];

/*
        float loanAmt = inputL.nextFloat();//Use inputloan as scanner variable

        //Scanner inputYear = new Scanner(System.in);
        int loanYear = inputL.nextInt();

        //Scanner inputRate = new Scanner(System.in);
        float loanRate = inputL.nextFloat();
*/

        System.out.printf("Loan Amount:  ");
        double loanAmt = inputL.nextDouble();
        System.out.printf("Number of Years: ");
        int loanYear = inputL.nextInt();
        System.out.printf("Annual Interest Rate: ");
        double loanRate = inputL.nextDouble();


        // Create preset formulas
/*
        loanRate = loanRate / 100;
        monthlyInterestRate = loanRate / 12;
        n = loanYear * 12;
        monthlyPayment = (loanAmount * i * Math.pow(i + 1, n)) / (Math.pow(i + 1, n) - 1);
        totalPayment = monthlyPayment * 12;
        // Calculate monthly payment
*/
        //Find monthly payment
        double i = (loanRate / 100) / 12;
        int n = loanYear * 12;
        double M = loanAmt * (i *  Math.pow(i + 1, n)) / (Math.pow(i + 1, n) - 1);

        //find total payment
        double totalPayment = M * 12;

        //print monthly and total amounts
        String formattedPaymentM = String.format("$%,.2f", M);
        System.out.printf("Monthly Payment: " + formattedPaymentM + "\n");

        String formattedPaymentT = String.format("$%,.2f", totalPayment);
        System.out.printf("Total Payment: " + formattedPaymentT);


        //print header
        System.out.printf("\n\t%5s\t%15s\t%15s\t%14s\n", "Payment #", "Interest ($)", "Principle ($)", "Balance ($)\n");
        //print every i in month

        double currentBalance = loanAmt;

        for (int j = 1; j <= n; j++) {
            //calculate components
            // 1. Calculate Interest for the current month based on the remaining balance
            double interestPaid = currentBalance * i;

            // 2. Calculate Principal Paid (portion of M that goes to loan reduction)
            double principalPaid = M - interestPaid;

            // 3. Calculate New Balance
            double newBalance = currentBalance - principalPaid;

            // Handle the final payment to ensure balance hits zero due to rounding
            if (j == n) {
                // Adjust principal/interest so the final balance is 0.00 (or near it)
                principalPaid = currentBalance;
                interestPaid = M - principalPaid;
                newBalance = 0.00;
            }

            // 4. Print the Row
            System.out.printf("\t%5d\t%,15.2f\t%,15.2f\t%,15.2f\n", j, interestPaid, principalPaid, newBalance);

            // 5. Update the Balance for the next loop iteration
            currentBalance = newBalance;

        }

    }
}

// monthly interest = monthly interest rate * balance (remaining principal).
