/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import models.User;
import controllers.UrlParams;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mixser
 */
public class UserDB {
    private Long lastGeneratedId = 0l;
    private static UserDB instance;
    
    
    private UserDB() {
        
    }
    
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(UrlParams.driver);
        Connection connection = DriverManager.getConnection(UrlParams.dataBaseUrl + "/gallery", "root", "159357852");
        return connection;
    }
    
    private List<User> selectUsersFromDB(String line) throws SQLException, ClassNotFoundException {
            List<User> result = new ArrayList<User>();
            Connection con = getConnection();
            Statement stat = con.createStatement();
            ResultSet set = stat.executeQuery(line);
            while (set.next()) {
                User user = new User();
                user.setId(set.getLong(1));
                user.setLogin(set.getString(2));
                user.setPassword(set.getString(3));
                user.setAdmin(set.getBoolean(4));
                result.add(user);
            }
            con.close();
            return result;
    }
    
    
    public static UserDB getInstance() { 
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }
    
    
    public User getUserById(Long id) {
        User user = null;
        try {
             List<User> users = selectUsersFromDB("SELECT * FROM user WHERE (id="+id+");");
             if (users.size() > 0)
                 user = users.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return user;
        }
    }
    
    public User getUserByLogin(String login) {
        User user = null;
        try {
             List<User> users = selectUsersFromDB("SELECT * FROM user WHERE (login=\""+login+"\");");
             if (users.size() > 0)
                 user = users.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return user;
        }
    }
    
    public List<User> getUsers() { 
        List<User> users = null;
        try {
             users = selectUsersFromDB("SELECT * FROM user;");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return users;
        }
    }
    
    
}
