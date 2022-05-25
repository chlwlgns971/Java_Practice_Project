package Chapter06;

<<<<<<< HEAD
//ìë™ì°¨ í´ë˜ìŠ¤(ì„¤ê³„ë„)
public class Car {
	//í•„ë“œ=ë©¤ë²„ë³€ìˆ˜=ì†ì„±
	//ì œì¡°ì‚¬
	String company="ê¸°ì•„";
	//ëª¨ë¸
	String model;
	String color;
	//ìµœëŒ€ìŠ¤í”¼ë“œ
	int maxSpeed;
	//í˜„ì¬ ìŠ¤í”¼ë“œ
	int speed;
	
	//ìƒì„±ì: ê°ì²´ê°€ ìƒì„±ë  ë•Œ ìë™ìœ¼ë¡œ ì‹¤í–‰(ì´ˆê¸°ê°’ì„ ì„¸íŒ… ì‹œ ì‚¬ìš©)
	//ê¸°ë³¸ìƒì„±ì
	Car(){}
	//ìƒì„±ì ì˜¤ë²„ë¡œë”©. ë§¤ê°œë³€ìˆ˜ ìˆœì„œ or ê°¯ìˆ˜ or íƒ€ì…ì´ ë‹¬ë¼ì•¼í•¨
	Car(String model){
		//model: ì´ê³³ìœ¼ë¡œ ë˜ì ¸ì§€ëŠ” ë¬¸ìí˜• íŒŒë¼ë¯¸í„°ë¥¼ ë‹´ì•„ì£¼ëŠ” ë§¤ê°œë³€ìˆ˜(ì§€ì—­ë³€ìˆ˜: ì´ ë¸”ë¡ì„ ë²—ì–´ë‚˜ë©´ ë©”ëª¨ë¦¬ì—ì„œ ì‚¬ë¼ì§)
		//ë©¤ë²„ë³€ìˆ˜<=ë§¤ê°œë³€ìˆ˜ë¥¼ í• ë‹¹(ëŒ€ì…)
//		this.model=model;
//		this.color = "ì€ìƒ‰";
//		this.maxSpeed = 250;
		// this: ìƒì„±ìì¸ë° ë‹¤ë¥¸ ìƒì„±ìë¥¼ í˜¸ì¶œ->ì²« ì¤„ì—ì„œë§Œ í—ˆìš©=>ë‹¤ë¥¸ ìƒì„±ì í˜¸ì¶œ
		this(model, "ì€ìƒ‰", 250);
	}
	//ìƒì„±ì ì˜¤ë²„ë¡œë”©
	Car(String model, String color){
		//ë§¤ê°œë³€ìˆ˜ì˜ ê°’ì„ ë©¤ë²„ë³€ìˆ˜ì— í• ë‹¹(ëŒ€ì…)
//		this.model=model;
//		this.color=color;
//		this.maxSpeed = 250;
		this(model, color, 250);
	}
	//ìƒì„±ì ì˜¤ë²„ë¡œë”©
	Car(String model, String color, int maxSpeed){
		//ë§¤ê°œë³€ìˆ˜ì˜ ê°’ì„ ë©¤ë²„ë³€ìˆ˜ì— í• ë‹¹(ëŒ€ì…)
=======
//ÀÚµ¿Â÷ Å¬·¡½º(¼³°èµµ)
public class Car {
	//ÇÊµå=¸â¹öº¯¼ö=¼Ó¼º
	//Á¦Á¶»ç
	String company="±â¾Æ";
	//¸ğµ¨
	String model;
	String color;
	//ÃÖ´ë½ºÇÇµå
	int maxSpeed;
	//ÇöÀç ½ºÇÇµå
	int speed;
	
	//»ı¼ºÀÚ: °´Ã¼°¡ »ı¼ºµÉ ¶§ ÀÚµ¿À¸·Î ½ÇÇà(ÃÊ±â°ªÀ» ¼¼ÆÃ ½Ã »ç¿ë)
	//±âº»»ı¼ºÀÚ
	Car(){}
	//»ı¼ºÀÚ ¿À¹ö·Îµù. ¸Å°³º¯¼ö ¼ø¼­ or °¹¼ö or Å¸ÀÔÀÌ ´Ş¶ó¾ßÇÔ
	Car(String model){
		//model: ÀÌ°÷À¸·Î ´øÁ®Áö´Â ¹®ÀÚÇü ÆÄ¶ó¹ÌÅÍ¸¦ ´ã¾ÆÁÖ´Â ¸Å°³º¯¼ö(Áö¿ªº¯¼ö: ÀÌ ºí·ÏÀ» ¹ş¾î³ª¸é ¸Ş¸ğ¸®¿¡¼­ »ç¶óÁü)
		//¸â¹öº¯¼ö<=¸Å°³º¯¼ö¸¦ ÇÒ´ç(´ëÀÔ)
//		this.model=model;
//		this.color = "Àº»ö";
//		this.maxSpeed = 250;
		// this: »ı¼ºÀÚÀÎµ¥ ´Ù¸¥ »ı¼ºÀÚ¸¦ È£Ãâ->Ã¹ ÁÙ¿¡¼­¸¸ Çã¿ë=>´Ù¸¥ »ı¼ºÀÚ È£Ãâ
		this(model, "Àº»ö", 250);
	}
	//»ı¼ºÀÚ ¿À¹ö·Îµù
	Car(String model, String color){
		//¸Å°³º¯¼öÀÇ °ªÀ» ¸â¹öº¯¼ö¿¡ ÇÒ´ç(´ëÀÔ)
//		this.model=model;
//		this.color=color;
//		this.maxSpeed = 250;
		this(model, color, 250);
	}
	//»ı¼ºÀÚ ¿À¹ö·Îµù
	Car(String model, String color, int maxSpeed){
		//¸Å°³º¯¼öÀÇ °ªÀ» ¸â¹öº¯¼ö¿¡ ÇÒ´ç(´ëÀÔ)
>>>>>>> refs/remotes/origin/master
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	public Car(String company, String model, String color, int maxSpeed, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color="
				+ color + ", maxSpeed=" + maxSpeed + ", speed=" + speed + "]";
	}
	
}