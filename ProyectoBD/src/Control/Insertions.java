package Control;

import java.sql.*; 

public class Insertions {
    public static void insertCountry(String name) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call insertCountry(?)}");
        stmt.setString(1, name);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertPerson(String name, String lastName,
        String birthDate, int genderId) throws SQLException {
            Connection con = sysConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{call insertPerson(?,?,?,?)}");
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setString(3, birthDate);
            stmt.setInt(4, genderId);
            stmt.execute();
            con.close();
            stmt.close();
    }
}
