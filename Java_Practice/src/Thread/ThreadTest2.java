package Thread;

public class ThreadTest2 {
	public static void main(String[] args) {
		//Thread가 수행되는 시간 체크해보기
		Thread th=new Thread(new MyRunner2());
		//위와 같은 의미
//		Runnable r2=new MyRunner2();
//		Thread th=new Thread(r2);
		
		//1970년 1월 1일 0시 0분0초로부터 경과한 시간을 밀리세컨드 단위로 반환한다.
		// 3000->1970년 1월 1일 0시 0분 3초
		long startTime=System.currentTimeMillis();
		th.start();
		try {
			th.join(); //현재 실행중인 쓰레드에서 대상이 되는 쓰레드(여기서는 th)
		}catch(InterruptedException e){
			
		}
		long endTime=System.currentTimeMillis();
		
		//경과시간
		System.out.println("경과시간: "+(endTime-startTime)/1000.0+"초");
	}
}
class MyRunner2 implements Runnable{
	@Override
	public void run() {
		long sum=0L;
		for(Long i=1L; i<1_000_000_000L; i++) {
			sum+=i;
		}
		System.out.println("합계: "+sum);
		
	}
	
}
