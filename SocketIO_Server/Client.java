package SocketIO_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            int port =  99 ;
            Socket socket = new Socket("localhost", port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // ghi du lieu
            PrintWriter write = new PrintWriter(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            String message ;
            while (true){
                // gui tin nhan
                System.out.println("Client :");
                message = sc.nextLine();
                // day du lieu di
                write.println(message);
                write.flush();
                // nhan tin nhan
                message = reader.readLine();
                System.out.println("Server :"+ message);
            }
        }catch(Exception ex){
            System.out.println("Error");
        }

    }
}
