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
        String birthDate, int height, int genderId) throws SQLException {
            Connection con = sysConnection.getConnection();
            CallableStatement stmt = con.prepareCall("{? = call person_utils.insertPerson(?,?,?,?,?)}");
            stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            stmt.setString(2, name);
            stmt.setString(3, lastName);
            stmt.setString(4, birthDate);
            stmt.setInt(5, height);
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
    
    public static void insertArtist(int id, int idType, String biography, 
    String trivia) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call Artist_utils.insertArtist(?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.setInt(2, idType);
        stmt.setString(3, biography);
        stmt.setString(4, trivia);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertArtistRelative(int id_artist, int id_relative, int id_type)
    throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ArtistRelative_utils.insertArtistRelative(?,?,?)}");
        stmt.setInt(1, id_artist);
        stmt.setInt(2, id_relative);
        stmt.setInt(3, id_type);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static int insertProduct(String title, int year, String synopsis, 
        String trailer, float price) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call product_utils.insertProduct(?,?,?,?,?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setString(2, title);
        stmt.setInt(3, year);
        stmt.setString(4, synopsis);
        stmt.setString(5, trailer);
        stmt.setFloat(6, price);
        stmt.execute();
        int id = stmt.getInt(1);
        con.close();
        stmt.close();
        return id;
    }
    
    public static void insertMovie(int IdProduct, int duration) throws SQLException{
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call movie_utils.insertMovie(?,?)}");
        stmt.setInt(1, IdProduct);
        stmt.setInt(2, duration);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static int insertSeries(int IdProduct) throws SQLException{
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call series_utils.insertSeries(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, IdProduct);
        stmt.execute();
        int id = stmt.getInt(1);
        con.close();
        stmt.close();
        return id;
    }
    
    public static int insertPhoto(String path) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call photo_utils.insertPhoto(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setString(2, path);
        stmt.execute();
        int id = stmt.getInt(1);
        con.close();
        stmt.close();
        return id;
    }
    
    public static void insertProductPhoto(int idPhoto, int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ProductPhoto_utils.insertProductPhoto(?,?)}");
        stmt.setInt(1, idPhoto);
        stmt.setInt(2, idProduct);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertProductArtist(int idProduct, int idArtist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call productArtist_utils.insertProductArtist(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idArtist);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertCategory(String name) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call category_utils.insertCategory(?)}");
        stmt.setString(1, name);
        stmt.execute();
        con.close();
        stmt.close();
    }

    public static void createWishlist(int idUser) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call wishlist_utils.insertWishlist(?)}");
        stmt.setInt(1, idUser);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void createCart(int idUser) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call shoppingCart_utils.insertShoppingCart(?)}");
        stmt.setInt(1, idUser);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertWishedProduct(int idProduct, int idWishlist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call wishedProduct_utils.insertWishedProduct(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idWishlist);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertCartProduct(int idProduct, int idCart) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call cartProduct_utils.insertCartProduct(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idCart);
        stmt.execute();
        con.close();
        stmt.close();
    }
       
    public static void InsertOwnedProduct(int idProduct, int idUser, String purchaseDate) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ownedProduct_utils.insertOwnedProduct(?,?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idUser);
        stmt.setString(3, purchaseDate);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertReview(String comment, int score, int idUser, int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call review_utils.insertReview(?,?,?,?)}");
        stmt.setInt(1, score);
        stmt.setString(2, comment);
        stmt.setInt(3, idUser);
        stmt.setInt(4, idProduct);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertProductCategory(int idProduct, int idCategory) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call productCategory_utils.insertProductCategory(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.setInt(2, idCategory);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertArtistPhoto(int idPhoto, int idArtist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ArtistPhoto_utils.insertArtistPhoto(?,?)}");
        stmt.setInt(1, idPhoto);
        stmt.setInt(2, idArtist);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static void insertNationality(int idPerson, int idCountry) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call nationality_utils.insertNationality(?, ?)}");
        stmt.setInt(1, idPerson);
        stmt.setInt(2, idCountry);
        stmt.execute();
        con.close();
        stmt.close();
    }
    
    public static int insertSeason(int number, int idSeries) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call season_utils.insertSeason(?,?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, number);
        stmt.setInt(3, idSeries);
        stmt.execute();
        int idSeason = stmt.getInt(1);
        con.close();
        stmt.close();
        return idSeason;
    }
    
    public static void insertEpisode(int number, String title, int idSeason, int duration) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call episode_utils.insertEpisode(?,?,?,?)}");
        stmt.setInt(1, number);
        stmt.setString(2, title);
        stmt.setInt(3, idSeason);
        stmt.setInt(4, duration);
        stmt.execute();
        con.close();
        stmt.close();
    }
}
