package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import Chapter10.TryCatch01;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	
	} 
    private void clientStart() {
    	Socket socket = null;
      
     	try {
     		socket = new Socket("192.168.143.5", 7777);
     		System.out.println("서버에 연결되었습니다");
     		System.out.println();
     		
     		//메세지 전송용 쓰레드 생성
     		ClientSender sender = new ClientSender(socket);
     		//메세지 수신용 쓰레드 생성
            ClientReceiver receiver = new ClientReceiver(socket);
            
            sender.start();
            receiver.start();

     	}catch(Exception e) {
     		
     	}


	}
    // 메시지 전송용 쓰레드
    class ClientSender extends Thread{
       private Socket socket;
       private DataInputStream din;
       private DataOutputStream dout;
       private String name;
       private Scanner sc;
       
       //생성자
       public ClientSender(Socket socket) {
    	   this.socket=socket;
    	   sc=new Scanner(System.in);
    	   try {
    		   //수신용
    		   din=new DataInputStream(socket.getInputStream());
    		   //송신용
    		   dout=new DataOutputStream(socket.getOutputStream());
    		   
    		   if(din!=null) {
    			   do {
    				   //클라이언트용 프로그램은 처음 실행하면 서버에 접속하고 접속이 성공하면 대화명을 입력받아 서버로 전송
    				   //서버로부터 대화명의 중복여부를 응답으로 받는다.
    				   System.out.println("대화명: ");
    				   String name=sc.nextLine();
    				   dout.writeUTF(name);
    				   
    				   //대화명의 중복여부를 응답으로 받는다.
    				   String feedback=din.readUTF();
    				   if("대화명중복".equals(feedback)) {
    					   System.out.println(name+"은 대화명이 중복됩니다.");
    					   System.out.println("다른 대화명을 입력하세요.");
    				   }
    				   else {
    					   this.name=name;
    					   System.out.println(name+" 대화명으로 대화방에 입장했습니다...");
    					   break;
    				   }
    			   }while(true);
    		   }
    		  
    	   } catch (Exception e) {
			// TODO: handle exception
    	   }
    	   
       }
       @Override
       public void run() {
          try {
             while(dout !=null) {
                //키보드로 입력한 메시지를 서버로 전송한다.
                dout.writeUTF("[" + name + "]" + sc.nextLine());
             }   
          } catch (Exception e) {
             // TODO: handle exception
          }
       }
    } //전송용 쓰레드 끝...
    
    //메세지 수신용 쓰레드
    class ClientReceiver extends Thread {
        private Socket socket;
        private DataInputStream din;

        // 생성자
        public ClientReceiver(Socket socket) {
           this.socket = socket;

           try {
              din = new DataInputStream(socket.getInputStream());
           } catch (Exception e) {
              // TODO: handle exception
           }
        } // 생성자 끝

        @Override
        public void run() {
           try {
              while (din != null) {
                 System.out.println(din.readUTF());
              }
           } catch (Exception e) {
              // TODO: handle exception
           }
        }
     }
}
