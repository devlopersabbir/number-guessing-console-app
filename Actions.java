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
        Scanner scnr = new Scanner(System.in);
        System.out.print(this.message + ": ");

        // take user input
        int userInputedNumber = scnr.nextInt();
        // if user inputed number less then of lowerBound or more then of upperBound
        if (userInputedNumber < this.lowerBound && userInputedNumber <= this.upperBound) {
            System.out.println("Enter the valid number🤒");
        } else {
            int generatedNumber = generate();

            if (userInputedNumber == generatedNumber) {
                System.out.println("Congratulation!");
            } else {
                System.out.println("You are loss!🥲");
                String decision = scnr.nextLine();

                if (decision == "NO") {
                    System.out.println("Thanks for using this applicationw😍");
                } else if (decision == "YES") {
                    run();
                }
                scnr.close();
            }
        }
        scnr.close();
    }
}