package Chapter06;
import java.util.*;
/*
 * Field
 * -멤버변수를 의미
 * -클래스 내부(메서드 안이 아님)
 * -자동 초기화->사용자가 초기화하지 않아도 초기화가 일어난다.(정수는 0, 실수는 0.0, 문자는 " ", boolean은 false, 배열이나 클래스, 인터페이스는 null)
 * -역할: 클래스의 생태를 표현
 * 
 * 멤버변수의 참조
 * -클래스 내부->객체 생성없이 참조할 수 있다.
 * -클래스 외부->객체를 생성하고 생성된 객체참조 변수를 이용하여 참조
 * 
 * 오버로딩
 * -같은 클래스 내에서 같은 이름의 메소드를 사용하는 것을 오버로딩이라고 한다.
 * -기능의 다형성을 보장하기 위해 사용
 * 
 * 오버라이딩
 * -상속관계가 선행되야하며, 부모클래스에서 정의된 메서드가 자식클래스에서 재정의하면서 다른 일을 할 수 있게 만드는 것을 오버라이딩이라고 한다.
 * 
 * 생성자 메서드(new)
 * -클래스를 호출할 때 초기화하는 목적으로 사용
 * 
 * 메서드
 * -클래스가 수행해야 할 비지니스 로직을 코드화한 모듈
 * -반환 타입이 있는 메서드, 반환타입이 없는 메서드로 나뉜다.
 */


/*
 * 문제1 다음조건을 만족하는 원(Circle)클래스를 구성하시오. 멤버변수는 실수타입의 반지름(radius)와 실수형 상수인 원주율(PI=3.1415926)
 * 	1)기본 생성자 및 반지름을 정의하는 생성자
 * 	2)현재의 반지름으로 면적을 구하여 반환하는 함수(getArea)
 * 문제2 원통클래스(Cylinder)를 구성하시오
 * 	1)멤버: 높이(실수형), 문제1에서 구성한 Circle타입의 원
 * 	2)메서드: 부피를 반환하는 실수형 메서드 getVolumn()
 */
public class MemberVal01 {

	public static void main(String[] args) {
//		MemberEx01 m1=new MemberEx01();
//		m1.setAge(26, "최지훈", true);
//		System.out.println(m1.toString());
		double r=23.35;
		double height=8.0;
		Circle circle=new Circle(r);
		System.out.println("반지름이 "+r+"인 원의 넓이= "+circle.getArea());
		Cylinder y1=new Cylinder();
		System.out.println("반지름이 23.35이고, 높이가 10인 원의 부피= "+y1.getVolumn());
		Cylinder y2=new Cylinder(height,new Circle(r));
		System.out.println("반지름이 "+r+"이고, 높이가 "+height+"인 원의 부피= "+y2.getVolumn());
		
//		Cylinder cl=new Cylinder();
//		cl.setCylinder(height,r);
//		System.out.println("반지름이 "+r+"이고, 높이가 "+height+"인 원의 부피= "+cl.getVolumn());
		
//		문제3 다음 조건을 만족하는 클래스를 생성하시오(사원클래스(Employee))
//		 	1)멤버변수: 월급여(salary): 정수형, 사원번호(emp_id): 문자열, 사원명(emp_name): 문자열
//		 	2)메서드: 생성자(사원번호, 사원명을 입력), 기본생성자, 연봉을 계산해서 반환하는 메서드
//		 문제4 위의 사원 여러명을 처리하기 위한 방법
//		 
//		 위 문제를 코딩하여 메로장에 복사한 후 sem-pc의 D:\A_TeachingMaterial\1.BasicJava\Homework에 전송할 것.
		Employee ep=new Employee();
		System.out.println("최지훈 사원의 보너스를 포함한 연봉은 "+ep.getYearSalary()+"입니다.");
		int salary=300;
		String emp_id="20220523";
		String emp_name="손흥민";
		Employee ep1=new Employee(salary,emp_id,emp_name);
		System.out.println(emp_name+"사원의 사원번호는 "+emp_id+"이고, 보너스를 포함한 연봉은 "+ep1.getYearSalary()+"입니다.");
		
		
		//문제4
		//Employee nameArray[i]=new Employee();
		Scanner sc=new Scanner(System.in);
		int[] salaryArr={200,300,400,500,350};
		String[] id={"001","002","003","004","005"};
		String[] name={"강","최","김","박","유"};
		for(int i=0; i<id.length; i++){
			Employee epy=new Employee(salaryArr[i],id[i],name[i]);
			System.out.println(name[i]+"사원의 사원번호는 "+id[i]+"이고, 보너스를 포함한 연봉은 "+epy.getYearSalary()+"입니다.");
		}
	}

}
