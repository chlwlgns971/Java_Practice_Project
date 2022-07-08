package Socket;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	/*
	 서버와 클라이언트가 접속이 완료되면 클라이언트가 'd:/d_other/펭귄.jpg'파일을 서버로 전송한다.
	 서버는 클라이언트가 보내온 파일을 받아서 d:/d_other/연습용 폴더에 저장한다.
	 */
	public static void main(String[] args) throws IOException {
		// TCP소켓 통신을 위해서 ServerSocket객체를 생성한다.
				ServerSocket server = new ServerSocket(7777);
				
				System.out.println("서버가 접속을 기다립니다.");
				
				//accept()메서드-> 클라이언트의 연결 요청이 올 때까지 계속 기다린다.
				//		->연결 요청이 오면 Socket객체를 생성해서 클라이언트의 Socket객체와 연결한다.
				Socket socket = server.accept();
				
				//accept()메서드 명령 이후의 내용은 연결이 완료되어야 실행된다.
				System.out.println("클라이언트와 연결되었습니다...");
				System.out.println();
				
				//Socket객체의 InputStream객체를 통해서 자료를 받는다.
				InputStream in=socket.getInputStream();
				DataInputStream din = new DataInputStream(in);
				FileOutputStream outS=new FileOutputStream("d:/d_other/연습용/펭귄.jpg");
				byte[] arr=new byte[4096];
				int len=0;
				while((len=din.read(arr))>0) {
					outS.write(arr,0,len);
				}
				System.out.println("파일받기가 완료되었습니다.");
				System.out.println("저장된 경로: d:/d_other/연습용");
				outS.close();
				din.close();
				socket.close();

	}

}
