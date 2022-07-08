package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverInfo = "localhost";
		System.out.println(serverInfo+" 서버에 연결 중입니다...");
		
		//서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다. ->Socket객체가 생성이 완료되면 해당 서버로 연결 요청을 보낸다.
		Socket socket = new Socket(serverInfo,7777);
		
		//Socket객체가 정상적으로 생성되었다면 서버와 연결이 완료되었다는 의미이고, 이 객체 생성 명령 이후에는 연결된 후의 작업을 기술하면 된다.
		File img=new File("d:/d_other/images/펭귄.jpg");
		byte[] arr=new byte[(int)img.length()];
		DataInputStream inS=new DataInputStream(new FileInputStream(img));
		OutputStream out=socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		int len=0;
		while((len=inS.read(arr))>0) {
			dout.write(arr,0,len);
		}
		
		inS.close();
		dout.close();
		socket.close();
		System.out.println("복사완료!");
	}
}
