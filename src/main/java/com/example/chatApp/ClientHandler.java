package com.example.chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run()  {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String str;
            while (!(str = in.readLine()).equals("stop")) {
                out.println(str);
                System.out.println("Server says: " + str);
            }
            System.out.println("Connection closed");
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

