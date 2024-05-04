
package Model;


public class Series {
    private int id;
    private String name;
    private int id_product;
    
    public Series(int id, int id_product, String name) {
        this.id = id;
        this.name = name;
        this.id_product = id_product;
    }

    public Series(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdProduct() {
        return id_product;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
