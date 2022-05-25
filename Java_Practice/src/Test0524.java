import java.util.Arrays;
import java.util.Scanner;

<<<<<<< HEAD
/*문제1 main 메서드가 없는 Mymath클래스를 구현하시오 
min=정수또는 실수를 10개 입력받아 최소값을 구한다.
max=정수또는 실수를 10개 입력받아 최대값을 구한다.
abs=정수또는 실수를 10개 입력받아 절댓값을 구한다.-배열로 저장*/


public class Test0524 {

	public static void main(String[] args) {
		Mymath math=new Mymath();
		Subject sub1=new Subject();
		sub1.setName("영어");
		sub1.setJumsu(78);
		Subject sub2=new Subject("국어");
		Subject sub3=new Subject("수학",83);
		
		sub1.print();
		sub2.print();
		sub3.print();
		
		
//		System.out.println("입력값의 최솟값: "+math.getMin());
//		System.out.println("입력값의 최댓값: "+math.getMax());
//		System.out.println("입력값의 절댒값: "+Arrays.toString(math.getAbs()));
		
		
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
			System.out.println("숫자 혹은 정수를 입력하세요: ");
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
			System.out.println("숫자 혹은 정수를 입력하세요: ");
			maxArr[i]=sc.nextDouble();
		}
		max=maxArr[0];
		for(int i=0; i<10; i++){
			if(max<maxArr[i]) max=maxArr[i];
		}
		return max;
	}
	public double[] getAbs(){
		double[] absArr=new double[10]; //반환용 절댓값 배열
		for(int i=0; i<10; i++){
			System.out.println("숫자 혹은 정수를 입력하세요: ");
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
		System.out.println("과목: "+this.subject);
		System.out.println("점수: "+this.score);
		System.out.println("성적: "+getDegree());
	}
}
=======
/*����1 main �޼��尡 ���� MymathŬ������ �����Ͻÿ� 
min=�����Ǵ� �Ǽ��� 10�� �Է¹޾� �ּҰ��� ���Ѵ�.
max=�����Ǵ� �Ǽ��� 10�� �Է¹޾� �ִ밪�� ���Ѵ�.
abs=�����Ǵ� �Ǽ��� 10�� �Է¹޾� ������ ���Ѵ�.-�迭�� ����*/


public class Test0524 {

	public static void main(String[] args) {
		Mymath math=new Mymath();
		Subject sub1=new Subject();
		Subject sub2=new Subject("����",100);
		
//		System.out.println("�Է°��� �ּڰ�: "+math.getMin());
//		System.out.println("�Է°��� �ִ�: "+math.getMax());
//		System.out.println("�Է°��� ������: "+Arrays.toString(math.getAbs()));
		
		System.out.println("sub1�� �������: "+sub1.getDegree());
		System.out.println("sub2�� �������: "+sub2.getDegree());
		sub1.setJumsu(-10);
		System.out.println("sub1�� �������: "+sub1.getDegree());
		sub1.setJumsu(70);
		System.out.println("sub1�� �������: "+sub1.getDegree());
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
			System.out.println("���� Ȥ�� ������ �Է��ϼ���: ");
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
			System.out.println("���� Ȥ�� ������ �Է��ϼ���: ");
			maxArr[i]=sc.nextDouble();
		}
		max=maxArr[0];
		for(int i=0; i<10; i++){
			if(max<maxArr[i]) max=maxArr[i];
		}
		return max;
	}
	public double[] getAbs(){
		double[] absArr=new double[10]; //��ȯ�� ���� �迭
		for(int i=0; i<10; i++){
			System.out.println("���� Ȥ�� ������ �Է��ϼ���: ");
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
