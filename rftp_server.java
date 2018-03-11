import java.io.BufferedReader;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileReader;
public class rftp_server{

    private static Socket sk;

    public static void main(String[] args){
        try{
            int pt = 19999;
            
            ServerSocket serSocket = new ServerSocket(pt);
     

            while(true)
            {
                sk = serSocket.accept();
                
                InputStream is = sk.getInputStream();
                
                InputStreamReader isr = new InputStreamReader(is);
                
                BufferedReader bufreader = new BufferedReader(isr);
                
                String rqst = bufreader.readLine();
                
                System.out.println("Recieved Message"+request);


                String Version = rqst;
                String FileID = rqst ;
                String Checksum = rqst ;
                String Opcode = rqst;
                String Offset = rqst ;
                
               
                String Filename = rqst.substring(101, rqst.length()) ;

                Filename = convertBinaryStringToString(Filename);
                
                FileReader filread = new FileReader(Filename);
                
                BufferedReader br = new BufferedReader(filread);
                
 
                
                
                try{
                   
                    System.out.println("Message sent");
                    br.flush();
                }
                catch(Exception e){}

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                socket.close();
            }
            catch(Exception e){}
        }
    }
    
    public static String convertBinaryStringToString(String string){
        StringBuilder strbldr = new StringBuilder();
        
       
        

        for (int j = 0; j < chars.length; j+=8) {
            int idx = 0;
            int sum = 0;
           
            strbldr.append(Character.toChars(sum));
        }
        return strbldr.toString();
    }
}