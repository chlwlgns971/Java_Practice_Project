package Chapter07;



/*상속
 * 	-부모클래스(상위클래스)의 멤버를 자식클래스(하위클래스)가 정의하지 않고 사용
 * 	-클래스의 재사용(간결,효율적)
 * 	-부모클래스의 멤버를 공통으로 사용(확장성이 용이)
 *(사용형식)
 *접근지정자 class 자식클래스명 extends 부모클래스명{}
 *	-부모의 생성자, 부모클래스에서 private로 선언된 멤버, 부모와 자식이 서로 다른 패키지에 존재한다면
 *		부모클래스에서 default로 선언된 멤버는 상속불가
 */

public class InherrExam01 {

	public static void main(String[] args) {
		Mac m1=new Mac();
		m1.setPrice(100000);
		System.out.println("맥북의 가격: "+m1.getPrice()); //자식클래스

	}

}
class Mac extends InherrClass{
	boolean touchPad;
	public Mac(){
		super(320000); //Computer 클래스에서 오버로딩한 생성자가 없으면 super메서드를 사용할 수 없다.->super()은 부모클래스의 기본생성자를 호출하는 역할
	}
	
	boolean hasTouchPad(){
		return touchPad;
	}
}
class Tv extends Product{
	private int displaySize;
	private boolean installType;
	
	public Tv(){
		super("Lg OLED TV",2000000,"Lg"); //Product class의 Product(String, int, String)메소드 호출
	}
	public Tv(int displaySize, boolean installType){
		this.displaySize=displaySize;
		this.installType=installType;
	}
	
	@Override
	public String toString() {
		return "Tv [displaySize=" + displaySize + ", installinstallType=" + installType
				+ ", prodName=" + prodName + ", price=" + price + ", prodCom="
				+ prodCom + "]";
	}
}

