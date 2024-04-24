
package Model;

public class RelativeType {
    private int id;
    private String name;
    
    public RelativeType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    
    @Override
    public String toString() {
        return name;
    }
}
