package Model;

import Control.Logic;
import java.sql.*; 

public class ArtistRelative {
    private int id;
    private int id_artist;
    private int id_relative;
    private int id_relationType;
    private String name_relative;

    public ArtistRelative(int id, int id_artist, int id_relative, int id_relationType) {
        this.id = id;
        this.id_artist = id_artist;
        this.id_relative = id_relative;
        this.id_relationType = id_relationType;
    }
    
    public ArtistRelative(int id, int id_artist, int id_relative, int id_relationType, String name) {
        this.id = id;
        this.id_artist = id_artist;
        this.id_relative = id_relative;
        this.id_relationType = id_relationType;
        this.name_relative = name;
    }
    
    @Override
    public String toString() {
        String relation_name = "Pariente";
        try {
            relation_name = Logic.getRelation(id_relationType);
        }
        catch (Exception e) {}
        
        return name_relative + "  (" + relation_name + ")";
    }

    public int getId() {
        return id;
    }

    public int getId_artist() {
        return id_artist;
    }

    public int getId_relative() {
        return id_relative;
    }

    public int getId_relationType() {
        return id_relationType;
    }

    public String getName_relative() {
        return name_relative;
    }
    
    
}
