package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/*
 -List와 Set의 차이점
 1. List
 	-데이터의 순서(index)가 있다.
 	-중복되는 데이터를 저장할 수 있다.
 2. Set
 	-데이터의 순서(index)가 없다.
 	-중복되는 데이터를 저장할 수 없다.
 */
public class SetTest {

	public static void main(String[] args) {
		HashSet hs1=new HashSet();
		//Set에 데이터를 추가할 때도 add()메서드를 사용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("set데이터 => "+hs1);
		System.out.println("set의 갯수 => "+hs1.size());
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd=hs1.add("FF");
		System.out.println("FF가 존재하지 않으면 true 존재하면 false>> "+isAdd);
		System.out.println("set데이터 => "+hs1);
		isAdd=hs1.add("AA");
		System.out.println("AA가 존재하지 않으면 true 존재하면 false>> "+isAdd);
		System.out.println("set데이터 => "+hs1);
		
		//Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 자료를 삭제한 후에 추가해 주는 방법을 사용한다.
		//삭제하는 메서드:remove(삭제할 데이터)=>반환값: 삭제성공(true), 삭제실패(false)/ clear()=>전체삭제
		//"FF"데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("삭제후 set데이터 => "+hs1);
		hs1.add("EE");
		System.out.println("set데이터 => "+hs1);
		
		/*
		 Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 따라서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 
		 -Iterator()메서드 => Set형의 데이터들을 Iterator형으로 변환해 주는 메서드
		 -Iterator에서 데이터를 하나씩 차례로 꺼내올 때 사용되는 메서드
			 1.hasNext()메서드 -> Iterator의 포인터가 가리키는 곳의 다음번째 위치에 데이터가 있는지 검사하는 메서드(true,false반환)
			 2.next()메서드 -> Iterator의 포인터를 다음번째 위치로 이동한 후 그 곳의 데이터를 반환하는 메서드
		-반복문(while문)과 위의 2개의 메서드를 사용하여 처리한다.
		 */
		Iterator it=hs1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*
		 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자.
		 번호는 1번부터 25번까지있고, 추첨할 인원은 3명이다.
		 당첨자 번호를 출력해보자.
		 */
		int result = (int)(Math.random()*25+1);
		HashSet<Integer> testSet=new HashSet<Integer>();
		while(testSet.size()<3) {
			testSet.add((int)(Math.random()*25+1));
		}
		System.out.println("당첨자번호: "+testSet);
		
		//Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList=new ArrayList<Integer>(testSet);
		System.out.println("List데이터 출력: "+testList);
		for(int i=0; i<testList.size(); i++) {
			System.out.println(testList.get(i));
		}
	}

}