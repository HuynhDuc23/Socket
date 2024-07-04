package ClientChatClient.ChatRoomClient;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String URL ="localhost";
    private static final int PORT = 5000 ;


    public void startClient(){
        try {
            // ket noi den server
            Socket socket = new Socket(URL , PORT);
            System.out.println("Connected to server ");
            // lien tuc doc du lieu tu server
            ClientListener client = new ClientListener(socket);
            new Thread(client).start();

            // lien tuc doc du lieu tu scanner
            OutputStream output = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true){
                String message = sc.nextLine();
                output.write(message.getBytes());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
