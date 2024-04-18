package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.*;

public class Cursors {
    public static ArrayList<Country> getCountries() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call country_utils.getCountries(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Country> countries = new ArrayList<Country>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Country country = new Country(id, name);
            countries.add(country);
        }
        con.close();
        stmt.close();
        return countries;
    }
    
    public static ArrayList<IdType> getIdTypes() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call idType_utils.getTypes(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<IdType> types = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            IdType type = new IdType(id, name);
            types.add(type);
        }
        con.close();
        stmt.close();
        return types;
    }
    
    public static ArrayList<Gender> getGenders() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call gender_utils.getGenders(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Gender> genders = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Gender gender = new Gender(id, name);
            genders.add(gender);
        }
        con.close();
        stmt.close();
        return genders;
    }
}
