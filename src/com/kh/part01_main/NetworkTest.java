package networkTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress Test
		InetAddress localIP = InetAddress.getLocalHost();
		
		System.out.println(localIP.getHostAddress());
		System.out.println(localIP.getHostName());
		
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println(naverIp.getHostAddress());
		
		InetAddress[] googleIps = InetAddress.getAllByName("www.google.com");
		System.out.println("구글 서버 ip 갯수 : " + googleIps.length);
		
		for(InetAddress ip : googleIps) {
			System.out.println(ip.getHostAddress());
			
		}
	}

}
