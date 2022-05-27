package Chapter07;

public interface Bank_Interface{
	int MAX_MONEY=100000;
	int withDraw(int amount); //출금메서드
	void deposit(int amount); //입금메서드
	
	default String findDormancyAccount(String usrId) {
		System.out.println("휴먼계좌를 찾아 계좌번호 반환");
		return "고객님의 휴먼계좌번호는입니다.";
	}
	
}