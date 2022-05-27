package Chapter07;

public abstract class KakaoBank implements Bank_Interface {
	public void kakaoWithdraw(int amount) {
		System.out.println("Kakao 은행의 출금로직");
	}
	public void KakaoDeposit(int amount) {
		System.out.println("Kakao 은행의 입금로직");
	}
}
