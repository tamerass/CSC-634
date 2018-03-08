import java.util.Scanner ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.Arrays;
import java.util.Timer;

public class GBN {
	
	public static void main(String[] args) throws IOException
    {
		
        FileReader file = new FileReader("Sender.txt");
        int[] intS = new int [7];
        int[] intR = new int[intS.length];
        int[] intA = new int[intS.length];
        int i=0;
        int s;
        
        Timer tm = new Timer();
        TimerTask tk = new TimerTask() {
            @Override
         public void run() {
          System.out.println("Begin clock" + System.currentTimeMillis());
             }
        };

        System.out.println("clock" + System.currentTimeMillis());
        tm.schedule(tk, 100,100);
        System.out.println("clock " + System.currentTimeMillis());

        
      
        //store the file into multiple packets  
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
            	intS[i] = input.nextInt();
                i++;
            }
            input.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(intS));
        System.out.println(intS[0]);
    
	
	//three way handshake protocol
	//Syn
	intR[0]=intS[0];
    intR[0]+=1;
    System.out.println(intR[0]);
    
	//Syn Ack
    if(intR[0]==101){
    //Ack
	Scanner sz =new Scanner(System.in);
	System.out.println("Please enter the window size: ");
	s =sz.nextInt();
	intS[0]=s;	
	System.out.println("Connection established: window size= "+ intS[0]);
	}
    
	else{
		System.out.println("Connection is not established");
		}
    
    System.out.println("Which Packet is lost");
    int l;
    
    Scanner so =new Scanner(System.in);
    l=so.nextInt();
  while(true){
	for(int u=0;u<l;u++){
		intR[u]=intS[u];
		System.out.println(intR[u]);
		intA[u]=u;
	}
	
	for(int m=l+1;m<intR.length;m++){
		intR[m]=intS[m];
		System.out.println(intR[m]);
		intA[m]=m;	
	
	
	if(intR[l]==0){
		System.out.println("The ACK  "+l+" is not received");
		
	}
	return True ;
	}
}
    }
