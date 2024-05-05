package Control;

import java.sql.*; 
import java.util.ArrayList;
import Model.Country;
import Model.*;
import java.util.HashMap;

public class Cursors {
    public static ArrayList<Country> getCountries() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call country_utils.getCountries(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Country> countries = new ArrayList<>();
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
    
    public static ArrayList<ArtistType> getArtistTypes() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call artist_utils.getArtistTypes(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<ArtistType> types = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            ArtistType type = new ArtistType(id, name);
            types.add(type);
        }
        con.close();
        stmt.close();
        return types;
    }
    
    public static ArrayList<RelativeType> getRelativeTypes() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call relativeType_utils.getRelativeTypes(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<RelativeType> types = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            RelativeType type = new RelativeType(id, name);
            types.add(type);
        }
        con.close();
        stmt.close();
        return types;
    }
    
    public static ArrayList<ArtistRelative> getArtistRelatives(int id_artist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call ArtistRelative_Utils.getArtistRelatives(?, ?)}");
        stmt.setInt(1, id_artist);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        
        ResultSet rs = (ResultSet) stmt.getObject(2);
        
        ArrayList<ArtistRelative> relatives = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            int id_relative = rs.getInt(2);
            String name = rs.getString(3) + " " + rs.getString(4);
            int id_relation = rs.getInt(5);
            
            //System.out.println("A: " + id + ", " + id_artist + ", " + id_relative + "| " + name + " | " + id_relation + " | ");
            
            ArtistRelative relative = new ArtistRelative(id, id_artist, id_relative, id_relation, name);
            relatives.add(relative);
        }
        con.close();
        stmt.close();
        return relatives;
    }
    
    public static ArrayList<Artist> getArtistsOfType(int idType) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call artist_utils.getArtistsOfType(?, ?)}");
        stmt.setInt(1, idType);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(2);
        
        ArrayList<Artist> artists = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2) + " " + rs.getString(3);
 
            Artist artist = new Artist(id, name);
            artists.add(artist);
        }
        con.close();
        stmt.close();
        return artists;
    }
    
    public static Person getPerson(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call person_utils.getPerson(?,?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.NUMBER);
        stmt.execute();
        
       String name = (String) stmt.getObject(2);
       String lastName = (String) stmt.getObject(3);
       String date = (String) stmt.getObject(4);
       int gender = (int) stmt.getInt(5);
       Person person = new Person(id, name, lastName, date, gender);
        con.close();
        stmt.close();
       return person;
    }
    
    public static Artist getArtist(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call artist_utils.getArtist(?,?,?,?,?,?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.NUMBER);
        stmt.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(9, oracle.jdbc.OracleTypes.NUMBER);
        stmt.execute();
        
       String name = (String) stmt.getObject(2);
       String lastName = (String) stmt.getObject(3);
       String type = (String) stmt.getObject(4);
       int typeId = (int) stmt.getInt(5);
       String bio = (String) stmt.getObject(6);
       String trivia = (String) stmt.getObject(7);
       String date = (String) stmt.getObject(8);
       int height = (int) stmt.getInt(9);
       Artist artist = new Artist(id, name + " " + lastName, type, typeId, date, 
       bio, trivia, height);
        con.close();
        stmt.close();
       return artist;
    }
    
    public static Product getProduct(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call product_utils.getProduct(?,?,?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(6, oracle.jdbc.OracleTypes.NUMBER);
        stmt.execute();
        String title = stmt.getString(2);
        int year = stmt.getInt(3);
        String synopsis = stmt.getString(4);
        String trailer = stmt.getString(5);
        float price = stmt.getFloat(6);
        Product product = new Product(id, title, year, synopsis, trailer, price);
        con.close();
        stmt.close();
        return product;
    }
    
    public static ArrayList<Product> getProducts() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call product_utils.getAllProducts(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Product> products = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int premiereYear = rs.getInt(3);
            String synopsis = rs.getString(4);
            String trailer = rs.getString(5);
            Product product = new Product(id, name, premiereYear, synopsis, trailer, 0);
            products.add(product);
        }
        con.close();
        stmt.close();
        return products;
    }
    
    public static ArrayList<Movie> getMovies() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call movie_utils.getAllMovies(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Movie> movies = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int idProd = rs.getInt(3);
            Movie movie = new Movie(id, idProd, name);
            movies.add(movie);
        }
        con.close();
        stmt.close();
        return movies;
    }
    
    public static ArrayList<Series> getSeries() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call series_utils.getAllSeries(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Series> series = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int idProd = rs.getInt(3);
            Series serie = new Series(id, idProd, name);
            series.add(serie);
        }
        con.close();
        stmt.close();
        return series;
    }
    
    public static ArrayList<Movie> getNmovies(int n) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call movie_utils.getNmovies(?, ?)}");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(1, n);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(2);
        
        ArrayList<Movie> movies = new ArrayList<>();
        while(rs.next()) {
            String name = rs.getString(1);
            int idMovie = rs.getInt(2);
            int idProduct = rs.getInt(3);
            Movie movie = new Movie(idMovie, idProduct, name);
            movies.add(movie);
        }
        con.close();
        stmt.close();
        return movies;
    }
    
    public static ArrayList<Series> getNseries(int n) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call series_utils.getNseries(?, ?)}");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(1, n);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(2);
        
        ArrayList<Series> series = new ArrayList<>();
        while(rs.next()) {
            String name = rs.getString(1);
            int idSeries = rs.getInt(2);
            int idProduct = rs.getInt(3);
            Series serie = new Series(idSeries, idProduct, name);
            series.add(serie);
        }
        con.close();
        stmt.close();
        return series;
    }
    
    public static String getProductMainImg(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call productPhoto_utils.getProductMainImg(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.setInt(2, id);
        stmt.execute();
        String result = stmt.getString(1);
        con.close();
        stmt.close();
        return result;
    }
    
    public static ArrayList<Integer> getArtistsInProduct(int idProd) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call productArtist_utils.getArtistsInProduct(?, ?)}");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(1, idProd);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(2);
        
        ArrayList<Integer> artistIds = new ArrayList<>();
        while(rs.next()) {
            int idArtist = rs.getInt(1);
            artistIds.add(idArtist);
        }
        con.close();
        stmt.close();
        return artistIds;
    }
    
    public static int getTypeOfArtist(int idArtist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call artist_utils.getTypeOfArtist(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, idArtist);
        stmt.execute();
        int result = stmt.getInt(1);
        con.close();
        stmt.close();
        return result;
    }
        
    public static HashMap<String, Integer> getCategories() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call category_utils.getAllCategories(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        HashMap<String, Integer> categories = new HashMap<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            categories.put(name, id);
        }
        con.close();
        stmt.close();
        return categories;
    }
    
    public static ArrayList<Person> getUsersPersonalData() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call sysUser_utils.getAllUsers(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Person> users = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String first_name = rs.getString(2);
            String last_name = rs.getString(3);
            String birth_date = rs.getString(4);
            int id_gender = rs.getInt(5);
            
            Person p = new Person(id, first_name, last_name, birth_date, id_gender);
            users.add(p);
        }
        
        con.close();
        stmt.close();
        return users;
    }
    
    public static ArrayList<Category> getCategoriesArr() throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call category_utils.getAllCategories(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Category> categories = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Category category = new Category(id, name);
            categories.add(category);
        }
        con.close();
        stmt.close();
        return categories;
    }
    
    public static int getWishlistId(int idUser) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call wishlist_utils.getWishlistId(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, idUser);
        stmt.execute();
        int result = stmt.getInt(1);
        con.close();
        stmt.close();
        return result;
    }
    
        public static int getCartId(int idUser) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call shoppingCart_utils.getCartId(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, idUser);
        stmt.execute();
        int result = stmt.getInt(1);
        con.close();
        stmt.close();
        return result;
    }
    
    public static int getAccountUserId(int idAccount) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call account_utils.getUserId(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
        stmt.setInt(2, idAccount);
        stmt.execute();
        int result = stmt.getInt(1);
        con.close();
        stmt.close();
        return result;
    }
    
    public static ArrayList<Product> getProductsInWishlist(int idWishlist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call wishedProduct_utils.getProductsInWishlist(?,?)}");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(1, idWishlist);
        stmt.execute();
        
        ResultSet rs = (ResultSet) stmt.getObject(2);
        ArrayList<Product> products = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            Product product = getProduct(id);
            products.add(product);
        }
        con.close();
        stmt.close();
        return products;
    }
    
    public static ArrayList<Product> getProductsInCart(int idCart) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call cartProduct_utils.getProductsInCart(?,?)}");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(1, idCart);
        stmt.execute();
        
        ResultSet rs = (ResultSet) stmt.getObject(2);
        ArrayList<Product> products = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            Product product = getProduct(id);
            products.add(product);
        }
        con.close();
        stmt.close();
        return products;
    }
    
    public static Account getAccount(int idAccount) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call account_utils.getAccount(?,?,?,?)}");
        stmt.setInt(1, idAccount);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.NUMBER);
        stmt.execute();
        String username = stmt.getString(2);
        int id_user = stmt.getInt(3);
        int id_type = stmt.getInt(4);
        Account result = new Account(idAccount, username, id_user, id_type);
        con.close();
        stmt.close();
        return result;
    }
    
    public static ArrayList<Review> getProductReviews(int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call review_utils.getProductReviews(?,?)}");
        stmt.setInt(1, idProduct);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        stmt.execute();
        
        ResultSet rs = (ResultSet) stmt.getObject(2);
        ArrayList<Review> reviews = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt(1);
            int score = rs.getInt(2);
            String comment = rs.getString(3);
            int idUser = rs.getInt(4);
            Review review = new Review(id, score, comment, idUser, idProduct);
            reviews.add(review);
        }
        con.close();
        stmt.close();
        return reviews;
    }
    
    public static String getUsernameByUserId(int idUser) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call account_utils.getUsernameByUserId(?)}");
        stmt.setInt(2, idUser);
        stmt.registerOutParameter(1,  oracle.jdbc.OracleTypes.VARCHAR);
        stmt.execute();
        String username = stmt.getString(1);
        con.close();
        stmt.close();
        return username;
    }
    
    public static float getAverageRating(int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call review_utils.getAverageRating(?)}");
        stmt.setInt(2, idProduct);
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.FLOAT);
        stmt.execute();
        float result = stmt.getFloat(1);
        con.close();
        stmt.close();
        return result;
    }
    
    public static String getProductCategory(int idProduct) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call productCategory_utils.getProductCategory(?)}");
        stmt.setInt(2, idProduct);
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.execute();
        String category = stmt.getString(1);
        con.close();
        stmt.close();
        return category;
    }
    
    public static ArrayList<String> getArtistPhotos(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call artistPhoto_utils.getArtistPhoto(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, id);
        stmt.execute();
        
        ResultSet rs = (ResultSet) stmt.getObject(1);
        ArrayList<String> photos = new ArrayList<>();
        
        while(rs.next()) {
            String photo = rs.getString(1);
            photos.add(photo);
        }
        
        con.close();
        stmt.close();
        return photos;
    }
    
    public static ArrayList<String> getCouple(int idArtist) throws SQLException {
        ArrayList<String> couple = new ArrayList();
        
        for (ArtistRelative relative : getArtistRelatives(idArtist)) {
            if (relative.getId_relationType() == 1) {
                couple.add(relative.getName_relative());
            }
        }
        
        return couple;
    }
    
    public static ArrayList<String> getParents(int idArtist) throws SQLException {
        ArrayList<String> parents = new ArrayList();
        
        for (ArtistRelative relative : getArtistRelatives(idArtist)) {
            if (relative.getId_relationType() == 2) {
                parents.add(relative.getName_relative());
            }
        }
        
        return parents;
    }
    
    public static ArrayList<String> getSiblings(int idArtist) throws SQLException {
        ArrayList<String> siblings = new ArrayList();
        
        for (ArtistRelative relative : getArtistRelatives(idArtist)) {
            if (relative.getId_relationType() == 3) {
                siblings.add(relative.getName_relative());
            }
        }
        
        return siblings;
    }
    
    public static ArrayList<String> getChildren(int idArtist) throws SQLException {
        ArrayList<String> children = new ArrayList();
        
        for (ArtistRelative relative : getArtistRelatives(idArtist)) {
            if (relative.getId_relationType() == 4) {
                children.add(relative.getName_relative());
            }
        }
        
        return children;
    }
    
    public static ArrayList<Integer> getArtistProducts(int idArtist) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{?=call productArtist_utils.getAllProducts(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, idArtist);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        ArrayList<Integer> products = new ArrayList<>();
        while(rs.next()) {
            int product = rs.getInt(1);
            products.add(product);
        }
        
        con.close();
        stmt.close();
        return products;
    }
    
    public static String getCountry(int idCountry) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{? = call country_utils.getCountryName(?)}");
        stmt.setInt(2, idCountry);
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.execute();
        String name = stmt.getString(1);
        con.close();
        stmt.close();
        return name;
    }
    
    public static ArrayList<Country> getNationalities(int idPerson) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{?=call nationality_utils.getAllNationalities(?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, idPerson);
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);
        
        
        ArrayList<Country> nationalities = new ArrayList<>();
        
        while(rs.next()) {
            int idCountry = rs.getInt(1);
            String name = getCountry(idCountry);
            nationalities.add(new Country(idCountry, name));
        }
        
        con.close();
        stmt.close();
        return nationalities;
    }
}
