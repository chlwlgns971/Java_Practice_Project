package Thread;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/*
 1~20억까지의 합계를 구하는 프로그램을 만드는데 하나의 쓰레드가 단독으로 처리할 때와
 여러개의 쓰레드가 협력해서 처리할 때의 경과시간을 비교해보자
 */
public class ThreadTime2 {

	public static void main(String[] args) {
		// 단독으로 처리하는 쓰레드
		SumThread sm=new SumThread(1, 2000000000);
		
		// 여럿이 협력해서 처리하는 쓰레드
//		SumThread sm1=new SumThread(1, 500000000);
//		SumThread sm2=new SumThread(500000000, 1000000000);
//		SumThread sm3=new SumThread(1000000000, 1500000000);
//		SumThread sm4=new SumThread(1500000000, 2000000000);
		SumThread[] smArr=new SumThread[] {
			new SumThread(1, 500000000),
			new SumThread(500000000, 1000000000),
			new SumThread(1000000000, 1500000000),
			new SumThread(1500000000, 2000000000)
		};
		
		//단독으로 처리하는 경우
		long startTime=System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		long endTime=System.currentTimeMillis();
		System.out.println("단독으로 처리했을 때의 경과 시간: "+(endTime-startTime)/1000.0+"초");
		
		//여러쓰레드가 협력해서 처리하는 경우
		startTime=System.currentTimeMillis();
		for(SumThread s: smArr) {
			s.start();
		}
		for(int i=0; i<smArr.length; i++) {
			try {
				smArr[i].join();
			}catch(InterruptedException e) {}
		}
		endTime=System.currentTimeMillis();
		System.out.println("협력해서 처리했을 때의 경과 시간: "+(endTime-startTime)/1000.0+"초");
	}

}
class SumThread extends Thread{
	//합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언
	private long startNum;
	private long endNum;
	
	public SumThread(long startNum, long endNum) {
		this.startNum=startNum;
		this.endNum=endNum;
	}
	@Override
	public void run() {
		long sum=0L;
		for(long i=startNum; i<=endNum; i++) {
			sum+=i;
		}
		System.out.println(startNum+"부터 "+endNum+"까지의 합계: "+sum);
	}
}
