package Homework;

import java.util.HashSet;
import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) {
		Controller c=new Controller();
		c.mainUI();
	}

}

class Controller {
	Scanner sc = new Scanner(System.in);

	public void mainUI() {
		String str="";
		int menuNum=0;
		Loop:while(true) {
			System.out.println("===================================");
			System.out.println("Lotto 프로그램");
			System.out.println("----------------------");
			System.out.println("1.Lotto 구입");
			System.out.println("2.프로그램 종료");
			System.out.println("===================================");
			System.out.println("메뉴선택: ");
			str=sc.nextLine();
			try {
				menuNum=Integer.parseInt(str);
				switch (menuNum) {
				case 1:
					purchaseUI();
					break Loop;
				case 2:
					System.out.println("감사합니다.");
					break;
				default:
					System.out.println("잘못된 메뉴번호입니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.");
				str="";
			}
		}

	}
	public void purchaseUI() {
		int money=0;
		while(true) {
			System.out.println("Lotto 구입시작");
			System.out.println("(1000원에 로또번호 하나입니다.)");
			System.out.println("금액 입력:");
			money=sc.nextInt();
			if(money>100000)System.out.println("입력금액이 너무 많습니다.");
			else if(money<0)System.out.println("잘못된 금액입니다.");
			else if(money<1000)System.out.println("입력금액이 너무 적습니다. 로또번호 구입 실패");
			else {
				new DTO().randomNum(money);
				break;
			}
		}
	}
}
class DTO{
	public void randomNum(int money) {
		//로또는 랜덤6자리
		int count=money/1000;
		for(int i=0; i<count; i++) {
			HashSet<Integer> testSet=new HashSet<Integer>();
			while(testSet.size()<6) {
				testSet.add((int)(Math.random()*45+1));
			}
			System.out.println("로또번호"+(i+1)+": "+testSet);
		}
		System.out.println("받은 금액은 "+money+"원이고 거스롬돈은 "+money%1000+"원입니다.");
	}
}