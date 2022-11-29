import java.sql.*;

public class addData {
    String user = "root";
    String location = "jdbc:mysql://localhost:3306/boa_credentials";
    String pass = "Magnum12!";
    private String userName = null;
    private String passWord = null;
    private String addInfo = null;
    private PreparedStatement preparedStatement;

    public addData(String Name, String passWord) throws SQLException {
        this.userName = Name;
        this.passWord = passWord;

        try {
            Connection connection = DriverManager.getConnection(location, user, pass);
            Statement statement = connection.createStatement();
            ResultSet help = statement.executeQuery("select * from boa_credentials.credentials");

            preparedStatement = connection.prepareStatement("insert into credentials" +
                    "(Username, " + "Password)" + "values (?, ?)");
            preparedStatement.setString(1, );
        } catch (Exception exception) {exception.printStackTrace();}
    }
}

