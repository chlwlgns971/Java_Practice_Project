import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������ �Է����ּ���: ");
		int score=sc.nextInt();
		String res="";
		
		switch (score/10) {
		case 10:
		case 9:
			res="��";
			break;
		case 8:
			res="��";
			break;
		case 7:
			res="��";
			break;
		case 6:
			res="��";
			break;

		default:
			res="��";
			break;
		}
		String str="�Է¹��� ����: "+score+"\n����: "+res;
		System.out.println(str);

	}

}
