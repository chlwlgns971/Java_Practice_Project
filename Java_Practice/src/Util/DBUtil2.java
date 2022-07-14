package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//dbInfo.properties파일의 내용을 이용하여 셋팅하는 방법

//방법1) Properties객체 이용하기

public class DBUtil2 {
	static Properties prop;
	
	//static 초기화 블럭
	static {
		prop=new Properties();
		
		File f=new File("res/config/dbInfo.properties");
		FileInputStream fin=null;
		try {
			fin=new FileInputStream(f); //입력 스트림 객체 생성
			
			prop.load(fin); //파일 읽어서 Properties객체에 추가하기
			
			Class.forName(prop.getProperty("driver"));
		}catch(IOException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}finally {
			if(fin!=null) try { fin.close(); } catch(IOException e) {}
		}
	}
	
	public static Connection getConnection1(){
		try {
			return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
	public static Connection getConnection2(){
		try {
			return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user2"),prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
