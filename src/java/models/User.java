/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mixser
 */
public class User {
    private Long id;
    private String login;
    private String password;
    private Boolean admin;
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password) { 
        this.password = password;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    public Boolean getAdmin() {
        return admin;
    }
}
