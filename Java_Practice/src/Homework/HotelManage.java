package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HotelManage {

	public static void main(String[] args) {
		/*
		 문제) 호텔 객실을 관리하는 프로그램을 작성하시오.

   		조건1)  호텔 객식을 나타내는 Room클래스는 방번호(int), 방종류, 투숙객이름 필드로 구성되어 있고			     
           방번호와 방종류는 다음과 같다.
           - 201~209 : 싱글룸
           - 301~309 : 더블룸
           - 401~409 : 스위트룸

  		조건2) 전체 객실 관리는 Map을 이용한다.
          (Map의 key값은 방번호로 하고 value값은 Room의 인스턴스로 한다.)
          생성자에서는 방번호와 방종류를 초기화한다.
		 */
		new HotelController().mainUI();
	}

}
class HotelController{
	Scanner sc=new Scanner(System.in);
	public void mainUI() {
		HashMap<Integer,RoomDTO> hotelMap=new HashMap<>();
		for(int i=201; i<=209; i++) {
			hotelMap.put(i, new RoomDTO(i));
		}
		for(int i=301; i<=309; i++) {
			hotelMap.put(i, new RoomDTO(i));		
		}
		for(int i=401; i<=409; i++) {
			hotelMap.put(i, new RoomDTO(i));
		}
		String str="";
		int selectMenu=0;
		MainLoop:while(true) {
			System.out.println("=================================================");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
			System.out.println("=================================================");
			System.out.print("선택>>>");
			str=sc.nextLine();
			try {
				selectMenu=Integer.parseInt(str);
				switch (selectMenu) {
				case 1:
					menu1UI(hotelMap);
					break;
				case 2:
					menu2UI(hotelMap);
					break;
				case 3:
					menu3UI(hotelMap);
					break;
				case 4:
					System.out.println("=================================================");
					System.out.println("호텔문을 닫았습니다.");
					System.out.println("=================================================");
					break MainLoop;
				default:
					System.out.println("올바른 메뉴를 선택해주세요");
					break;
				}
			} catch (Exception e) {
				System.out.println("올바른 메뉴번호를 입력해주세요.");
			}
		}
	}
	public void menu1UI(HashMap hotelMap) {//체크인
		System.out.println("=================================================");
		System.out.println("             체크인 작업");
		System.out.println("=================================================");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("=================================================");
		System.out.print("방 번호 입력>>>");
		int roomNum=sc.nextInt();
		sc.nextLine();
		if((roomNum>=201 && roomNum<=209)||(roomNum>=301 && roomNum<=309)||(roomNum>=401 && roomNum<=409)) {
			if(((RoomDTO) hotelMap.get(roomNum)).getResName()!=null) System.out.println("이미 사용중인 방입니다.");
			else {
				System.out.print("예약자 이름 입력>>>");
				String resName=sc.nextLine();
				new HotelDAO().insert(hotelMap, roomNum, resName);
			}
		}
		else System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
	}
	public void menu2UI(HashMap hotelMap) {//체크아웃
		System.out.println("=================================================");
		System.out.println("             체크아웃 작업");
		System.out.println("=================================================");
		System.out.print("체크아웃할 방의 번호를 입력해주세요>>>");
		int roomNum=sc.nextInt();
		sc.nextLine();
		if((roomNum>=201 && roomNum<=209)||(roomNum>=301 && roomNum<=309)||(roomNum>=401 && roomNum<=409)) {
			if(((RoomDTO) hotelMap.get(roomNum)).getResName()==null) System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다.");
			else {
				new HotelDAO().delete(hotelMap, roomNum);
			}
		}
		else System.out.println(roomNum+"호 객실은 존재하지 않습니다.");
	}
	public void menu3UI(HashMap hotelMap) {//객실상태조회
		//방번호를 순서대로 나오게 하기위해서 방 번호만 List에 넣은 후 정렬하여 사용
		ArrayList<Integer> numList=new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(numList);
		for(int num: numList) {
			System.out.println("방 번호: "+((RoomDTO) hotelMap.get(num)).getRoomNum()+"   방 종류: "+((RoomDTO) hotelMap.get(num)).getRoomType()+
					"   예약자이름: "+((RoomDTO) hotelMap.get(num)).getResName());
			System.out.println();
		}
		//정렬 안한 상태로 출력
//		Set<Integer> keySet=hotelMap.keySet();
//		Iterator<Integer> it=keySet.iterator();
//		while(it.hasNext()) {
//			int key=it.next();
//			System.out.println("방 번호: "+((RoomDTO) hotelMap.get(key)).getRoomNum()+"   방 종류: "+((RoomDTO) hotelMap.get(key)).getRoomType()+
//					"   예약자이름: "+((RoomDTO) hotelMap.get(key)).getResName());
//			System.out.println();
//		}
	}
}
class HotelDAO{
	public void insert(HashMap hotelMap, int roomNum, String resName) {
		((RoomDTO) hotelMap.get(roomNum)).setResName(resName);
		System.out.println("예약이 완료되었습니다.");
	}
	public void delete(HashMap hotelMap, int roomNum) {
		((RoomDTO) hotelMap.get(roomNum)).setResName(null);
		System.out.println("체크아웃이 완료되었습니다.");
	}
}
class RoomDTO{
	private int roomNum;
	private String roomType;
	private String resName;
	
	RoomDTO(int roomNum, String resName){
		this.roomNum=roomNum;
		if(roomNum>=201 && roomNum<=209) this.roomType="싱글룸";
		else if(roomNum>=301 && roomNum<=309) this.roomType="더블룸";
		else if(roomNum>=401 && roomNum<=409) this.roomType="스위트룸";
		this.resName=resName;
	}
	RoomDTO(int roomNum){
		this.roomNum=roomNum;
		if(roomNum>=201 && roomNum<=209) this.roomType="싱글룸";
		else if(roomNum>=301 && roomNum<=309) this.roomType="더블룸";
		else if(roomNum>=401 && roomNum<=409) this.roomType="스위트룸";
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	@Override
	public String toString() {
		return "RoomDTO [roomNum=" + roomNum + ", roomType=" + roomType + ", resName=" + resName + "]";
	}
	
}
