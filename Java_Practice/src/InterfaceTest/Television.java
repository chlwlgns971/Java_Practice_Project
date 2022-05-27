package InterfaceTest;

public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Tv를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Tv를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("소리크기: "+volume);
	}

}
