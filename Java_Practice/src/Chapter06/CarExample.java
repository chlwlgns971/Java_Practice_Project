<<<<<<< HEAD

package Chapter06;
/*ctrl+alt+ë°©í–¥í‚¤ì•„ëž˜->ì•„ëž«ì¤„ì— í˜„ìž¬ ì¤„ ì½”ë“œ ë³µì‚¬í›„ ë¶™ì—¬ë„£ê¸°
 *shift+home->í˜„ìž¬ì¤„ ì „ì²´ì„ íƒ
 *ctrl+F6= íŒ¨í‚¤ì§€ë‚´ ë‹¤ë¥¸ ìžë°”íŒŒì¼ë¡œ ì´ë™
 *ctrl+F3= ë©”ì†Œë“œ ìœ„ì—ì„œ ì‹¤í–‰í•˜ë©´ í•´ë‹¹ ë©”ì†Œë“œ ìœ„ì¹˜ë¡œ ì´ë™ê°€ëŠ¥
 */

public class CarExample {
	public static void main(String[] args) {
		System.out.println("ì‹¤í–‰");
		// myCar: ê°ì²´, í´ëž˜ìŠ¤ë³€ìˆ˜, ì¸ìŠ¤í„´ìŠ¤
		Car myCar=new Car("í˜„ëŒ€ìžë™ì°¨","ê·¸ëžœì €","ê²€ì •",350,0);
		System.out.println("ì œìž‘íšŒì‚¬: "+myCar.company);
		System.out.println("ëª¨ë¸ëª…: "+myCar.model);
		System.out.println("ìƒ‰ê¹”: "+myCar.color);
		System.out.println("ìµœê³ ì†ë„: "+myCar.maxSpeed);
		System.out.println("í˜„ìž¬ì†ë„: "+myCar.speed);
		//í•„ë“œê°’ ë³€ê²½
		myCar.speed=60;
		System.out.println(myCar.toString());
		
		//ì˜¤ë²„ë¡œë”©í…ŒìŠ¤íŠ¸
		System.out.println("ì˜¤ë²„ë¡œë”© í…ŒìŠ¤íŠ¸ ì‹œìž‘");
		Car car1=new Car();
		System.out.println("car1.company: "+car1.company);
		System.out.println("car1.model: "+car1.model);
		System.out.println("car1.color: "+car1.color);
		System.out.println("car1.maxSpeed: "+car1.maxSpeed);
		Car car2=new Car("ìžê°€ìš©");
		System.out.println("car2.company: "+car2.company);
		System.out.println("car2.model: "+car2.model);
		System.out.println("car2.color: "+car2.color);
		System.out.println("car2.maxSpeed: "+car2.maxSpeed);
		Car car3=new Car("ìžê°€ìš©","í™”ì´íŠ¸");
		System.out.println("car3.company: "+car3.company);
		System.out.println("car3.model: "+car3.model);
		System.out.println("car3.color: "+car3.color);
		System.out.println("car3.maxSpeed: "+car3.maxSpeed);
		Car car4=new Car("íƒì‹œ","ê²€ì •",250);
		System.out.println("car4.company: "+car4.company);
		System.out.println("car4.model: "+car4.model);
		System.out.println("car4.color: "+car4.color);
		System.out.println("car4.maxSpeed: "+car4.maxSpeed);
	}
}
=======
package Chapter06;

/*ctrl+alt+¹æÇâÅ°¾Æ·¡->¾Æ·§ÁÙ¿¡ ÇöÀç ÁÙ ÄÚµå º¹»çÈÄ ºÙ¿©³Ö±â
 *shift+home->ÇöÀçÁÙ ÀüÃ¼¼±ÅÃ
 *ctrl+F6= ÆÐÅ°Áö³» ´Ù¸¥ ÀÚ¹ÙÆÄÀÏ·Î ÀÌµ¿
 *ctrl+F3= ¸Þ¼Òµå À§¿¡¼­ ½ÇÇàÇÏ¸é ÇØ´ç ¸Þ¼Òµå À§Ä¡·Î ÀÌµ¿°¡´É
 */

public class CarExample {
	public static void main(String[] args) {
		System.out.println("½ÇÇà");
		// myCar: °´Ã¼, Å¬·¡½ºº¯¼ö, ÀÎ½ºÅÏ½º
		Car myCar=new Car("Çö´ëÀÚµ¿Â÷","±×·£Àú","°ËÁ¤",350,0);
		System.out.println("Á¦ÀÛÈ¸»ç: "+myCar.company);
		System.out.println("¸ðµ¨¸í: "+myCar.model);
		System.out.println("»ö±ò: "+myCar.color);
		System.out.println("ÃÖ°í¼Óµµ: "+myCar.maxSpeed);
		System.out.println("ÇöÀç¼Óµµ: "+myCar.speed);
		//ÇÊµå°ª º¯°æ
		myCar.speed=60;
		System.out.println(myCar.toString());
		
		//¿À¹ö·ÎµùÅ×½ºÆ®
		System.out.println("¿À¹ö·Îµù Å×½ºÆ® ½ÃÀÛ");
		Car car1=new Car();
		System.out.println("car1.company: "+car1.company);
		System.out.println("car1.model: "+car1.model);
		System.out.println("car1.color: "+car1.color);
		System.out.println("car1.maxSpeed: "+car1.maxSpeed);
		Car car2=new Car("ÀÚ°¡¿ë");
		System.out.println("car2.company: "+car2.company);
		System.out.println("car2.model: "+car2.model);
		System.out.println("car2.color: "+car2.color);
		System.out.println("car2.maxSpeed: "+car2.maxSpeed);
		Car car3=new Car("ÀÚ°¡¿ë","È­ÀÌÆ®");
		System.out.println("car3.company: "+car3.company);
		System.out.println("car3.model: "+car3.model);
		System.out.println("car3.color: "+car3.color);
		System.out.println("car3.maxSpeed: "+car3.maxSpeed);
		Car car4=new Car("ÅÃ½Ã","°ËÁ¤",250);
		System.out.println("car4.company: "+car4.company);
		System.out.println("car4.model: "+car4.model);
		System.out.println("car4.color: "+car4.color);
		System.out.println("car4.maxSpeed: "+car4.maxSpeed);
	}
}
>>>>>>> refs/remotes/origin/master
