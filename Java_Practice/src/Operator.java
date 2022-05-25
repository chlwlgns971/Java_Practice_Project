//Operator01
<<<<<<< HEAD
/*1. ì—°ì‚°ìžì˜ ì¢…ë¥˜
 * 	-ì‚°ìˆ , ê´€ê³„, ë…¼ë¦¬, ëŒ€ìž…, ì¦ê°, ì¡°ê±´
 * 	-ë‹¨í•­, ì´í•­, ì‚¼í•­
 * 	-ë…¼ë¦¬ ì—°ì‚°ìž(!->&&->||ìˆœìœ¼ë¡œ ì—°ì‚°)
 */
public class Operator {
	public static void main(String[] args) {
		int a=5;
		int b=5;
		int c=7;
		
		//ë‹¨í•­ ì—°ì‚°ìž
		UnaryOperator up=new UnaryOperator();
		System.out.println("a++ is "+up.postfixIncrement(a));
		System.out.println("++a is "+up.prefixIncrement(a));
		System.out.println("a-- is "+up.postfixDecrement(a));
		System.out.println("--a is "+up.prefixDecrement(a));
		
		//ì´í•­ ì—°ì‚°ìž
		BinaryOperator bo=new BinaryOperator();
		System.out.println("a+b="+bo.add(a, b)); 
		System.out.println("a-b="+bo.minus(a, b)); 
		System.out.println("a*b="+bo.multiply(a, b));
		System.out.println("c/a="+bo.divide(c, a)); 
		System.out.println("c%a="+bo.remain(c, a)); 
		System.out.println("2022%7="+bo.remain(2022, 7));
		
		//ê´€ê³„ ì—°ì‚°ìž
		RelationalOperator ro=new RelationalOperator();
		System.out.println("boolean a>b="+ro.compare(a, b));
		System.out.println("boolean ('co'=='Co')="+ro.compare("co", "Co"));
		System.out.println("boolean ('co'=='co')="+ro.compare("co", "co"));
		System.out.println("boolean (new String('co')==new String('co'))="
				+ro.compare(new String("co"), new String("co")));//ê°ì²´ë¥¼ ìƒˆë¡œ ìƒì„±í–ˆê¸° ë•Œë¬¸ì— ì„œë¡œ ë‹¤ë¥¸ ì£¼ì†Œì˜ Stringì´ë¼ì„œ false
		System.out.println("boolean equals(new String('co')==new String('co'))="
				+(ro.compareEquals(new String("co"), new String("co")))); //equalsë¥¼ ì‚¬ìš©í•˜ë©´ ì£¼ì†Œê°€ ë‹¤ë¥´ë”ë¼ë„ ê°’ ìžì²´ë¥¼ ë¹„êµí•˜ê¸° ë•Œë¬¸ì— trueì¶œë ¥
		System.out.println("boolean ('c'=='c')="+ro.compare('c', 'c'));// ì•„ìŠ¤í‚¤ì½”ë“œë¡œ a>bë¹„êµ ë©”ì†Œë“œì— ë“¤ì–´ê°€ê¸°ë•Œë¬¸ì— false
		
		//ë…¼ë¦¬ì—°ì‚°ìž
		LogicalOperator lo=new LogicalOperator();
		System.out.println("True && True is "+lo.and(true, true));
		System.out.println("False && True is "+lo.and(false, true));
		System.out.println("True || True is "+lo.or(true, true));
		System.out.println("False || True is "+lo.or(false, true));
		System.out.println("True 'NOT' is "+lo.not(true));
		System.out.println("False 'NOT' is "+lo.not(false));
		//ë…¼ë¦¬ì—°ì‚°ìž í…ŒìŠ¤íŠ¸(ìœ¤ë…„íŒë³„)
		int year=1997;
		if(lo.or(lo.and(year%4==0, year%100 !=0),year%400==0)){
			System.out.println(year+"ë…„ì€ ìœ¤ë…„ìž…ë‹ˆë‹¤.");
		}
		else System.out.println(year+"ë…„ì€ í‰ë…„ìž…ë‹ˆë‹¤.");
		
		//ì‚¼í•­ ì—°ì‚°ìž
		System.out.println(a>b ? true:false); //aê°€ bë³´ë‹¤ í°ê²Œ ì°¸ì´ë©´ trueì¶œë ¥, ì•„ë‹ˆë¼ë©´ falseì¶œë ¥
		System.out.println(a==b ? true:false); //aì™€ bê°€ ê°™ë‹¤ë©´ true ì¶œë ¥, ì•„ë‹ˆë¼ë©´ falseì¶œë ¥
		
	}
}
class UnaryOperator{//ë‹¨í•­ì—°ì‚°ìž=ì¦ê°ì—°ì‚°ìž
	public int prefixIncrement(int a){
		int res=++a;
		return res;
	}
	public int postfixIncrement(int a){
		int res=a++;
		return res;
	}
	public int prefixDecrement(int a){
		int res=--a;
		return res;
	}
	public int postfixDecrement(int a){
		int res=a--;
		return res;
	}
	
}
class BinaryOperator{//ì´í•­ì—°ì‚°ìž
	public int add(int a, int b){ //ë”í•˜ê¸°
		int res=a+b;
		return res;
	}
	public double add(double a, int b){ //ì˜¤ë²„ë¡œë”©(ìœ„ì— ê°™ì€ ì´ë¦„ì˜ addë©”ì†Œë“œê°€ ì¡´ìž¬í•˜ì§€ë§Œ íƒ€ìž…ì´ ë‹¤ë¥´ê¸° ë•Œë¬¸ì— ì‚¬ìš©ê°€ëŠ¥)
		double res=a+b;
		return res;
	}
	public int minus(int a, int b){ //ë¹¼ê¸°
		int res=a-b;
		return res;
	}
	public int divide(int a, int b){ //ë‚˜ëˆ—ì…ˆ Â‘Â–
		int res=a/b;
		return res;
	}
	public int remain(int a, int b){ //ë‚˜ëˆ—ì…ˆ ë‚˜ë¨¸ì§€
		int res=a%b;
		return res;
	}
	public int multiply(int a, int b){ // ê³±ì…ˆ
		int res=a*b;
		return res;
	}
}
class RelationalOperator{//ê´€ê³„ì—°ì‚°ìž
=======
/*1. ¿¬»êÀÚÀÇ Á¾·ù
 * 	-»ê¼ú, °ü°è, ³í¸®, ´ëÀÔ, Áõ°¨, Á¶°Ç
 * 	-´ÜÇ×, ÀÌÇ×, »ïÇ×
 * 	-³í¸® ¿¬»êÀÚ(!->&&->||¼øÀ¸·Î ¿¬»ê)
 */
public class Operator {
	public static void main(String[] args) {
		int a=5;
		int b=5;
		int c=7;
		
		//´ÜÇ× ¿¬»êÀÚ
		UnaryOperator up=new UnaryOperator();
		System.out.println("a++ is "+up.postfixIncrement(a));
		System.out.println("++a is "+up.prefixIncrement(a));
		System.out.println("a-- is "+up.postfixDecrement(a));
		System.out.println("--a is "+up.prefixDecrement(a));
		
		//ÀÌÇ× ¿¬»êÀÚ
		BinaryOperator bo=new BinaryOperator();
		System.out.println("a+b="+bo.add(a, b)); 
		System.out.println("a-b="+bo.minus(a, b)); 
		System.out.println("a*b="+bo.multiply(a, b));
		System.out.println("c/a="+bo.divide(c, a)); 
		System.out.println("c%a="+bo.remain(c, a)); 
		System.out.println("2022%7="+bo.remain(2022, 7));
		
		//°ü°è ¿¬»êÀÚ
		RelationalOperator ro=new RelationalOperator();
		System.out.println("boolean a>b="+ro.compare(a, b));
		System.out.println("boolean ('co'=='Co')="+ro.compare("co", "Co"));
		System.out.println("boolean ('co'=='co')="+ro.compare("co", "co"));
		System.out.println("boolean (new String('co')==new String('co'))="
				+ro.compare(new String("co"), new String("co")));//°´Ã¼¸¦ »õ·Î »ý¼ºÇß±â ¶§¹®¿¡ ¼­·Î ´Ù¸¥ ÁÖ¼ÒÀÇ StringÀÌ¶ó¼­ false
		System.out.println("boolean equals(new String('co')==new String('co'))="
				+(ro.compareEquals(new String("co"), new String("co")))); //equals¸¦ »ç¿ëÇÏ¸é ÁÖ¼Ò°¡ ´Ù¸£´õ¶óµµ °ª ÀÚÃ¼¸¦ ºñ±³ÇÏ±â ¶§¹®¿¡ trueÃâ·Â
		System.out.println("boolean ('c'=='c')="+ro.compare('c', 'c'));// ¾Æ½ºÅ°ÄÚµå·Î a>bºñ±³ ¸Þ¼Òµå¿¡ µé¾î°¡±â¶§¹®¿¡ false
		
		//³í¸®¿¬»êÀÚ
		LogicalOperator lo=new LogicalOperator();
		System.out.println("True && True is "+lo.and(true, true));
		System.out.println("False && True is "+lo.and(false, true));
		System.out.println("True || True is "+lo.or(true, true));
		System.out.println("False || True is "+lo.or(false, true));
		System.out.println("True 'NOT' is "+lo.not(true));
		System.out.println("False 'NOT' is "+lo.not(false));
		//³í¸®¿¬»êÀÚ Å×½ºÆ®(À±³âÆÇº°)
		int year=1997;
		if(lo.or(lo.and(year%4==0, year%100 !=0),year%400==0)){
			System.out.println(year+"³âÀº À±³âÀÔ´Ï´Ù.");
		}
		else System.out.println(year+"³âÀº Æò³âÀÔ´Ï´Ù.");
		
		//»ïÇ× ¿¬»êÀÚ
		System.out.println(a>b ? true:false); //a°¡ bº¸´Ù Å«°Ô ÂüÀÌ¸é trueÃâ·Â, ¾Æ´Ï¶ó¸é falseÃâ·Â
		System.out.println(a==b ? true:false); //a¿Í b°¡ °°´Ù¸é true Ãâ·Â, ¾Æ´Ï¶ó¸é falseÃâ·Â
		
	}
}
class UnaryOperator{//´ÜÇ×¿¬»êÀÚ=Áõ°¨¿¬»êÀÚ
	public int prefixIncrement(int a){
		int res=++a;
		return res;
	}
	public int postfixIncrement(int a){
		int res=a++;
		return res;
	}
	public int prefixDecrement(int a){
		int res=--a;
		return res;
	}
	public int postfixDecrement(int a){
		int res=a--;
		return res;
	}
	
}
class BinaryOperator{//ÀÌÇ×¿¬»êÀÚ
	public int add(int a, int b){ //´õÇÏ±â
		int res=a+b;
		return res;
	}
	public double add(double a, int b){ //¿À¹ö·Îµù(À§¿¡ °°Àº ÀÌ¸§ÀÇ add¸Þ¼Òµå°¡ Á¸ÀçÇÏÁö¸¸ Å¸ÀÔÀÌ ´Ù¸£±â ¶§¹®¿¡ »ç¿ë°¡´É)
		double res=a+b;
		return res;
	}
	public int minus(int a, int b){ //»©±â
		int res=a-b;
		return res;
	}
	public int divide(int a, int b){ //³ª´°¼À ‘–
		int res=a/b;
		return res;
	}
	public int remain(int a, int b){ //³ª´°¼À ³ª¸ÓÁö
		int res=a%b;
		return res;
	}
	public int multiply(int a, int b){ // °ö¼À
		int res=a*b;
		return res;
	}
}
class RelationalOperator{//°ü°è¿¬»êÀÚ
>>>>>>> refs/remotes/origin/master
	public boolean compare(int a,int b){
		boolean res=a>b;
		return res;
	}
	public boolean compare(String a,String b){
		boolean res=(a==b);
		return res;
	}
	public boolean compareEquals(String a,String b){
		boolean res=a.equals(b);
		return res;
	}
}
class LogicalOperator{
	public boolean and(boolean a, boolean b){
		boolean res=a&&b;
		return res;
	}
	public boolean or(boolean a, boolean b){
		boolean res=a||b;
		return res;
	}
	public boolean not(boolean a){
		return (!a);
	}
}