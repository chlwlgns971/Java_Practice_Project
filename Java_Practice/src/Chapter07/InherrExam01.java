package Chapter07;

/*���
 * 	-�θ�Ŭ����(����Ŭ����)�� ����� �ڽ�Ŭ����(����Ŭ����)�� �������� �ʰ� ���
 * 	-Ŭ������ ����(����,ȿ����)
 * 	-�θ�Ŭ������ ����� �������� ���(Ȯ�强�� ����)
 *(�������)
 *���������� class �ڽ�Ŭ������ extends �θ�Ŭ������{}
 *	-�θ��� ������, �θ�Ŭ�������� private�� ����� ���, �θ�� �ڽ��� ���� �ٸ� ��Ű���� �����Ѵٸ�
 *		�θ�Ŭ�������� default�� ����� ����� ��ӺҰ�
 */

public class InherrExam01 {

	public static void main(String[] args) {
		Mac m1=new Mac();
		m1.setPrice(100000);
		System.out.println("�ƺ��� ����: "+m1.getPrice()); //�ڽ�Ŭ����

	}

}
class Mac extends InherrClass{
	boolean touchPad;
	public Mac(){
		super(320000); //Computer Ŭ�������� �����ε��� �����ڰ� ������ super�޼��带 ����� �� ����.->super()�� �θ�Ŭ������ �⺻�����ڸ� ȣ���ϴ� ����
	}
	
	boolean hasTouchPad(){
		return touchPad;
	}
}
class Tv extends Product{
	private int displaySize;
	private boolean installType;
	
	public Tv(){
		super("Lg OLED TV",2000000,"Lg"); //Product class�� Product(String, int, String)�޼ҵ� ȣ��
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
