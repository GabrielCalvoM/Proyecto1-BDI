
package Model;

public class ProductOnPlatform {
    private int id;
    private int price;
    private int id_product;
    private int id_streamPlatform;
    
    public ProductOnPlatform(int id, int price, int id_product, int id_streamPlatform) {
        this.id = id;
        this.price = price;
        this.id_product = id_product;
        this.id_streamPlatform = id_streamPlatform;
    }
}
