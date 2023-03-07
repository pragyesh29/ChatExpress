import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

class Server{
    public static void main(String[] args) {
        System.out.println("Waiting for Clients...");
        try{
            ServerSocket server_socket = new ServerSocket(8888);
            Socket clientSocket = server_socket.accept();
            System.out.println("Connection Established successfully...");

            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String messageFromClient = br.readLine();
                System.out.println("Client : " + messageFromClient);
                if(messageFromClient.equals("bye!")){
                    break;
                }else{
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    String responeToClient = in.readLine();
                    PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                    printWriter.println(responeToClient);
                }
            }
            System.out.println("Closing sockets");
            clientSocket.close();
            server_socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}