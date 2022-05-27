package Chapter07;

public class SHBank implements Bank_Interface {

	@Override
	public int withDraw(int amount) {
		System.out.println("SHBank의 출금 로직구현");
		if(amount>Bank_Interface.MAX_MONEY) {
			System.out.println("하루 허용된 출금을 초과");
			return 0;
		}
		else return amount;
	}

	@Override
	public void deposit(int amount) {
		System.out.println("SHBank의 입금 로직구현");
	}

}
