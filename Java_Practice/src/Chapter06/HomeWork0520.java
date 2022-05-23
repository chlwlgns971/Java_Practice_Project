package Chapter06;
import java.util.*;

public class HomeWork0520 {

	public static void main(String[] args) {
		//기본생성자로 이름은 네모, 가로12, 세로12의 값을 가진 rect메소드 생성
				Rect rect1=new Rect();
				Scanner sc=new Scanner(System.in);
				
				System.out.print("객체 이름을 입력하세요: ");
				String str=sc.nextLine();
				System.out.println();
				System.out.print("가로 길이를 입력하세요: ");
				int width=sc.nextInt();
				System.out.println();
				System.out.println("세로 길이를 입력하세요: ");
				int height=sc.nextInt();
				System.out.println();
				//2. 이름,가로,세로를 입력받은 rect메소드 생성
				Rect rect2=new Rect(str,width,height);
				
				//3. 1,2번 객체 정보를 출력
				System.out.println("1번 객체 이름:"+rect1.name+" 가로:"+rect1.getWidth()+
						" 세로:"+rect1.getHeight()+" 면적:"+rect1.getArea()+" 둘레:"+rect1.getCircumference());
				System.out.println("2번 객체 이름:"+rect2.name+" 가로: "+rect2.getWidth()+
						" 세로:"+rect2.getHeight()+" 면적:"+rect2.getArea()+" 둘레:"+rect2.getCircumference());
				
				//4. 1번 객체에서 현재 가로의 값에 +2한 값으로 면적과 둘레를 재계산하여 출력
				rect1.width+=2;
				System.out.println("1번 객체 이름:"+rect1.name+" 가로:"+rect1.getWidth()+
						" 세로:"+rect1.getHeight()+" 면적:"+rect1.getArea()+" 둘레:"+rect1.getCircumference());

	}

}
class Rect{
	String name;
	int width;//가로
	private int height; //세로
	
	Rect(){
		this.name="네모";
		this.width=12;
		this.height=23;
	}
	Rect(String name){
		this.name=name;
	}
	Rect(String name,int width,int height){
		this.name=name;
		this.width=width;
		this.height=height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getArea() {
		return width*height;
	}
	public int getCircumference() {
		return (width+height)*2;
	}
	
}