package Thread;

import java.util.ArrayList;
import java.util.Collections;

/*
 10마리의 말들이 경주하는 경마 프로그램 작성하기
 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.(Comparable인터페이스 구현)
 
 경기 구간은 1~50구간으로 되어 있다.
 말의 현재 위치는 말이 현재 달리고 있는 구간 값이 저장된다.
 
 경기가 진행되는 동안에는 중간 중간에 각 말들의 위치를 나타내시오
 
 ex)
 말 이름01:--->--------------------------
 말 이름02:------->----------------------
 ....
 말 이름10:----->------------------------
 경기가 끝나면 등수 순으로 정렬하여 출력한다.
 */
public class HorseRace {
	public static ArrayList<Horse> horseList;
	static int staticRank=1;
	
	public static void main(String[] args) {
		horseList=new ArrayList<Horse>();
		horseList.add(new Horse("1번말",0));
		horseList.add(new Horse("2번말",0));
		horseList.add(new Horse("3번말",0));
		horseList.add(new Horse("4번말",0));
		horseList.add(new Horse("5번말",0));
		horseList.add(new Horse("6번말",0));
		horseList.add(new Horse("7번말",0));
		horseList.add(new Horse("8번말",0));
		horseList.add(new Horse("9번말",0));
		horseList.add(new Horse("10번말",0));
		
		for(Horse h: horseList) {
			h.start();
		}
		CheckLocate th1=new CheckLocate();
		th1.start();
		for(Horse h:horseList) {
			try {
				h.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		th1.setWork(false);
		Collections.sort(horseList);
		for(Horse h:horseList) {
			System.out.println(h.getHorseName()+"의 최종순위: "+h.getRank());
		}
		
		
	}

}
class Horse extends Thread implements Comparable<Horse>{
	private String horseName;
	private int rank;
	private int locate;
	
	public Horse() {}
	public Horse(String horseName, int locate) {
		this.horseName=horseName;
		this.locate=locate;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocate() {
		return locate;
	}

	public void setLocate(int locate) {
		this.locate = locate;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=50; i++) {
			this.locate=i;
			//System.out.println(this.horseName+"의 현재위치: "+i+"구역");
			try {
				Thread.sleep((int)(Math.random()*400+100));
				//위치출력
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setRank(HorseRace.staticRank);
		HorseRace.staticRank++;
	}

	@Override
	public int compareTo(Horse h) {
//		if(this.rank<h.getRank()) return -1;
//		else if(this.rank==h.getRank()) return 0;
//		else return 1;
		return Integer.compare(this.rank,h.getRank());
	}
}
class CheckLocate extends Thread{
	ArrayList<Horse> list=HorseRace.horseList;
	private boolean work=true;
	
	public boolean getWork() {
		return work;
	}
	public void setWork(boolean work) {
		this.work=work;
	}
	@Override
	public void run() {
		while(work) {
			for(Horse h:list) {
				String str="";
				for(int i=1; i<=50; i++) {
					if(h.getLocate()==i)str+=">";
					else str+="-";
				}
				System.out.println(h.getHorseName()+":"+str);
			}
			System.out.println("============================================================");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
