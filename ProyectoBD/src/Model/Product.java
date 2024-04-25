package Model;

public class Product {
    int id;
    String title;
    int premier;
    String synopsis;
    String trailer;

    public Product(int id, String title, int premier, String synopsis, String trailer) {
        this.id = id;
        this.title = title;
        this.premier = premier;
        this.synopsis = synopsis;
        this.trailer = trailer;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPremier() {
        return premier;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getTrailer() {
        return trailer;
    }
    
    @Override
    public String toString() {
        return title + " (" + this.premier + ")";
    }
}
