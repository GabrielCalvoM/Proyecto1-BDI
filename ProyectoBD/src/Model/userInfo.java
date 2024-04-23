package Model;

public class userInfo {
    private static userInfo instance;
    private Account account;

    private userInfo() {
        
    }

    public static userInfo getInstance() {
        if (instance == null) {
            instance = new userInfo();
        }
        return instance;
    }
    
    public Account getAccount() {
        if (account != null){
            return account;
        }
        return null;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
}

