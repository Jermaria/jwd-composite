package by.jwd.task7.validation;

import java.io.File;

public class FileValidator {
    
    public static boolean isSourceValid (String path) {   
        File file = new File(path);
        boolean isValid = file.isFile() && file.length() > 0;
        return isValid;
    }
}
