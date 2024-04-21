package Model;

public class Artist {
    private int id;
    private int id_artistType;
    private String biography_artist;
    private String trivia_data;
    private String name;
    private String artistType;
    private String birthDate;

    public Artist(int id, int id_artistType, String biography_artist, String trivia_data) {
        this.id = id;
        this.id_artistType = id_artistType;
        this.biography_artist = biography_artist;
        this.trivia_data = trivia_data;
    }
    
    public Artist(int id, String name, String type, String birth, 
        String bio, String trivia, int height) {
            this.id = id;
            this.name = name;
            artistType = type;
            birthDate = birth;
            biography_artist = bio;
            trivia_data = trivia;
    }
    
    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getId_artistType() {
        return id_artistType;
    }

    public String getBiography_artist() {
        return biography_artist;
    }

    public String getTrivia_data() {
        return trivia_data;
    }

    public String getName() {
        return name;
    }
    
    
    
   @Override
    public String toString() {
        return name;
    }
}
