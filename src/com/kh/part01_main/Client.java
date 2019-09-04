package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
//		1. 서버의 IP주소와 서버가 정한 port번호를 매개변수로 하여 클라이언트용 소켓 객체를 생성한다.
		int port = 8500;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			String serverIp = InetAddress.getLocalHost().getHostAddress();
			//System.out.println("serverIp : " + serverIp);
			
			Socket socket = new Socket(serverIp, port);
			
			if(socket != null) {
//			2. 서버와의 입출력 스트림을 오픈한다.
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				
//			3. 보조스트림을 붙여 성능을 개선한다.
			br = new BufferedReader(new InputStreamReader(input));
			pw = new PrintWriter(output);
				
//			4. 스트림을 통해 읽고 쓰기를 한다.
			Scanner sc = new Scanner(System.in);
			
			do {
				System.out.print("대화 입력 :");
				String message = sc.nextLine();
				
				pw.println(message);
				pw.flush();
				
				if(message.equals("exit")) {
					break;
				}
				
				String recieveMessage = br.readLine();
				System.out.println(recieveMessage);
				sc.nextLine();
				
				
			}while(true);
			
//			5. 통신을 종료한다.
			socket.close();
			
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
