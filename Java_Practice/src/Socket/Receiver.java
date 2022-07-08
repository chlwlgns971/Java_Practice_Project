package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//이 쓰레드는 소켓을 통해서 메세지를 받는 역할만 담당한다.
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream din;
	
	//생성자
	public Receiver(Socket socket) {
		this.socket=socket;
		
		try {
			din=new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	@Override
	public void run() {
		while(din!=null) {
			try {
				System.out.println(din.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
