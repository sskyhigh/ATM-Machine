public class typicalUser {
    private int funds;
    private String userName;
    private String passWord;

    public typicalUser(int ID, int deposit, String userName, String passWord) {
        funds = deposit;
        userName = userName;
        passWord = passWord;
    }

    

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s" + id, deposit, withdraw, balance);
    }
}
