package Control;

import java.sql.*; 

public class Insertions {
    public static void insertCountry(String name) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call Country_Utils.insertCountry(?)}");
        stmt.setString(1, name);
        stmt.execute();
        con.close();
        stmt.close();
    }
         
    public static int insertPerson(String name, String lastName,
        String birthDate, int genderId) throws SQLException {
            Connection con = sysConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{? = call person_utils.insertPerson(?,?,?,?,?)}");
            stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            stmt.setString(2, name);
            stmt.setString(3, lastName);
            stmt.setString(4, birthDate);
            stmt.setInt(5, 0);
            stmt.setInt(6, genderId);
            stmt.execute();
            int result = stmt.getInt(1);
            con.close();
            stmt.close();
            return result;
    }
    
    public static void insertUser(int id, String email, int phone, int idCountry, 
        int idType, int idNumber) throws SQLException {
            Connection con = sysConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{call SysUser_utils.insertSysUser(?,?,?,?,?,?)}");
            stmt.setInt(1, id);
            stmt.setString(2, email);
            stmt.setInt(3, phone);
            stmt.setInt(4, idCountry);
            stmt.setInt(5, idType);
            stmt.setInt(6, idNumber);
            stmt.execute();
            con.close();
            stmt.close();
    }
    
    public static void insertAccount(String username, String password, int idUser,
        int idAccountType, int idCatalogue) throws SQLException {
            Connection con = sysConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{call Account_utils.insertAccount(?,?,?,?,?)}");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, idUser);
            stmt.setInt(4, idAccountType);
            stmt.setInt(5, idCatalogue);
            stmt.execute();
            con.close();
            stmt.close();
    }
}
