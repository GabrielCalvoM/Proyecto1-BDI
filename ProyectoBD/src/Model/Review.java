
package Model;

public class Review {
    private int id;
    private int score;
    private String description;
    private int id_user;
    private int id_product;
    
    public Review(int id, int score, String description, int id_user, int id_product) {
        this.id = id;
        this.score = score;
        this.description = description;
        this.id_user = id_user;
        this.id_product = id_product;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_product() {
        return id_product;
    }
    
        
    @Override
    public String toString() {
        return Integer.toString(score);
    }
}
