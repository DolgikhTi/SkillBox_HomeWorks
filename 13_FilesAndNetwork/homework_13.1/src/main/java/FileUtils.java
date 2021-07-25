import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        try {
            return Files.walk(Path.of(path))
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
        }catch (IOException e) {
            return 0L;
        }
    }

    public static String sizeConverter(long originalSize) {

        final String[] units = {" bytes", " Kb", " Mb", " Gb", " Tb", " Pb"};
        int unitIndex = 0;

        double tempSize = (double) originalSize / 1024;

        while (tempSize >= 1) {
            tempSize = tempSize / 1024;
            unitIndex++;
        }
        if (unitIndex == 0) {
            return originalSize + units[unitIndex];
        } else {
            return (Math.round(10 * originalSize / (Math.pow(1024, (unitIndex)))) / 10.0) + units[unitIndex];
        }
    }
}
