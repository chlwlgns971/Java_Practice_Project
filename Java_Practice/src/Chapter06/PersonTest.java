package Chapter06;

public class PersonTest {

	public static void main(String[] args) {
		PersonTest pt=new PersonTest();
		Person p1=new Person();
		Person p2=new Person("������",97,02,12);
		MyDate md1=new MyDate(99,11,29);
		Person p3=new Person("������",md1);
		
		personInfo(p1);
		pt.personPrint(p1);
		personInfo(p2);
		pt.personPrint(p2);
		personInfo(p3);
		pt.personPrint(p3);

	}
	public static void personInfo(Person P){
		System.out.println(P+"�� �̸��� "+P.getName()+"�̰�, ��������� "+P.getBirth()+"�Դϴ�.");
	}
	public void personPrint(Person P){
		System.out.println(P+"�� �̸��� "+P.getName()+"�̰�, ��������� "+P.getBirth()+"�Դϴ�.");
	}
	

}
