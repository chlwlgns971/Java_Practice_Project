package Chapter11;
import java.util.*;
public class ObjectClass {

	public static void main(String[] args) {
		//cloneTest
		CloneTest cl1=new CloneTest();
		cl1.setModelName("소나타");
		cl1.setOwner("홍길동");
		
		//EqualTest
		User user01=new User(1000,"홍정기");
		User user02=new User(1000,"홍정기");
		
		System.out.println(user01==user02);
		System.out.println(user01.equals(user02));
	}

}
class User{
	private int id;
	private String name;
	
	public User(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			return this.getId()==((User)obj).getId();
		}
		else return false;
	}
	 
}
class Student{
	private int studNo;
	private String studName;
	public Student(){}
	   
	public Student(int studNo, String studName){
		this.studNo=studNo;
		this.studName=studName;
   }
	public int getStudNo() {
		return studNo;
	}
	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}

	@Override
	public String toString() {
		return "Student [studNo=" + studNo + ", studName=" + studName + "]";
	}
	
}
class CloneTest implements Cloneable {
   private String modelName;
   private ArrayList<String> owner=new ArrayList<String>();
   //자동형변환 방지를 위해서 owner라고 이름 붙은 ArrayList에는 들어갈 수 있는 dataType을
   //String Type. 문자열로 한정한 것. 그 외는 저장 될 수 없음. 
   
   public String getModelName() {
      return modelName;
   }
   public void setModelName(String modelName) {
      this.modelName = modelName;
   }
   public ArrayList<String> getOwner() {
      return owner;
   }
   public void setOwner(String name) {
      this.owner.add(name);
      //이렇게 살짝 바꿔줘야함, 그러면 배열로 저장됨...
   }
   
   @Override
   public Object clone(){
      try{
         CloneTest cloneCar=(CloneTest)super.clone();
         //super에서 clone 호출하면 object type으로 변한다고
         //내가 생성하고자 하는 Car 타입으로 down casting 함
         cloneCar.owner=(ArrayList)owner.clone();
         return cloneCar;
      }
      catch(CloneNotSupportedException e) {
    	  e.printStackTrace();
    	  return e;
      }
   }
   
   
}