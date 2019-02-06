package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
public class Client
{
  public static void main(String[] args) throws UnknownHostException, IOException
  {
     Socket s = new Socket("127.0.0.1", 3000);
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     PrintStream p = new PrintStream(s.getOutputStream()); 
     InputStream sc1 = s.getInputStream();
     BufferedReader receive = new BufferedReader(new InputStreamReader(sc1));
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = br.readLine();  
        p.println(sendMessage);       
        p.flush();                    
        if((receiveMessage = receive.readLine()) != null) 
        {
            System.out.println(receiveMessage); 
        }         
      }               
    }                    
}                        