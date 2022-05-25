import java.util.Arrays;
import java.util.Scanner;

<<<<<<< HEAD
/*ë¬¸ì œ1 main ë©”ì„œë“œê°€ ì—†ëŠ” Mymathí´ëž˜ìŠ¤ë¥¼ êµ¬í˜„í•˜ì‹œì˜¤ 
min=ì •ìˆ˜ë˜ëŠ” ì‹¤ìˆ˜ë¥¼ 10ê°œ ìž…ë ¥ë°›ì•„ ìµœì†Œê°’ì„ êµ¬í•œë‹¤.
max=ì •ìˆ˜ë˜ëŠ” ì‹¤ìˆ˜ë¥¼ 10ê°œ ìž…ë ¥ë°›ì•„ ìµœëŒ€ê°’ì„ êµ¬í•œë‹¤.
abs=ì •ìˆ˜ë˜ëŠ” ì‹¤ìˆ˜ë¥¼ 10ê°œ ìž…ë ¥ë°›ì•„ ì ˆëŒ“ê°’ì„ êµ¬í•œë‹¤.-ë°°ì—´ë¡œ ì €ìž¥*/


public class Test0524 {

	public static void main(String[] args) {
		Mymath math=new Mymath();
		Subject sub1=new Subject();
		sub1.setName("ì˜ì–´");
		sub1.setJumsu(78);
		Subject sub2=new Subject("êµ­ì–´");
		Subject sub3=new Subject("ìˆ˜í•™",83);
		
		sub1.print();
		sub2.print();
		sub3.print();
		
		
//		System.out.println("ìž…ë ¥ê°’ì˜ ìµœì†Ÿê°’: "+math.getMin());
//		System.out.println("ìž…ë ¥ê°’ì˜ ìµœëŒ“ê°’: "+math.getMax());
//		System.out.println("ìž…ë ¥ê°’ì˜ ì ˆëŒ’ê°’: "+Arrays.toString(math.getAbs()));
		
		
	}

}
class Mymath{
	double PI=3.1415927;
	double E=2.718281;
	Scanner sc=new Scanner(System.in);
	
	public double getMin(){
		double min=0;
		double[] minArr=new double[10];
		for(int i=0; i<10; i++){
			System.out.println("ìˆ«ìž í˜¹ì€ ì •ìˆ˜ë¥¼ ìž…ë ¥í•˜ì„¸ìš”: ");
			minArr[i]=sc.nextDouble();
		}
		min=minArr[0];
		for(int i=0; i<10; i++){
			if(min>minArr[i]) min=minArr[i];
		}
		return min;
	}
	public double getMax(){
		double max=0;
		double[] maxArr=new double[10];
		for(int i=0; i<10; i++){
			System.out.println("ìˆ«ìž í˜¹ì€ ì •ìˆ˜ë¥¼ ìž…ë ¥í•˜ì„¸ìš”: ");
			maxArr[i]=sc.nextDouble();
		}
		max=maxArr[0];
		for(int i=0; i<10; i++){
			if(max<maxArr[i]) max=maxArr[i];
		}
		return max;
	}
	public double[] getAbs(){
		double[] absArr=new double[10]; //ë°˜í™˜ìš© ì ˆëŒ“ê°’ ë°°ì—´
		for(int i=0; i<10; i++){
			System.out.println("ìˆ«ìž í˜¹ì€ ì •ìˆ˜ë¥¼ ìž…ë ¥í•˜ì„¸ìš”: ");
			absArr[i]=Math.abs(sc.nextDouble());
		}
		return absArr;
	}
	
}
class Subject{
	String subject;
	int score;
	
	Subject(){}
	Subject(String subject){
		this.subject=subject;
	}
	Subject(String subject, int score){
		this.subject=subject;
		if(detectScore(score)) this.score=score;
	}
	public void setName(String subject){
		this.subject=subject;
	}
	public void setJumsu(int score){
		if(score>100 || score<0) this.score=-1;
		else this.score=score;
	}
	public boolean detectScore(int score){
		if(score>100 || score<0) return false;
		else return true;
	}
	public String getDegree(){
		String str="";
		switch (this.score/10) {
		case 10:
		case 9:
			str="A";
			break;
		case 8:
			str="B";
			break;
		case 7:
			str="C";
			break;
		case 6:
			str="D";
			break;
		default:
			str="F";
			break;
		}
		return str;
	}
	public void print() {
		System.out.println("ê³¼ëª©: "+this.subject);
		System.out.println("ì ìˆ˜: "+this.score);
		System.out.println("ì„±ì : "+getDegree());
	}
}
=======
/*¹®Á¦1 main ¸Þ¼­µå°¡ ¾ø´Â MymathÅ¬·¡½º¸¦ ±¸ÇöÇÏ½Ã¿À 
min=Á¤¼ö¶Ç´Â ½Ç¼ö¸¦ 10°³ ÀÔ·Â¹Þ¾Æ ÃÖ¼Ò°ªÀ» ±¸ÇÑ´Ù.
max=Á¤¼ö¶Ç´Â ½Ç¼ö¸¦ 10°³ ÀÔ·Â¹Þ¾Æ ÃÖ´ë°ªÀ» ±¸ÇÑ´Ù.
abs=Á¤¼ö¶Ç´Â ½Ç¼ö¸¦ 10°³ ÀÔ·Â¹Þ¾Æ Àý´ñ°ªÀ» ±¸ÇÑ´Ù.-¹è¿­·Î ÀúÀå*/


public class Test0524 {

	public static void main(String[] args) {
		Mymath math=new Mymath();
		Subject sub1=new Subject();
		Subject sub2=new Subject("±¹¾î",100);
		
//		System.out.println("ÀÔ·Â°ªÀÇ ÃÖ¼Ú°ª: "+math.getMin());
//		System.out.println("ÀÔ·Â°ªÀÇ ÃÖ´ñ°ª: "+math.getMax());
//		System.out.println("ÀÔ·Â°ªÀÇ Àýˆ¹°ª: "+Arrays.toString(math.getAbs()));
		
		System.out.println("sub1ÀÇ Á¡¼öµî±Þ: "+sub1.getDegree());
		System.out.println("sub2ÀÇ Á¡¼öµî±Þ: "+sub2.getDegree());
		sub1.setJumsu(-10);
		System.out.println("sub1ÀÇ Á¡¼öµî±Þ: "+sub1.getDegree());
		sub1.setJumsu(70);
		System.out.println("sub1ÀÇ Á¡¼öµî±Þ: "+sub1.getDegree());
	}

}
class Mymath{
	double PI=3.1415927;
	double E=2.718281;
	Scanner sc=new Scanner(System.in);
	
	public double getMin(){
		double min=0;
		double[] minArr=new double[10];
		for(int i=0; i<10; i++){
			System.out.println("¼ýÀÚ È¤Àº Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			minArr[i]=sc.nextDouble();
		}
		min=minArr[0];
		for(int i=0; i<10; i++){
			if(min>minArr[i]) min=minArr[i];
		}
		return min;
	}
	public double getMax(){
		double max=0;
		double[] maxArr=new double[10];
		for(int i=0; i<10; i++){
			System.out.println("¼ýÀÚ È¤Àº Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			maxArr[i]=sc.nextDouble();
		}
		max=maxArr[0];
		for(int i=0; i<10; i++){
			if(max<maxArr[i]) max=maxArr[i];
		}
		return max;
	}
	public double[] getAbs(){
		double[] absArr=new double[10]; //¹ÝÈ¯¿ë Àý´ñ°ª ¹è¿­
		for(int i=0; i<10; i++){
			System.out.println("¼ýÀÚ È¤Àº Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			absArr[i]=Math.abs(sc.nextDouble());
		}
		return absArr;
	}
	
}
class Subject{
	String subject;
	int score;
	
	Subject(){
		this.subject="default";
		this.score=0;
	}
	Subject(String subject){
		this.subject=subject;
		this.score=0;
	}
	Subject(String subject, int score){
		this.subject=subject;
		this.score=score;
	}
	public void setName(String subject){
		this.subject=subject;
	}
	public void setJumsu(int score){
		if(score>100 || score<0) this.score=-1;
		else this.score=score;
	}
	boolean detectScore(){
		if(this.score>100 || this.score<0) return false;
		else return true;
	}
	public String getDegree(){
		String str="";
		switch (this.score/10) {
		case 10:
		case 9:
			str="A";
			break;
		case 8:
			str="B";
			break;
		case 7:
			str="C";
			break;
		case 6:
			str="D";
			break;
		default:
			str="F";
			break;
		}
		return str;
	}
}
>>>>>>> refs/remotes/origin/master
