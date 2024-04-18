package Model;

public class Account {
    private int id;
    private String username;
    private String password;
    private int id_user;
    private int id_accountType;
    private int id_catalogue;
    
    public Account(int id, String username, String password, 
        int id_user, int id_accountType, int id_catalogue) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.id_user = id_user;
            this.id_accountType = id_accountType;
            this.id_catalogue = id_catalogue;
    }
}
