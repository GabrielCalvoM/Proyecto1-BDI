package Control;

import java.sql.*;

public class sysConnection {
    public static Connection getConnection() {
        //String DBname = "jdbc:oracle:thin:@//localhost:1521/BasesI"; // Gabriel Connection
        //String DBname = "jdbc:oracle:thin:@//localhost:1521/LoscraDB"; // Carlos Connection
        String DBname = "jdbc:oracle:thin:@localhost:1521:XE"; // Adrian Connection
        String user = "proy1";
        String password = "proy1";
        
        try{
            Connection con = DriverManager.getConnection(DBname, user, password);
            return con;
        }
        catch (SQLException e) {
            System.out.println("getConnection error: " + e);
        }
        return null;
    }
}
