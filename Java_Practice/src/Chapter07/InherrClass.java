package Chapter07;

public class InherrClass {
	private int price; //private�� �ص� getPrice �޼��带 ���� ȣ�Ⱑ��
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
	public int sale(int count){//�ǸŰ��� ,count=���ż���
		return count*price;
	}
	public int refund(int count){//��ǰó��
		return -count*price;
	}
}