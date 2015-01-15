package moo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDAO {
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost/trippin_dev?user=root&password=abcABC123";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public static List<String> getUserNames() throws Exception {
        // MySQLJava moo = new MySQLJava(MYSQL_DRIVER, MYSQL_URL);
        // moo.readData();
        List<String> result = new ArrayList<String>();

        try {
            Class.forName(MYSQL_DRIVER);
            connection = DriverManager.getConnection(MYSQL_URL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select name from users;");
            // getResultSet(resultSet);

            while (resultSet.next()) {
                result.add(resultSet.getString("name"));
            }
            //preparedStatement = connection.prepareStatement("insert into javaTestDB.test_table values (default,?)");
            //preparedStatement.setString(1,"insert test from java");
            //preparedStatement.executeUpdate();
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return result;
    }
}