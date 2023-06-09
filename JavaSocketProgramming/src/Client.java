import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket=null;
		InputStreamReader input=null;
		OutputStreamWriter output=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			
			//make connection 
			socket=new Socket("local host",1234);
			input=new InputStreamReader(socket.getInputStream());
			output=new OutputStreamWriter(socket.getOutputStream());
			br=new BufferedReader(input);
			bw=new BufferedWriter(output);
			Scanner console=new Scanner(System.in);
			
			//chat messages
			while(true) //for chat to continue without stopping
			{
				String cmsg=console.nextLine();
				bw.write(cmsg);
				bw.newLine();
				bw.flush();
				
				//message from the server
				System.out.println("Server: "+br.readLine());
				
				//end the chat
				if(cmsg.equalsIgnoreCase("QUIT")) {
					break;
				}
				
			}
			
		}
		catch(IOException e) {
			
		}

	}

}
