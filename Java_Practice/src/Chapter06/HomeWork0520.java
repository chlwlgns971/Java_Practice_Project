package Chapter06;
<<<<<<< HEAD
import java.util.*;

public class HomeWork0520 {

	public static void main(String[] args) {
		//ê¸°ë³¸ìƒì„±ìžë¡œ ì´ë¦„ì€ ë„¤ëª¨, ê°€ë¡œ12, ì„¸ë¡œ12ì˜ ê°’ì„ ê°€ì§„ rectë©”ì†Œë“œ ìƒì„±
				Rect rect1=new Rect();
				Scanner sc=new Scanner(System.in);
				
				System.out.print("ê°ì²´ ì´ë¦„ì„ ìž…ë ¥í•˜ì„¸ìš”: ");
				String str=sc.nextLine();
				System.out.println();
				System.out.print("ê°€ë¡œ ê¸¸ì´ë¥¼ ìž…ë ¥í•˜ì„¸ìš”: ");
				int width=sc.nextInt();
				System.out.println();
				System.out.println("ì„¸ë¡œ ê¸¸ì´ë¥¼ ìž…ë ¥í•˜ì„¸ìš”: ");
				int height=sc.nextInt();
				System.out.println();
				//2. ì´ë¦„,ê°€ë¡œ,ì„¸ë¡œë¥¼ ìž…ë ¥ë°›ì€ rectë©”ì†Œë“œ ìƒì„±
				Rect rect2=new Rect(str,width,height);
				
				//3. 1,2ë²ˆ ê°ì²´ ì •ë³´ë¥¼ ì¶œë ¥
				System.out.println("1ë²ˆ ê°ì²´ ì´ë¦„:"+rect1.name+" ê°€ë¡œ:"+rect1.getWidth()+
						" ì„¸ë¡œ:"+rect1.getHeight()+" ë©´ì :"+rect1.getArea()+" ë‘˜ë ˆ:"+rect1.getCircumference());
				System.out.println("2ë²ˆ ê°ì²´ ì´ë¦„:"+rect2.name+" ê°€ë¡œ: "+rect2.getWidth()+
						" ì„¸ë¡œ:"+rect2.getHeight()+" ë©´ì :"+rect2.getArea()+" ë‘˜ë ˆ:"+rect2.getCircumference());
				
				//4. 1ë²ˆ ê°ì²´ì—ì„œ í˜„ìž¬ ê°€ë¡œì˜ ê°’ì— +2í•œ ê°’ìœ¼ë¡œ ë©´ì ê³¼ ë‘˜ë ˆë¥¼ ìž¬ê³„ì‚°í•˜ì—¬ ì¶œë ¥
				rect1.width+=2;
				System.out.println("1ë²ˆ ê°ì²´ ì´ë¦„:"+rect1.name+" ê°€ë¡œ:"+rect1.getWidth()+
						" ì„¸ë¡œ:"+rect1.getHeight()+" ë©´ì :"+rect1.getArea()+" ë‘˜ë ˆ:"+rect1.getCircumference());

	}

}
class Rect{
	String name;
	int width;//ê°€ë¡œ
	private int height; //ì„¸ë¡œ
	
	Rect(){
		this.name="ë„¤ëª¨";
=======
import java.util.Scanner;

public class HomeWork0520 {

	public static void main(String[] args) {
		//±âº»»ý¼ºÀÚ·Î ÀÌ¸§Àº ³×¸ð, °¡·Î12, ¼¼·Î12ÀÇ °ªÀ» °¡Áø rect¸Þ¼Òµå »ý¼º
		Rect rect1=new Rect();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("°´Ã¼ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä: ");
		String str=sc.nextLine();
		System.out.println();
		System.out.print("°¡·Î ±æÀÌ¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
		int width=sc.nextInt();
		System.out.println();
		System.out.println("¼¼·Î ±æÀÌ¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
		int height=sc.nextInt();
		System.out.println();
		//2. ÀÌ¸§,°¡·Î,¼¼·Î¸¦ ÀÔ·Â¹ÞÀº rect¸Þ¼Òµå »ý¼º
		Rect rect2=new Rect(str,width,height);
		
		//3. 1,2¹ø °´Ã¼ Á¤º¸¸¦ Ãâ·Â
		System.out.println("1¹ø °´Ã¼ ÀÌ¸§:"+rect1.name+" °¡·Î:"+rect1.getWidth()+
				" ¼¼·Î:"+rect1.getHeight()+" ¸éÀû:"+rect1.getArea()+" µÑ·¹:"+rect1.getCircumference());
		System.out.println("2¹ø °´Ã¼ ÀÌ¸§:"+rect2.name+" °¡·Î: "+rect2.getWidth()+
				" ¼¼·Î:"+rect2.getHeight()+" ¸éÀû:"+rect2.getArea()+" µÑ·¹:"+rect2.getCircumference());
		
		//4. 1¹ø °´Ã¼¿¡¼­ ÇöÀç °¡·ÎÀÇ °ª¿¡ +2ÇÑ °ªÀ¸·Î ¸éÀû°ú µÑ·¹¸¦ Àç°è»êÇÏ¿© Ãâ·Â
		rect1.width+=2;
		System.out.println("1¹ø °´Ã¼ ÀÌ¸§:"+rect1.name+" °¡·Î:"+rect1.getWidth()+
				" ¼¼·Î:"+rect1.getHeight()+" ¸éÀû:"+rect1.getArea()+" µÑ·¹:"+rect1.getCircumference());
	}

}
class Rect{
	String name;
	int width;//°¡·Î
	private int height; //¼¼·Î
	
	Rect(){
		this.name="³×¸ð";
>>>>>>> refs/remotes/origin/master
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