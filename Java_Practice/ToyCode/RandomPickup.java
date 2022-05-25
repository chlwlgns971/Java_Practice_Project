public class RandomPickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rand=(int)(Math.random()*10+1);
		switch (rand) {
		case 10:
			System.out.println("SSRÀ» »ÌÀ¸¼Ì½À´Ï´Ù."); //10%È®·ü
			break;
		case 9:
		case 8:
			System.out.println("SRÀ» »ÌÀ¸¼Ì½À´Ï´Ù."); //20%È®·ü
			break;
		case 7:
		case 6:
		case 5:
			System.out.println("RÀ» »ÌÀ¸¼Ì½À´Ï´Ù."); //30%È®·ü
			break;
		default:
			System.out.println("NÀ» »ÌÀ¸¼Ì½À´Ï´Ù."); //50%È®·ü
			break;
		}
	}

}