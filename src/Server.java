import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket serverSocket = new ServerSocket(9000);
		System.out.println("Server is up and running!");
		
		Socket socket = serverSocket.accept();
		
		while(true) {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if(bReader.ready()) {
				String fileName = bReader.readLine();
				System.out.println("Searching for file: " + fileName); 
				 
				File file = new File("/Users/Sandeep/Documents/eclipse-workspace/SocketCNLAB/client.txt");
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				String existingFile = file.getName();
				if(fileName.equals(existingFile)) {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					boolean flag = true;
					
					while(flag) {
						String string = fileReader.readLine();
						if(string == null) {
							flag = false;
							break;
						}
						System.out.println(string);
						out.println(string);
						Thread.sleep(2000);
					}
				}
				else {
					System.out.println("There is no file " + fileName + " in server!");;
					out.println("Sorry, No such file exists!");
				}
			}
			
		}
	
		
	}

}
