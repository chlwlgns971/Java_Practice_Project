package Chapter05;

import java.util.Arrays;

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
