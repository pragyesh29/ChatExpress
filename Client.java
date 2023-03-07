import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            System.out.println("Client Started...");
            Socket soc = new Socket("localhost", 8888);

            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String message = br.readLine();
                PrintWriter printwriter = new PrintWriter(soc.getOutputStream(), true);
                printwriter.println(message);
                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String recievedMessage = in.readLine();
                System.out.println("Server : " + recievedMessage);
                if(recievedMessage.equals("ok Bye!")){
                    break;
                }
            }
            soc.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}