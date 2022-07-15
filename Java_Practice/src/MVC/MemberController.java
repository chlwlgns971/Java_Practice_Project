package MVC;

import java.util.Scanner;

public class MemberController {
	private IMemberService service;       //Service 객체가 저장될 변수 선언
	   
   private Scanner sc = new Scanner(System.in);
   
   //생성자
   public MemberController() {
      service = new MemberServiceImpl();      //service 객체 생성
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
//         case 2 :            //삭제
//        	deleteMember();
//            break;
//         case 3 :            //수정
//            updateMember();
//            break;
//         case 4 :            //전체 출력
//            displayMember();
//            break;
//         case 5 :            //수정
//            updateMember2();
//            break;
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
}
