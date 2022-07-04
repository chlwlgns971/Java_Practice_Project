package Thread;
/*
 쓰레드의 동기화 효율을 높이기 위해 wait(),notify()를 사용한다.(동기화 블록 내에서만 사용가능)
 	-wait(): 객체의 lock을 풀고 해당 객체의 쓰레드를 waiting pool에 넣는다.
 	-notify(): waiting pool에서 대기중인 쓰레드 중의 하나를 깨운다.
 	-notifyAll(): waiting pool에서 대기중인 모든 쓰레드를 깨운다.
 */

public class WaitNotify {

	public static void main(String[] args) {
		// wait(),notify()를 이용한 두 쓰레드에서 번갈아 한번씩 실행하는 예제
		
		WorkObject work=new WorkObject();
		
		ThreadA th1=new ThreadA(work);
		ThreadB th2=new ThreadB(work);
		th1.start();
		th2.start();

	}

}
//공통으로 사용할 객체
class WorkObject{
	public synchronized void testMethod1() {
		System.out.println("testMethod1() 메서드 실행 중...");
		
		notify();
		try {
			wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void testMethod2() {
		System.out.println("testMethod2() 메서드 실행 중...");
		
		notify();
		try {
			wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//WorkObject의 testMethod1()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj=workObj;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethod1();
		}
		//10번을 반복한 후 종료되어야 하지만, wait상태에서 대기하기 때문에 프로그램이 종료되지 않는다.
		//따라서 깨워줄 synchronized 메서드를 만들어서 notify를 해줘야 정상적으로 프로그램이 종료된다.
		synchronized (workObj) { 
			workObj.notify();
		}
	}
}
//WorkObject의 testMethod1()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj=workObj;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethod2();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}