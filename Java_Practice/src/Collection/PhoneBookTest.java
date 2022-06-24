package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	public static void main(String[] args) {
		//문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하라
		/*조건) 아래의 메뉴를 구성하고 해당 기능을 작성	
		 	-------------------------
		 	1. 전화번호 등록
		 	2. 전화번호 수정
		 	3. 전화번호 삭제
		 	4. 전화번호 검색
		 	5. 전화번호 전체출력
		 	0. 프로그램 종료
		 	--------------------------
		 	Map의 구조는 key값을 이름을 사용하고 value값으로 phone클래스의 인스턴스로 한다.
		 	이름이 같으면 이미 등록된 사람입니다. 출력(중복허용안함)
		 */
		new PbController().mainUI();	

	}

}
class PbController{
	HashMap<String,PersonDTO> phonbook=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	void mainUI() {
		String str="";
		int selectMenu=0;
		MainLoop:while(true) {
			System.out.println("=====================");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("=====================");
			System.out.print("번호입력>>");
			str=sc.nextLine();
			try {
				selectMenu=Integer.parseInt(str);
				switch (selectMenu) {
				case 1:
					menu1UI();
					break;
				case 2:
					menu2UI();
					break;
				case 3:
					menu3UI();
					break;
				case 4:
					menu4UI();
					break;
				case 5:
					menu5UI();
					break;
				case 0:
					System.out.println("이용해주셔서 감사합니다.");
					break MainLoop;
				default:
					System.out.println("잘못된 메뉴번호입니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("올바른 번호를 입력해주세요");
			}
		}
	}
	void menu1UI() { //전화번호 등록
		String name="";
		String addr="";
		String hp="";
		System.out.print("이름을 입력하세요>>>");
		name=sc.nextLine();
		if(phonbook.containsKey(name)) System.out.println("이미 등록된 사람입니다.");
		else {
			System.out.print("주소를 입력하세요>>>");
			addr=sc.nextLine();
			
			System.out.print("전화번호를 입력하세요>>>");
			hp=sc.nextLine();
			new PbDAO().insert(phonbook, name, addr, hp);
		}
	}
	void menu2UI() { //전화번호 수정
		String name="";
		String hp="";
		System.out.print("수정할 사람의 이름을 입력하세요>>>");
		name=sc.nextLine();
		if(phonbook.containsKey(name)) {
			System.out.print("수정할 전화를 입력해주세요>>>");
			hp=sc.nextLine();
			new PbDAO().update(phonbook, name, hp);
			System.out.println("===========수정결과=============");
			System.out.println("이름: "+phonbook.get(name).getName());
			System.out.println("주소: "+phonbook.get(name).getAddr());
			System.out.println("전화번호: "+phonbook.get(name).getHP());
		}
		else {
			System.out.println("정보가 없는 사람입니다.");
		}
		
	}
	void menu3UI() { //전화번호 삭제
		String name="";
		System.out.print("삭제할 사람의 이름을 입력하세요>>>");
		name=sc.nextLine();
		if(phonbook.containsKey(name)) {
			new PbDAO().delete(phonbook, name);
		}
		else {
			System.out.println("정보가 없는 사람입니다.");
		}	
	}
	void menu4UI() { //전화번호 검색
		String name="";
		System.out.print("검색할 사람의 이름을 입력하세요>>>");
		name=sc.nextLine();
		if(phonbook.containsKey(name)) {
			new PbDAO().searchOne(phonbook, name);
		}
		else {
			System.out.println("정보가 없는 사람입니다.");
		}
	}
	void menu5UI() { //전화번호 전체검색
		new PbDAO().searchAll(phonbook);
	}
}
class PbDAO{
	public void insert(HashMap map, String name, String addr, String hp) {
		map.put(name, new PersonDTO(name,addr,hp));
		System.out.println(name+" 전화번호 정보 등록 완료");
	}
	public void update(HashMap map,String name, String hp) {
		((PersonDTO) map.get(name)).setHP(hp);
		System.out.println("수정이 완료되었습니다.");
	}
	public void delete(HashMap map, String name) {
		map.remove(name);
		System.out.println("삭제가 완료되었습니다.");
	}
	public void searchOne(HashMap map, String name) {
		System.out.println("이름: "+((PersonDTO) map.get(name)).getName());
		System.out.println("주소: "+((PersonDTO) map.get(name)).getAddr());
		System.out.println("전화번호: "+((PersonDTO) map.get(name)).getHP());
	}
	public void searchAll(HashMap map) {
		Set<String> keySet=map.keySet();
		Iterator<String> it=keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println("이름: "+((PersonDTO) map.get(key)).getName());
			System.out.println("주소: "+((PersonDTO) map.get(key)).getAddr());
			System.out.println("전화번호: "+((PersonDTO) map.get(key)).getHP());
			System.out.println("=====================");
		}
	}
}
class PersonDTO{
	private String name; //이름
	private String addr; //주소
	private String HP; //휴대전화번호
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHP() {
		return HP;
	}
	public void setHP(String hP) {
		HP = hP;
	}
	public PersonDTO(String name, String addr, String hP) {
		super();
		this.name = name;
		this.addr = addr;
		HP = hP;
	}
	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", addr=" + addr + ", HP=" + HP + "]";
	}
	
	
}
