package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataOutputStream dout;
	public static void main(String[] args) throws UnknownHostException, IOException {
//		String serverInfo = "localhost";
//		System.out.println(serverInfo+" 서버에 연결 중입니다...");
//		
//		//서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다. ->Socket객체가 생성이 완료되면 해당 서버로 연결 요청을 보낸다.
//		Socket socket = new Socket(serverInfo,7777);
//		
//		//Socket객체가 정상적으로 생성되었다면 서버와 연결이 완료되었다는 의미이고, 이 객체 생성 명령 이후에는 연결된 후의 작업을 기술하면 된다.
//		File img=new File("d:/d_other/images/펭귄.jpg");
//		byte[] arr=new byte[(int)img.length()];
//		DataInputStream inS=new DataInputStream(new FileInputStream(img));
//		OutputStream out=socket.getOutputStream();
//		DataOutputStream dout = new DataOutputStream(out);
//		
//		int len=0;
//		while((len=inS.read(arr))>0) {
//			dout.write(arr,0,len);
//		}
//		
//		inS.close();
//		dout.close();
//		socket.close();
//		System.out.println("복사완료!");
		
		//========================================================================
		//선생님 풀이
		new TcpFileClient().clientStart();
	}
	public void clientStart() {
		
		//전송할 파일 정보를 갖는 File객체 생성
		File file=new File("d:/d_other/images/펭귄.jpg");
		String fileName = file.getName();
		if(!file.exists()) {
			System.out.println(fileName+" 파일이 없습니다.");
			System.out.println("작업종료...");
			return;
		}
		try {
			socket =new Socket("localhost",7777);
			System.out.println("파일 전송 시작...");
			dout=new DataOutputStream(socket.getOutputStream());
			
			//서버와 접속이 완료되면 전송할 파일이름을 제일 먼저 전송한다.
			dout.writeUTF(fileName);
			
			//파일 읽기용 스트림 객체 생성
			bin=new BufferedInputStream(new FileInputStream(file));
			
			//서버로 출력(전송)하기 위한 출력용 스트림 객체 생성
			bout=new BufferedOutputStream(socket.getOutputStream());
			byte[] temp=new byte[1024];
			int len=0;
			while((len=bin.read(temp))>0) {
				bout.write(temp,0,len);
			}
			bout.flush();
			System.out.println("파일 전송 완료...");
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		}finally {
			//사용했던 스트림과 소켓 닫기
			if(dout!=null)  try {dout.close();} catch(IOException e) {}
			if(bin!=null)  try {bin.close();} catch(IOException e) {}
			if(bout!=null)  try {bout.close();} catch(IOException e) {}
			if(socket!=null)  try {socket.close();} catch(IOException e) {}
		}
	}
}
