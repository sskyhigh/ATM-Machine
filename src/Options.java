
import java.util.Scanner;

public class Options {
    private int userInput, userCode;
    private int correct;
    private int max = 3;
    Scanner sc = new Scanner(System.in);

    public boolean checkPinCode() {
        boolean right = false;
        System.out.println("Please enter pin code to unlock: ");
        userCode = sc.nextInt();
        while (max > 0) {
            int pinCode = 1111;
            if (userCode != pinCode) {
                System.out.println("Please try again");
                userCode = sc.nextInt();
                max--;
                if (userCode == pinCode) {
                    right = true;
                    break;
                }
            }
            if (max == 0) {
                System.out.println("You've been locked out! \n" +
                        "Exiting... ");
                right = false;
            }
        }
        return right;
    }

    public int showScreen() {
        if (checkPinCode()) {
            System.out.println("Please pick from the options: ");
            System.out.println("1 - Deposit \n" +
                    "2 - Withdrawal \n" +
                    "3 - Check Balance \n" +
                    "4-  Exit");
            userInput = sc.nextInt();
        }
        return userInput;
    }


    public int getUserCode() {
        return this.userInput;
    }

    public int getCorrect() {
        return this.correct;
    }

    public int getUserInput() {
        return this.userInput;
    }
}
