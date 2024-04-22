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
    
    public static void deletePerson(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call Person_Utils.deletePerson(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteArtist(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call Artist_Utils.deleteArtist(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteRelationType(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call RelationType_Utils.deleteRelationType(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteArtistRelative(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ArtistRelative_Utils.deleteArtistRelative(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteMovie(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call movie_utils.removeMovie(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteSeries(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call series_utils.removeSeries(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
}
