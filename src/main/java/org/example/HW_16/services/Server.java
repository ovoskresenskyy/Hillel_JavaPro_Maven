package org.example.HW_16.services;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static ApplicationService applicationService;

    public static void start(){

        try (ServerSocket serverSocket = new ServerSocket(10160)){
            System.out.println("Server is started!");

            Socket clientSocket = serverSocket.accept();

            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                applicationService = new ApplicationService();
            } catch (IOException e) {
                System.out.println("Connection is broken");
                applicationService.closeApplication();
            }

        } catch (IOException e){
            System.out.println("Connection is broken");
            applicationService.closeApplication();
        }
    }

    public static void sendMessage(String message){
        try {
            writer.write("\n" + message);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Message didn't send to user.");
        }
    }

    public static String getUserInput(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "x";
        }
    }
}
