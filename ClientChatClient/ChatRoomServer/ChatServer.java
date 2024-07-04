package ClientChatClient.ChatRoomServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 5000 ;
    private List<ClientHandler> clients = new ArrayList<>();

    public  void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server listening" + PORT);
            // wait connect client to server
            while(true){
                // moi khi co 1 client connect ts , tao ra mot socket
                Socket clientSocket = serverSocket.accept();
                System.out.println("New  Client connect den server" + clientSocket.getInetAddress().getHostAddress());
                // 1 luong
                // 1  su ket noi giua client va server va 1 id
                ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis()+"", this);
                clients.add(clientHandler);
                // create thread
                new Thread(clientHandler).start();
            }
        }catch(Exception ex){
            ex.getMessage();
        }
    }
    // xu ly truong hop khong gui ve chinh user do
    public void  broadcastMessage( String id , String message){
        for(var client : clients){
            if(!(client.getId().equals(id))){
                client.sendMessage(id +" "+ message);
            }

        }
    }

}
