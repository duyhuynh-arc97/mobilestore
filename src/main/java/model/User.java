package model;

public class User {
    private String username;
    private String password;

    public User(){
        
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String a){
        this.username = a;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String a){
        this.password = a;
    }
}
