package BankManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankController {
	private BankInfoServiceImpl service;       //Service 객체가 저장될 변수 선언
	   
	private Scanner sc = new Scanner(System.in);
   
	//생성자
	public BankController() {
		service = BankInfoServiceImpl.getInstance();      //service 객체 생성
	}

	public static void main(String[] args) {
		new BankController().bankStart();
	}
	private void bankStart() {
		while(true) {
			int num=displayMain();
			switch (num) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				getAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("잘못된 메뉴번호입니다.");
				break;
			}
		}
	}
	private int displayMain() {
		int num=0; //메뉴번호 저장변수
		System.out.println("=============================================");
		System.out.println("1. 계좌번호 추가");
		System.out.println("2. 계좌번호 삭제");
		System.out.println("3. 계좌번호 수정");
		System.out.println("4. 전체 계좌번호 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("=============================================");
		System.out.print("메뉴를 선택해주세요>>");
		num=sc.nextInt();
		return num;
	}
	private void insert() {
		System.out.println();
		String bank_no="";
		while(true) {
			System.out.print("계좌번호를 입력해주세요>>");
			bank_no=sc.next();
			
			int count=service.checkNo(bank_no);
			if(count==0) break;
			else {
				System.out.println("중복된 계좌번호입니다.");
			}
		}
		System.out.print("은행명을 입력해주세요>>");
		String bank_name=sc.next();
		
		System.out.print("사용자명을 입력해주세요>>");
		String bank_user_name=sc.next();
		
		int cnt=service.insert(new BankVO(bank_no, bank_name, bank_user_name));
		if(cnt==0) System.out.println("등록 실패");
		else System.out.println("등록 성공");
	}
	private void delete() {
		System.out.println();
		System.out.print("계좌번호를 입력해주세요>>");
		String bank_no=sc.next();
		
		int count=service.checkNo(bank_no);
		if(count==0) {
			System.out.println("등록되지 않은 계좌번호입니다.");
		}
		else{
			int cnt=service.delete(bank_no);
			if(cnt==0) System.out.println("삭제 실패");
			else System.out.println("삭제 성공");
		}
	}
	private void update() {
		System.out.println();
		System.out.print("계좌번호를 입력해주세요>>");
		String bank_no=sc.next();
		
		int count=service.checkNo(bank_no);
		int cnt=0;
		if(count==0) {
			System.out.println("등록되지 않은 계좌번호입니다.");
		}
		else{
			System.out.print("변경할 은행명을 입력해주세요>>");
			String bank_name=sc.next();
			
			System.out.print("변경할 사용자명을 입력해주세요>>");
			String bank_user_name=sc.next();
			
			cnt=service.update(new BankVO(bank_no, bank_name, bank_user_name));
			if(cnt==0) System.out.println("수정 실패");
			else System.out.println("수정 성공");
		}
	}
	private void getAll() {
		System.out.println();
		List<BankVO> list=new ArrayList<>();
		list=service.getAll();
		
		System.out.println("=================================================================");
		System.out.println("계좌번호                  은행명    사용자명        등록날짜");
		System.out.println("=================================================================");
		for(BankVO bv: list) {
			String bank_no=bv.getBank_no();
			String bank_name=bv.getBank_name();
			String bank_user_name=bv.getBank_user_name();
			String bank_date=bv.getBank_date();
			System.out.println(bank_no  + "\t\t"+bank_name  + "\t"+bank_user_name  + "\t"+bank_date);
		}
	}

}
