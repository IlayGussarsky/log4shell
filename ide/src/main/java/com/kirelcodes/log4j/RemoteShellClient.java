package com.kirelcodes.log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteShellClient {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        String END_STRING = "asdfg";

        String serverAddress = "127.0.0.1"; // Replace with the IP address of the server
        int serverPort = 9919; // Replace with the port number of the server

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + serverAddress + ":" + serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String command;
            do {
                System.out.print("Enter a command (or 'exit' to quit): ");
                command = consoleReader.readLine();
                System.out.println(command);
                out.println(command); // Send the command to the server

                System.out.println(ANSI_RED + " ---- Server response ---- " + ANSI_RESET);
                String response;
                while ((response = in.readLine()) != null && !response.contains(END_STRING)) {
                    System.out.println("\t" + ANSI_RED + response + ANSI_RESET);
                }

            } while (!command.equalsIgnoreCase("exit"));

            // Cleanup
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}