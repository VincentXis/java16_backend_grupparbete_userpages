package se.nackademin.domain;

import se.nackademin.session.IPersistable;

public class User implements IPersistable{
    private String id;
    private String userName;
    private String password;

    // Constructor

    public User() {
        id = "1";
    }
    
    
    // Get
    @Override
    public String getId() {
        return id;
    }
    
    public String getUserName() {
        if (userName == null) {
            userName = "wawa";
        }
        return userName;
    }

    public String getPassword() {
        if (password == null) {
            password = "123";
        }
        return password;
    }

    // Set
    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    
    
}
