
import java.util.Scanner;

public class Options {
    private static int userInput;
    private int userCode;
    private int pinCode = 1111;
    private int max = 2;
    Scanner sc = new Scanner(System.in);

    public boolean checkPinCode() {
        boolean right = false;
        System.out.println("Please enter pin code to unlock: ");
        userCode = sc.nextInt();
        while (max > 0) {
            if (userCode != pinCode) {
                System.out.println("Please try again " +
                        "You have " + max + " more attempts ");
                userCode = sc.nextInt();
                max--;
            } else {
                showScreen();
            }
            if (max == 0) {
                System.out.println("You've been locked out! \n" +
                        "Exiting... ");
                break;
            }
        }
        return right;
    }

    public boolean checkCode() {
        return userCode == pinCode;
    }

    public int showScreen() {
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please pick from the options: ");
            System.out.println("1 - Deposit \n" +
                    "2 - Withdrawal \n" +
                    "3 - Check Balance \n" +
                    "4-  Exit");
            userInput = sc.nextInt();
            if (userInput == 4) {
                return -1;
            }
        }
        return userInput;
    }

    public int getUserCode() {
        return this.userInput;
    }

    public int getUserInput() {
        return this.userInput;
    }
}
