public class RandomPickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rand=(int)(Math.random()*10+1);
		switch (rand) {
		case 10:
			System.out.println("SSR�� �����̽��ϴ�."); //10%Ȯ��
			break;
		case 9:
		case 8:
			System.out.println("SR�� �����̽��ϴ�."); //20%Ȯ��
			break;
		case 7:
		case 6:
		case 5:
			System.out.println("R�� �����̽��ϴ�."); //30%Ȯ��
			break;
		default:
			System.out.println("N�� �����̽��ϴ�."); //50%Ȯ��
			break;
		}
	}

}