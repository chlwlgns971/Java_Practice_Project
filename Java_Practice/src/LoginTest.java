import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���̵� �Է����ּ���: ");
		String id=sc.nextLine();
		System.out.println("��й�ȣ�� �Է����ּ���: ");
		String pw=sc.nextLine();
		int intPW=Integer.parseInt(pw); //������ ���ϱ� ���� paseInt���
		
		if (id.equals("cjh97")){
			if (intPW==1234) System.out.println("�α��ο� �����Ͽ����ϴ�.");
			else System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
		}
		else System.out.println("���̵� �߸��ԷµǾ����ϴ�.");
	}
}