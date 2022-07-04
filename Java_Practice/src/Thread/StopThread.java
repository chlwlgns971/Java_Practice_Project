package Thread;

/*
 Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
 이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어 나중에 실행되는 쓰레드나 프로그램에 영향을 줄 수 있다.
 그래서 stop()메서드는 비추천.
 */
public class StopThread {
	
	public static void main(String[] args) {
		/*StopTestThread1 th1=new StopTestThread1();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th1.setStop(true);*/
		//th1.stop(); //권장하지 않음. lock을 풀지 않고 종료될 수 있다.
		
		//interrupt()메서드를 활용한 쓰레드 멈추기
		StopTestThread2 th2=new StopTestThread2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th2.interrupt();

	}

}
//interrupt()메서드를 이용하여 쓰레드를 멈추게하는 방법
class StopTestThread2 extends Thread{
	@Override
	public void run() {
		//방법1-> interrupt()메서드를 sleep()메서드를 이용하는 방법
		//
//		try {
//			while(true) {
//				System.out.println("작업 실행 중...");
//				Thread.sleep(1);//일시정지 상태에서 interrupt()메서드가 실행되면 sleep()메서드는 InterruptException이 실행된
//			}
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(" interrupt()메서드 자원 정리 중...");
//		System.out.println("쓰레드 종료...");
		
		//방법2
		while(true) {
			System.out.println("......쓰레드 실행 중......");
			
			//interrupt()메서드가 호출되었는지 여부 검사하기
			//검사방법1->Thread의 인스턴스 메서드인 isInterrupted()를 이용하기
				//->이 메서드는 interrupt()메서드가 호출되면 true를 반환한다.
//			if(this.isInterrupted()) {
//				break;
//			}
			//검사방법2->Thread의 정적메서드인 interrupted()메서드를 이용하기
				//interrupt()메서드가 호출되면 true반환
			if(Thread.interrupted()) {
				break;
			}
		}
		System.out.println(" interrupt()메서드 자원 정리 중...");
		System.out.println("쓰레드 종료...");
	}
}

//쓰레드를 멈추게 하는 연습용 쓰레드
class StopTestThread1 extends Thread{
	private boolean stop;
	public void setStop(boolean stop) {
		this.stop=stop;
	}
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 실행 중...");
		}
		System.out.println("자원 정리 중...");
		System.out.println("쓰레드 종료...");
	}
}