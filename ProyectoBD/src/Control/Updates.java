package Control;

import java.sql.*;

public class Updates {

    public static void updatePerson(int id, String name, String lastName, String birthDate, int height, int genderId)
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call updatePerson(?,?,?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, lastName);
        stmt.setString(4, birthDate);
        stmt.setInt(5, height);
        stmt.setInt(6, genderId);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void updateArtist(int id, int id_ArtistType, String bio, String trivia) 
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call updateArtist(?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.setInt(2, id_ArtistType);
        stmt.setString(3, bio);
        stmt.setString(4, trivia);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void updateArtistRelative(int id, String name, int id_relationType) {
        // TODO
    }
    
    public static void updateArtistRelative(int id, int id_relationType) 
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call updateArtistRelativeRelation(?, ?)}");
        stmt.setInt(1, id);
        stmt.setInt(2, id_relationType);
        stmt.execute();
        
        stmt.close();
        con.close();
    }
    
    public static void updateCountry(int id, String name) 
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call updateCountry(?,?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void updateCategory(int id, String name) 
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call updateCategory(?,?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.execute();
        con.close();
        stmt.close();
    }

}
