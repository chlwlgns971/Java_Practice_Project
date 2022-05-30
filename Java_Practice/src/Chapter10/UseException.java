package Chapter10;
import java.util.Random;

public class UseException {
	public static void useExcept() throws RandException{
		Random r=new Random();
		int rndNum=r.nextInt();
		if(rndNum==0) {
			throw new RandException("생성된 난수가 0이어서 예외발생");
		}
	}
}
class RandException extends Exception{
	   public RandException(String msg) {
	      super(msg);
	   }
}
