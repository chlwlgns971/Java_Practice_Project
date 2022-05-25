public class RandomPickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rand=(int)(Math.random()*10+1);
		switch (rand) {
		case 10:
			System.out.println("SSR을 뽑으셨습니다."); //10%확률
			break;
		case 9:
		case 8:
			System.out.println("SR을 뽑으셨습니다."); //20%확률
			break;
		case 7:
		case 6:
		case 5:
			System.out.println("R을 뽑으셨습니다."); //30%확률
			break;
		default:
			System.out.println("N을 뽑으셨습니다."); //50%확률
			break;
		}
	}

}