package Chapter06;

public class StudentExample {

	public static void main(String[] args) {
		//설계도 객체명= 생성자 설계도();
		Student s1=new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		s1.setStuName("유재석");
		s1.setStuNum("a001");
		s1.setTelNum("010-1234-5678");
		System.out.println("s1: "+s1.toString());
		
		Student s2=new Student();
		System.out.println("s2 변수가 또 다른"+" Student 객체를 참조합니다.");
		s2.setStuName("박명수");
		s2.setStuNum("b001");
		System.out.println("s2: "+s2.toString());
		
		Student s3=new Student();
		System.out.println("s3 변수가 또 다른"+" Student 객체를 참조합니다.");
		System.out.println("s3: "+s3.toString());
	}

}