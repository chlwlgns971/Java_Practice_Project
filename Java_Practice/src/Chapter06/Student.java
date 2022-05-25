package Chapter06;

/*ctrl+F6= 패키지내 다른 자바파일로 이동
 *ctrl+F3= 메소드 위에서 실행하면 해당 메소드 위치로 이동가능
 *-인스턴스화(객체화)
 *		-객체를 인스턴스라고도 부르며 클래스로 객체로 만드는 과정을 인스턴스화라고 한다.
 *-인스턴스: 클래스로부터 만들어진 객체 ->"설계도는 클래스, 클래스로 만든 객체는 인스턴스"
 */

class Student{
	//속성=필드=멤버변수:정적인 데이터를 담을 때 필요함
	private String stuNum; //학번
	private String stuName; //학생이른
	private String telNum; //학생 연락처
	//기본생성자. 생략가능(다른 클래스에서 호출할 때 실행)
	public Student() {}
	
	//setter 메소드(setter 메소드이기 때문에 어디서든 접근이 가능해야한다.
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	//입력받은 값을 보여줘야한다.
	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", stuName=" + stuName
				+ ", telNum=" + telNum + "]";
	}
	public String viewInfo(){
		return stuNum+" "+stuName+" "+telNum;
	}
}