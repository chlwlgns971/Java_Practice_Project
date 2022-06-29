package Thread;

import javax.swing.JOptionPane;

public class ThreadTest4 {

	public static void main(String[] args) {
		//값을 10초안에 입력받도록 하는 코드(10초가 지나면 프로그램 종료)
		Thread th1=new DataInput();
		Thread th2=new CountDown();
		th1.start();
		th2.start();
	}
}
//데이터를 입력하는 쓰레드
class DataInput extends Thread{
	public static boolean inputCheck=false;
	
	@Override
	public void run() {
		// 사용자로부터 데이터 입력받기
		String str=JOptionPane.showInputDialog("아무거나 입력하세요");
		inputCheck=true;
		System.out.println("입력한 값: "+str);
	}
}
//카운트다운 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			if(DataInput.inputCheck==true) break; // return; //run()메서드가 종료되면 종료
			else System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
}
