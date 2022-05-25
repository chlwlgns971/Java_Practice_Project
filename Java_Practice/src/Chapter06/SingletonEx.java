package Chapter06;

/*Singleton Class
<<<<<<< HEAD
 * 	-ì „ì²´ í”„ë¡œê·¸ëž¨ì—ì„œ í´ëž˜ìŠ¤ ê°ì²´ê°€ í•˜ë‚˜ë§Œ ìƒì„±ë˜ê³  í•´ë‹¹ ê°ì²´ê°€ í•„ìš”í•  ë•Œë§ˆë‹¤ í•´ë‹¹ ê°ì²´ì˜ ì£¼ì†Œê°’ì„ ì „ë‹¬
 * 	-ìƒì„±ìž ë©”ì†Œë“œì˜ ì ‘ê·¼ì§€ì •ìžë¡œ privateë¥¼ ì‚¬ìš©í•˜ì—¬ ì™¸ë¶€ì—ì„œ í´ëž˜ìŠ¤ ê°ì²´ë¥¼ ì§ì ‘ ìƒì„±í•˜ì§€ ëª»í•¨
 * 	-í´ëž˜ìŠ¤ ë‚´ë¶€ì—ì„œ ìžì‹ ì˜ íƒ€ìž…ì˜ ê°ì²´ë¥¼ ìƒì„±í•˜ì—¬ ì´ˆê¸°í™”
 * 	-ì™¸ë¶€ì—ì„œ í˜¸ì¶œê°€ëŠ¥í•œ getInstance()ì„ ì–¸ ì‚¬ìš©
 * 	-Springì—ì„œ ë§Žì´ ì‚¬ìš©
 * 	-Threadì— ì·¨ì•½í•œ ë©´ì´ ìžˆìŒ
 */

public class SingletonEx {

	public static void main(String[] args) {
		//s1ì€ staticìœ¼ë¡œ ì„ ì–¸ë˜ì—ˆê¸° ë•Œë¬¸ì— newìƒì„±ìžë¥¼ í†µí•´ ê°ì²´ìƒì„±í•  ìˆ˜ê°€ ì—†ë‹¤.
		//	->ë”°ë¼ì„œ ê·¸ëƒ¥ í´ëž˜ìŠ¤ ì´ë¦„ì„ í†µí•´ í˜¸ì¶œì´ ê°€ëŠ¥í•˜ë˜, ë©”ì„œë“œì—ë„ staticì„ ë¶™ì—¬ì•¼ í•œë‹¤.
		//ì •ì  blockì´ìš©: ì¸ìŠ¤í„´ìŠ¤ì˜ ìƒì„± ì‹œì ì´ ì‚¬ìš©ì‹œì ì´ ì•„ë‹ˆë¼ í´ëž˜ìŠ¤ ë¡œë”© ì‹œì 
		Singleton s1=Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2=Singleton.getInstance();
		System.out.println(s2);
		System.out.println();
		
		//ì¸ìŠ¤í„´ìŠ¤ê°€ í•„ìš”í•œ ì‹œì ì—ì„œ ê°ì²´ ìƒì„±
		Singleton01 st1=Singleton01.getInstance();
		System.out.println(st1);
		Singleton01 st2=Singleton01.getInstance();
		System.out.println(st2);
		
		//ìŠ¤ë ˆë“œ ì²˜ë¦¬
		Singleton02 sg1=Singleton02.getInstance();
		System.out.println(st1);
		Singleton02 sg2=Singleton02.getInstance();
		System.out.println(st2);
	}

}
//ì •ì  blockì´ìš©: ì¸ìŠ¤í„´ìŠ¤ì˜ ìƒì„± ì‹œì ì´ ì‚¬ìš©ì‹œì ì´ ì•„ë‹ˆë¼ í´ëž˜ìŠ¤ ë¡œë”© ì‹œì (ìž˜ ì‚¬ìš©ì•ˆí•¨)
class Singleton{
	private static Singleton s1;
	private Singleton(){}
	static{
		try{
			s1=new Singleton();
		}
		catch(Exception e){
			throw new RuntimeException("Create Instance fail"+"msg="+e.getMessage());
		}
	}
	public static Singleton getInstance(){
		return s1;
	}
}
//ì¸ìŠ¤í„´ìŠ¤ê°€ í•„ìš”í•œ ì‹œì ì—ì„œ ê°ì²´ ìƒì„± (ìžì£¼ì‚¬ìš©)
class Singleton01{
	private static Singleton01 s1;
	private Singleton01(){}
	public static Singleton01 getInstance(){
		if(s1==null) s1=new Singleton01();
		return s1;
	}
}
//ìŠ¤ë ˆë“œ ì²˜ë¦¬ í¬í•¨
class Singleton02{
	private static Singleton02 s1;
	private Singleton02(){}
	public static synchronized Singleton02 getInstance(){
	//ìŠ¤ë ˆë“œì—ì„œ ë™ì‹œ ì ‘ê·¼ë¬¸ì œ í•´ê²°->but ì‹œê°„ì´ ë§Žì´ ì†Œìš”ë˜ì–´ ì„±ëŠ¥ì €í•˜ê°€ ì¼ì–´ë‚¨
		if(s1==null) s1=new Singleton02();
		return s1;
	}
}
//ìŠ¤ë ˆë“œ ì²˜ë¦¬ í¬í•¨+ì„±ëŠ¥ê°œì„ (ì´ë„ˆí´ëž˜ìŠ¤ ì´ìš©)
class Singleton03{
	private static Singleton03 s1;
	private Singleton03(){}
	private static class InnerInstance{
		final static Singleton03 s1=new Singleton03();
	}
	public static Singleton03 getInstance(){
		return InnerInstance.s1;
	}
}
=======
 * 	-ÀüÃ¼ ÇÁ·Î±×·¥¿¡¼­ Å¬·¡½º °´Ã¼°¡ ÇÏ³ª¸¸ »ý¼ºµÇ°í ÇØ´ç °´Ã¼°¡ ÇÊ¿äÇÒ ¶§¸¶´Ù ÇØ´ç °´Ã¼ÀÇ ÁÖ¼Ò°ªÀ» Àü´Þ
 * 	-»ý¼ºÀÚ ¸Þ¼ÒµåÀÇ Á¢±ÙÁöÁ¤ÀÚ·Î private¸¦ »ç¿ëÇÏ¿© ¿ÜºÎ¿¡¼­ Å¬·¡½º °´Ã¼¸¦ Á÷Á¢ »ý¼ºÇÏÁö ¸øÇÔ
 * 	-Å¬·¡½º ³»ºÎ¿¡¼­ ÀÚ½ÅÀÇ Å¸ÀÔÀÇ °´Ã¼¸¦ »ý¼ºÇÏ¿© ÃÊ±âÈ­
 * 	-¿ÜºÎ¿¡¼­ È£Ãâ°¡´ÉÇÑ getInstance()¼±¾ð »ç¿ë
 * 	-Spring¿¡¼­ ¸¹ÀÌ »ç¿ë
 * 	-Thread¿¡ Ãë¾àÇÑ ¸éÀÌ ÀÖÀ½
 */

public class SingletonEx {

	public static void main(String[] args) {
		//s1Àº staticÀ¸·Î ¼±¾ðµÇ¾ú±â ¶§¹®¿¡ new»ý¼ºÀÚ¸¦ ÅëÇØ °´Ã¼»ý¼ºÇÒ ¼ö°¡ ¾ø´Ù.
		//	->µû¶ó¼­ ±×³É Å¬·¡½º ÀÌ¸§À» ÅëÇØ È£ÃâÀÌ °¡´ÉÇÏµÇ, ¸Þ¼­µå¿¡µµ staticÀ» ºÙ¿©¾ß ÇÑ´Ù.
		//Á¤Àû blockÀÌ¿ë: ÀÎ½ºÅÏ½ºÀÇ »ý¼º ½ÃÁ¡ÀÌ »ç¿ë½ÃÁ¡ÀÌ ¾Æ´Ï¶ó Å¬·¡½º ·Îµù ½ÃÁ¡
		Singleton s1=Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2=Singleton.getInstance();
		System.out.println(s2);
		System.out.println();
		
		//ÀÎ½ºÅÏ½º°¡ ÇÊ¿äÇÑ ½ÃÁ¡¿¡¼­ °´Ã¼ »ý¼º
		Singleton01 st1=Singleton01.getInstance();
		System.out.println(st1);
		Singleton01 st2=Singleton01.getInstance();
		System.out.println(st2);
		
		//½º·¹µå Ã³¸®
		Singleton02 sg1=Singleton02.getInstance();
		System.out.println(st1);
		Singleton02 sg2=Singleton02.getInstance();
		System.out.println(st2);
	}

}
//Á¤Àû blockÀÌ¿ë: ÀÎ½ºÅÏ½ºÀÇ »ý¼º ½ÃÁ¡ÀÌ »ç¿ë½ÃÁ¡ÀÌ ¾Æ´Ï¶ó Å¬·¡½º ·Îµù ½ÃÁ¡(Àß »ç¿ë¾ÈÇÔ)
class Singleton{
	private static Singleton s1;
	private Singleton(){}
	static{
		try{
			s1=new Singleton();
		}
		catch(Exception e){
			throw new RuntimeException("Create Instance fail"+"msg="+e.getMessage());
		}
	}
	public static Singleton getInstance(){
		return s1;
	}
}
//ÀÎ½ºÅÏ½º°¡ ÇÊ¿äÇÑ ½ÃÁ¡¿¡¼­ °´Ã¼ »ý¼º (ÀÚÁÖ»ç¿ë)
class Singleton01{
	private static Singleton01 s1;
	private Singleton01(){}
	public static Singleton01 getInstance(){
		if(s1==null) s1=new Singleton01();
		return s1;
	}
}
//½º·¹µå Ã³¸® Æ÷ÇÔ
class Singleton02{
	private static Singleton02 s1;
	private Singleton02(){}
	public static synchronized Singleton02 getInstance(){
	//½º·¹µå¿¡¼­ µ¿½Ã Á¢±Ù¹®Á¦ ÇØ°á->but ½Ã°£ÀÌ ¸¹ÀÌ ¼Ò¿äµÇ¾î ¼º´ÉÀúÇÏ°¡ ÀÏ¾î³²
		if(s1==null) s1=new Singleton02();
		return s1;
	}
}
//½º·¹µå Ã³¸® Æ÷ÇÔ+¼º´É°³¼±(ÀÌ³ÊÅ¬·¡½º ÀÌ¿ë)
class Singleton03{
	private static Singleton03 s1;
	private Singleton03(){}
	private static class InnerInstance{
		final static Singleton03 s1=new Singleton03();
	}
	public static Singleton03 getInstance(){
		return InnerInstance.s1;
	}
}
>>>>>>> refs/remotes/origin/master
