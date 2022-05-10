import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디를 입력해주세요: ");
		String id=sc.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		String pw=sc.nextLine();
		int intPW=Integer.parseInt(pw); //정수로 비교하기 위한 paseInt사용
		
		if (id.equals("cjh97")){
			if (intPW==1234) System.out.println("로그인에 성공하였습니다.");
			else System.out.println("비밀번호가 잘못되었습니다.");
		}
		else System.out.println("아이디가 잘못입력되었습니다.");
	}
}