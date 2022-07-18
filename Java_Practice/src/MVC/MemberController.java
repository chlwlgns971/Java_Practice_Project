package MVC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
MVC(Model, View, Controller)패턴
MVC패턴의 로직을 처리하는 클래스들
	-VO,DRO=>데이터를 저장하는 역할만 하는 클래스
		(VO=Value Object, DTO=Data Transfer Object)=> DB테이블에서 1개의 레코드를 저장할 클래스
	
	-DAO=>SQL문을 서버에 보내서 결과를 얻어오는 역할을 수행하는 클래스
		(DAO=Data Access Object)
	-Service=>일을 수행하는 중간 관리자와 같은 역할을 수행하는 클래스
	Service는 일이 있으면 그 일에 필요한 DAO를 호출해서 일을 처리한 후 처리 결과를 Controller에 전달한다.
	
	Controller=> 비지니스 로직이 시작되는 곳으로 사용자의 요청에 맞는 일을 Service에게 시키고, 
	Service가 보내온 처리결과를 화면등에 반영시키는 역할을 수행
	
	Controller -> Service -> DTO -> DB서버 -> DAO-> Service-> Controller
	보통은 DTO/VO -> DAO/Service interface-> DAO -> Controller순으로 작성한다.
*/

public class MemberController {
	private IMemberService service;       //Service 객체가 저장될 변수 선언
	   
	private Scanner sc = new Scanner(System.in);
   
	//생성자
	public MemberController() {
		//service = new MemberServiceImpl();      //service 객체 생성
		service = MemberServiceImpl.getInstance();      //service 객체 생성
	}
   
	public static void main(String[] args) {
		new MemberController().memberStart();
	}
   
	//시작 메서드
	public void memberStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
         
			case 1 :            //추가
				insertMember();
				break;
	         case 2 :            //삭제
	        	deleteMember();
	            break;
	         case 3 :            //수정
	            updateMember();
	            break;
	         case 4 :            //전체 출력
	            displayMember();
	            break;
	         case 5 :            //수정
	            updateMember2();
	            break;
	         case 0 :
	            System.out.println("프로그램을 종료합니다....");
	            return;
            
	         default :
	            System.out.println("");
	            System.err.println("작업 번호를 잘못 입력했습니다.");
	            System.err.println("다시 입력하세요.");
			}
		} 
	}
	private void insertMember() {
		System.out.println();      
		System.out.println("추가할 회원 정보를 입력하세요. ");
      
		int count= 0;
		String memId = null;
		do {
			System.out.print("회원ID >> ");
			memId = sc.next();
			count = service.getMemberIdCount(memId);
         
			if(count>0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID입니다. ");
				System.out.println(" 다른 회원ID를 입력해주세요.");            
			}
      
		}while(count>0);
     	System.out.print("비밀번호 >> ");
     	String pass = sc.next();
     
     	System.out.print("회원이름 >> ");
     	String name = sc.next();
     
     	System.out.print("전화번호 >> ");
     	String tel = sc.next();
     
     	sc.nextLine();      //입력버퍼 비우기      -->nextLine 쓰려면, nextLine 아닌 게 쓰여진거 이후에, 한번 써 줘서 버퍼 비워줘야 함. 
     	System.out.print("주소 >> ");
     	String addr = sc.nextLine();
     
     	//입력한 데이터를 MemberVO객체에 저장한다.
     	MemberVO memVo=new MemberVO();
     	memVo.setMem_id(memId);
     	memVo.setMem_pass(pass);
     	memVo.setMem_name(name);
     	memVo.setMem_tel(tel);
     	memVo.setMem_addr(addr);
     
     	// Service의 insert메서드 호출
     	int cnt = service.insertMember(memVo);
     
     	if(cnt>0) {
     		System.out.println(memId + " 회원 정보 추가 완료!!!");
     	}else {
     		System.out.println(memId + " 회원 정보 추가 실패~~~");
     	}      
   }
   private void deleteMember() {
	   System.out.println();
	   System.out.println("삭제할 회원 정보를 입력하세요.");
	   System.out.print("회원ID>> ");
	   String id=sc.next();
	   
	   int cnt = service.deleteMember(id);
       
       if(cnt>0) {
          System.out.println(id + "회원 정보 삭제 성공!!!");
       }else {
          System.err.println( id + "회원은 없는 회원이거나 삭제에 실패했습니다...");
       }
   }
   private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원정보를 입력하세요. ");
		  
		System.out.print("회원ID >> ");
		String id = sc.next();
		  
		int count = service.getMemberIdCount(id);
		  
		if(count==0) {      //없는 회원이면....
			System.out.println(id + "은(는) 없는 회원ID입니다. ");
			System.out.println("수정 작업을 종료합니다. ");
		    return;
		}
		  
		System.out.println();
		System.out.print("새로운 비밀번호 >>");
		String newPass = sc.next();
		  
		System.out.print("새로운 회원이름 >>");
		String newName = sc.next();
		  
		System.out.print("새로운 전화번호 >>");
		String newTel = sc.next();
		  
		sc.nextLine();         //입력 버퍼 비우기
		System.out.print("새로운 회원주소 >>");
		String newAddr = sc.nextLine();
		
		//입력한 데이터를 MemberVO객체에 저장한다.
        MemberVO memVo=new MemberVO();
        memVo.setMem_id(id);
        memVo.setMem_pass(newPass);
        memVo.setMem_name(newName);
        memVo.setMem_tel(newTel);
        memVo.setMem_addr(newAddr);
        
        int cnt=service.updateMember(memVo);
        
        if(cnt>0) {
        	System.out.println("회원정보 수정 성공");
        }
        else {
        	System.out.println("회원정보 수정 실패");
        }
   }
   private void updateMember2() {
	   System.out.println();
	   System.out.println("수정할 회원정보를 입력하세요. ");

	   System.out.print("회원ID >> ");
	   String id = sc.next();

	   int count = service.getMemberIdCount(id);

	   if (count == 0) { // 없는 회원이면...
		   System.err.println(id + "은(는) 없는 회원ID입니다. ");
		   System.err.println("수정 작업을 종료합니다. ");
		   return;
	   }

	   int num;
	   String field = null; // 수정할 항목의 컬럼명이 저장될 변수
	   String title = null; // 수정할 항목을 입력 받을 때 사용할 메시지(항목명)

	   do {
		   System.out.println();
		   System.out.println("  *  수정을 희망하는 항목의 번호를 입력하세요");
		   System.out.println("1.  비밀번호        2. 회원이름       3. 전화번호          4. 회원주소");
		   System.out.println("-----------------------------------------------------------------");
		   System.out.print("수정할 항목 선택 >>");
		   num = sc.nextInt();

		   switch (num) {
		   case 1: // 비밀번호
			   field = "mem_pass";
			   title = "비밀번호";
			   break;
		   case 2: // 회원이름
			   field = "mem_name";
			   title = "회원이름";
			   break;
		   case 3: // 전화번호
			   field = "mem_tel";
			   title = "전화번호";
			   break;
		   case 4: // 회원주소
			   field = "mem_addr";
			   title = "회원주소";
			   break;
		   default:
			   System.out.println(" 수정할 항목 번호를 잘못 입력하였습니다 .");
			   System.out.println(" 다시 입력해 주세요");

		   }

	   } while (num < 1 || num > 4); // 항목 번호 잘못 입력한 경우 다시 반복.

	   System.out.println();

	   sc.nextLine(); // 입력 버퍼 비우기
	   System.out.print("새로운" + title + " >>");
	   String data = sc.nextLine();

	   // 선택할 컬럼명이 수정할 데이터 그리고 회원ID를 Map에 추가한다.
	   // Key값 정보 : 회원ID(memid), 수정할컬럼명(field), 수정할데이터(data)
	   Map<String, String> paramMap = new HashMap<String, String>();
	   paramMap.put("memid", id);
	   paramMap.put("field", field);
	   paramMap.put("data", data);

	   int cnt = service.updateMember2(paramMap);

	   if (cnt > 0) {
		   System.out.println("수정 작업 성공~~~");
	   } else {
		   System.out.println("수정 작업 실패!!!");
	   }

   }
   private int displayMenu() {
      System.out.println();
      System.out.println("  *  원하는 작업의 번호를 입력하세요");
      System.out.println();
      System.out.println("-------------------------------------------");
      System.out.println("   1. 자 료   추 가");
      System.out.println("   2. 자 료  삭 제");
      System.out.println("   3. 자 료  수 정");
      System.out.println("   4. 전 체  자 료  출 력");
      System.out.println("   5.  자 료  선 택 수 정");
      System.out.println("   0. 작 업  끝. ");
      System.out.println("-------------------------------------------");
      System.out.print("   번호 입력 >>");
      
      return sc.nextInt();
   }
   
   private void displayMember() {
	   List<MemberVO> memList=service.getAllMember();
	   System.out.println();
	   System.out.println("-----------------------------------------------------");
	   System.out.println("  ID    비밀번호   이름           전화번호            주 소");
	   System.out.println("-----------------------------------------------------");
	   if(memList==null || memList.size()==0) {
		   System.out.println("등록된 회원이 존재하지 않습니다.");
	   }
	   else {
		   for(MemberVO memVo : memList) {
			   String id=memVo.getMem_id();
			   String pass=memVo.getMem_pass();
			   String name=memVo.getMem_name();
			   String tel=memVo.getMem_tel();
			   String addr=memVo.getMem_addr();
			   System.out.println(id  + "\t"+pass  + "\t"+name  + "\t"+tel  + "\t"+addr);      

		   }
	   }
	   System.out.println("---------------------------------------------------------------------------------------");
	   System.out.println("출력 끝....");
   }
}
