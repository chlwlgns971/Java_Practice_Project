package Chapter06;

/*접근지정자가 default고, 메인 메소드가 없는 클래스. ->작업용 클래스 */
//ClassConcept.java파일에서 사용한다.
class Animal {
	String name; //멤버변수: class내부와 메소드 밖에서 선언된 변수
	String kind;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name; //파란색 글씨 name은 멤버변수라는 의미
	}
}
