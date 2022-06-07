package Chapter11;
import java.util.*;

/*
* 문제1 : 키보드로 "N"이나 "n"을 입력할때 까지 정수를 입력 받아 ArrayList에 저장하고,
* 저장된 값 중 가장 큰 값을 출력하는 프로그램 작성
* 문제2 : 학생클래스는 학번(정수)이고,이름(문자열),점수(정수)의 속성을 갖고 있으며, 초기값을 이용하여
* 객체를 생성하는 생성자 메서드와 getter / setter, toString()을 가지고있다.
* 실행클래스에서 학생정보를 입력하는 메서드(insertScore())와 전체 학생을 조회하는 메서드 (selectAll()),
* 특정학생의 이름을 입력받아 해당 학생정보를 출력하는 selectOne()메서드를 구현하시오
* 
*/

public class ListCollection2 {

	public static void main(String[] args) {
		//문제1
		Ex1 ex1=new Ex1();
		ex1.ex1();
		
		//문제2
		Ex2 ex2=new Ex2();
		
		ex2.insertScore(1, "최지훈", 90);
		ex2.insertScore(2, "최지훈1", 80);
		ex2.insertScore(3, "최지훈2", 70);
		ex2.insertScore(4, "최지훈3", 60);
		ex2.insertScore(5, "최지훈4", 50);
		ex2.insertScore(6, "최지훈5", 40);
		ex2.insertScore(7, "최지훈6", 30);
		ex2.selectAll();
		ex2.selectOne("최지훈4");
		
		

	}

}
class Ex1{
	Scanner sc=new Scanner(System.in);
	public void ex1() {
		ArrayList<Integer> intList =new ArrayList <Integer>();
		String str="";
		while(true) {
			try {
				System.out.println("정수를 입력하세요: ");
				str=sc.nextLine();
				intList.add(Integer.parseInt(str));
			} catch (Exception e) {
				if(str.equals("N")||str.equals("n")) {
					System.out.println("루프를 종료합니다.");
					break;
				}
				else System.out.println("잘못된 값 입력입니다.");
			}
		}
		System.out.println("입력받은 정수들의 값: "+intList);
		System.out.println("입력받은 값의 최댓값: "+maxNumber(intList));
	}
	public int maxNumber(List<Integer> list) {
		int max=list.get(0);
		for(int i=0; i<list.size(); i++) {
			if(max<list.get(i)) max=list.get(i);
		}
		return max;
	}
}
class SearchStu{
	private int stuNum;
	private String name;
	private int score;
	SearchStu(){
		this.stuNum=001;
		this.name="최지훈";
		this.score=90;
	}
	SearchStu(int stuNum, String name, int score){
		this.stuNum = stuNum;
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SearchStu [stuNum=" + stuNum + ", name=" + name + ", score=" + score + "]";
	}
	
}
class Ex2{
	ArrayList<SearchStu> student =new ArrayList <>();
	public void insertScore(int stuNum, String name, int score) {
		student.add(new SearchStu(stuNum,name,score));
	}
	public void selectAll() {
		System.out.println(student);
	}
	public void selectOne(String name) {
		Iterator<SearchStu> iterator=student.iterator();
		while(true) {
			SearchStu ss=iterator.next();
			if(ss.getName().equals(name)){
	            System.out.println("학생을 찾았음 : \n"+ss);
	            break;
	         }
		}
		
	}
}
