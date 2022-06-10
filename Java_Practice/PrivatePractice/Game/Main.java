package Game;

import java.util.Scanner;

public class Main {
	Character c;
	Item[] items;
	Monster[] monsters;
	Scanner sc=new Scanner(System.in);
	
	Main(){
		c=new Character("가렌", 100, 50, 10, 10);
		items=new Item[12];
		items[0]=new Item("나무검",0,0,10,0);
		items[1]=new Item("천갑옷",0,0,0,10);
		items[2]=new Item("체력구슬",10,0,0,0);
		items[3]=new Item("마나구슬",0,10,0,0);
		
		items[4]=new Item("강철검",0,0,30,0);
		items[5]=new Item("가죽갑옷",0,0,0,30);
		items[6]=new Item("체력주머니",50,0,0,0);
		items[7]=new Item("마나주머니",0,50,0,0);
		
		items[8]=new Item("무한의대검",0,0,100,0);
		items[9]=new Item("가시갑옷",0,0,0,100);
		items[10]=new Item("체력의 샘",100,0,0,0);
		items[11]=new Item("마나의 샘",0,100,0,0);
		
		monsters=new Monster[3];
		monsters[0]=new Monster("바위게",20,20,10,10,50,new Item[] {items[0],items[1],items[2],items[3]});
		monsters[1]=new Monster("협곡의 전령",100,20,50,50,100,new Item[] {items[4],items[5],items[6],items[7]});
		monsters[2]=new Monster("바론",5000,2000,200,200,400,new Item[] {items[8],items[9],items[10],items[11]});
	}
	public static void main(String[] args) {
		new Main().start();
	}
	void consoleClean() {
		for(int i=0; i<50; i++) {
			System.out.println();
		}
	}
	private void start() {
		int input=0;
		System.out.println("========================게임시작=======================");
		while(true) {
			if(c.hp<=0) {
				System.out.println("플레이어의 체력이 없습니다.");
				System.out.println("게임을 종료합니다.");
				break;
			}
			System.out.println("------------------메인메뉴-----------------");
			System.out.println("1.내정보 2.사냥 0.종료");
			System.out.println("-----------------------------------------");
			System.out.println("메뉴를 입력해주세요>>");
			input=Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
	private void hunt() {
		consoleClean();
		Monster originM=monsters[(int)(Math.random()*monsters.length)];
		Monster m=new Monster(originM.name, originM.maxHp, originM.maxMp, originM.att, originM.def, originM.exp, originM.items);
		System.out.println("-----------------전투화면-----------------");
		System.out.println(m.name+"을(를) 만났습니다. 전투를 시작합니다.");
		int input=0;
		battle: while(true) { //반복문에 이름 붙이기
			System.out.println("1.공격 2.도망>>");
			input=Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				c.attack(m);
				if(m.hp<=0) {
					System.out.println(m.name+"을(를) 처치하였습니다.");
					System.out.println("---------------전투종료-------------");
					c.getExp(m.exp);
					c.getItem(m.itemDrop());
					System.out.println();
					break battle;
				}
				m.attack(c);
				if(c.hp<=0) {
					System.out.println(c.name+"이(가) 죽었습니다.");
					System.out.println("---------------전투종료-------------");
					System.out.println();
					break battle;
				}
				break;
			case 2:
				System.out.println(m.name+"으로부터 도망쳤습니다.");
				break battle;
		
			}
		}
	}
}
