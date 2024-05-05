package Model;

public class Episode {
    private int id;
    private int epNumber;
    private String title;
    private int id_season;
    private int duration;

    public Episode(int id, int epNumber, String title, int id_season) {
        this.id = id;
        this.epNumber = epNumber;
        this.title = title;
        this.id_season = id_season;
    }

    public Episode(int epNumber, String title, int duration) {
        this.epNumber = epNumber;
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getEpNumber() {
        return epNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getId_season() {
        return id_season;
    }

    public int getDuration() {
        return duration;
    }    
    
    @Override 
    public String toString() {
        return title + " | " + Integer.toString(duration) + " mins";
    }
}
