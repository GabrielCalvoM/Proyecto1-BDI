package Control;

import java.sql.*;

public class Updates {

    public static void updatePerson(int id, String name, String lastName, String birthDate, int height, int genderId)
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call person_utils.updatePerson(?,?,?,?,?,?)}");
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
        CallableStatement stmt = con.prepareCall("{call artist_utils.updateArtist(?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.setInt(2, id_ArtistType);
        stmt.setString(3, bio);
        stmt.setString(4, trivia);
        stmt.execute();
        con.close();
        stmt.close();
    }
}
