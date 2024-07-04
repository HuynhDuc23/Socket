package SocketIO2_Client;

import SocketIO_Server.MyProcess;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            int port = 99 ;
            // create server
            ServerSocket serverSocket = new ServerSocket(port);
            // agree connect to client to server
            // chap nhan ket noi tu client

            while (true){
                // server chap nhan nhieu thread truy cap vao server
                Socket clientSocket = serverSocket.accept();
                MyProcess mp = new MyProcess(clientSocket);
                mp.start();
            }

            // bat dau trao doi thong tin voi nhau
            // doc va ghi du lieu khi client gui den
            // Cho ket noi
            //Thread.sleep(5000);
            // ngat ket noi
//            clientSocket.close();
//            serverSocket.close();
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
