package Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList list1=new ArrayList();
		
		//add메소드
		list1.add("add");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("size=>"+list1.size());
		System.out.println("list1=>"+list1);
		
		//get()메서드를 사용하여 데이터를 꺼내온다.
		System.out.println("1번째 자료:"+list1.get(1));
		System.out.println();
		
		//데이터끼워넣기
		list1.add(3,"zzz");
		System.out.println("list1=>"+list1);
		System.out.println();
		
		//데이터변경
		String temp=(String)list1.set(3, "yyy");
		System.out.println("list1=>"+list1);
		System.out.println();
		
		//삭제도 같다.
		list1.remove(3);
		System.out.println("list1=>"+list1);
		list1.remove("bbb");
		System.out.println("list1=>"+list1);
		System.out.println();
		
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("BBBB");
		list2.add("EEEE");
		//출력(향상된 for문)
		for(String s:list2) {
			System.out.println(s);
		}
		
		//contains(비교객체)==>리스트에 '비교객체'가 있으면 true, 없으면 false를 반환한다.
		System.out.println("DDDD값: "+list2.contains("DDD"));
		System.out.println("ZZZZ값: "+list2.contains("ZZZ"));
		
		//indexOF(비교객체)
		//lastIndexOf(비교객체)
		//==>리스트에 '비교객체'가 있으면 '비교객체'가 저장되어 있는 index값을 반환하고 없으면 -1을 반환한다.
		System.out.println("1.BBBB 위치값: "+list2.indexOf("BBBB"));
		System.out.println("1.BBBB 위치값: "+list2.lastIndexOf("BBBB"));
		System.out.println("1.HHHH 위치값: "+list2.indexOf("HHHH"));
		System.out.println();
		
		//toArray()==>리스트 안의 데이터를 배열로 변환하여 반환한다.=>기본적으로 Object형 배열로 변환한다.
		//toArray(new 제네릭타입[0]); ==>제네릭 타입의 배열로 변환한다.
		Object[] strArr=list2.toArray();
		System.out.println("배열의 갯수: "+strArr.length);
		
		String[] strArr2=list2.toArray(new String[0]);
		//출력(향상된 for문)
		for(String s:strArr2) {
			System.out.println(s);
		}
		
		//문제
		Ex ex=new Ex();
		//ex.qa1(); //1번문제
		//ex.qa2(); //2번문제
		ex.qa3();
	}
}
class Ex{
	Scanner sc= new Scanner(System.in);
	public void qa1() {
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0; i<5; i++) {
			System.out.print("사람이름을 입력하세요>>>");
			list.add(sc.nextLine());
		}
		System.out.println("======1번문제답======");
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).substring(0, 1).equals("김")) System.out.println(list.get(i));
			//if(list.get(i).indexOf("김")==0) System.out.println(list.get(i)); //이 방식으로도 가능함
			//if(list.get(i).startsWith("김")) //list.get(i)가 "김"으로 시작하는지 검사해서 맞으면 true반환
		}
		
	}
	public void qa2() {
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0; i<5; i++) {
			System.out.print((i+1)+"번째 별명을 입력하세요>>>");
			list.add(sc.nextLine());
		}
		int max=list.get(0).length();
		int index=0;
		for(int i=1; i<list.size(); i++) {
			if(max<list.get(i).length()) {
				max=list.get(i).length();
				index=i;
			}
		}
		System.out.println("======2번문제답======");
		System.out.println(list.get(index));
	}
	//문제3 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에 별명의 길이가 제일 긴 별명들을 출력하시오.(단 별명의 길이가 같은 것이 존재할 수 있다.)
	public void qa3() {
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<Integer> index=new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			System.out.print((i+1)+"번째 별명을 입력하세요>>>");
			list.add(sc.nextLine());
		}
		int max=list.get(0).length();
		index.add(0);
		
		for(int i=1; i<list.size(); i++) {
			if(max<list.get(i).length()) {
				max=list.get(i).length();
				index.clear();
				index.add(i);
			}
			else if(max==list.get(i).length()){
				index.add(i);
			}
		}
		System.out.println("======3번문제답======");
		for(int i:index) {
			System.out.println(list.get(i));
		}
	}
}
