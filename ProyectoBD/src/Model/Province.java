package Model;

public class Province {
    private int id;
    private String name;
    private int id_country;
    private String country_name;

    public Province(int id, String name, int id_country) {
        this.id = id;
        this.name = name;
        this.id_country = id_country;
        country_name = "";
    }
    
    public Province(int id, String name, int id_country, String country_name) {
        this.id = id;
        this.name = name;
        this.id_country = id_country;
        this.country_name = country_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getId_country() {
        return id_country;
    }

    public String getCountry_name() {
        return country_name;
    }
    
    
    
    @Override
    public String toString() {
        return name + ", " + country_name;
    }
}
