package Thread;
/*
 데몬 쓰레드
 	-일반 쓰레드의 작업을 돕는 보조적인 역할을 수행.
 	-일반 쓰레드가 모두 종료되면 자동적으로 종료한다.
 	-가비지 컬렉터, 자동저장, 화면 자동개신 등에 사용된다.
 	-무한루프와 조건문을 이용해서 실행 후 대기하다가 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.
 	*setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실행되어야 한다. 그렇지 않으면 예외발생
 */

public class DaemonThread {

	public static void main(String[] args) {
		// 데몬쓰레드 연습->자동저장
		AutoSaveThread autoSave=new AutoSaveThread();
		
		//데몬쓰레드로 설정하기->반드시 start()메서드를 호출하기 전에 설정한다.
		autoSave.setDaemon(true);
		autoSave.start();
		
		try {
			for(int i=1; i<=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
class AutoSaveThread extends Thread{
	//자동저장하는 메서드
	private void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			save();
		}
	}
}