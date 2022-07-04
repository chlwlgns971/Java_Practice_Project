package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 Vector, Hashtable등 예전부터 존재하던 Collection객체들은 내부에 이미 동기화 처리가 되어있다.
 그런데, Collection에 새로 구성된 클래스들은 동기화 처리가 되어있지 않다.
 따라서 동기화 처리가 필요한 프로그램에서 이런 Collection을 사용할 경우에는 동기화 처리를 한 후에 사용해야 한다.
 */
public class ThreadSynchronized3 {
	private Vector<Integer> vec=new Vector<Integer>();
	
	//동기화 처리가 되지 않은 List
	private List<Integer> list1=new ArrayList<Integer>();
	
	public void testStart() {
		//익명 구현체로 쓰레드 구현
		Runnable r=new Runnable() {
			
			@Override
			public synchronized void run() {
				for(int i=0; i<10000; i++) {
					//vec.add(i);
					list1.add(i);
				}
				
			}
		};
		//Thread 배열 생성
		Thread[] thArr=new Thread[] {
			new Thread(r),	
			new Thread(r),	
			new Thread(r),	
			new Thread(r),	
			new Thread(r)	
		};
		for(Thread th: thArr) {
			th.start();
		}
		for(Thread th: thArr) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("vec의 개수: "+vec.size());
		System.out.println("list의 개수: "+list1.size());
	}
	
	public static void main(String[] args) {
		new ThreadSynchronized3().testStart();
	}
}
