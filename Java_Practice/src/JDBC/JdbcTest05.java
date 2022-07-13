package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.DBUtil;

public class JdbcTest05 {

	public static void main(String[] args) {
		/*
		 LPROD테이블에 새로운 데이터를 추가하기
		 	-lprod_gu와 lprod_nm은 직접 입력 받아서 처리하고, lprod_id는 현재의 lprod_id중 제일 큰 값보다 1 크게해서 처리한다.
		 	-그리고 입력받은 lprod_gu가 이미 등록되어 있는 데이터면 다시 입력 받아서 처리한다.
		 */
		Scanner sc=new Scanner(System.in);
		
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ddit","java");
			conn=DBUtil.getConnection1();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String gu="";
			while(true) {
				System.out.println("lprod_gu를 입력하세요");
				gu=sc.next();
				String count="";
				rs=stmt.executeQuery("SELECT COUNT(LPROD_GU) FROM LPROD WHERE LPROD_GU='"+gu+"'");
				while(rs.next()) {
					count=rs.getString(1);
				}
				if(count.equals("0")) break;
				else {
					System.out.println("중복된 값입니다. 다른 값을 입력해주세요.");
					continue;
				}
			}
			System.out.println("lprod_nm을 입력하세요");
			String nm=sc.next();
			
			String sql="insert into lprod values((select max(lprod_id) from lprod)+1 , ?, ?)";
			//PreparedStatement객체 생성-> 이 때 사용할 쿼리문을 인수값으로 넘겨준다.
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, gu);
	        pstmt.setString(2, nm);
	        
	        int cnt=pstmt.executeUpdate();
	        System.out.println("반환값: "+cnt);
	        
	        rs=stmt.executeQuery("SELECT* FROM LPROD");
	        while(rs.next()) {
				//포인터가 가리키는 곳의 자료를 가져오는 방법
				//형식1)rs.get자료형이름("컬럼명" 또는 "alias명");
				//형식2)rs.get자료형이름(컬럼번호); ->컬럼번호는 1부터 시작
				System.out.println("Lprod_id: "+rs.getInt("lprod_id"));
				System.out.println("Lprod_gu: "+rs.getString(2));
				System.out.println("Lprod_nm: "+rs.getString(3));
				System.out.println("=======================================");
			}
	        
		}catch (SQLException e) {
			e.printStackTrace();
		} 
//		catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		finally {
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

	}

}
