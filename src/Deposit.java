import java.util.Scanner;
public class Deposit extends Transaction {
    private double deposit;
    Scanner sc = new Scanner(System.in);

    public void setDeposit() {
        this.deposit = deposit;
    }

    public void depositAmount() {
        System.out.println("How much do you want to deposit?");
        deposit = sc.nextDouble();
    }

    public double getDeposit() {
        return this.deposit;
    }
}
