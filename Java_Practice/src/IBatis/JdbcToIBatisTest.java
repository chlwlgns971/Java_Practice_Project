package IBatis;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

//jdbcTest프로젝트에 있는 JdbcTest05.java를 IBatis로 처리되도록 하시오
public class JdbcToIBatisTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			//1. IBatis의 환경설정파일(sqlMapConfig.xml)을 읽어와서 포기화 작업을 진행한다.
			
			//1-1 문자인코딩 캐릭터셋 설정
			Charset charset=Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			//1-2 환경설정 파일을 읽어올 스트림 객체 생성
			Reader rd=Resources.getResourceAsReader("config/sqlMapConfig.xml");
			
			//1-3. 위에서 생성한 스트림 객체를 이용하여 환경설정 파일을 읽어와 실행 시켜 환경설정을 완성한 후, SQL문을 호출해서 실행
			SqlMapClient smc=SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close(); //스트림 닫기
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
