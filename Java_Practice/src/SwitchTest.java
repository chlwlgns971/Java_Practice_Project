import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("성적을 입력해주세요: ");
		int score=sc.nextInt();
		String res="";
		
		switch (score/10) {
		case 10:
		case 9:
			res="수";
			break;
		case 8:
			res="우";
			break;
		case 7:
			res="미";
			break;
		case 6:
			res="양";
			break;

		default:
			res="가";
			break;
		}
		String str="입력받은 점수: "+score+"\n성적: "+res;
		System.out.println(str);

	}

}