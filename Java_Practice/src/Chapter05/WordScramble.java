package Chapter05;

import java.util.Arrays;
import java.util.Scanner;

/*5���� ���� �ܾ� �� ������ �ܾ �����Ͽ� �ܾ �����ϴ� ö�ڸ� ���� �� ����ڿ��� �����ϸ� ����ڰ� �� �ܾ ���ߴ� ����
 * +�õ� Ƚ���� ����Ͻÿ�
 */

public class WordScramble {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int rand=(int)(Math.random()*5);
		String[] word={"apple","tumblr","window","computer","button"}; 
		String str=""; //���ĺ� ������ ���� �ܾ �����ϴ� ����
		int[] randNum=new int[word[rand].length()]; //�ߺ����ŵ� �ε��� �������� ����Ǵ� �迭
		for(int i=0; i<word[rand].length(); i++){ //�������� �ε������� �����ϰ� �ߺ�����
			randNum[i]=(int)(Math.random()*word[rand].length());
			for(int j=0; j<i; j++){
				if(randNum[i]==randNum[j]) i--;
			}
			
		}
		//System.out.println(Arrays.toString(randNum)); //�������� ������ �ε��� ����
		for(int i=0; i<randNum.length; i++){
			str+=word[rand].substring(randNum[i], randNum[i]+1); //substring(a,b)=string�� a�ε������� b�ε��� ������ �߶�
		}
		
		String asw="";
		while(true){
			System.out.println(str);
			System.out.print("������ �Է����ּ���(�ҹ���): ");
			asw=sc.nextLine();
			if (asw.equals(word[rand])){
				System.out.println("�����Դϴ�.");
				break;
			}
			else System.out.println("������ �ƴմϴ�.");
		}

	}

}

//public String suffle(String str){ //�������� ����� �˰���
//	char[] ch=str.toCharArray();
//	for(int i=0; i<=100000; i++){
//		int r1=(int)(Math.random()*ch.length);
//		char temp=ch[0];
//		ch[0]=ch[r1];
//		ch[r1]=temp;
//	}
//	retirm(new String(ch))
//}
