package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//전송만을 하는 쓰레드
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	private String name;
	private Scanner sc;
	
	//생성자
	public Sender(Socket socket) {
		this.socket=socket;
		sc = new Scanner(System.in);
		
		System.err.print("대화명 입력>>");
		name=sc.nextLine();
		
		try {
			dout=new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(dout!=null) {
	         try {
	            dout.writeUTF(name + " : " + sc.nextLine());
	         } catch (IOException e) {
	            
	         }
		}

	}
}

