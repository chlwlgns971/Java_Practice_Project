package Thread;

public class ThreadSynchronized2 {
	private int balance; //잔액이 저장될 변수
	
	public int getBalance(){
		return balance;
	}
	public void setBalance(int balance) {
		this.balance=balance;
	}
	
	//입금을 처리하는 메서드
	public void deposit(int money) {
		balance+=money;
	}
	
	//출금을 처리하는 메서드(반환값: 출금성공(true), 실패(false)
	public synchronized boolean withdraw(int money) { //synchronized를 사용해서 동기화 실행. (동기화를 안하면 쓰레드2가 접근하는 시접에서 1의 처리가 끝나지 않았기 때문에 -잔고가 나온다.)
		if(balance>=money) { //출금가능
			
			for(int i=1; i<=100000000; i++) {} //시간 지연용
			
			balance-=money;
			System.out.println("메서드 안에서 balance= "+getBalance());
			return true;
		}
		else {//출금불가
			return false;
		}
	}

	public static void main(String[] args) {
		ThreadSynchronized2 account=new ThreadSynchronized2();
		account.setBalance(10000); //잔액을 10000원으로 설정
		
		//익명 구현체로 쓰레드 구현->main에서 선언한 변수를 사용할 수 있다는 장점이 있다.
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				boolean result=account.withdraw(6000); //6000원 출금
				System.out.println("쓰레드에서 result = "+result+", balance= "+account.getBalance());
			}
		};
		Thread th1=new Thread(r);
		Thread th2=new Thread(r);
		
		th1.start();
		th2.start();
	}

}
class acount{
	
}
