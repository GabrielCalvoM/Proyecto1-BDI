package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.*;

public class Logic {
    public static boolean verifyAccountCredentials(String username, String password) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call account_utils.checkUserPassword(?, ?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.execute();
        int result = stmt.getInt(1);
        return result > 0;
    } 
    
    public static boolean getUsernameUnique(String username) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call account_utils.getUsernameUnique(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setString(2, username);
        stmt.execute();
        int result = stmt.getInt(1);
        return result < 1;
    }
}
