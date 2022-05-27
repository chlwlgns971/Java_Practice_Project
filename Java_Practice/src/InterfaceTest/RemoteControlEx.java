package InterfaceTest;

public class RemoteControlEx {
	public static void main(String[] args) {
		System.out.println("시작");
		//인터페이스(켜다,끄다,볼륨조절)
		RemoteControl rc;
		//클래스(실체)(텔레비전을 켜다, 끄다, 볼륨조절)
		rc=new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		//클래스(실체)(오디오를 켜다, 끄다, 볼륨조절)
		rc=new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(7);
		
		//***** 기존엔 class명 변수명=new class명() 식으로 선언하였다.
		// 하지만 스프링에선 인터페이스를 클래스보다 더 많이, 자주 사용하므로 인터페이스 변수를 생성하고 해당 변수에 객체를 생성하는 방식으로 많이 사용한다.
	}
}
