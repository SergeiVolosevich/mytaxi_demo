package by.mytaxi.demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TaxiFirstConnection {
    private static Logger log = LogManager.getLogger(TaxiFirstConnection.class);// prochitat pro loger;

    private static final String URL = "jdbc:mysql://localhost:3306/sql_demo";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws SQLException {

        System.out.println("hello");
        

        try (Connection connection = getConnection();
           CallableStatement statement = connection.prepareCall(DataBaseQeueies.CALL_SHIFTS_PROCEDURE)) {

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    log.info(rs.getString("id"));
                }
            }
        }



    public static Connection getConnection() throws SQLException {
        Properties info = new Properties();
        try(InputStream inputStream = new FileInputStream("src\\main\\resources\\database.properties")){
            info.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(info.getProperty("jdbc.url"),info.getProperty("jdbc.user"),
                info.getProperty("jdbc.password"));
    }
}
