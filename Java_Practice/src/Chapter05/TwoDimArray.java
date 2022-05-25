package Chapter05;

import java.util.Arrays;
<<<<<<< HEAD
/*2차원 배열
 * -행과 열로 구성
 * (선언형식)
 * 타입명[][] 배열명;
 * 타입명[] 배열명[];
 * 타입명 배열명[][];
 * (생성규칙)
 * -new 연산자 사용
 * 타입명[][] 배열명=new 타입명[행의 크기][열의 크기];
 * -데이터를 정의해서 사용
 * 타입명[][] 배열명={{데이터,....},{데이터,....}}; ->각 행마다 열의 갯수가 달라질 수 있다. 이것을 '가변배열'이라고 한다.
 * (가변배열 생성규칙)
 * 타입명[][] 배열명=new 타입명[행의 크기][]; -> 행의 크기만 고정하고 열의 크기는 미정.
 * 배열명[0]=new 타입명[열의 크기]; ->0번째 행의 열의 크기 선언
 * 배열명[1]=new 타입명[열의 크기]; ->1번째 행의 열의 크기 선언
 */

public class TwoDimArray {

	public static void main(String[] args) {
		ArrayTest arrTest=new ArrayTest();
		arrTest.scoreArr();

	}

}
class ArrayTest{
	public void scoreArr(){
		//int[][] score=new int[7][8]; //각 요소를 각각 넣을 때 이렇게 선언. 
		int[][] score={{60,80,60,70,85,0,0,1}, //0,0,1= 총점, 평균, 등수
				{70,90,75,70,80,0,0,1},
				{90,80,50,60,60,0,0,1},
				{95,90,85,90,95,0,0,1},
				{50,65,55,60,70,0,0,1},
				{65,75,85,64,50,0,0,1},
				{75,95,95,95,90,0,0,1}};
		String[] score_nm={"강감찬","이성계","홍길동","정몽주","김유신","이순신","전우치"};
		
		//총점과 평균
		for(int i=0; i<score.length;i++){ //2차원 배열에서 '.length'는 행의 갯수
			for(int j=0; j<score[0].length-3; j++){ //2차원 배열에서 '배열명.length'가 열의 갯수
				score[i][5]+=score[i][j]; //점수 총합
			}
			score[i][6]+=(score[i][5]/5); //평균점수
		}
		//등수구하기
		score=getRank(score);
		
		//출력
		System.out.println("    이  름        국어   영어   수학  과학   사회   총점   평균   등수");
		System.out.println("==========================================");
		for(int i=0; i<score.length; i++){ //방법1
			System.out.println(score_nm[i]+" 점수= "+Arrays.toString(score[i]));
		}
		System.out.println(" 이  름   국어   영어  수학  과학   사회  총점   평균   등수");
		System.out.println("=====================================");
		for(int i=0; i<score.length; i++){ //방법2
			System.out.printf("%5s",score_nm[i]);
			for(int j=0; j<score[i].length; j++){
				System.out.printf("%4d",score[i][j]);
			}
			System.out.println();
		}
		//숙제1
		int[] index=hw1(score);
		System.out.println("등수 순서대로 출력결과");
		for(int i=0; i<index.length; i++){
			System.out.println(score_nm[index[i]]+" 점수= "+Arrays.toString(score[index[i]]));
		}
		
		//숙제2
		hw2();
		
	}
	public int[][] getRank(int[][] a){ //등수 구하는 메소드
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[i][5]<a[j][5]){
					a[i][7]++;
				}
			}
		}
		return a;
	}
	/*숙제1. 위의 결과를 등수 순으로 출력하시오.
	 *숙제2. 다음 자료로 막대 그래프를 작성하시오
	 *	[자료]: {25,55,45,40,50}
	 *	-막대 그래프를 다음과 같이 출력하시오 (hint 위에서 아래로 출력해야함)
	 *-> 공통점: 최고점을 55, 최하점을 25로 뒀을 때 ((값-25)/5)+1= 별의 갯수
	 *55|*
	 *50|*
	 *45|*   *
	 *40|*   *
	 *35|* * *
	 *30|* * *
	 *25|* * *
	*/
	public int[] hw1(int[][] a){
		int[] index=new int[a.length];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[j][7]==i+1) index[i]=j;
			}
		}
		return index;
	}
	public void hw2(){
		int[] arr={25,55,45,40,50};
		int[] starNum=new int[5]; //별의 갯수
		String[][] str={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""}};
		String[] str1={"55|","50|","45|","40|","35|","30|","25|"};
		for(int i=0; i<arr.length; i++){ //별 갯수를 구해 starNum배열에 삽입
			starNum[i]=((arr[i]-25)/5)+1;
		}
		System.out.println(Arrays.toString(starNum)); //역순으로 별 갯수만큼 삽입
		for(int i=0; i<str[i].length; i++){
			for(int j=str.length-1; j>(str.length-1)-starNum[i]; j--){
				str[j][i]="*";
			}
		}
		for(int i=0; i<str.length; i++){ 
			System.out.printf("%5s",str1[i]);
			for(int j=0; j<str[i].length; j++){
				System.out.printf("%4s",str[i][j]);
			}
			System.out.println();
		}
		System.out.println("       25  55  45  40  50");
	}
}


=======

/*2���� �迭
 * -��� ���� ����
 * (��������)
 * Ÿ�Ը�[][] �迭��;
 * Ÿ�Ը�[] �迭��[];
 * Ÿ�Ը� �迭��[][];
 * (������Ģ)
 * -new ������ ���
 * Ÿ�Ը�[][] �迭��=new Ÿ�Ը�[���� ũ��][���� ũ��];
 * -�����͸� �����ؼ� ���
 * Ÿ�Ը�[][] �迭��={{������,....},{������,....}}; ->�� �ึ�� ���� ������ �޶��� �� �ִ�. �̰��� '�����迭'�̶�� �Ѵ�.
 * (�����迭 ������Ģ)
 * Ÿ�Ը�[][] �迭��=new Ÿ�Ը�[���� ũ��][]; -> ���� ũ�⸸ �����ϰ� ���� ũ��� ����.
 * �迭��[0]=new Ÿ�Ը�[���� ũ��]; ->0��° ���� ���� ũ�� ����
 * �迭��[1]=new Ÿ�Ը�[���� ũ��]; ->1��° ���� ���� ũ�� ����
 */

public class TwoDimArray {

	public static void main(String[] args) {
		ArrayTest arrTest=new ArrayTest();
		arrTest.scoreArr();

	}

}
class ArrayTest{
	public void scoreArr(){
		//int[][] score=new int[7][8]; //�� ��Ҹ� ���� ���� �� �̷��� ����. 
		int[][] score={{60,80,60,70,85,0,0,1}, //0,0,1= ����, ���, ���
				{70,90,75,70,80,0,0,1},
				{90,80,50,60,60,0,0,1},
				{95,90,85,90,95,0,0,1},
				{50,65,55,60,70,0,0,1},
				{65,75,85,64,50,0,0,1},
				{75,95,95,95,90,0,0,1}};
		String[] score_nm={"������","�̼���","ȫ�浿","������","������","�̼���","����ġ"};
		
		//������ ���
		for(int i=0; i<score.length;i++){ //2���� �迭���� '.length'�� ���� ����
			for(int j=0; j<score[0].length-3; j++){ //2���� �迭���� '�迭��.length'�� ���� ����
				score[i][5]+=score[i][j]; //���� ����
			}
			score[i][6]+=(score[i][5]/5); //�������
		}
		//������ϱ�
		score=getRank(score);
		
		//���
		System.out.println("    ��  ��        ����   ����   ����  ����   ��ȸ   ����   ���   ���");
		System.out.println("==========================================");
		for(int i=0; i<score.length; i++){ //���1
			System.out.println(score_nm[i]+" ����= "+Arrays.toString(score[i]));
		}
		System.out.println(" ��  ��   ����   ����  ����  ����   ��ȸ  ����   ���   ���");
		System.out.println("=====================================");
		for(int i=0; i<score.length; i++){ //���2
			System.out.printf("%5s",score_nm[i]);
			for(int j=0; j<score[i].length; j++){
				System.out.printf("%4d",score[i][j]);
			}
			System.out.println();
		}
		//����1
		int[] index=hw1(score);
		System.out.println("��� ������� ��°��");
		for(int i=0; i<index.length; i++){
			System.out.println(score_nm[index[i]]+" ����= "+Arrays.toString(score[index[i]]));
		}
		
		//����2
		hw2();
		
	}
	public int[][] getRank(int[][] a){ //��� ���ϴ� �޼ҵ�
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[i][5]<a[j][5]){
					a[i][7]++;
				}
			}
		}
		return a;
	}
	/*����1. ���� ����� ��� ������ ����Ͻÿ�.
	 *����2. ���� �ڷ�� ���� �׷����� �ۼ��Ͻÿ�
	 *	[�ڷ�]: {25,55,45,40,50}
	 *	-���� �׷����� ������ ���� ����Ͻÿ� (hint ������ �Ʒ��� ����ؾ���)
	 *-> ������: �ְ����� 55, �������� 25�� ���� �� ((��-25)/5)+1= ���� ����
	 *55|*
	 *50|*
	 *45|*   *
	 *40|*   *
	 *35|* * *
	 *30|* * *
	 *25|* * *
	*/
	public int[] hw1(int[][] a){
		int[] index=new int[a.length];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[j][7]==i+1) index[i]=j;
			}
		}
		return index;
	}
	public void hw2(){
		int[] arr={25,55,45,40,50};
		int[] starNum=new int[5]; //���� ����
		String[][] str={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""}};
		String[] str1={"55|","50|","45|","40|","35|","30|","25|"};
		for(int i=0; i<arr.length; i++){ //�� ������ ���� starNum�迭�� ����
			starNum[i]=((arr[i]-25)/5)+1;
		}
		System.out.println(Arrays.toString(starNum)); //�������� �� ������ŭ ����
		for(int i=0; i<str[i].length; i++){
			for(int j=str.length-1; j>(str.length-1)-starNum[i]; j--){
				str[j][i]="*";
			}
		}
		for(int i=0; i<str.length; i++){ 
			System.out.printf("%5s",str1[i]);
			for(int j=0; j<str[i].length; j++){
				System.out.printf("%4s",str[i][j]);
			}
			System.out.println();
		}
		System.out.println("       25  55  45  40  50");
	}
}
>>>>>>> refs/remotes/origin/master
