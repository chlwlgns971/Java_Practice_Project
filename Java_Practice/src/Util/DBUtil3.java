package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

//dbInfo.properties파일의 내용을 이용하여 셋팅하는 방법

//방법2) ResourceBundle객체 이용하기

public class DBUtil3 {
	static Logger logger=Logger.getLogger(DBUtil3.class);
	static ResourceBundle bundle;
	
	//static 초기화 블럭
	static {
		bundle=ResourceBundle.getBundle("config.dbInfo");
		logger.info("ResourceBundle객체 생성-dbinfo.properties 파일읽기");
		
		try {
			Class.forName(bundle.getString("driver"));
			logger.info("DB 드라이버 로딩 성공");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			logger.error("드라이버 로딩 실패!!-"+e);
		}
	}
	
	public static Connection getConnection1(){
		try {
			return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
	public static Connection getConnection2(){
		try {
			return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user2"),bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
