package SocketIO_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyProcess extends Thread{
    private Socket socket ;

    public MyProcess(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
      try {
          // doc du lieu
          BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          // ghi du lieu
          PrintWriter write = new PrintWriter(socket.getOutputStream());

          Scanner sc = new Scanner(System.in);
          while (true){
              // nhan tin nhan tu client
              String message ;
              while((message = reader.readLine()) != null){
                  System.out.println("Client: "+message);
              }
              // gui tin nhan
              System.out.println("Server : ");
              message= sc.nextLine();
              write.println(message);
          }

     }catch (Exception ex){


      }
    }
}
