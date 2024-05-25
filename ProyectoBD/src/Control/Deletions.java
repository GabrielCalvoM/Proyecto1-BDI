package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.*;

public class Deletions {
    
    public static void deleteCountry(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call removeCountry(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteArtist(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteArtist(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteArtistRelative(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteArtistRelative(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteMovie(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call removeMovie(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteSeries(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call removeSeries(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteCategory(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteCategory(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void removeCategoryProduct (int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteProductCategory(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteFromWishlist(int idWishlist, int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteWishedProduct(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idWishlist);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteFromCart(int idCart, int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteCartProduct(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idCart);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteReview(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteReview(?)}");
        stmt.setInt(1, id);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void deleteNationality(int idCountry, int idPerson) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call deleteNationality(?, ?)}");
        stmt.setInt(1, idCountry);
        stmt.setInt(2, idPerson);
        stmt.execute();
        con.close();
        stmt.close();
    }
}
