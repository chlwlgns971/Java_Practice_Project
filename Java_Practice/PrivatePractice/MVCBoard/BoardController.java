package MVCBoard;

import java.util.List;
import java.util.Scanner;

import MVC.MemberVO;

public class BoardController {
	private BoardServiceImpl service;       //Service 객체가 저장될 변수 선언
	   
	private Scanner sc = new Scanner(System.in);
   
	//생성자
	public BoardController() {
		service = BoardServiceImpl.getInstance();      //service 객체 생성
	}
   
	public static void main(String[] args) {
		new BoardController().boardStart();
	}
	public void boardStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
         
			case 1 :            //글 작성
				writePost();
				break;
	         case 2 :            //게시물보기
	        	showPost();
	            break;
	         case 3 :            //검색
	            searchPost();
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
	private int displayMenu() {
		 List<BoardVO> postList=service.display();
		 int num=0;
		 System.out.println();
		 System.out.println("-----------------------------------------------------");
		 System.out.println("No	           제 목                 작성자   조회수");
		 System.out.println("-----------------------------------------------------");
		 if(postList==null || postList.size()==0) {
			 System.out.println("등록된 게시글이 존재하지 않습니다.");
			 System.out.println("-----------------------------------------------------");
			 System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
			 System.out.print("작업선택>>> ");
			 num=sc.nextInt();
		 }
		 else {
			 for(BoardVO vo : postList) {
				 int no=vo.getBoard_no();
				 String title=vo.getBoard_title();
				 String writer=vo.getBoard_writer();
				 String cnt=vo.getBoard_cnt();
				 System.out.println(no  + "\t"+title  + "\t\t\t"+writer  + "\t"+cnt);      
			 }
			 System.out.println("-----------------------------------------------------");
			 System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
			 System.out.print("작업선택>>> ");
			 num=sc.nextInt();
	 	}
		return num;
	}
	private void writePost() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------------------------");
		sc.nextLine();
		System.out.print("제  목>>");
		String title=sc.nextLine();
		System.out.print("작 성 자>>");
		String writer=sc.nextLine();
		System.out.print("내  용>>");
		String content=sc.nextLine();
		service.insert(new BoardVO(title,writer,content));	
	}
	private void showPost() {
		List<BoardVO> post=service.display();
		System.out.print("게시글 번호를 입력해주세요>>");
		int num=sc.nextInt();
		post=service.showPost(num);
		System.out.println(post);
		
		if(post==null || post.size()==0) {
			 System.out.println("등록된 게시글이 존재하지 않습니다.");
			 return;
		 }
		
		System.out.println("-----------------------------------------------------");
		System.out.println(num+"번글 내용");
		System.out.println("-----------------------------------------------------");
		for(BoardVO vo : post) {
			System.out.println("-제 목: "+vo.getBoard_title()); 
			System.out.println("-작성자: "+vo.getBoard_writer()); 
			System.out.println("-내 용: "+vo.getBoard_content()); 
			System.out.println("-작성일: "+vo.getBoard_date()); 
			System.out.println("-조회수: "+(Integer.parseInt(vo.getBoard_cnt())+1)); 
		 }
		 System.out.println("-----------------------------------------------------");
		 System.out.println("메뉴 : 1. 수정     2. 삭제    3. 홈으로 돌아가기");
		 System.out.print("작업선택>>> ");
		 switch (sc.nextInt()) {
			case 1:
				updatePost(num);
				break;
			case 2:
				deletePost(num);
				break;
			case 3:
				return;
			default:
				System.out.println("잘못된 입력입니다. 홈으로 돌아갑니다.");
				break;
		}
	}
	private void updatePost(int board_no) {
		System.out.println();
		System.out.println("글 수정하기");
		System.out.println("-----------------------------------------------------");
		sc.nextLine();
		System.out.print("제  목>>");
		String title=sc.nextLine();
		System.out.print("작 성 자>>");
		String writer=sc.nextLine();
		System.out.print("내  용>>");
		String content=sc.nextLine();
		service.update(new BoardVO(title,writer,board_no,content));	
	}
	private void deletePost(int board_no) {
		System.out.println("정말로 삭제하시겠습니까? y/n");
		String str=sc.next();
		if(str.equals("y")) {
			service.delete(board_no);
			System.out.println("삭제가 완료되었습니다.");
		}
	}
	private void searchPost() {
		List<BoardVO> postList=service.display();
		sc.nextLine();
		System.out.print("검색어를 입력하세요>>");
		postList=service.searchPost(sc.nextLine());
		System.out.println("-----------------------------------------------------");
		System.out.println("No	  제 목          작성자   조회수");
		System.out.println("-----------------------------------------------------");
		for(BoardVO vo : postList) {
			 int no=vo.getBoard_no();
			 String title=vo.getBoard_title();
			 String writer=vo.getBoard_writer();
			 String cnt=vo.getBoard_cnt();
			 System.out.println(no  + "\t"+title  + "\t\t"+writer  + "\t"+cnt);      
		 }
		 System.out.println("-----------------------------------------------------");
		 System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    4.홈으로 돌아가기");
		 System.out.print("작업선택>>> ");
		 switch (sc.nextInt()) {
		 case 1 :            //글 작성
				writePost();
				break;
	         case 2 :            //게시물보기
	        	showPost();
	            break;
	         case 3 :
	        	 searchPost();
	        	 break;
	         case 4 :
	            return;
			 default:
				 System.out.println("잘못된 입력입니다. 홈으로 돌아갑니다.");
				 break;
		}
		
	}
}
