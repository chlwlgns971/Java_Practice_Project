import java.util.Scanner;

//지각 여부 확인 프로그램
public class LateDetect {

	public static void main(String[] args) {
		LateTest lt=new LateTest();
		Scanner scanner=new Scanner(System.in);
		String insertTime; //키보드 입력값
		while(true){
			System.out.println("등교시간을 입력해주세요 (00:00,24h형식):");
			System.out.println("종료하려면 'q'를 입력하세요");
			insertTime=scanner.next();
			try{ //첫 번째 if문에서 자릿수 부족으로 인한 예외발생
				if (!insertTime.substring(2,3).equals(":")) System.out.println("형식에 맞게 다시 입력해주세요.");
				else lt.detect(insertTime);
			}
			catch(Exception e){
				if (insertTime.equals("q")){
					System.out.println("프로그램이 종료되었습니다.");
					break;
				}
				else System.out.println("형식에 맞게 다시 입력해주세요.");
			}
		}
		
	}

}
class LateTest{
	String time="09:00";
	void detect(String a){
		try{// 숫자 이외의 문자가 들어오는 경우 예외발생
			String Fa=a.substring(0,2); //String.substirng(@,@) = String의 일부분을 잘라내는 메소드
			int IFt=Integer.parseInt(time.substring(1,2)); //Integer.parseInt(string) = string을 int형으로 변환하는 메소드
			int IFa=0;
			
			if (Fa.charAt(0)=='0') IFa=Integer.parseInt(Fa.substring(1,2));
			else IFa=Integer.parseInt(Fa);
			
			if(IFa>24) System.out.println("잘못된 값 입력입니다.");
			else{
				if(IFt>IFa) System.out.println("정상등교입니다.");
				else System.out.println("지각입니다.");
			}
		}

		catch (Exception e) {
			System.out.println("잘못된 값 입력입니다.");
		}
		
	}
}