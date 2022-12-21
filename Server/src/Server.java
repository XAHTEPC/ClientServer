import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) throws IOException {

        try(ServerSocket server = new ServerSocket(8000);){
           System.out.println("Start!");
           while(true)
               try(Phone phone = new Phone (server))
               {
                   String request = phone.readLine();
                   System.out.println("request: " + request);
                   String response = (int) (Math.random()*40-10) + "";
                   Thread.sleep(4000);
                   phone.writeLine(response);
                   System.out.println("Response: " + response);

               } catch (NullPointerException | InterruptedException e) {
                   e.printStackTrace();
               }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
