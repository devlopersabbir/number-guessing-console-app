import java.util.Random;
import java.util.Scanner;

public class Actions {
    private String message;
    private int lowerBound;
    private int upperBound;

    enum Selection {
        YES,
        NO
    }

    Scanner scnr = new Scanner(System.in);

    public void setDetails(String message, int lowerBound, int upperBound) {
        this.message = message;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int generate() {
        int randomNumber = new Random().nextInt((upperBound - lowerBound) + 1) + lowerBound;
        return randomNumber;
    }

    public void run() {
        System.out.print(this.message + ": ");

        // take user input
        int userInputedNumber = scnr.nextInt();
        // if user inputed number less then of lowerBound or more then of upperBound
        if (userInputedNumber < this.lowerBound || userInputedNumber > this.upperBound) {
            System.out.println("Enter the valid number🤒");
            decisionCreator();
        } else {
            int generatedNumber = generate(); // generate random number

            if (userInputedNumber == generatedNumber) {
                System.out.println("Congratulation!🎉");
                decisionCreator();
            } else {
                System.out.println("You are loss!🥲\n Program generate= " + generatedNumber);
                decisionCreator();
            }
        }
        scnr.close();
    }

    public void decisionCreator() {
        System.out.print("Do you want to start again? Y / N: ");
        char decision = scnr.next().toCharArray()[0];

        switch (decision) {
            case 'N':
                System.out.println(
                        "======================================\nThanks for using this application 😍\n======================================");
                break;
            case 'Y':
                run();
                break;
            default:
                System.out.println("Fail to impress you!" + decision);
        }
    }
}