package Chapter05;

import java.util.Arrays;

/*
����������: �ּҸ� �����ϰ� �ִ� ���� ->�迭, ��ü ��������, ������, �������̽�
	==, != �����ڴ� ������ ������ ����� ��(�ּ�)�� ��
	����񱳴� equals()�� ���
*/
/*
Chapter05 �迭
	-����Ÿ���� �����͸� ���ӵ� �������� �����ϰ� �ϰ����� ó���� ���� �� �� �ִ� ������
	-����->�ʱ�ȭ->���
	-����� �迭�� ũ��� �ø��ų� ���� �� ����.
�迭����
	-Ÿ��[] �迭��;
	-Ÿ��[] �迭��=new Ÿ�Ը�[ũŰ];
	-Ÿ��[] �迭��={��1,��2....};
*/

public class RefVal {

	public static void main(String[] args) {
		TestArrays ta=new TestArrays();
		ta.lotto();
		ta.sampleArray();
	}

}
class TestArrays{
	public void sampleArray(){
		int[] num=new int[5];
		String[] name=new String[5];
		name[0]="ȫ�浿";
		name[1]="ȫ���";
		name[2]="������";
		name[3]="�̼���";
		name[4]="������";
		num[0]=90;
		num[1]=80;
		num[2]=70;
		num[3]=60;
		num[4]=40;
		for(int i=0; i<name.length; i++){
			System.out.println(name[i]+"�� ������ "+num[i]+"�Դϴ�.");
		}
	}
	public void lotto(){ //���� �ߺ� ����. �ذ� �ʿ�
		int[] num=new int[6];
		int rand=0;
		for(int i=0; i<num.length; i++){
			rand=(int)(Math.random()*45+1);
			if (i==0) num[i]=rand;
			else{
				for(int j=0; j<i; j++){
					if(rand==num[j]) i--;
				}
			}
			num[i]=rand;
		}
		Arrays.sort(num); //����
		System.out.println("�ζǹ�ȣ "+Arrays.toString(num));
	}
}