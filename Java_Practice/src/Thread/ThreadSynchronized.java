package Thread;

public class ThreadSynchronized {
	public static void main(String[] args) {
		ShareObject shObj=new ShareObject();
		
		TestThread th1=new TestThread("1번 쓰레드", shObj);
		TestThread th2=new TestThread("2번 쓰레드", shObj);
		
		th1.start();
		th2.start();
	}
}
class TestThread extends Thread{
	private ShareObject shObj;
	
	public TestThread(String name, ShareObject shObj) {
		super(name);
		this.shObj=shObj;
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			shObj.add();
		}
	}
}
//공통 클래스
class ShareObject{
	private int sum=0;
	
	//public synchronized void add() { //방법1 -> 메서드에 동기화 설정
	public void add() {
		synchronized (this) { //방법2->동기화 블럭으로 설정
			int n=sum;
			n+=10;
			sum=n;
			System.out.println(Thread.currentThread().getName()+" 합계: "+sum);
		}
	}
}