package Model;

public class Product {
    int id;
    String title;
    int premier;
    String synopsis;
    String trailer;
    float price;
    int sales;

    public Product(int id, String title, int premier, String synopsis, String trailer,
            float price) {
        this.id = id;
        this.title = title;
        this.premier = premier;
        this.synopsis = synopsis;
        this.trailer = trailer;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
    
    
    @Override
    public String toString() {
        return title;
    }
}
