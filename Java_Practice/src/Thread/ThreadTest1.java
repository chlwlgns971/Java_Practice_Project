package Thread;
/*
 프로세스: 실행 중인 프로그램. 자원과 쓰레드로 구성
 쓰레드: 프로세스 내에서 실제 작업을 수행. 모든 프로세스는 하나 이상의 쓰레드를 가지고 있다.
 
 멀티쓰레드vs멀티프로세스 => 하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.
 
 멀티쓰레드의 장단점
 	-장점: 자원을 보다 효율적으로 사용할 수 있고, 사용자에 대한 응답성이 향상된다. 작업이 분리되어 코드가 간결해 진다.
 	-단점: 동기화에 주의해야 한다. 교착상태(deadlock)가 발생하지 않도록 주의해야 한다. 각 쓰레드가 효율적으로 실행될 수 있게 해야한다.
 
 쓰레드의 구현과 실행
 	-방법1: Thread클래스를 상속 -> 객체 생성 후 바로 사용가능
 		class MyThread extends Thread{}
 	-방법2: Runnable인터페이스를 구현 ->바로 사용은 불가능하고 객체 생성 후 변수값으로 넣어줘야 사용가능
 		class MyThead implements Runnable{}
 */

public class ThreadTest1 {

	public static void main(String[] args) {
		// 싱글 쓰레드 프로그램
		//'*'문자를 200개 출력하는 부분과 '$'문자를 200개 출력하는 프로그램을 작성하라
		for(int i=1; i<=200; i++) {
			System.out.print("*");
		}
		System.out.println();
		for(int i=1; i<=200; i++) {
			System.out.print("$");
		}
		System.out.println();
		System.out.println();
		// 멀티 쓰레드 프로그램
		//'*'문자를 200개 출력하는 부분과 '$'문자를 200개 출력하는 프로그램을 작성하라
		
		//방법1) Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한 후 인스턴스의 start()메서드를 호출해서 실행
		MyThread1 th1=new MyThread1();
		th1.start();
		
		//방법2) Runnable인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다.
		//그리고 생성된 이 class의 인스턴스를 Thread의 인스턴스를 생성할 때 생성자에 인수값으로 넣어서 생성한 후 이 Thread의 인스턴스의 start()메서드를 호출해서 실행한다.
		Runnable r1=new MyRunner();
		Thread th2=new Thread(r1);
		th2.start();
		
		//방법3) Runnable인터페이스의 익명 구현체를 이용하는 방법
		Runnable r2=new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					try {
						//Thread.sleep(시간)
						//시간은 밀리세컨드 단위를 사용한다. ->1000은 1초를 의미
						Thread.sleep(100);
					}
					catch(InterruptedException e){
						
					}
				}
			}
		};
		Thread th3=new Thread(r2);
		th3.start();
		System.out.println("main메서드 종료");
	}

}
//방법1- Thread클래스를 상속한 class작성하기
class MyThread1 extends Thread{
	@Override
	public void run() {
		//이 run()메서드 안에는 쓰레드에서 처리할 내용을 기술한다.
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			try {
				//Thread.sleep(시간)
				//시간은 밀리세컨드 단위를 사용한다. ->1000은 1초를 의미
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}
//방법2-Runnable인터페이스를 구현한 class작성하기
class MyRunner implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}
