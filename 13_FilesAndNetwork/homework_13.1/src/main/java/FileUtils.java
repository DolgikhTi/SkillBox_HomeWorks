import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {

        File file = new File(path);
        long length = 0L;

        for(File f : file.listFiles())
        {
            if(f.isDirectory())
            {
                for ( File child : f.listFiles())
                {
                    length = length + child.length();
                }
            }
            else
            {
                length = f.length();
            }
        }
        return length;
    }
}
