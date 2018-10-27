import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String ipAddress = "localhost";
		int portNumber = 9000;
			
		Socket socket = new Socket(ipAddress, portNumber);
		
		System.out.println("Enter the name of the file ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println(fileName);
		while(true) {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if(bReader.ready()) {
				System.out.println(bReader.readLine());
			}
		}
	}
}
