
package Model;

public class sysUser {
    private int id;
    private String email;
    private int phone_number;
    private int id_district;
    private int id_type;

    public sysUser(int id, String email, int phone_number, int id_district, int id_type) {
        this.id = id;
        this.email = email;
        this.phone_number = phone_number;
        this.id_district = id_district;
        this.id_type = id_type;
    }
}
