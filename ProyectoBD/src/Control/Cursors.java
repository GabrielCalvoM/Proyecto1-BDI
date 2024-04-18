package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.*;

public class Cursors {
    public static void getPersonName() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call getNamePerson(?)}");
        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.setInt(2, 1);
        stmt.execute();
        String name = stmt.getString(1);
        System.out.println(name);
        con.close();
        stmt.close();
    }
    
    public static void getAllNames() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call getAllPeople(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        String fila;
        
        while (rs.next()) {
            fila = rs.getString(1);
            System.out.println(fila);
        }
        con.close();
        stmt.close();
    }
    
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
    
    public static ArrayList<Province> getProvinces() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call province_utils.getProvinces(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Province> provinces = new ArrayList<Province>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int id_country = rs.getInt(3);
            stmt = con.prepareCall("{ ? = call country_utils.getCountryName(?) }");
            stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
            stmt.setInt(2, id_country);
            stmt.execute();
            String countryName = stmt.getString(1);
            Province province = new Province(id, name, id_country, countryName);
            provinces.add(province);
        }
        con.close();
        stmt.close();
        return provinces;
    }
}
