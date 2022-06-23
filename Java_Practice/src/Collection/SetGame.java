package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 Set을 이용해서 숫자 야구 게임 프로그램을 작성하시오.
 컴퓨터의 숫자는 난수를 이용하여 구한다.
 스트라이크는 S,볼은 B로 나타낸다.
 
 예시) 컴퓨터의 난수->9 5 7
 */
public class SetGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashSet<Integer> comNum=new HashSet<Integer>();
		
		while(comNum.size()<3) {
			comNum.add((int)(Math.random()*9+1));
		}
		ArrayList<Integer> comList=new ArrayList<Integer>(comNum);
		ArrayList<Integer> userList=new ArrayList<Integer>();
		int strike=0;
		int ball=0;
		int count=1;
		
		while(true) {
			for(int i=0; i<comList.size(); i++) {
				System.out.print(i+1+"번째 수를 입력하세요>>");
				userList.add(sc.nextInt());
			}
			for(int i=0; i<comList.size(); i++) {
				if(comList.get(i)==userList.get(i)) strike++;
				else {
					for(int j=0; j<comList.size(); j++) {
						if(userList.get(i)==comList.get(j)) ball++;
					}
				}
			}
			System.out.println("Stike: "+strike);
			System.out.println("Ball: "+ball);
			if(strike==3) {
				System.out.println(count+"회 만에 정답입니다.");
				System.out.println("게임에서 승리하셨습니다. 게임을 종료합니다.");
				System.out.println("컴퓨터의 숫자: "+comList);
				break;
			}
			else {
				strike=0;
				ball=0;
				userList.clear();
				count++;
				System.out.println("==============================");
			}
		}

	}

}
