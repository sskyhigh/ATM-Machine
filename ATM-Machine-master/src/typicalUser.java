public class typicalUser {
    private int funds;
    private String userName;
    private String passWord;

    public typicalUser(int ID, int deposit, String userName, String passWord) {
        funds = deposit;
        userName = userName;
        passWord = passWord;
    }

    public String getUserName() {return userName;}

    public String getPassWord() {return passWord;}

    public void setPassWord(String passWord) {this.passWord = passWord;}

    public void setUsername(String userName) {this.userName = userName;}

    @Override
    public String toString() {return String.format("%s,%s,%s" + funds, userName, passWord);}
}
