import java.io.FileWriter;
import java.io.IOException;

public class OpenVideo {
    static OpenVideo example = new OpenVideo();

    public OpenVideo() {
        System.out.println("Hi");
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String fileName = "flotz.txt";

        try {
            String content = "You are being attacked";
            FileWriter fileWriter = new FileWriter(desktopPath + fileName);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Text file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String[] command = {"cmd", "/c", "start", "msedge", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (InterruptedException | IOException var3) {
            var3.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            String[] command = {"cmd", "/c", "start", "msedge", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (InterruptedException | IOException var3) {
            var3.printStackTrace();
        }

    }
}
