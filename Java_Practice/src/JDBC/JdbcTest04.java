package JDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","testID","java");
			System.out.println("드라이버 로딩성공");
			
			System.out.println("계좌번호 정보 추가하기");
			System.out.println("계좌번호: ");
			String bankNo=sc.next();
			
			System.out.println("은행이름: ");
			String bankName=sc.next();
			
			System.out.println("예금주명 : ");
	        String bankUser = sc.next();
	        
//	        //Statement객체를 이용하여 데이터 추가하기
//	        String sql="insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date) "
//	        		+"values('"+bankNo+"','"+bankName+"','"+bankUser+"', sysdate)";
//	        System.out.println("SQL=>"+sql);
//	        
//	        stmt=conn.createStatement();
	        
	     	//쿼리문을 실행할 떄 쿼리문이 SELECT문일 경우에는 executeQuery()메서드를 사용하고, SELECT문이 아닐때는 executeUpdate()메서드를 사용한다.
	        //executeUpdate()메서드는 작업에 성공한 레코드 수를 반환한다.
	        //int cnt=stmt.executeUpdate(sql);
	        
	        //쿼리문에서 데이터가 들어갈 자리를 물음표(?)로 표시해서 작성한다.
	        String sql="insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date) "
	        		+"values(?, ?, ?, sysdate)";
	        
	        //PreparedStatement객체 생성-> 이 때 사용할 쿼리문을 인수값으로 넘겨준다.
	        pstmt=conn.prepareStatement(sql);
	        
	        //쿼리문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
	        //형식) pstmt.set자료형이름(물음표순번, 셋팅할 데이터); ->물음표 번호는 1번부터 시작
	        pstmt.setString(1, bankNo);
	        pstmt.setString(2, bankName);
	        pstmt.setString(3, bankUser);
	        
	        //쿼리문을 실행할 떄 쿼리문이 SELECT문일 경우에는 executeQuery()메서드를 사용하고, SELECT문이 아닐때는 executeUpdate()메서드를 사용한다.
	        //executeUpdate()메서드는 작업에 성공한 레코드 수를 반환한다.
	        int cnt=pstmt.executeUpdate();
	        
	        System.out.println("반환값: "+cnt);
	        

		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
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
