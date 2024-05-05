
package Model;

public class Season {
    private int id;
    private int number_season;
    private int id_series;
    
    public Season(int id, int number_season, int id_series) {
        this.id = id;
        this.number_season = number_season;
        this.id_series = id_series;
    }
    

    public int getId() {
        return id;
    }

    public int getNumber_season() {
        return number_season;
    }

    public int getId_series() {
        return id_series;
    }
    
    @Override 
    public String toString() {
        return "Temporada: " + Integer.toString(number_season);
    }
}
