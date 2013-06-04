package controllers;


import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.http.fileupload.FileUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mixser
 */
public class FileSaver {
    private static final String path ="/home/mixser/NetBeansProjects/Gallery/build/web/images/";
            
    public static boolean saveFile(InputStream input, String fileName) {
        FileOutputStream out = null;
        File file = null;
        int size = 0; 
        try {
            file = new File(path + fileName);
            out = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int read = 0;
            
            while ((read = input.read(bytes)) != -1) { 
                out.write(bytes, 0, read);
                size += read;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(out);
            if (size > 5 * 1024 * 1024 || size == 0) {
                if (file != null)
                    file.delete();
                return false;
            }
            return true;
        }
    }
    
    private static void close(Closeable closeable) {
        try { 
            if (closeable != null)
                closeable.close();
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
