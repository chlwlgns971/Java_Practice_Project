package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// properties파일의 내용을 읽어와 화면에 출력하기
		
		//읽어온 정보를 저장할 Properties객체 생성
		Properties prop=new Properties();
		
		//읽어올 파일명을 이용한 FIle객체 생성
		File f=new File("res/config/dbInfo.properties");
		if(!f.exists()) {
			System.out.println("파일이 없습니다.");
			return;
		}
		
		//파일 입력용 스트림 객체 변수 선언
		FileInputStream fin=null;
	
		try {
			//파일 내용을 읽어올 스트림 객체 생성
			fin=new FileInputStream(f);
			
			//위에서 생성한 입력용 스트림을 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
			
			//파일 내용을 읽어와 value값으로 분류한 후 Properties객체에 추가한다.
			prop.load(fin);
			
			//읽어온 정보 출력하기
			System.out.println("driver: "+prop.getProperty("driver"));
			System.out.println("url: "+prop.getProperty("url"));
			System.out.println("user: "+prop.getProperty("user"));
			System.out.println("user2: "+prop.getProperty("user2"));
			System.out.println("pass: "+prop.getProperty("pass"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fin!=null) try { fin.close(); } catch(IOException e) {}
		}

	}

}
