package Model;

public class Product {
    int id;
    String title;
    int premier;
    String synopsis;
    String trailer;
    float price;
    int sales;
    String dateBought;
    float rating;

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

    public String getDateBought() {
        return dateBought;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
    

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }
    
    
    @Override
    public String toString() {
        return title;
    }
}
