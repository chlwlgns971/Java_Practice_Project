package Chapter07;

<<<<<<< HEAD


/*ìƒì†
 * 	-ë¶€ëª¨í´ë˜ìŠ¤(ìƒìœ„í´ë˜ìŠ¤)ì˜ ë©¤ë²„ë¥¼ ìì‹í´ë˜ìŠ¤(í•˜ìœ„í´ë˜ìŠ¤)ê°€ ì •ì˜í•˜ì§€ ì•Šê³  ì‚¬ìš©
 * 	-í´ë˜ìŠ¤ì˜ ì¬ì‚¬ìš©(ê°„ê²°,íš¨ìœ¨ì )
 * 	-ë¶€ëª¨í´ë˜ìŠ¤ì˜ ë©¤ë²„ë¥¼ ê³µí†µìœ¼ë¡œ ì‚¬ìš©(í™•ì¥ì„±ì´ ìš©ì´)
 *(ì‚¬ìš©í˜•ì‹)
 *ì ‘ê·¼ì§€ì •ì class ìì‹í´ë˜ìŠ¤ëª… extends ë¶€ëª¨í´ë˜ìŠ¤ëª…{}
 *	-ë¶€ëª¨ì˜ ìƒì„±ì, ë¶€ëª¨í´ë˜ìŠ¤ì—ì„œ privateë¡œ ì„ ì–¸ëœ ë©¤ë²„, ë¶€ëª¨ì™€ ìì‹ì´ ì„œë¡œ ë‹¤ë¥¸ íŒ¨í‚¤ì§€ì— ì¡´ì¬í•œë‹¤ë©´
 *		ë¶€ëª¨í´ë˜ìŠ¤ì—ì„œ defaultë¡œ ì„ ì–¸ëœ ë©¤ë²„ëŠ” ìƒì†ë¶ˆê°€
 */

public class InherrExam01 {

	public static void main(String[] args) {
		Mac m1=new Mac();
		m1.setPrice(100000);
		System.out.println("ë§¥ë¶ì˜ ê°€ê²©: "+m1.getPrice()); //ìì‹í´ë˜ìŠ¤

	}

}
class Mac extends InherrClass{
	boolean touchPad;
	public Mac(){
		super(320000); //Computer í´ë˜ìŠ¤ì—ì„œ ì˜¤ë²„ë¡œë”©í•œ ìƒì„±ìê°€ ì—†ìœ¼ë©´ superë©”ì„œë“œë¥¼ ì‚¬ìš©í•  ìˆ˜ ì—†ë‹¤.->super()ì€ ë¶€ëª¨í´ë˜ìŠ¤ì˜ ê¸°ë³¸ìƒì„±ìë¥¼ í˜¸ì¶œí•˜ëŠ” ì—­í• 
	}
	
	boolean hasTouchPad(){
		return touchPad;
	}
}
class Tv extends Product{
	private int displaySize;
	private boolean installType;
	
	public Tv(){
		super("Lg OLED TV",2000000,"Lg"); //Product classì˜ Product(String, int, String)ë©”ì†Œë“œ í˜¸ì¶œ
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

=======
/*»ó¼Ó
 * 	-ºÎ¸ğÅ¬·¡½º(»óÀ§Å¬·¡½º)ÀÇ ¸â¹ö¸¦ ÀÚ½ÄÅ¬·¡½º(ÇÏÀ§Å¬·¡½º)°¡ Á¤ÀÇÇÏÁö ¾Ê°í »ç¿ë
 * 	-Å¬·¡½ºÀÇ Àç»ç¿ë(°£°á,È¿À²Àû)
 * 	-ºÎ¸ğÅ¬·¡½ºÀÇ ¸â¹ö¸¦ °øÅëÀ¸·Î »ç¿ë(È®Àå¼ºÀÌ ¿ëÀÌ)
 *(»ç¿ëÇü½Ä)
 *Á¢±ÙÁöÁ¤ÀÚ class ÀÚ½ÄÅ¬·¡½º¸í extends ºÎ¸ğÅ¬·¡½º¸í{}
 *	-ºÎ¸ğÀÇ »ı¼ºÀÚ, ºÎ¸ğÅ¬·¡½º¿¡¼­ private·Î ¼±¾ğµÈ ¸â¹ö, ºÎ¸ğ¿Í ÀÚ½ÄÀÌ ¼­·Î ´Ù¸¥ ÆĞÅ°Áö¿¡ Á¸ÀçÇÑ´Ù¸é
 *		ºÎ¸ğÅ¬·¡½º¿¡¼­ default·Î ¼±¾ğµÈ ¸â¹ö´Â »ó¼ÓºÒ°¡
 */

public class InherrExam01 {

	public static void main(String[] args) {
		Mac m1=new Mac();
		m1.setPrice(100000);
		System.out.println("¸ÆºÏÀÇ °¡°İ: "+m1.getPrice()); //ÀÚ½ÄÅ¬·¡½º

	}

}
class Mac extends InherrClass{
	boolean touchPad;
	public Mac(){
		super(320000); //Computer Å¬·¡½º¿¡¼­ ¿À¹ö·ÎµùÇÑ »ı¼ºÀÚ°¡ ¾øÀ¸¸é super¸Ş¼­µå¸¦ »ç¿ëÇÒ ¼ö ¾ø´Ù.->super()Àº ºÎ¸ğÅ¬·¡½ºÀÇ ±âº»»ı¼ºÀÚ¸¦ È£ÃâÇÏ´Â ¿ªÇÒ
	}
	
	boolean hasTouchPad(){
		return touchPad;
	}
}
class Tv extends Product{
	private int displaySize;
	private boolean installType;
	
	public Tv(){
		super("Lg OLED TV",2000000,"Lg"); //Product classÀÇ Product(String, int, String)¸Ş¼Òµå È£Ãâ
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
>>>>>>> refs/remotes/origin/master
