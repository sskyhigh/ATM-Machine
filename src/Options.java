
import java.util.Scanner;

public class Options {
    private int userInput, userCode;
    private int max = 3;
    private final int pinCode = 1111;
    Scanner sc = new Scanner(System.in);

    public void checkPinCode() {
        System.out.println("Please enter pin code to unlock: ");
        userCode = sc.nextInt();
        while (max > 0) {
            if (userCode != pinCode) {
                System.out.println("Please try again");
                userCode = sc.nextInt();
                max--;
            }
        }
    }

    public void showScreen() {
        System.out.println(System.out.println("Please pick from the options: ");
        System.out.println("1 - Deposit \n" +
                "2 - Withdrawal" +
                "3 - Check Balance" +
                "4- ");
    }

    public int getUserCode(){
        return this.userInput;
    }
    public int getUserInput() {
        return this.userInput;
    }
}
