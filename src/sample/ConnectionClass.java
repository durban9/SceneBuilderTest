package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection(){



        String dbname = "visionworks_database";
        String userName = "root";
        String password = "1C0manche!";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbname, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
