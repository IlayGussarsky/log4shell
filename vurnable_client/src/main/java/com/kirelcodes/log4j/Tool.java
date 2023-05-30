import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Tool {
    static Tool example = new Tool();

    public Tool() {
        String PathToExtremelyImportantFile = "C:\\Users\\TLP-242\\Desktop\\extremely_important_file.txt";
        int key = 1;
        try {
            // Read the file bytes
            byte[] fileBytes = Files.readAllBytes(Paths.get(PathToExtremelyImportantFile));

            // XOR each byte with the key
            for (int i = 0; i < fileBytes.length; i++) {
                fileBytes[i] ^= key;
            }

            // Write the modified bytes back to the file
            Files.write(Paths.get(PathToExtremelyImportantFile), fileBytes);
            System.out.println("File encryption completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while encrypting the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi:)");
    }
}