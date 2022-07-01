package Homework;

import javax.swing.JOptionPane;

public class RockPaperScissors {

	public static void main(String[] args) {
		/*
		 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
		 
		 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고, 사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력 받는다.
		 입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
		 5초 안에 입력이 없으면 게임에 진것으로 처리하고, 5초안에 입력이 있으면 승패를 구해서 출력한다.
		 */
		int num=(int)Math.random()*3+1;
		String aiResult="";
		if(num==1) aiResult="바위";
		else if(num==2) aiResult="보";
		else aiResult="가위";
		 
		Thread th1=new DataInput();
		Thread th2=new CountDown();
		th1.start();
		th2.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new CompareResult().compare(DataInput.str, aiResult));

	}

}
class CompareResult{
	public String compare(String str1, String str2) {
		String result="";
		if(str1.equals("바위")) {
			if(str2.equals("보")) result="컴퓨터의 결과는 "+str2+"이고 패배하셨습니다.";
			else if(str2.equals("바위")) result="컴퓨터의 결과는 "+str2+"이고 비겼습니다.";
			else  result="컴퓨터의 결과는 "+str2+"이고 승리하셨습니다.";
		}
		else if(str1.equals("보")) {
			if(str2.equals("가위")) result="컴퓨터의 결과는 "+str2+"이고 패배하셨습니다.";
			else if(str2.equals("보")) result="컴퓨터의 결과는 "+str2+"이고 비겼습니다.";
			else  result="컴퓨터의 결과는 "+str2+"이고 승리하셨습니다.";
		}
		else if(str1.equals("가위")) {
			if(str2.equals("바위")) result="컴퓨터의 결과는 "+str2+"이고 패배하셨습니다.";
			else if(str2.equals("가위")) result="컴퓨터의 결과는 "+str2+"이고 비겼습니다.";
			else  result="컴퓨터의 결과는 "+str2+"이고 승리하셨습니다.";
		}
		else result="올바른 입력값이 아닙니다. 게임에서 패배하셨습니다.";
		return result;
	}
	public void compare2(String str1, String str2) { //또 다른 결과비교방법
		switch(str1+str2) {
		case "가위가위":
		case "바위바위":
		case "보보":
			System.out.println("비겼습니다.");
			break;
		case "바위가위":
		case "가위보":
		case "보바위":
			System.out.println("게임에서 승리하셨습니다.");
			break;
		case "바위보":
		case "가위바위":
		case "보가위":
			System.out.println("게임에서 패배하셨습니다.");
			break;
		}
	}
}
//데이터를 입력하는 쓰레드
class DataInput extends Thread{
	public static boolean inputCheck=false;
	public static String str;
	@Override
	public void run() {
		// 사용자로부터 데이터 입력받기
		str=JOptionPane.showInputDialog("'가위', '바위', '보' 중 한가지를 입력해주세요");
		inputCheck=true;
	}
}
//카운트다운 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			if(DataInput.inputCheck==true) return;
			else System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("제한시간이 지났습니다. 게임에서 패배하셨습니다.");
		System.exit(0);
	}
}