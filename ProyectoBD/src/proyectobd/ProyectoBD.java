package proyectobd;

import Control.Cursors;
import Control.Insertions;

public class ProyectoBD {
    public static void main(String[] args) {
        try {
            Cursors.getCountries();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
