
package DataAccess;

import java.io.File;
import java.io.FilenameFilter;


public class FileDA implements FilenameFilter{

    private String extn;
    
    public FileDA(String extn){
    this.extn = extn.toLowerCase();
    }
    
    
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(extn);
        
    }
    
}
