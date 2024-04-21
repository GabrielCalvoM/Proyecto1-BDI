package Model;

public class Movie {
    int id;
    int idProduct;
    int duration;
    String name;

    public Movie(int id, int idProduct, int duration) {
        this.id = id;
        this.idProduct = idProduct;
        this.duration = duration;
    }

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getDuration() {
        return duration;
    }
      
   @Override
    public String toString() {
        return name;
    }
}
