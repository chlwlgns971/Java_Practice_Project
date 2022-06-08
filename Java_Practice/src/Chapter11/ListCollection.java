package Chapter11;
import java.util.*;

/*
컬렉션 프레임워크 (Collection Framework)
- 자료구조를 사용해서 객체들을 효율적으로 관리할 수 있도록 인터페이스와 
  구현 클래스를 java.util 패키지에서 제공함
- 프레임워크 : 사용 방법을 정해놓은 라이브러리
- 주요 인터페이스로 List, Set, Map이 있음
  collection                               <=interface  
   List           Set          Map         <=interface
     ArrayList      HashSet      HashMap   <=class       
     Vector         TreeSet      TreeMap
     LinkedList                  Hashtable
                                 Properties
[1] ArrayList
  . ArrayList는 List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 
    선형리스트
  . 일반적인 배열과 같은 순차리스트이며 인덱스로 내부의 객체를 관리
  . ArrayList는 객체들이 추가되어 저장 용량(capacity)을 초과한다면 
    자동으로 부족한 크기만큼 저장 용량(capacity)이 늘어난다 
  . 주요메서드 : add(Object o), add(int index, Object o),
              get(int index), remove(int index), clear(), 
              contains(Object o), isEmpty(), indexOf(Object o),
              size(), asList(), iterator()   
 1) ArrayList 선언 
   ArrayList list = new ArrayList();//타입 미설정 Object로 선언
   ArrayList<Student> members = new ArrayList<Student>();//Student객체만 사용가능
   ArrayList<Integer> num = new ArrayList<Integer>();//타입설정 Integer객체 만 사용가능
   ArrayList<Integer> num2 = new ArrayList<>();//new에서 타입 파라미터 생략가능
   ArrayList<Integer> num3 = new ArrayList<Integer>(10);//초기 용량(capacity)지정
   ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));//생성시 값추가
 
 2) iterator() 메서드 
  . iterator()는 반복을 통해 순회하면서 탐색할 때 사용
  . iterator()를 사용하기 위해선 객체를 먼저 생성해주어야 하며, 다음과 같은 
    메소드를 지원
  . hasNext() : 다음 엘리먼트가 있는지 확인 즉, 현재 위치에서 다음 위치로 
    이동할 수 있는지 판단
  . next() : 다음 엘리먼트를 가져오는 역할
  . remove() : next()로 가져온 엘리먼트를 삭제
    
(사용예) 요일들을 저장할 수있는 ArrayList를 생성하고 이를 조작하는 프로그램 작성*/

public class ListCollection {

	public static void main(String[] args) {
		 ArrayList <Prod> list = new ArrayList<Prod>();   //Generic 이용하여 특정 타입만 저장하게 할 수 있음.
	      Prod prod = new Prod("p101","삼성TV 40인치",350000);
	      
	      list.add(prod); 
	      list.add(new Prod("p102","LG Caption TV",400000));
	      list.add(new Prod("p103","LG NoteBook",1500000));
	      /*
	      System.out.println(list.get(0));      
	      System.out.println(list.get(1));      
	      System.out.println(list.get(2));
	      System.out.println(list.size());
	      */
	      
	      /*
	      //일반 for문을 사용한 검색
	      for(int i=0; i<list.size(); i++){
	         System.out.println(list.get(i)+"\n");
	      }
	      */
	      //inhanced for문 사용한 검색
	   /*   for(Prod p : list){
	         //타입이름 : 배열이나 컬렉션이름 ---배열에 들은 원소를 처음부터 끝까지 빠뜨리지 않고 검색
	         System.out.println(p+"\n");
	         //list에 들은 값이 p에 하나씩 전달되기에
	   }*/
	   
	      //Iterator 사용한 검색(list, set에서만 사용가능, Map불가능ㄴ
	      /*
	       * 반복자로 특정 컬렉션 객체의 내용을 처음부터 차례대로 검색 할 때 사용
	       * 컬렉션 중 Collection 인터페이스를 구현한 객체에서 사용가능
	       * 사용형식
	       * Iterator<데이터타입> 이름 = 컬렉션.iterator();
	       *  - hasNext() : 가져올 다음 자료가 있는지 여부
	       *  - next() : hasNext()가 참일때 해당 객체를 가져옴
	       *  -remove() : next()에 의해 가져온 자료를 제거
	       *  -전체 검색할 때 주로 사용
	       */
	      
	      Iterator<Prod> iterator=list.iterator();
	      boolean flag=false;
	      while(iterator.hasNext()){
	         Prod p=iterator.next();
	         //System.out.println(p.getProdId());
	         if(p.getProdId().equals("p102")){
	            System.out.println("p102 제품정보를 찾았음 : \n"+p);
	            flag=true;
	         }
	      }
	      if(flag==false){
	         System.out.println("찾는 상품정보가 없음");
	      }
	      //indetOf(Object o) =>자료가 저장된 인덱스 값을 반환
	      System.out.println(list.get(list.indexOf(prod)));
	      //contains(Object o)=>특정 객체의 존재유무 판단         //contains 메서드의 매개변수는 객체 
	      if(list.contains(prod)){      
	         System.out.println(prod+"자료가 저장되어 있음");
	         }else{
	            System.out.println(prod+"자료는 list에 없음");
	         }
	}

}
class Prod {
	   private String prodId;
	   private String prodName;
	   private int price;
	   
	   public Prod(){}
	   
	   public Prod(String prodId, String prodName, int price){
	      this.prodId =prodId;
	      this.prodName=prodName;
	      this.price=price;
	   }

	   public String getProdId() {
	      return prodId;
	   }

	   public void setProdId(String prodId) {
	      this.prodId = prodId;
	   }

	   public String getProdName() {
	      return prodName;
	   }

	   public void setProdName(String prodName) {
	      this.prodName = prodName;
	   }

	   public int getPrice() {
	      return price;
	   }

	   public void setPrice(int price) {
	      this.price = price;
	   }

	   @Override
	   public String toString(){
	      return " ID="+getProdId()+"\n Name="+getProdName()+"\n Price ="+getPrice();
	   }
	   
}
	

