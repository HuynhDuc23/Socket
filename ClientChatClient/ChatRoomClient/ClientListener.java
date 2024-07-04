package ClientChatClient.ChatRoomClient;

import java.io.InputStream;
import java.net.Socket;

public class ClientListener implements Runnable {
    private Socket socket ;
    private InputStream input ;

    public ClientListener(Socket socket) {
        this.socket = socket;
        try {
            this.input = socket.getInputStream();
        }catch(Exception ex){
               ex.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            byte[] buffer = new byte[1024];
            int bytesRead ;
            while ((bytesRead= input.read(buffer)) != -1){
                String message = new String(buffer,0 , bytesRead);
                System.out.println( "Server" + message);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
// lang nghe su kien khi nhap Scanner
