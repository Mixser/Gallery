/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mixser
 */
public class Picture  {
    private Long id;
    private String title;
    private String details;
    private String fileName;
    private String removeCode;
    private Long userId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDetails() {
        return details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setRemoveCode(String removeCode) {
        this.removeCode = removeCode;
    }
    
    public String getRemoveCode() {
        return removeCode;
    }
    
    public String getUrlForDelete() {
        return "/picture/delete/?id="+id+"&rem_code="+removeCode;
    }
    
    public String getUrlForEdit() {
        return "/picture/edit/?id="+id+"&code="+removeCode;
    }
    
    
}
