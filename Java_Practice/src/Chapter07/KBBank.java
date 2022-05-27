package Chapter07;

public class KBBank implements Bank_Interface {
	private int balance; //잔고
	
	public KBBank() {
		balance=1000000;
	}
	public KBBank(int balance) {
		this.balance=balance;
	}
	public void setBalance(int balance) {
		this.balance=balance;
	}
	public int getBalance() {
		return balance;
	}
	
	@Override
	public int withDraw(int amount) {
		System.out.println("KB은행만의 인출로직");
		if(amount<Bank_Interface.MAX_MONEY) {
			if(amount>balance) {
				System.out.println("인출불가능: 잔고부족");
				return 0;
			}
			else return amount;
		}
		else{
			System.out.println("하루 출금 허용 금액을 초과");
			return 0;
		}
	}

	@Override
	public void deposit(int amount) {
		balance+=amount;
	}

}
