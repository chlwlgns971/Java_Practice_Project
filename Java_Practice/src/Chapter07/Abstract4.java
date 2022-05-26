package Chapter07;

public class Abstract4{
	public static void main(String[] args) {
		System.out.println("---------------------------------");
		Tank tank = new Tank();
		tank.move(100, 300);
		tank.sizeMode();
		tank.stop("탱크", 300, 400);
		
		
		System.out.println("---------------------------------");
		
		Marine marine = new Marine();
		marine.move(200, 500);
		marine.stimPack();
		marine.stop("마린", 300, 400);
		
		System.out.println("————————————————");
		
		DropShip dp = new DropShip();
		dp.move(500, 600);
		dp.load();
		dp.unload();
		dp.stop("드랍쉽", 200, 100);
	   }
}
abstract class Unit{
   //필드
    int x;
    int y;
    String str;
    //추상메서드 선언(구현부 없다.)
    //모든 유닛은 움직여야하기 때문에 move()를 추상메서드로 썼다.
    public abstract void move(int x, int y);
    
    public void stop(String str, int x, int y) {
        this.x = x;
        this.y = y;
        this.str = str;
        System.out.println("현재위치: " + this.x + "," + this.y +"에 " + this.str + "가/이 멈춥니다.");
    }   
}
class DropShip extends Unit{
	public DropShip() {}
	
	@Override
	public void move(int x, int y) {
	System.out.println("드랍쉽의 위치: " + x +"," + y + "로 이동함.");    
	}
	//DropShip의 고유메서드
	public void load(){
	    System.out.println("탑승모드: 유닛 탑승!");
	}
	 
	public void unload(){
	    System.out.println("탑승모드: 유닛 하강!");
	}
}
class Marine extends Unit{
	public Marine() {}
	
	@Override
	public void move(int x, int y) {
		System.out.println("마린의 위치: " + x +"," + y + "로 이동함.");    
	}
	//Marine의 고유메서드
	public void stimPack(){
	    System.out.println("공격모드: 스팀팩 장전!");
	}
}
class Tank extends Unit{
	public Tank() {}
    
	@Override
	public void move(int x, int y) {
		System.out.println("탱크의 위치: " + x +"," + y + "로 이동함.");    
	}
	//Tank의 고유메서드
	public void sizeMode(){
	    System.out.println("공격모드: 시즈모드 변환");
	}
}
