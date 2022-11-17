public class typicalUser {
    private int id;
    private int deposit;
    private int withdraw;
    private int balance;

    public typicalUser(int ID, int deposit, int withdraw, int balance) {
        this.id = ID;
        deposit = deposit;
        withdraw = withdraw;
        balance = balance;
    }

    public int getID() {return id;}

    public int getDeposit() {return deposit;}

    public int getWithdraw() {return withdraw;}

    public int getBalance() {return balance;}

    public void setId() {this.id = id;}

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s" + id, deposit, withdraw, balance);
    }
}
