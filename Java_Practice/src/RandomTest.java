public class RandomTest {

	public static void main(String[] args) {
		RandomTest test=new RandomTest();
		test.randProc();

	}
	public void randProc(){
		/*
		 50~100:최대-최소+1
		 int a=(int)(Math.random()*51+50) 
		 
		 100~150
		 int a=(int)(Math.random()*51+100) 
		 */
		
		
		//주사위 던지기-랜덤발생 1~6
		int rand=(int)(Math.random()*6+1); 
		
		switch (rand) {
		case 1:
			System.out.println(rand+" 나왔습니다."+"\n사탕 1개를 받습니다.");
			break;
		case 2:
			System.out.println(rand+" 나왔습니다."+"\n사탕 2개를 받습니다.");
			break;
		case 3:
			System.out.println(rand+" 나왔습니다."+"\n사탕 3개를 받습니다.");
			break;
		case 4:
			System.out.println(rand+" 나왔습니다."+"\n사탕 4개를 받습니다.");
			break;
		case 5:
			System.out.println(rand+" 나왔습니다."+"\n사탕 5개를 받습니다.");
			break;
		case 6:
			System.out.println(rand+" 나왔습니다."+"\n사탕 6개를 받습니다.");
			break;
		}
	}

}