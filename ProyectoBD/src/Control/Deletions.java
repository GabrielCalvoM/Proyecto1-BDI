package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.*;

public class Deletions {
    public static void deleteCountry(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call Country_Utils.removeCountry(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
}
