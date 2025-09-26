

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class lab1 {
    public static void main(String[] args) {
        Scanner inputLoan = new Scanner(System.in);
        float loanAmt = inputLoan.nextFloat();//Use inputloan as scanner variable

        Scanner inputYear = new Scanner(System.in);
        int loanYear = inputLoan.nextInt();

        Scanner inputRate = new Scanner(System.in);
        float loanRate = inputRate.nextFloat();

        System.out.print("Loan Amount: " + loanAmt);
        System.out.print("Number of Years: " + loanYear);
        System.out.print("Annual Interest Rate: " + loanRate);
    }
}

// monthly interest = monthly interest rate * balance (remaining principal).