package Chapter07;

public class InherrClass {
<<<<<<< HEAD
	private int price; //privateë¥¼ í•´ë„ getPrice ë©”ì„œë“œë¥¼ í†µí•´ í˜¸ì¶œê°€ëŠ¥
	public InherrClass(int price){
		this.price=price;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	
}
class Product{
	String prodName;
	int price;
	String prodCom;
	
	public Product(){}
	public Product(String prodName, int price, String prodCom){
		this.prodName=prodName;
		this.price=price;
		this.prodCom=prodCom;
	}
	public int sale(int count){//íŒë§¤ê´€ë¦¬ ,count=êµ¬ë§¤ìˆ˜ëŸ‰
		return count*price;
	}
	public int refund(int count){//ë°˜í’ˆì²˜ë¦¬
=======
	private int price; //private¸¦ ÇØµµ getPrice ¸Þ¼­µå¸¦ ÅëÇØ È£Ãâ°¡´É
	public InherrClass(int price){
		this.price=price;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	
}
class Product{
	String prodName;
	int price;
	String prodCom;
	
	public Product(){}
	public Product(String prodName, int price, String prodCom){
		this.prodName=prodName;
		this.price=price;
		this.prodCom=prodCom;
	}
	public int sale(int count){//ÆÇ¸Å°ü¸® ,count=±¸¸Å¼ö·®
		return count*price;
	}
	public int refund(int count){//¹ÝÇ°Ã³¸®
>>>>>>> refs/remotes/origin/master
		return -count*price;
	}
}