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
    
    public static Artist getArtist(int id) throws SQLException {
        System.out.println("start");
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call artist_utils.getArtist(?,?,?,?,?,?,?,?,?)}");
        stmt.setInt(1, id);
        System.out.println("register params.");
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.NUMBER);
        stmt.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(9, oracle.jdbc.OracleTypes.NUMBER);
        stmt.execute();
        System.out.println("executed");
        
       String name = (String) stmt.getObject(2);
       String lastName = (String) stmt.getObject(3);
       String type = (String) stmt.getObject(4);
       int typeId = (int) stmt.getInt(5);
       String bio = (String) stmt.getObject(6);
       String trivia = (String) stmt.getObject(7);
       String date = (String) stmt.getObject(8);
       int height = (int) stmt.getInt(9);
       System.out.println("got values.");
       Artist artist = new Artist(id, name + " " + lastName, type, typeId, date, 
       bio, trivia, height);
        con.close();
        stmt.close();
        System.out.println("finished.");
       return artist;
    }
    
    public static Product getProduct(int id) throws SQLException {
        Connection con = sysConnection.getConnection();
        CallableStatement stmt = con.prepareCall("{call product_utils.getProduct(?,?,?,?,?)}");
        stmt.setInt(1, id);
        stmt.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
        stmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
        stmt.execute();
        String title = stmt.getString(2);
        int year = stmt.getInt(3);
        String synopsis = stmt.getString(4);
        String trailer = stmt.getString(5);
        Product product = new Product(id, title, year, synopsis, trailer);
        con.close();
        stmt.close();
        return product;
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
            Movie movie = new Movie(id, name);
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
            Series serie = new Series(id, name);
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
}
