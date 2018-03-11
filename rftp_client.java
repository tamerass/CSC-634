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



public class rftp_client {

    public static Socket sk;

    public static void main(String args[]) {
    	
        try{
        	
            String ht = "host";
            
            InetAddress adrs = InetAddress.getByName(ht);
            int port = 2555;

            sk = new Socket(adrs, port);

            OutputStream opS = sk.getOutputStream();
            
            OutputStreamWriter opsW = new OutputStreamWriter(opS);
            
            BufferedWriter bw = new BufferedWriter(opsW);
            
            int Version = 1;
            
            int Opcode = 1;
            
            int FileID = 1100;
            
            int Filename = 100 ;
            
            int Offset = 0 ;
            
            int Checksum = Version+Opcode+Offset+FileID+Filename;

            int req = Version + Opcode + Checksum + FileID + Offset + Filename;
            
            int message = req ;
            
            bw.write(message);
            
            
            System.out.println("message has been sent");
            
            bw.flush();
            
            InputStream inpst = sk.getInputStream();
            
            InputStreamReader inpstrr = new InputStreamReader(inpst);
            
            BufferedReader bufred = new BufferedReader(inpstrr);
            
            int id;
            
            while (id != 0) {    
            	
            	System.out.println("message " +id +" received");
            }
            
        }
        catch (Exception ex){
        	
        	ex.printStackTrace();
        }
        finally{
            try{
            	sk.close();
            }
            catch(Exception ex1){
            	
                ex1.printStackTrace();
            }
        }
    }
    
}