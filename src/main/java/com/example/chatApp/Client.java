package com.example.chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        Socket socket = new Socket("localhost", 9001);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String str;
        do {
            System.out.println("Client1:");
            str = userInput.readLine();
            out.println(str);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Server response: " + in.readLine());
        } while (!str.equals("stop"));

        socket.close();
    }
}
