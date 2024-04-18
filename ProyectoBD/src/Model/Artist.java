package Model;

public class Artist {
    private int id;
    private int id_artistType;
    private String biography_artist;
    private String trivia_data;

    public Artist(int id, int id_artistType, String biography_artist, String trivia_data) {
        this.id = id;
        this.id_artistType = id_artistType;
        this.biography_artist = biography_artist;
        this.trivia_data = trivia_data;
    }
    
    
}
