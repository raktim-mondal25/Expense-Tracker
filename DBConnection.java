import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String username = "root";
    private static final String password = "your_password_here";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
