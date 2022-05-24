package Chapter07;

public class InherrClass {
	private int price; //private를 해도 getPrice 메서드를 통해 호출가능
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
	public int sale(int count){//판매관리 ,count=구매수량
		return count*price;
	}
	public int refund(int count){//반품처리
		return -count*price;
	}
}