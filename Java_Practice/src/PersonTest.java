
public class PersonTest {

	public static void main(String[] args) {
		PersonTest pt=new PersonTest();
		Person p1=new Person();
		Person p2=new Person("최지훈",97,02,12);
		MyDate md1=new MyDate(99,11,29);
		Person p3=new Person("최정훈",md1);
		
		personInfo(p1);
		pt.personPrint(p1);
		personInfo(p2);
		pt.personPrint(p2);
		personInfo(p3);
		pt.personPrint(p3);

	}
	public static void personInfo(Person P){
		System.out.println(P+"의 이름은 "+P.getName()+"이고, 생년월일은 "+P.getBirth()+"입니다.");
	}
	public void personPrint(Person P){
		System.out.println(P+"의 이름은 "+P.getName()+"이고, 생년월일은 "+P.getBirth()+"입니다.");
	}
	

}
