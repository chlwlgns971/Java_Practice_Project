package Chapter05;

import java.util.Arrays;
import java.util.Scanner;

/*5개의 영어 단어 중 임의의 단어를 선택하여 단어를 구성하는 철자를 섞은 후 사용자에게 제시하면 사용자가 그 단어를 맞추는 게임
 * +시도 횟수도 출력하시오
 */

public class WordScramble {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int rand=(int)(Math.random()*5);
		String[] word={"apple","tumblr","window","computer","button"}; 
		String str=""; //알파벳 순서를 섞은 단어를 저장하는 변수
		int[] randNum=new int[word[rand].length()]; //중복제거된 인덱스 난수값이 저장되는 배열
		for(int i=0; i<word[rand].length(); i++){ //랜덤으로 인덱스값을 생성하고 중복제거
			randNum[i]=(int)(Math.random()*word[rand].length());
			for(int j=0; j<i; j++){
				if(randNum[i]==randNum[j]) i--;
			}
			
		}
		//System.out.println(Arrays.toString(randNum)); //랜덤으로 생성된 인덱스 순서
		for(int i=0; i<randNum.length; i++){
			str+=word[rand].substring(randNum[i], randNum[i]+1); //substring(a,b)=string을 a인덱스부터 b인덱스 전까지 잘라냄
		}
		
		String asw="";
		while(true){
			System.out.println(str);
			System.out.print("정답을 입력해주세요(소문자): ");
			asw=sc.nextLine();
			if (asw.equals(word[rand])){
				System.out.println("정답입니다.");
				break;
			}
			else System.out.println("정답이 아닙니다.");
		}

	}

}

//public String suffle(String str){ //선생님이 만드신 알고리즘
//	char[] ch=str.toCharArray();
//	for(int i=0; i<=100000; i++){
//		int r1=(int)(Math.random()*ch.length);
//		char temp=ch[0];
//		ch[0]=ch[r1];
//		ch[r1]=temp;
//	}
//	retirm(new String(ch))
//}
