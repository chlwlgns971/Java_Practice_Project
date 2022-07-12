package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest03 {

	public static void main(String[] args) {
		// 문제) LPROD_ID값을 2개 입력받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB연결->Connection객체 생성
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ddit","java");
			
			//3. 쿼리문 작성
			System.out.print("1번째 LPROD_ID를 입력>>>");
			int id1=sc.nextInt();
			System.out.print("2번째 LPROD_ID를 입력>>>");
			int id2=sc.nextInt();
			String sql="";
			if(id1==id2) sql="select* from lprod where lprod_id="+id1;
			else if(id1>id2) sql="select* from lprod where lprod_id>="+id2+" and lprod_id<="+id1;
			else sql="select* from lprod where lprod_id>="+id1+" and lprod_id<="+id2;
			
			
			//4. 질의
			//4-1. Statement객체 또는 PrepareStatement객체 생성
			stmt=conn.createStatement(); //Statement객체 생성하기
			
			//4-2. 쿼리문을 DB서버로 보내서 결과를 얻어온다.(실행할 쿼리문이 select문이기 떄문에 결과가 ResultSet객체에 저장되어 반환된다.
			rs=stmt.executeQuery(sql);
			
			//5. 결과 처리하기 -> select한 결과를 한 레코드씩 화면에 출력하기(반복문과 next()메서드를 이용해서 처리한다.)
			System.out.println("===쿼리문 처리 결과===");
			
			//rs.next()->ResultSet객체의 데이터를 가리키는 포인터를 다은번쨰 레코드 위치로 이동시키고 그 곳에 데이터가 있으면 true반환
			while(rs.next()) {
				//포인터가 가리키는 곳의 자료를 가져오는 방법
				//형식1)rs.get자료형이름("컬럼명" 또는 "alias명");
				//형식2)rs.get자료형이름(컬럼번호); ->컬럼번호는 1부터 시작
				System.out.println("Lprod_id: "+rs.getInt("lprod_id"));
				System.out.println("Lprod_gu: "+rs.getString(2));
				System.out.println("Lprod_nm: "+rs.getString(3));
				System.out.println("=======================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
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
