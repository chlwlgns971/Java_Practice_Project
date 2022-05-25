package Chapter06;

/*	2022.05.23
<<<<<<< HEAD
 * ì¸ìŠ¤í„´ìŠ¤ë©¤ë²„ì™€ static ë©¤ë²„
 * 1)ì¸ìŠ¤í„´ìŠ¤ ë©¤ë²„
 * 	-í´ë˜ìŠ¤ì—ì„œ ì„ ì–¸ë˜ëŠ” í•„ë“œ(ë³€ìˆ˜ì™€ ìƒìˆ˜) ë° ë©”ì„œë“œ
 * 	-ìƒì„±ì€ í´ë˜ìŠ¤ ê°ì²´ê°€ ìƒì„±ë  ë•Œ
 * 	-ì‚¬ìš©ìê°€ ì´ˆê¸°í™”ë¥¼ ì‹œí‚¤ì§€ ì•Šì•„ë„ ìë™ì´ˆê¸°í™”ê°€ ëœë‹¤.
 * 	-this, super: ì°¸ì¡°í˜• ë³€ìˆ˜ ì œê³µ(ì°¸ì¡°í˜• ë³€ìˆ˜ëŠ” ì£¼ì†Œê°’ì„ ê°€ì§€ê³  ìˆëŠ” ë³€ìˆ˜)
 * 	-this: ìì‹ ì˜ í´ë˜ìŠ¤ ì£¼ì†Œë¥¼ ì €ì¥ ->ì¸ìŠ¤í„´ìŠ¤ ë³€ìˆ˜ì™€ ë©”ì„œë“œ ë‚´ë¶€ì—ì„œ ì„ ì–¸ëœ ì§€ì—­ë³€ìˆ˜ê°€ ê°™ì€ ë‹¨ì–´ë¡œ êµ¬ì„±ë˜ì—ˆì„ ë•Œ ë©”ì„œë“œ ë‚´ë¶€ì—ì„œ ì¸ìŠ¤í„´ìŠ¤ ë³€ìˆ˜ë¥¼ ì§€ì¹­í•  ë•Œ ì‚¬ìš©
 * 
 * 2) ì •ì ë©¤ë²„
 * 	-static í‚¤ì›Œë“œë¥¼ ì‚¬ìš©
 * 	-ìƒì„±ì‹œì ì´ í•´ë‹¹ í´ë˜ìŠ¤ê°€ ë©”ëª¨ë¦¬ì— loadingë  ë•Œ ìƒì„±->ì´ˆê¸°í™”ë„ í•œë²ˆë§Œ ìˆ˜í–‰.
 * 	-JVMë©”ëª¨ë¦¬ ì¤‘ ë©”ì„œë“œ ì˜ì—­ì— ì €ì¥ë¨
 * 	-ì •ì ë©”ì„œë“œ ë‚´ì—ì„œ ì°¸ì¡°í•˜ëŠ” ë³€ìˆ˜ë‚˜ ë©”ì„œë“œëŠ” ë°˜ë“œì‹œ ì •ì ì´ì–´ì•¼ í•¨
 * 	-ì •ì ë©”ì„œë“œì—ì„œ thisë³€ìˆ˜ëŠ” ì‚¬ìš©í•  ìˆ˜ ì—†ë‹¤.
 * 	-ì •ì ë©”ì„œë“œë¥¼ í˜¸ì¶œí•  ê²½ìš° í•´ë‹¹ í´ë˜ìŠ¤ì´ë¦„ìœ¼ë¡œë„ í˜¸ì¶œê°€ëŠ¥
 * 	-staticì„ ì‚¬ìš©í•´ì„œ ê°ì²´ë¥¼ ìƒì„±í•  ë•Œë§ˆë‹¤ ì œí’ˆë²ˆí˜¸ë¥¼ ë‹¤ë¥´ê²Œ í•˜ëŠ” ë“± ì‘ìš©í•  ìˆ˜ ìˆì§€ë§Œ, ê²°í•©ë„ê°€ ë†’ì•„ì ¸ì„œ ë¶€ì‘ìš© ë°œìƒê°€ëŠ¥ì„±ì´ ìˆë‹¤.
 * 		->ë”°ë¼ì„œ ê¼­ í•„ìš”í•œ ë¶€ë¶„ë§Œ staticì„ ì‚¬ìš©í•˜ëŠ” ê²ƒì´ ì¢‹ë‹¤.
 * 
 * 3)finalí•„ë“œ
 * 	-ë³€ìˆ˜, ë©”ì„œë“œ, í´ë˜ìŠ¤ì— ì‚¬ìš©
 * 	-ë³€ìˆ˜ì— ì‚¬ìš©ë˜ì–´ ìƒìˆ˜í™”
 * 	-ë©”ì„œë“œì— ì‚¬ìš©ë˜ë©´ overridingì´ ì œí•œë¨
 * 	-í´ë˜ìŠ¤ì— ì‚¬ìš©ë˜ë©´ í•˜ìœ„í´ë˜ìŠ¤ ìƒì„±ì´ ë¶ˆê°€(ì¢…ë‹¨ í´ë˜ìŠ¤)
 * 	-ì¸ìŠ¤í„´ìŠ¤ë³€ìˆ˜ì— ì‚¬ìš©ë˜ë©´ í•´ë‹¹ í´ë˜ìŠ¤ëŠ” ì¬ì„±ìƒì´ ë¶ˆê°€ëŠ¥
 */

public class Instance01 {

	public static void main(String[] args) {
		//this ë©¤ë²„ë³€ìˆ˜ ì—°ìŠµ
		Car2 car=new Car2();
		Car2 car2=new Car2();
		car2.setColor("ê²€ì •");
		car2.setKind("ì„¸ë‹¨");
		car2.setMaxSpeed(300);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		System.out.println();
		
		//staticì„ ì‚¬ìš©í•œ ì œí’ˆë²ˆí˜¸ ì¦ê°€
		Prod p1=new Prod();
		p1.printInfo();
		Prod p2=new Prod();
		p2.printInfo();
		Prod p3=new Prod();
		p3.printInfo();
		System.out.println();
		
		//finalí•„ë“œ ê°ì²´ìƒì„± ì—°ìŠµ
		final Company cp1=new Company();
		cp1.setName("(ì£¼)ë‹¤íŒ”ì•„");
		System.out.println("íšŒì‚¬ëª…: "+cp1.getName());
		//cp1=new Company(); //cp1ì„ finalë¡œ ìƒì„±í–ˆê¸°ë•Œë¬¸ì— ê°™ì€ í´ë˜ìŠ¤ ê°ì²´ì˜ ì¬ìƒì„±ì´ ë¶ˆê°€ëŠ¥
		System.out.println();
		
		//finalí•„ë“œ í´ë˜ìŠ¤ì„ ì–¸ ì—°ìŠµ
		Shape s1=new Shape();
		System.out.println(s1.getShape());
		Rectangle r1=new Rectangle();
		System.out.println(r1.getShape());
		//Shape í´ë˜ìŠ¤ì— finalì„ ë¶™ì´ë©´ ìì‹í´ë˜ìŠ¤ë¥¼ ê°€ì§ˆ ìˆ˜ ì—†ê¸°ë•Œë¬¸ì— ì—ëŸ¬ê°€ ë‚œë‹¤.
		System.out.println();
		System.out.println("ì˜¤ë²„ë¼ì´ë“œ í…ŒìŠ¤íŠ¸");
		Shape s2=new Rectangle();
		System.out.println("Shape s2=new Rectangle()ì˜ ê²°ê³¼ëŠ” "+s2.getShape());
	}

}
class Car2{
	private String kind;
	private String color;
	private int maxSpeed;
	
	Car2(){
		this.color="color";
		this.kind="kind";
		this.maxSpeed=0;
	}
	
	public void setKind(String kind){
		this.kind=kind;
	}
	public String getKind(){
		return kind;
	}
	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed=maxSpeed;
	}
	public int getMaxSpeed(){
		return maxSpeed;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getcolor(){
		return color;
	}
	@Override
	public String toString() {
		return "Car2 [kind=" + kind + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]";
	}
	
}
class Prod{ //staticì—°ìŠµ
	static int prod_id=99;
	
	public Prod(){// ìƒˆë¡œìš´ ê°ì²´ë¥¼ ìƒì„±í•  ë•Œë§ˆë‹¤ ì œí’ˆë²ˆí˜¸ë¥¼ 1ì”© ì¦ê°€->but ìƒì„±ë  ë•Œë§ˆë‹¤ ì´ˆê¸°í™”ê°€ ì¼ì–´ë‚˜ì„œ í•­ìƒ ê°™ì€ ë²ˆí˜¸ ì¶œë ¥ ->staticì‚¬ìš© í•„ìš”
		prod_id++;
	}
	public void printInfo(){
		System.out.println("ì œí’ˆë²ˆí˜¸: "+prod_id);
	}
}
class Company{//final ì—°ìŠµ
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
/*final*/ class Shape{
	String kind;
	
	Shape(){
		kind="ë‹¤ê°í˜•";
	}
	public /*final*/ String getShape(){ //ë©”ì„œë“œì— finalì´ ë¶™ìœ¼ë©´ ì˜¤ë²„ë¼ì´ë”©ì„ í•  ìˆ˜ ì—†ë‹¤.
		return kind;
	}
	
}
class Rectangle extends Shape{//ìƒì† ë° ì˜¤ë²„ë¼ì´ë”©
	Rectangle(){
		kind="ì‚¬ê°í˜•"; //ë¶€ëª¨í´ë˜ìŠ¤ì—ì„œ ì„ ì–¸ëœ ë³€ìˆ˜ì´ê¸° ë•Œë¬¸ì— ìì‹í´ë˜ìŠ¤ì—ì„  ì„ ì–¸ì—†ì´ ì‚¬ìš©ê°€ëŠ¥
	}
	@Override
	public final String getShape(){
		return "ë‹¤ê°í˜•ì˜ ì¢…ë¥˜:"+kind;
=======
 * ÀÎ½ºÅÏ½º¸â¹ö¿Í static ¸â¹ö
 * 1)ÀÎ½ºÅÏ½º ¸â¹ö
 * 	-Å¬·¡½º¿¡¼­ ¼±¾ğµÇ´Â ÇÊµå(º¯¼ö¿Í »ó¼ö) ¹× ¸Ş¼­µå
 * 	-»ı¼ºÀº Å¬·¡½º °´Ã¼°¡ »ı¼ºµÉ ¶§
 * 	-»ç¿ëÀÚ°¡ ÃÊ±âÈ­¸¦ ½ÃÅ°Áö ¾Ê¾Æµµ ÀÚµ¿ÃÊ±âÈ­°¡ µÈ´Ù.
 * 	-this, super: ÂüÁ¶Çü º¯¼ö Á¦°ø(ÂüÁ¶Çü º¯¼ö´Â ÁÖ¼Ò°ªÀ» °¡Áö°í ÀÖ´Â º¯¼ö)
 * 	-this: ÀÚ½ÅÀÇ Å¬·¡½º ÁÖ¼Ò¸¦ ÀúÀå ->ÀÎ½ºÅÏ½º º¯¼ö¿Í ¸Ş¼­µå ³»ºÎ¿¡¼­ ¼±¾ğµÈ Áö¿ªº¯¼ö°¡ °°Àº ´Ü¾î·Î ±¸¼ºµÇ¾úÀ» ¶§ ¸Ş¼­µå ³»ºÎ¿¡¼­ ÀÎ½ºÅÏ½º º¯¼ö¸¦ ÁöÄªÇÒ ¶§ »ç¿ë
 * 
 * 2) Á¤Àû¸â¹ö
 * 	-static Å°¿öµå¸¦ »ç¿ë
 * 	-»ı¼º½ÃÁ¡ÀÌ ÇØ´ç Å¬·¡½º°¡ ¸Ş¸ğ¸®¿¡ loadingµÉ ¶§ »ı¼º->ÃÊ±âÈ­µµ ÇÑ¹ø¸¸ ¼öÇà.
 * 	-JVM¸Ş¸ğ¸® Áß ¸Ş¼­µå ¿µ¿ª¿¡ ÀúÀåµÊ
 * 	-Á¤Àû¸Ş¼­µå ³»¿¡¼­ ÂüÁ¶ÇÏ´Â º¯¼ö³ª ¸Ş¼­µå´Â ¹İµå½Ã Á¤ÀûÀÌ¾î¾ß ÇÔ
 * 	-Á¤Àû¸Ş¼­µå¿¡¼­ thisº¯¼ö´Â »ç¿ëÇÒ ¼ö ¾ø´Ù.
 * 	-Á¤Àû¸Ş¼­µå¸¦ È£ÃâÇÒ °æ¿ì ÇØ´ç Å¬·¡½ºÀÌ¸§À¸·Îµµ È£Ãâ°¡´É
 * 	-staticÀ» »ç¿ëÇØ¼­ °´Ã¼¸¦ »ı¼ºÇÒ ¶§¸¶´Ù Á¦Ç°¹øÈ£¸¦ ´Ù¸£°Ô ÇÏ´Â µî ÀÀ¿ëÇÒ ¼ö ÀÖÁö¸¸, °áÇÕµµ°¡ ³ô¾ÆÁ®¼­ ºÎÀÛ¿ë ¹ß»ı°¡´É¼ºÀÌ ÀÖ´Ù.
 * 		->µû¶ó¼­ ²À ÇÊ¿äÇÑ ºÎºĞ¸¸ staticÀ» »ç¿ëÇÏ´Â °ÍÀÌ ÁÁ´Ù.
 * 
 * 3)finalÇÊµå
 * 	-º¯¼ö, ¸Ş¼­µå, Å¬·¡½º¿¡ »ç¿ë
 * 	-º¯¼ö¿¡ »ç¿ëµÇ¾î »ó¼öÈ­
 * 	-¸Ş¼­µå¿¡ »ç¿ëµÇ¸é overridingÀÌ Á¦ÇÑµÊ
 * 	-Å¬·¡½º¿¡ »ç¿ëµÇ¸é ÇÏÀ§Å¬·¡½º »ı¼ºÀÌ ºÒ°¡(Á¾´Ü Å¬·¡½º)
 * 	-ÀÎ½ºÅÏ½ºº¯¼ö¿¡ »ç¿ëµÇ¸é ÇØ´ç Å¬·¡½º´Â Àç¼º»ıÀÌ ºÒ°¡´É
 */

public class Instance01 {

	public static void main(String[] args) {
		//this ¸â¹öº¯¼ö ¿¬½À
		Car2 car=new Car2();
		Car2 car2=new Car2();
		car2.setColor("°ËÁ¤");
		car2.setKind("¼¼´Ü");
		car2.setMaxSpeed(300);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		System.out.println();
		
		//staticÀ» »ç¿ëÇÑ Á¦Ç°¹øÈ£ Áõ°¡
		Prod p1=new Prod();
		p1.printInfo();
		Prod p2=new Prod();
		p2.printInfo();
		Prod p3=new Prod();
		p3.printInfo();
		System.out.println();
		
		//finalÇÊµå °´Ã¼»ı¼º ¿¬½À
		final Company cp1=new Company();
		cp1.setName("(ÁÖ)´ÙÆÈ¾Æ");
		System.out.println("È¸»ç¸í: "+cp1.getName());
		//cp1=new Company(); //cp1À» final·Î »ı¼ºÇß±â¶§¹®¿¡ °°Àº Å¬·¡½º °´Ã¼ÀÇ Àç»ı¼ºÀÌ ºÒ°¡´É
		System.out.println();
		
		//finalÇÊµå Å¬·¡½º¼±¾ğ ¿¬½À
		Shape s1=new Shape();
		System.out.println(s1.getShape());
		Rectangle r1=new Rectangle();
		System.out.println(r1.getShape());
		//Shape Å¬·¡½º¿¡ finalÀ» ºÙÀÌ¸é ÀÚ½ÄÅ¬·¡½º¸¦ °¡Áú ¼ö ¾ø±â¶§¹®¿¡ ¿¡·¯°¡ ³­´Ù.
		System.out.println();
		System.out.println("¿À¹ö¶óÀÌµå Å×½ºÆ®");
		Shape s2=new Rectangle();
		System.out.println("Shape s2=new Rectangle()ÀÇ °á°ú´Â "+s2.getShape());
	}

}
class Car2{
	private String kind;
	private String color;
	private int maxSpeed;
	
	Car2(){
		this.color="color";
		this.kind="kind";
		this.maxSpeed=0;
	}
	
	public void setKind(String kind){
		this.kind=kind;
	}
	public String getKind(){
		return kind;
	}
	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed=maxSpeed;
	}
	public int getMaxSpeed(){
		return maxSpeed;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getcolor(){
		return color;
	}
	@Override
	public String toString() {
		return "Car2 [kind=" + kind + ", color=" + color + ", maxSpeed="
				+ maxSpeed + "]";
	}
	
}
class Prod{ //static¿¬½À
	static int prod_id=99;
	
	public Prod(){// »õ·Î¿î °´Ã¼¸¦ »ı¼ºÇÒ ¶§¸¶´Ù Á¦Ç°¹øÈ£¸¦ 1¾¿ Áõ°¡->but »ı¼ºµÉ ¶§¸¶´Ù ÃÊ±âÈ­°¡ ÀÏ¾î³ª¼­ Ç×»ó °°Àº ¹øÈ£ Ãâ·Â ->static»ç¿ë ÇÊ¿ä
		prod_id++;
	}
	public void printInfo(){
		System.out.println("Á¦Ç°¹øÈ£: "+prod_id);
	}
}
class Company{//final ¿¬½À
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}
/*final*/ class Shape{
	String kind;
	
	Shape(){
		kind="´Ù°¢Çü";
	}
	public /*final*/ String getShape(){ //¸Ş¼­µå¿¡ finalÀÌ ºÙÀ¸¸é ¿À¹ö¶óÀÌµùÀ» ÇÒ ¼ö ¾ø´Ù.
		return kind;
	}
	
}
class Rectangle extends Shape{//»ó¼Ó ¹× ¿À¹ö¶óÀÌµù
	Rectangle(){
		kind="»ç°¢Çü"; //ºÎ¸ğÅ¬·¡½º¿¡¼­ ¼±¾ğµÈ º¯¼öÀÌ±â ¶§¹®¿¡ ÀÚ½ÄÅ¬·¡½º¿¡¼± ¼±¾ğ¾øÀÌ »ç¿ë°¡´É
	}
	@Override
	public final String getShape(){
		return "´Ù°¢ÇüÀÇ Á¾·ù:"+kind;
>>>>>>> refs/remotes/origin/master
	}
}