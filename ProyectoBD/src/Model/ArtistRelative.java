package Model;

public class ArtistRelative {
    private int id;
    private int id_artist;
    private int id_relative;
    private int id_relationType;

    public ArtistRelative(int id, int id_artist, int id_relative, int id_relationType) {
        this.id = id;
        this.id_artist = id_artist;
        this.id_relative = id_relative;
        this.id_relationType = id_relationType;
    }
}
