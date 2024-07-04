package ClientChatClient.ChatRoomServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket ;
    private String id ;
    private InputStream input ; // doc du lieu ra
    private OutputStream output ; // ghi du lieu vao
    private ChatServer chatServer;
    public ClientHandler(Socket socket, String id, ChatServer chatServer) {
        this.socket = socket;
        this.id = id;
        this.chatServer =chatServer;
        try {
            this.input = socket.getInputStream();
            this.output = socket.getOutputStream();
        }catch(Exception ex){
            ex.getMessage();
        }
    }

    @Override
    public void run() {
          try{
              byte[] buffer = new byte[1024];
              int bytesRead ;
              while ((bytesRead= input.read(buffer)) != -1){
                  String message = new String(buffer,0 , bytesRead);
                  chatServer.broadcastMessage(id,this.id + " : " +message);
              }
          }catch(Exception ex){
              System.out.println(ex.getMessage());
          }
    }
    public void sendMessage(String message){
        try {
            this.output.write(message.getBytes());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getId() {
        return id;
    }
}
