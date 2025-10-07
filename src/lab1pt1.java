/*

1. DESIGN

The objective of this program is to create a loan amortization program that calculates the details of a loan
agreement. Details such as principal, interest rate, and number of years are the inputs. Monthly and total
payments are calculated to give the end-user an idea of how their loan agreement will be.

Loops will be utilized to maximize efficiency and allow for flexibility per user case.

*/

import java.util.Scanner;


public class lab1pt1 {
    public static void main(String[] args) {
        Scanner inputL = new Scanner(System.in); //Single scanner for user to input in sequence

/*

2. INPUTS

We use scanners to allow the end-user to input their loan details. In our case, we decide to put input
before the main variable declarations. The reason is because the other variables depend on the inputs in
their declarations, so keeping in this order will make more sense.

The loan amount will be double due to the uncertainty of the size of the loan.
Number of years is represented as a float,  as despite the input the loans will be measured in months,
which means fractions of years are allowed.
Interest rate is calculated as a double. The input is assuming the unit is percentage, and the processing
will convert from percentage to decimal for calculating.

*/

        System.out.printf("Loan Amount:  ");
        double loanAmt = inputL.nextDouble();
        System.out.printf("Number of Years: ");
        float loanYear = inputL.nextInt();
        System.out.printf("Annual Interest Rate: ");
        double loanRate = inputL.nextDouble();


// The following are the formulas that will be used in the processing.
/*

loanRate = loanRate / 100;
monthlyInterestRate = loanRate / 12;
n = loanYear * 12;
monthlyPayment = (loanAmount * i * Math.pow(i + 1, n)) / (Math.pow(i + 1, n) - 1);
totalPayment = monthlyPayment * 12;

*/

/*

3a. VARIABLES + INITIAL PROCESSING PT 1

The following are the variables used. The variable groups will be split into 2 groups: initial declarations
and 2nd declarations. The reasoning is because the code will be messy of all variables are declared at once
in this case. In my opinion, some declarations can be saved for later to provide context to the processing.

Here, we use i, n, and M.
i stands for interest rate.
n is the number of months (year * 12).
M represents the amount required per month, considering interest.

The data of the variables need processing. The processing is also split into two sections, this initial
processing and a later processing for the itemized loan recordings. In the processing, we use Math.pow to
calculate the exponent. In our cases, Math.pow(i + 1, n) represents (i + 1)^n.

*/

        //Find monthly payment
        double i = (loanRate / 100) / 12;
        float n = loanYear * 12;
        double M = loanAmt * (i *  Math.pow(i + 1, n)) / (Math.pow(i + 1, n) - 1);

        //find total payment
        double totalPayment = M * 12;

/*

4a. PRINT PT 1

The following are the formatted prints. The prints will tell the monthly and total payment amounts
considering tax, providing the user a general summary of their loan. The amount M is formatted to
list the amounts in dollars.

*/

        //print monthly and total amounts
        String formattedPaymentM = String.format("$%,.2f", M);
        System.out.printf("Monthly Payment: " + formattedPaymentM + "\n");

        String formattedPaymentT = String.format("$%,.2f", totalPayment);
        System.out.printf("Total Payment: " + formattedPaymentT);

        System.out.printf("\n------------------------------------------------------------------");
        //print header
        System.out.printf("\n\t%5s\t%15s\t%15s\t%14s\n", "Payment #", "Interest ($)", "Principle ($)", "Balance ($)");
        System.out.printf("------------------------------------------------------------------\n");
        //print every i in month
/*

3b. VARIABLES + PROCESSING PT 2

The variables are declared in the processing for maximize efficiency and minimize confusion.

We decided to change loanAmt into currentBalance to fit the context of the following process.

The processing is encapsulated in a for loop so that the program runs and prints smoothly regardless of loan details.
Any length and principal amount of a loan can be input with no issues.

 */
        double currentBalance = loanAmt;

        for (int j = 1; j <= n; j++) {
            // Calculate Interest for the current month based on the remaining balance
            double interestPaid = currentBalance * i;

            // Calculate Principal Paid
            double principalPaid = M - interestPaid;

            // Calculate New Balance (amount that is left)
            double newBalance = currentBalance - principalPaid;

            // Handle the final payment to ensure balance hits zero due to rounding
            if (j == n) {
                // Adjust principal/interest so the final balance is 0.00
                principalPaid = currentBalance;
                interestPaid = M - principalPaid;
                newBalance = 0.00;
            }

            /*

            4b. PRINT PT 2

            The following is the print function for each row every month in a loan. The print is still in the loop
            so that every month is calculated. It has been formatted to seamlessly align with the header.

             */
            // Print the Row
            System.out.printf("\t%5d\t%,15.2f\t%,15.2f\t%,15.2f\n", j, interestPaid, principalPaid, newBalance);

            // Update the Balance for the next loop iteration
            currentBalance = newBalance;

        }
        System.out.printf("------------------------------------------------------------------");
    }
}

/*

5. OUTPUT

The following is the output of the given scenario:
- Principal $20,000
- Duration: 5 Years
- Interest: 5%

Loan Amount:  20000
Number of Years: 5
Annual Interest Rate: 5
Monthly Payment: $377.42
Total Payment: $4,529.10
------------------------------------------------------------------
	Payment #	   Interest ($)	  Principle ($)	   Balance ($)
------------------------------------------------------------------
	    1	          83.33	         294.09	      19,705.91
	    2	          82.11	         295.32	      19,410.59
	    3	          80.88	         296.55	      19,114.04
	    4	          79.64	         297.78	      18,816.26
	    5	          78.40	         299.02	      18,517.24
	    6	          77.16	         300.27	      18,216.97
	    7	          75.90	         301.52	      17,915.45
	    8	          74.65	         302.78	      17,612.67
	    9	          73.39	         304.04	      17,308.63
	   10	          72.12	         305.31	      17,003.33
	   11	          70.85	         306.58	      16,696.75
	   12	          69.57	         307.85	      16,388.89
	   13	          68.29	         309.14	      16,079.76
	   14	          67.00	         310.43	      15,769.33
	   15	          65.71	         311.72	      15,457.61
	   16	          64.41	         313.02	      15,144.59
	   17	          63.10	         314.32	      14,830.27
	   18	          61.79	         315.63	      14,514.64
	   19	          60.48	         316.95	      14,197.69
	   20	          59.16	         318.27	      13,879.43
	   21	          57.83	         319.59	      13,559.83
	   22	          56.50	         320.93	      13,238.91
	   23	          55.16	         322.26	      12,916.64
	   24	          53.82	         323.61	      12,593.04
	   25	          52.47	         324.95	      12,268.09
	   26	          51.12	         326.31	      11,941.78
	   27	          49.76	         327.67	      11,614.11
	   28	          48.39	         329.03	      11,285.08
	   29	          47.02	         330.40	      10,954.67
	   30	          45.64	         331.78	      10,622.89
	   31	          44.26	         333.16	      10,289.73
	   32	          42.87	         334.55	       9,955.18
	   33	          41.48	         335.94	       9,619.24
	   34	          40.08	         337.34	       9,281.89
	   35	          38.67	         338.75	       8,943.14
	   36	          37.26	         340.16	       8,602.98
	   37	          35.85	         341.58	       8,261.40
	   38	          34.42	         343.00	       7,918.40
	   39	          32.99	         344.43	       7,573.97
	   40	          31.56	         345.87	       7,228.10
	   41	          30.12	         347.31	       6,880.79
	   42	          28.67	         348.75	       6,532.04
	   43	          27.22	         350.21	       6,181.83
	   44	          25.76	         351.67	       5,830.16
	   45	          24.29	         353.13	       5,477.03
	   46	          22.82	         354.60	       5,122.43
	   47	          21.34	         356.08	       4,766.35
	   48	          19.86	         357.56	       4,408.78
	   49	          18.37	         359.05	       4,049.73
	   50	          16.87	         360.55	       3,689.18
	   51	          15.37	         362.05	       3,327.12
	   52	          13.86	         363.56	       2,963.56
	   53	          12.35	         365.08	       2,598.48
	   54	          10.83	         366.60	       2,231.89
	   55	           9.30	         368.13	       1,863.76
	   56	           7.77	         369.66	       1,494.10
	   57	           6.23	         371.20	       1,122.90
	   58	           4.68	         372.75	         750.16
	   59	           3.13	         374.30	         375.86
	   60	           1.57	         375.86	           0.00
------------------------------------------------------------------


The following is the output of the given scenario:

- Principal: $10,000
- Duration: 2 Years
- Interest: 7%

Loan Amount:  10000
Number of Years: 2
Annual Interest Rate: 7
Monthly Payment: $447.73
Total Payment: $5,372.71
------------------------------------------------------------------
	Payment #	   Interest ($)	  Principle ($)	   Balance ($)
------------------------------------------------------------------
	    1	          58.33	         389.39	       9,610.61
	    2	          56.06	         391.66	       9,218.94
	    3	          53.78	         393.95	       8,825.00
	    4	          51.48	         396.25	       8,428.75
	    5	          49.17	         398.56	       8,030.19
	    6	          46.84	         400.88	       7,629.31
	    7	          44.50	         403.22	       7,226.09
	    8	          42.15	         405.57	       6,820.51
	    9	          39.79	         407.94	       6,412.57
	   10	          37.41	         410.32	       6,002.25
	   11	          35.01	         412.71	       5,589.54
	   12	          32.61	         415.12	       5,174.42
	   13	          30.18	         417.54	       4,756.88
	   14	          27.75	         419.98	       4,336.90
	   15	          25.30	         422.43	       3,914.47
	   16	          22.83	         424.89	       3,489.58
	   17	          20.36	         427.37	       3,062.21
	   18	          17.86	         429.86	       2,632.35
	   19	          15.36	         432.37	       2,199.98
	   20	          12.83	         434.89	       1,765.09
	   21	          10.30	         437.43	       1,327.66
	   22	           7.74	         439.98	         887.68
	   23	           5.18	         442.55	         445.13
	   24	           2.60	         445.13	           0.00
------------------------------------------------------------------


 */
