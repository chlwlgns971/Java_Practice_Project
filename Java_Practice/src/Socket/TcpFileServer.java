package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
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
	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataInputStream din;
	public static void main(String[] args) throws IOException {
//		// TCP소켓 통신을 위해서 ServerSocket객체를 생성한다.
//		ServerSocket server = new ServerSocket(7777);
//		
//		System.out.println("서버가 접속을 기다립니다.");
//		
//		//accept()메서드-> 클라이언트의 연결 요청이 올 때까지 계속 기다린다.
//		//		->연결 요청이 오면 Socket객체를 생성해서 클라이언트의 Socket객체와 연결한다.
//		Socket socket = server.accept();
//		
//		//accept()메서드 명령 이후의 내용은 연결이 완료되어야 실행된다.
//		System.out.println("클라이언트와 연결되었습니다...");
//		System.out.println();
//		
//		//Socket객체의 InputStream객체를 통해서 자료를 받는다.
//		InputStream in=socket.getInputStream();
//		DataInputStream din = new DataInputStream(in);
//		FileOutputStream outS=new FileOutputStream("d:/d_other/연습용/펭귄.jpg");
//		byte[] arr=new byte[4096];
//		int len=0;
//		while((len=din.read(arr))>0) {
//			outS.write(arr,0,len);
//		}
//		System.out.println("파일받기가 완료되었습니다.");
//		System.out.println("저장된 경로: d:/d_other/연습용");
//		outS.close();
//		din.close();
//		socket.close();
		
		//==============================================================================
		//선생님 풀이
		new TcpFileServer().serverStart();

	}
	public void serverStart() {
		//저장할 폴더 정보를 갖는 File객체 생성
		File saveDir=new File("d:/d_other/연습용");
		if(!saveDir.exists()) {
			//저장할 폴더가 없으면 새로 만들어 준다.
			saveDir.mkdirs();
		}
		try {
			server=new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			socket=server.accept(); //클라이언트 요청 기다리기
			System.out.println("파일 저장 시작...");
			
			//클라이언트가 맨 처음 보낸 '파일명'데이터를 받음
			//입력용 스트림 객체 생성
			din=new DataInputStream(socket.getInputStream());
			String fileName=din.readUTF(); //파일명 받기
			
			//파일 저장위치와 파일명을 지정하여 File객체 생성
			File file=new File(saveDir, fileName);
			
			//클라이언트가 전송할 파일 내용을 읽어서 저장할 스트림 객체 생성
			bin=new BufferedInputStream(socket.getInputStream());
			bout=new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] temp=new byte[1024];
			int len=0;
			while((len=bin.read(temp))>0) {
				bout.write(temp,0,len);
			}
			bout.flush();
			System.out.println("파일 저장 완료...");
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}finally {
			if(din!=null) try {din.close();} catch(IOException e) {}
			if(bin!=null) try {bin.close();} catch(IOException e) {}
			if(bout!=null) try {bout.close();} catch(IOException e) {}
			if(socket!=null) try {socket.close();} catch(IOException e) {}
			if(server!=null) try {server.close();} catch(IOException e) {}
		}
	}

}
