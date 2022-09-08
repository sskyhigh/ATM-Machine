import java.util.Scanner;
public class Deposit extends Options{
    private double deposit;
    Scanner sc = new Scanner(System.in);
    public void setDeposit(){
        this.deposit = deposit;
    }
    public void getDeposit(){
        this.deposit = deposit;
    }
    public void depositAmount(){
        System.out.println("How much do you want to deposit?");
        deposit = sc.nextDouble();
    }
}
