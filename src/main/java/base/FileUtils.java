package base;

import java.io.File;

public class FileUtils {
    public static boolean moveFile(File file, String destination){

        File existingFile = new File(destination);
        if(existingFile.exists()){
            existingFile.delete();
        }

        return file.renameTo(new File(destination));
    }
}
