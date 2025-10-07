import java.util.Scanner;


public class lab1pt2 {
    public static void main(String[] args) {

        System.out.println("Enter number that you want to find the square root of: ");
        Scanner input = new Scanner(System.in);
        //System.out.println("The system will now use the Babylonian method to find the square root.\n" +
        //        "The following sequence of numbers will represent the processing to find the square root:\n");

        double n = input.nextDouble();
        double guess = n / 2;

        double pctDiff = Double.MAX_VALUE;
        double lastGuess = guess;

        while (Math.abs(pctDiff) >= 0.0001)
        {
            double r = n / guess;
            guess = (guess + r) / 2;
            pctDiff = ((guess-lastGuess)/lastGuess); // normally, multiply by 100, but don't need to necessarily...
            lastGuess = guess;
            System.out.println(guess);
        }
        System.out.printf("-----------------------------------------------------------------------------\n");
        System.out.println("The following output is the square root of your input: " + guess);
        System.out.printf("-----------------------------------------------------------------------------");
    }
}
