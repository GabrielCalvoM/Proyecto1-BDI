/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import com.sun.jdi.connect.spi.Connection;
import java.sql.*;

/**
 *
 * @author cahuc
 */
public class sysConnection {
    public static Connection obtConnection() {
        try {
            String myDB = "jdbc:oracle:thin:@//localhost:1521/LoscraDB";
            String user = "PROY1";
            String password = "proy1";
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            java.sql.Connection connection = DriverManager.getConnection(myDB, user, password);
            return (Connection) connection;
        } catch (SQLException e) {
            System.out.println("[ERROR] Ha ocurrido el siguiente error: " + e);
        }
        return null;
    }
}
