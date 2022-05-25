package Chapter06;

public class MemberEx01 {
	private int age;
	private String name;
	private boolean gender=false;
	
	public void setAge(int age, String name, boolean gender){
		this.age=age;
		this.name=name;
		this.gender=gender;
	}

	@Override
	public String toString() {
		return "MemberEx01 [age=" + age + ", name=" + name + ", gender="
				+ gender + "]";
	}
}
/*
<<<<<<< HEAD
* ë¬¸ì œ1 ë‹¤ìŒì¡°ê±´ì„ ë§Œì¡±í•˜ëŠ” ì›(Circle)í´ëž˜ìŠ¤ë¥¼ êµ¬ì„±í•˜ì‹œì˜¤. ë©¤ë²„ë³€ìˆ˜ëŠ” ì‹¤ìˆ˜íƒ€ìž…ì˜ ë°˜ì§€ë¦„(radius)ì™€ ì‹¤ìˆ˜í˜• ìƒìˆ˜ì¸ ì›ì£¼ìœ¨(PI=3.1415926)
* 	1)ê¸°ë³¸ ìƒì„±ìž ë° ë°˜ì§€ë¦„ì„ ì •ì˜í•˜ëŠ” ìƒì„±ìž
* 	2)í˜„ìž¬ì˜ ë°˜ì§€ë¦„ìœ¼ë¡œ ë©´ì ì„ êµ¬í•˜ì—¬ ë°˜í™˜í•˜ëŠ” í•¨ìˆ˜(getArea)
* ë¬¸ì œ2 ì›í†µí´ëž˜ìŠ¤(Cylinder)ë¥¼ êµ¬ì„±í•˜ì‹œì˜¤
* 	1)ë©¤ë²„: ë†’ì´(ì‹¤ìˆ˜í˜•), ë¬¸ì œ1ì—ì„œ êµ¬ì„±í•œ Circleíƒ€ìž…ì˜ ì›
* 	2)ë©”ì„œë“œ: ë¶€í”¼ë¥¼ ë°˜í™˜í•˜ëŠ” ì‹¤ìˆ˜í˜• ë©”ì„œë“œ getVolumn()
* ë¬¸ì œ3 ë‹¤ìŒ ì¡°ê±´ì„ ë§Œì¡±í•˜ëŠ” í´ëž˜ìŠ¤ë¥¼ ìƒì„±í•˜ì‹œì˜¤(ì‚¬ì›í´ëž˜ìŠ¤(Employee))
* 	1)ë©¤ë²„ë³€ìˆ˜: ì›”ê¸‰ì—¬(salary): ì •ìˆ˜í˜•, ì‚¬ì›ë²ˆí˜¸(emp_id): ë¬¸ìžì—´, ì‚¬ì›ëª…(emp_name): ë¬¸ìžì—´
* 	2)ë©”ì„œë“œ: ìƒì„±ìž(ì‚¬ì›ë²ˆí˜¸, ì‚¬ì›ëª…ì„ ìž…ë ¥), ê¸°ë³¸ìƒì„±ìž, ì—°ë´‰ì„ ê³„ì‚°í•´ì„œ ë°˜í™˜í•˜ëŠ” ë©”ì„œë“œ
* ë¬¸ì œ4 ìœ„ì˜ ì‚¬ì› ì—¬ëŸ¬ëª…ì„ ì²˜ë¦¬í•˜ê¸° ìœ„í•œ ë°©ë²•
* 
* ìœ„ ë¬¸ì œë¥¼ ì½”ë”©í•˜ì—¬ ë©”ë¡œìž¥ì— ë³µì‚¬í•œ í›„ sem-pcì˜ D:\A_TeachingMaterial\1.BasicJava\Homeworkì— ì „ì†¡í•  ê²ƒ.
* íŒŒì¼ëª…: ì´ë¦„.txt
*/
class Circle{
	public double radius;
	private final double PI=3.1415926;
	public Circle(double radius){
		this.radius=radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getArea(){
		double circleArea=radius*radius*PI;
		return circleArea;
	}
}
class Cylinder{
	private double height;
	private Circle c1;
	public Cylinder(){
		this(10,new Circle(23.35));
	}
	public Cylinder(double height, Circle c1){
		this.height=height;
		this.c1=c1;
	}
	public double getVolumn(){
		double cylinder=c1.getArea()*height;
		return cylinder;
	}
}
//class Cylinder{
//	private double height;
//	private double radius;
//	public void setCylinder(double height, double radius){
//		this.height=height;
//		this.radius=radius;
//	}
//	public double getVolumn(){
//		Circle circle=new Circle(radius); //getVolumn ë°–ì—ì„œ ì„ ì–¸í•˜ë©´ Cylinder í´ëž˜ìŠ¤ê°€ í˜¸ì¶œë˜ëŠ” ì‹œì ì— ì„ ì–¸ë˜ê³  radiusê°€ 0ì´ ëœë‹¤. ë”°ë¼ì„œ ë‚´ë¶€ ë©”ì†Œë“œì•ˆì—ì„œ ì„ ì–¸
//		double cylinder=circle.getArea()*height;
//		return cylinder;
//	}
//}
class Employee{
	int salary;
	String emp_id;
	String emp_name;
	public Employee(){
		this.salary=250;
		this.emp_id="20220520";
		this.emp_name="ìµœì§€í›ˆ";
=======
* ¹®Á¦1 ´ÙÀ½Á¶°ÇÀ» ¸¸Á·ÇÏ´Â ¿ø(Circle)Å¬·¡½º¸¦ ±¸¼ºÇÏ½Ã¿À. ¸â¹öº¯¼ö´Â ½Ç¼öÅ¸ÀÔÀÇ ¹ÝÁö¸§(radius)¿Í ½Ç¼öÇü »ó¼öÀÎ ¿øÁÖÀ²(PI=3.1415926)
* 	1)±âº» »ý¼ºÀÚ ¹× ¹ÝÁö¸§À» Á¤ÀÇÇÏ´Â »ý¼ºÀÚ
* 	2)ÇöÀçÀÇ ¹ÝÁö¸§À¸·Î ¸éÀûÀ» ±¸ÇÏ¿© ¹ÝÈ¯ÇÏ´Â ÇÔ¼ö(getArea)
* ¹®Á¦2 ¿øÅëÅ¬·¡½º(Cylinder)¸¦ ±¸¼ºÇÏ½Ã¿À
* 	1)¸â¹ö: ³ôÀÌ(½Ç¼öÇü), ¹®Á¦1¿¡¼­ ±¸¼ºÇÑ CircleÅ¸ÀÔÀÇ ¿ø
* 	2)¸Þ¼­µå: ºÎÇÇ¸¦ ¹ÝÈ¯ÇÏ´Â ½Ç¼öÇü ¸Þ¼­µå getVolumn()
* ¹®Á¦3 ´ÙÀ½ Á¶°ÇÀ» ¸¸Á·ÇÏ´Â Å¬·¡½º¸¦ »ý¼ºÇÏ½Ã¿À(»ç¿øÅ¬·¡½º(Employee))
* 	1)¸â¹öº¯¼ö: ¿ù±Þ¿©(salary): Á¤¼öÇü, »ç¿ø¹øÈ£(emp_id): ¹®ÀÚ¿­, »ç¿ø¸í(emp_name): ¹®ÀÚ¿­
* 	2)¸Þ¼­µå: »ý¼ºÀÚ(»ç¿ø¹øÈ£, »ç¿ø¸íÀ» ÀÔ·Â), ±âº»»ý¼ºÀÚ, ¿¬ºÀÀ» °è»êÇØ¼­ ¹ÝÈ¯ÇÏ´Â ¸Þ¼­µå
* ¹®Á¦4 À§ÀÇ »ç¿ø ¿©·¯¸íÀ» Ã³¸®ÇÏ±â À§ÇÑ ¹æ¹ý
* 
* À§ ¹®Á¦¸¦ ÄÚµùÇÏ¿© ¸Þ·ÎÀå¿¡ º¹»çÇÑ ÈÄ sem-pcÀÇ D:\A_TeachingMaterial\1.BasicJava\Homework¿¡ Àü¼ÛÇÒ °Í.
* ÆÄÀÏ¸í: ÀÌ¸§.txt
*/
class Circle{
	public double radius;
	private final double PI=3.1415926;
	public Circle(double radius){
		this.radius=radius;
	}
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getArea(){
		double circleArea=radius*radius*PI;
		return circleArea;
	}
}
class Cylinder{
	private double height;
	private Circle c1;
	public Cylinder(){
		this(10,new Circle(23.35));
	}
	public Cylinder(double height, Circle c1){
		this.height=height;
		this.c1=c1;
	}
	public double getVolumn(){
		double cylinder=c1.getArea()*height;
		return cylinder;
	}
}
//class Cylinder{
//	private double height;
//	private double radius;
//	public void setCylinder(double height, double radius){
//		this.height=height;
//		this.radius=radius;
//	}
//	public double getVolumn(){
//		Circle circle=new Circle(radius); //getVolumn ¹Û¿¡¼­ ¼±¾ðÇÏ¸é Cylinder Å¬·¡½º°¡ È£ÃâµÇ´Â ½ÃÁ¡¿¡ ¼±¾ðµÇ°í radius°¡ 0ÀÌ µÈ´Ù. µû¶ó¼­ ³»ºÎ ¸Þ¼Òµå¾È¿¡¼­ ¼±¾ð
//		double cylinder=circle.getArea()*height;
//		return cylinder;
//	}
//}
class Employee{
	int salary;
	String emp_id;
	String emp_name;
	public Employee(){
		this.salary=250;
		this.emp_id="20220520";
		this.emp_name="ÃÖÁöÈÆ";
>>>>>>> refs/remotes/origin/master
	}
	public Employee(int salary, String emp_id, String emp_name){
		this.salary=salary;
		this.emp_id=emp_id;
		this.emp_name=emp_name;
	}
	public int getYearSalary(){
		return (salary*12)+(salary*5);
	}
}