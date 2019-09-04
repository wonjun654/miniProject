package networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
//		1. 서버의 포트번호를 정한다.
		int port = 8500;
		
//		2. 서버용 소캣 객체를 생성한다
		try {
			ServerSocket server = new ServerSocket(port);
			
//			3. 클라이언트쪽에서 접속 요청이 오기를 기다린다.
			while(true) {
//				4. 접속 요청이 오면 요청을 수락하고 해당 클라이언트에 대한 소켓 객체를 생성한다.
				Socket client = server.accept();
				
//				5. 연결된 클라이언트와 입출력 스트림을 생성한다.
				InputStream input = client.getInputStream();
				OutputStream output = client.getOutputStream();
				
//				6. 보조스트림을 통해 성능을 개선시킨다.
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
				
//				7. 스트림을 통해 읽고 쓰기를 한다.
				while(true) {
					String message = br.readLine();
					
					if(message.equals("exit")) {
						System.out.println(client.getInetAddress().getHostAddress() + "가 보낸 메세지 :" + message);
						pw.println("메세지 받기 성공");
						pw.flush();
						
					}else {
						System.out.println("접속 종료");
						break;
					}
				}
//				8. 통신을 종료한다.
				client.close();
				br.close();
				pw.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
