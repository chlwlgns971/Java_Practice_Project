package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.DBUtil;
import Util.DBUtil2;
import Util.DBUtil3;

public class ManageMember {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 회원을 관리하는 프로그램을 작성하시오.(MYMEMBER테이블 이용)
		 	-아래 메뉴의 기능을 모두 구현하시오.(CRUD기능 구현)
		 	1. 자료 추가	->insert(C)
		 	2. 자료 삭제	->delete(D)
		 	3. 자료 수정	->update(U)
		 	4. 현재 자료 출력	->select(R)
		 	0. 작업 끝
		 -조건
		 1. 자료 추가에서 회원ID는 중복되지 않는다.(중복되면 다시 입력)
		 2. 자료 삭제는 회원ID를 입력받아서 처리
		 3. 자료 수정에서 회원ID는 변경되지 않는다.
		 */

		new ManageMember().memberStart();
	}
	private void disConnect() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	private void memberStart() {
		MainLoop:while(true) {
			int choice=displayMenu();
			switch (choice) {
			case 1:
				insertMember();
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				updateMember2();
				break;
			case 5:
				displayMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break MainLoop;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	//회원정보를 추가하는 메서드
	//자료 추가해서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력)
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count=0;
		String memId=null;
		do {
			System.out.print("회원ID>> ");
			memId=sc.next();
			count=getMemberIdCount(memId);
			if(count!=0) {
				System.out.println("ID가 중복되었습니다.");
				System.out.println("다시 입력해주세요.");
			}
			else break;
		}while(count>0);
		
		System.out.print("비밀번호>>> ");
		String pass=sc.next();
		
		System.out.print("회원이름>>> ");
		String name=sc.next();
		
		System.out.print("전화번호>>> ");
		String tel=sc.next();
		
		sc.nextLine(); //입력버퍼지우기
		System.out.print("회원주소>>> ");
		String addr=sc.nextLine();
		
		try {
			conn=DBUtil.getConnection2();
			
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
	                  +"values(?, ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,memId);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
			pstmt.setString(4,tel);
			pstmt.setString(5,addr);
			
			int cnt=pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(memId+" 회원정보 추가 완료!!!");
			}
			else System.out.println(memId+" 회원정보 추가 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	} 
	//회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberIdCount(String memId) {
		int count=0;
		
		try {
			conn=DBUtil.getConnection2();
			String sql="select count(*) cnt from mymember where mem_id = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return count;
	}
	//회원정보 삭제
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원ID>>>");
		String id=sc.next();
		
		try {
			conn=DBUtil.getConnection2();
			String sql="delete from mymember where mem_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int cnt=pstmt.executeUpdate();
			if(cnt>0) System.out.println("회원정보 삭제완료");
			else System.out.println("회원정보가 존재하지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//회원정보 수정
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원정보를 입력하세요. ");
		  
		System.out.print("회원ID >> ");
		String id = sc.next();
		  
		int count = getMemberIdCount(id);
		  
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
		  
		try {
		   conn = DBUtil.getConnection2();
		     
		   String sql = " update mymember set "
		     +" mem_pass =?, mem_name = ?, mem_tel =?, mem_addr =? "
		     +" where mem_id =? ";
		         
		       pstmt = conn.prepareStatement(sql);
		       pstmt.setString(1, newPass);
		       pstmt.setString(2, newName);
		       pstmt.setString(3, newTel);
		       pstmt.setString(4, newAddr);
		       pstmt.setString(5, id);  
		       int cnt=pstmt.executeUpdate();
		       if(cnt>0) {
		    	   System.out.println(id+" 회원정보 수정 완료!!!");
		       }
		       else System.out.println(id+" 회원정보 수정 실패");
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }finally {
			 disConnect();
		 }
    }
	//원하는 항목만 수정하는 메서드
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원정보를 입력하세요. ");
		  
		System.out.print("회원ID >> ");
		String id = sc.next();
		  
		int count = getMemberIdCount(id);
		  
		if(count==0) {      //없는 회원이면....
			System.out.println(id + "은(는) 없는 회원ID입니다. ");
			System.out.println("수정 작업을 종료합니다. ");
		    return;
		}
		
		System.out.println();
		System.out.println("====================================================");
		System.out.println("1. 회원비밀번호 수정");
		System.out.println("2. 회원이름 수정");
		System.out.println("3. 회원전화번호 수정");
		System.out.println("4. 회원주소 수정");
		System.out.println("====================================================");
		System.out.print("원하는 수정작업을 선택해주세요>> ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			System.out.print("새로운 비밀번호 >>");
			String newPass = sc.next();
			try {
				   conn = DBUtil.getConnection2();
				     
				   String sql = " update mymember set mem_pass =? where mem_id =? ";
			       pstmt = conn.prepareStatement(sql);
			       pstmt.setString(1, newPass);
			       pstmt.setString(2, id);  
			       int cnt=pstmt.executeUpdate();
			       if(cnt>0) {
			    	   System.out.println(id+" 회원정보 수정 완료!!!");
			       }
			       else System.out.println(id+" 회원정보 수정 실패");
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }finally {
					 disConnect();
				 }
			break;
		case 2:
			System.out.print("새로운 회원이름 >>");
			String newName = sc.next();
			try {
				   conn = DBUtil.getConnection2();
	
				   String sql = " update mymember set mem_name =? where mem_id =? ";
			       pstmt = conn.prepareStatement(sql);
			       pstmt.setString(1, newName);
			       pstmt.setString(2, id); 
			       int cnt=pstmt.executeUpdate();
			       if(cnt>0) {
			    	   System.out.println(id+" 회원정보 수정 완료!!!");
			       }
			       else System.out.println(id+" 회원정보 수정 실패");
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }finally {
					 disConnect();
				 }
			break;
		case 3:
			System.out.print("새로운 전화번호 >>");
			String newTel = sc.next();
			try {
				   conn = DBUtil.getConnection2();
				     
				   String sql = " update mymember set mem_tel =? where mem_id =? ";
			       pstmt = conn.prepareStatement(sql);
			       pstmt.setString(1, newTel);
			       pstmt.setString(2, id);  
			       int cnt=pstmt.executeUpdate();
			       if(cnt>0) {
			    	   System.out.println(id+" 회원정보 수정 완료!!!");
			       }
			       else System.out.println(id+" 회원정보 수정 실패");
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }finally {
					 disConnect();
				 }
			break;
		case 4:
			sc.nextLine();         //입력 버퍼 비우기
			System.out.print("새로운 회원주소 >>");
			String newAddr = sc.nextLine();
			try {
				   conn = DBUtil.getConnection2();
				     
				   String sql = " update mymember set mem_addr =? where mem_id =? ";
			       pstmt = conn.prepareStatement(sql);
			       pstmt.setString(1, newAddr);
			       pstmt.setString(2, id);   
			       int cnt=pstmt.executeUpdate();
			       if(cnt>0) {
			    	   System.out.println(id+" 회원정보 수정 완료!!!");
			       }
			       else System.out.println(id+" 회원정보 수정 실패");
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }finally {
					 disConnect();
				 }
			break;
		default:
			System.out.println("올바른 작업을 선택해주세요.");
			break;
		}
		
	}
	
	//전체 회원 정보를 출력하는 메서드
	private void displayMember() {
		System.out.println();
		System.out.println("====================================================");
		System.out.println(" ID	비밀번호		이름	전화전호		주소");
		System.out.println("====================================================");
		try {
//			conn=DBUtil.getConnection2();
//			conn=DBUtil2.getConnection2();
			conn=DBUtil3.getConnection2();
			String sql="select* from mymember";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("mem_id");
				String pass=rs.getString("mem_pass");
				String name=rs.getString("mem_name"); 
				String tel=rs.getString("mem_tel");
				String addr=rs.getString("mem_addr");
				
				System.out.println(id+"\t"+pass+"\t"+name+"\t"+tel+"\t"+addr);
			}
			System.out.println("================================================");
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	//메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("           회원 관리 프로그램");
		System.out.println("====================================");
		System.out.println("1. 자료추가");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 자료부분수정");
		System.out.println("5. 자료출력");
		System.out.println("0. 작업 끝");
		System.out.println("====================================");
		System.out.print("원하는 작업 선택>>>");
		return sc.nextInt();
	}

}
