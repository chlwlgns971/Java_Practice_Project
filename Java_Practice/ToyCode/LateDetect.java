import java.util.Scanner;

//���� ���� Ȯ�� ���α׷�
public class LateDetect {

	public static void main(String[] args) {
		LateTest lt=new LateTest();
		Scanner scanner=new Scanner(System.in);
		String insertTime; //Ű���� �Է°�
		while(true){
			System.out.println("��ð��� �Է����ּ��� (00:00,24h����):");
			System.out.println("�����Ϸ��� 'q'�� �Է��ϼ���");
			insertTime=scanner.next();
			try{ //ù ��° if������ �ڸ��� �������� ���� ���ܹ߻�
				if (!insertTime.substring(2,3).equals(":")) System.out.println("���Ŀ� �°� �ٽ� �Է����ּ���.");
				else lt.detect(insertTime);
			}
			catch(Exception e){
				if (insertTime.equals("q")){
					System.out.println("���α׷��� ����Ǿ����ϴ�.");
					break;
				}
				else System.out.println("���Ŀ� �°� �ٽ� �Է����ּ���.");
			}
		}
		
	}

}
class LateTest{
	String time="09:00";
	void detect(String a){
		try{// ���� �̿��� ���ڰ� ������ ��� ���ܹ߻�
			String Fa=a.substring(0,2); //String.substirng(@,@) = String�� �Ϻκ��� �߶󳻴� �޼ҵ�
			int IFt=Integer.parseInt(time.substring(1,2)); //Integer.parseInt(string) = string�� int������ ��ȯ�ϴ� �޼ҵ�
			int IFa=0;
			
			if (Fa.charAt(0)=='0') IFa=Integer.parseInt(Fa.substring(1,2));
			else IFa=Integer.parseInt(Fa);
			
			if(IFa>24) System.out.println("�߸��� �� �Է��Դϴ�.");
			else{
				if(IFt>IFa) System.out.println("�����Դϴ�.");
				else System.out.println("�����Դϴ�.");
			}
		}

		catch (Exception e) {
			System.out.println("�߸��� �� �Է��Դϴ�.");
		}
		
	}
}