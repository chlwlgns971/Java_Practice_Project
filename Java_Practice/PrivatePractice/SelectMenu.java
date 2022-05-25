import java.util.*;

//식사메뉴 정하기
public class SelectMenu {

	public static void main(String[] args) {
		Menu mn=new Menu();
		ArrayList menu=new ArrayList<>();
		menu=mn.menuList();
		//점심메뉴
		double randomValue=Math.random();
		int index=(int)(randomValue*menu.size());
		//System.out.println(index);
		System.out.println("점심메뉴는 "+menu.get(index));
		
		//저녁메뉴
		menu.remove(index);
		double randomValue2=Math.random();
		int index2=(int)(randomValue2*menu.size());
		//System.out.println(index2);
		System.out.println("저녁메뉴는 "+menu.get(index2));
		
	}

}
class Menu{
	ArrayList menuList(){
		ArrayList<String> menu=new ArrayList<>(Arrays.asList("오류동 꼬마김밥","다온짬뽕(볶음짬뽕 맛집)","버거킹","칼국수 만드는 사람들","라면", 
				"7930손님식탁(돈까스,파스타)","반석돈까스","부부칼국수","오박사 전복해신탕(닭곰탕, 닭칼국수)","궁전가든(찌개전문)","3일 소고기국밥","짜글이","복록수(중국집)",
				"제육","김치찌개","금성 칡냉면","신대칼국수(빨간칼국수)","황지(백숙집)","화평본가(차돌된장, 우동, 냉면)","본가순대","경복궁 우리밥상(한식뷔페)","잘임스국수앤덮밥",
				"항아리보쌈","꽃님이네(백반)","참이맛감자탕","밥통령","미스사이공 세이점","라멘","스시은인","쓰촨(중국집)"));
		return menu;
	}
}