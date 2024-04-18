package Model;

public class Episode {
    private int id;
    private int epNumber;
    private String title;
    private int id_season;

    public Episode(int id, int epNumber, String title, int id_season) {
        this.id = id;
        this.epNumber = epNumber;
        this.title = title;
        this.id_season = id_season;
    }
}
