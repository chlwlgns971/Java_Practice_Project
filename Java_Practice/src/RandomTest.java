public class RandomTest {

	public static void main(String[] args) {
		RandomTest test=new RandomTest();
		test.randProc();

	}
	public void randProc(){
		/*
		 50~100:�ִ�-�ּ�+1
		 int a=(int)(Math.random()*51+50) 
		 
		 100~150
		 int a=(int)(Math.random()*51+100) 
		 */
		
		
		//�ֻ��� ������-�����߻� 1~6
		int rand=(int)(Math.random()*6+1); 
		
		switch (rand) {
		case 1:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 1���� �޽��ϴ�.");
			break;
		case 2:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 2���� �޽��ϴ�.");
			break;
		case 3:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 3���� �޽��ϴ�.");
			break;
		case 4:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 4���� �޽��ϴ�.");
			break;
		case 5:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 5���� �޽��ϴ�.");
			break;
		case 6:
			System.out.println(rand+" ���Խ��ϴ�."+"\n���� 6���� �޽��ϴ�.");
			break;
		}
	}

}