import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CreateFileExample {
    public static void main(String[] args) {
        String desktopPath = "C:\\Users\\TLP-242\\Desktop";

        try {
            // Create the directory if it doesn't exist
            File desktopDirectory = new File(desktopPath);
            if (!desktopDirectory.exists()) {
                desktopDirectory.mkdirs();
            }

            // Generate a random filename
            String fileName = UUID.randomUUID().toString() + ".txt";

            // Create the file
            File file = new File(desktopPath, fileName);
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
