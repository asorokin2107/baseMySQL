import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "*****";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courses");
            while (resultSet.next()) {
                String courseName = resultSet.getString("name");
                int coursePrice = resultSet.getInt("price");
                System.out.println(courseName + " " + coursePrice);
            }
            resultSet.close();
            statement.close();;
            connection.close();;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
