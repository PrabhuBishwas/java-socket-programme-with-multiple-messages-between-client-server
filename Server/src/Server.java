import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
public class Server
{
  public static void main(String[] args) throws IOException
  {
      ServerSocket s = new ServerSocket(3000);
      System.out.println("Server is waiting");
      Socket s1 = s.accept( );                          
      System.out.println("Client is connected");                  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintStream p = new PrintStream(s1.getOutputStream()); 
      InputStream istream = s1.getInputStream();
      BufferedReader receive = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage, sendMessage;               
      while(true)
      {
        if((receiveMessage = receive.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = br.readLine(); 
        p.println(sendMessage);             
        p.flush();
      }               
    }                    
}                        