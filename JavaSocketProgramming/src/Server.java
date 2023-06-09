import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket=null;
		InputStreamReader input=null;
		OutputStreamWriter output=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		ServerSocket ssocket=null;
		
		while(true)// will run forever
		{
			try {
				//making connection
				ssocket=new ServerSocket(1234);
				socket=ssocket.accept();
				input=new InputStreamReader(socket.getInputStream());
				output=new OutputStreamWriter(socket.getOutputStream());
				br=new BufferedReader(input);
				bw=new BufferedWriter(output);
				Scanner console=new Scanner(System.in);
				//chat
				while(true) {
					String mfcl=br.readLine();
					System.out.println("Client: "+mfcl);
					bw.write("Message received.");
					bw.newLine();
					bw.flush();
					
					
					//end chat
					if(mfcl.equalsIgnoreCase("QUIT")) {
						break;
					}
				}
			}
			catch(IOException e) {
				
			}
			
		}
		

	}

}
