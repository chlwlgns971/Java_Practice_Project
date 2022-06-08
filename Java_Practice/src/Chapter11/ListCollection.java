package Chapter11;
import java.util.*;



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
	

