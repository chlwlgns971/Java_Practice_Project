package Thread;

//쓰레드의 상태를 출력하는 클래스
public class ThreadTest5 {

	public static void main(String[] args) {
		StatePrintThread th=new StatePrintThread(new TargetThread());
		th.start();
	}

}
//쓰레드 상태의 검사 대상이 되는 쓰레드 만들기
class TargetThread extends Thread{
	@Override
	public void run() {
		long a = 0;
		for(long i=1L; i<=200_000_000_000L; i++) {a++;} //시간 지연용
		
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(long i=1L; i<=200_000_000_000L; i++) {a--;} //시간 지연용
	}
}
//TargetThread의 상태를 확인해서 출력하느 ㄴ쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	//생성자
	public StatePrintThread(TargetThread target) {
		this.target=target;
	}
	@Override
	public void run() {
		while(true) {
			//대상쓰레드의 상태값 구하기
			Thread.State state=target.getState();
			
			//상태값 출력
			System.out.println("TargetThread의 상태값: "+state);
			
			//쓰레드의 상태값을 비교한다.
			if(state==Thread.State.NEW) { //NEW상태인지 여부 검사
				target.start(); //대상쓰레드 작동
			}
			if(state==Thread.State.TERMINATED) { //종료상태 여부 검사
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}