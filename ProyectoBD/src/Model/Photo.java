package Model;

public class Photo {
    String dir;
    String fileName;

    public Photo(String dir, String fileName) {
        this.dir = dir;
        this.fileName = fileName;
    }

    public String getDir() {
        return dir;
    }

    public String getFileName() {
        return fileName;
    }
    
    
}
