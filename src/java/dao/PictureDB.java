/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Picture;
import controllers.UrlParams;
import java.util.ArrayList;
/**
 *
 * @author mixser
 */
public class PictureDB {
    private Long lastGeneratedId = 0l;
    private static PictureDB instance;
    private boolean needToRefreshPicures;
    
    public static PictureDB getInstance() { 
        if (instance == null) {
            instance = new PictureDB();
        }
        return instance;
    }
    
    private PictureDB() { 
       
    }
    
    private static Connection connectToDataBase() throws SQLException, ClassNotFoundException { 
       Class.forName(UrlParams.driver);
       Connection connection = DriverManager.getConnection(UrlParams.dataBaseUrl + "/gallery", "root", "159357852");
       return connection;
    }
    
    private List<Picture> selectPicturesFromDB(String line) throws SQLException, ClassNotFoundException {
        List<Picture> pictures = new ArrayList<Picture>();
        Connection connection = connectToDataBase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(line);
        while (resultSet.next()) {
            Picture picture = new Picture();
            picture.setId(resultSet.getLong(1));
            picture.setTitle(resultSet.getString(2));
            picture.setDetails(resultSet.getString(3));
            picture.setUserId(resultSet.getLong(4));
            picture.setRemoveCode(resultSet.getString(5));
            picture.setFileName(resultSet.getString(6));
            pictures.add(picture);
        }
        return pictures;
    } 
    
    private Long getLastId() {
        Long id = null;
         try {
            Connection connection = connectToDataBase();
            Statement stat = connection.createStatement();
            String query = "SELECT id FROM picture ORDER BY id DESC LIMIT 0, 1;";
            ResultSet res = stat.executeQuery(query);
            if (res.next()) 
                id = res.getLong(1);
            else 
                id = 0l;
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             return id;
         }
    }

    
    
    
    public void addPicture(Picture picture)  {
        picture.setId(getLastId()+1);
        try {
            Connection connection = connectToDataBase();
            Statement stat = connection.createStatement();
            String query = String.format("INSERT INTO picture (id,title,details,filename,user_id,remove_code)"
                    + " VALUES(%d,\"%s\",\"%s\",\"%s\",%d,\"%s\")",picture.getId().intValue(),
                    picture.getTitle(), picture.getDetails(), picture.getFileName(),picture.getUserId(),picture.getRemoveCode());
            stat.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePictureById(Long id) {
        if (getPictureById(id) != null) {
            try {
            Connection connection = connectToDataBase();
            Statement stat = connection.createStatement();
            String query = "DELETE FROM picture WHERE id="+id+";";
            stat.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public Picture getPictureById(Long id) {
        Picture picture = null;
        List<Picture> pictures;
        try {
            pictures = selectPicturesFromDB("SELECT * FROM picture WHERE (id="+id+");");
            if (pictures.size() > 0) 
                picture = pictures.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return picture;
        }
    }
    
    public List<Picture> getPictures() {
        List<Picture> pictures = null;
        try {
            pictures = selectPicturesFromDB("SELECT * FROM picture;");
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return pictures;
        }
    }
    
    public List<Picture> getLastPictures(int count) {
        List<Picture> res = null;
        try {
            res = selectPicturesFromDB("SELECT * FROM picture ORDER BY id DESC LIMIT 0, "+count);
        } catch (SQLException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public void saveOrUpdatePicture(Picture picture) {
        if (getPictureById(picture.getId()) != null)
            updatePicture(picture);
        else 
            addPicture(picture);
    }
    
    public void updatePicture(Picture picture)  {
            try {
                Connection connection = connectToDataBase();
                Statement stat = connection.createStatement();
                String query = String.format("UPDATE picture SET title=\"%s\", details=\"%s\", filename=\"%s\","
                        + "remove_code=\"%s\" WHERE id=%d;", picture.getTitle(), picture.getDetails(), picture.getFileName(), picture.getRemoveCode(),picture.getId());
                stat.executeUpdate(query);
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PictureDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
