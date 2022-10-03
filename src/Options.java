import java.util.Scanner;

public class Options {
    private static int userInput;
    private int userCode;
    private int pinCode = 1111;
    private int max = 2;
    private final int Deposit = 1;
    private final int Withdrawal = 2;
    private final int Check_Bal = 3;
    private final int Exit = 4;
    Scanner sc = new Scanner(System.in);

    public void checkPinCode() {
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
    }

    public int showScreen() {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Please pick from the options: ");
                System.out.println("1 - Deposit \n" +
                        "2 - Withdrawal \n" +
                        "3 - Check Balance \n" +
                        "4-  Exit");
                userInput = sc.nextInt();
                if (getUserInput() == Deposit) {
                    Deposit obj = new Deposit();
                    obj.depositAmount();
                } else if (getUserInput() == Withdrawal) {
                    Transaction obj = new Transaction();
                    obj.trans();
                } else if (getUserInput() == Check_Bal) {
                    Check_Balance newBal = new Check_Balance();
                } else if (userInput == Exit) {
                    return -1;
                } else {
                    System.out.println("Invalid input!" +
                            "Please enter another or -4 to exit");
                    userInput = sc.nextInt();
                }
            }
        }
        return userInput;
    }
    public void setUserInput(int a) {
        userInput = a;
    }

    public int getUserInput() {
        return userInput;
    }
}
