package IBatis;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIBatisTest {

	public static void main(String[] args) {
		/*
		 IBatis란?
		 	-Java에서 DB를 편하게 핸들링할 수 있게 해주는 프레임워크
		 	-SQL문과 Java코드를 분리하고, 파라미터값만 변경되지 않으면,
			-Java소스 변경없이 SQL문만 변경해서 사용할 수 있다.
			-iBatis 데이터매퍼 API를 이용해서 자바빈즈(보통VO객체) 혹은 Map객체를 PreparedStatement의 파라미터에 매핑해 주고, SQL문의 실행 결과를
				자바빈즈 혹은 Map객체에 자동으로 매핑해 준다.
		 */
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
			
			//2.실행할 SQL문이 작성된 태그를 호출해서 실행하기
			
			//2-1. insert연습
//			System.out.println("insert 작업 시작...");
//			System.out.print("Lprod_id입력>>");
//			int lprodID=sc.nextInt();
//			
//			System.out.print("Lprod_gu입력>>");
//			String lprodGu=sc.next();
//			
//			System.out.print("Lprod_nm입력>>");
//			String lprodNm=sc.next();
//			
//			//inert할 데이터를 VO객체에 저장한다.
//			LprodVO lvo=new LprodVO();
//			lvo.setLplod_id(lprodID);
//			lvo.setLplod_gu(lprodGu);
//			lvo.setLprod_nm(lprodNm);
//			
//			//SqlMapClient객체를 이용하여 처리할 쿼리문을 호출해서 실행
//			//형식) SqlMapClient객체변수.insert("namespace속성값.id속성값",파라미터클래스);반환값=> insert 성공: null, 실패: 오류객체 
//			Object obj=smc.insert("Lprod.insertLprod",lvo);
//			
//			if(obj==null) {
//				System.out.println("insert 작업성공");
//			}
//			else {
//				System.out.println("insert 작업실패");
//			}
//			System.out.println("========================================================================");
			
			//2-2. update연습
//			System.out.println("update 시작...");
//			System.out.print("수정할 lprod_gu입력>>");
//			String lgu=sc.next();
//			
//			System.out.print("새로운 lprod_id입력>>");
//			int lid=sc.nextInt();
//			
//			System.out.print("새로운 lprod_nm입력>>");
//			String lnm=sc.next();
//			
//			//입력받은 데이터를 VO에 저장한다.
//			LprodVO lvo2=new LprodVO();
//			lvo2.setLplod_id(lid);
//			lvo2.setLplod_gu(lgu);
//			lvo2.setLprod_nm(lnm);
//			
//			//update실행
//			//형식) sqlMapClient객체변수.update("namespace속성값.id속성값",파라미터클래스) 반환값: 작업에 성공한 레코드 수
//			int cnt=smc.update("Lprod.updateLprod",lvo2);
//			if(cnt>0) System.out.println("작업성공");
//			else System.out.println("작업실패");
//			System.out.println("========================================================================");
			
			//2-3 delete연습
//			System.out.println("delete 시작..");
//			System.out.print("삭제할 lprod_gu입력>>");
//			String lgu=sc.next();
//			
//			//delete실행
//			//형식) sqlMapClient객체변수.delete("namespace속성값.id속성값",파라미터클래스) 반환값: 작업에 성공한 레코드 수
//			int cnt2=smc.delete("Lprod.deleteLprod",lgu);
//			if(cnt2>0) System.out.println("작업성공");
//			else System.out.println("작업실패");
//			System.out.println("========================================================================");
			
			//2-4 select연습
			//1) select의 결과가 여러개인 경우
			System.out.println("select 시작...(결과가 여러개일 경우)");
			
			//select의 결과가 여러개인 경우에는 queryForList()메서드를 사용하는데, 
			//	이 메서드는 여러개의 레코드 각각을 VO에 담은 후 이 VO데이터들을 List에 추가해 주는 작업을 자동으로수행한다.
			//형식) sqlMapClient객체변수.queryForList("namespace속성값.id속성값",파라미터클래스)
			List<LprodVO> lprodList= smc.queryForList("Lprod.getAllLprod");
			
			for(LprodVO lvo3: lprodList) {
				System.out.println("ID: "+lvo3.getLprod_id());
				System.out.println("GU: "+lvo3.getLprod_gu());
				System.out.println("NM: "+lvo3.getLprod_nm());
				System.out.println("---------------------------");
			}
			System.out.println("========================================================================");
			// 2) select의 결과가 1개의 레코드일 경우
	         System.out.println("select 시작 (결과가 1개일 경우...)");
	         System.out.print("검색할 Lprod_gu 입력 : ");
	         String lgu3 = sc.next();
	         
	         // select한 결과가 1개가 확실할 경우에는 queryForObject()메서드를 사용한다.
	         // 형식) sqlMapClient객체변수.queryForObject("namespace속성값.id속성값", 파라미터클래스)
	         //   반환값 : 처리 결과가 1개일 경우(정상) ==> 해당 객체 반환
	         //         처리 결과가 여러개일 경우 ==> Exception 객체 반환
	         //         처리 결과가 없을 경우 ==> null 반환
	         
	         LprodVO lvo4 = (LprodVO)smc.queryForObject("Lprod.getLprod", lgu3); 
	         // Object로 담겨서 오기 때문에 형변환이 필요하다.
	         // 형변환 하지않으면 오류가 뜬다.
	         
	         if(lvo4==null) {
	            System.out.println("검색 결과가 하나도 없습니다...");
	            return;
	         }
	         
	         System.out.println("...검색 결과...");
	         System.out.println("ID : " + lvo4.getLprod_id());
	         System.out.println("GU : " + lvo4.getLprod_gu());
	         System.out.println("NM : " + lvo4.getLprod_nm());
	         System.out.println("--------------------------");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
