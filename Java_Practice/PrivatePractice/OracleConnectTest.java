import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OracleConnectTest {
	public static void main(String[] args) {
		//드라이버 검색 (db와 연동 준비)
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ddit";
		String password = "java";
		Connection conn=null;
		Statement stat = null;
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//쿼리 작성
			String str="a001";
			ResultSet rs = stat.executeQuery("SELECT* FROM MEMBER WHERE MEM_ID='"+str+"'");
			//ResultSet rs = stat.executeQuery("SELECT* FROM MEMBER");
			//column갯수 구하기
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			//row갯수 구하기
//			int rowcount = 0;
//			rs.first();
//			if (rs.last()) {
//			  rowcount = rs.getRow();
//			  rs.beforeFirst(); 
//			}
//			System.out.println(rowcount);
			while (rs.next()) {
				//속성명을 입력해야지 출력가능 -> 검색할 select문을 선택문으로 만들고 선택한 속성은 문자화해서 출력하는걸로 해야함.
//				System.out.print(rs.getString("MEM_ID"));
//				System.out.print(" ");
//				System.out.print(rs.getString("MEM_NAME"));
//				System.out.print(" ");
//				System.out.print(rs.getString("MEM_ADD1"));
//				System.out.print(" ");
//				System.out.print(rs.getString("MEM_JOB"));
//				System.out.println();
				
                //인덱스로도 접근가능. 가독성엔 취약.
				for(int i=1; i<=columnCount; i++) {
					System.out.print(rs.getString(i));
					System.out.print(" ");
				}
				System.out.println();
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
			}
			rs.close();  //커서 닫기
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		} 
	}
}
