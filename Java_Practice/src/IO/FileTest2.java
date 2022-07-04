package IO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileTest2 {

	public static void main(String[] args) {
		File f1=new File("D:\\D_Other\\Text\\test1.txt");
		System.out.println(f1.getName()+"의 크기: "+f1.length());
		System.out.println("path: "+f1.getPath());
		System.out.println("absolutePath: "+f1.getAbsolutePath());
		System.out.println();
		
		//자바 프로그램의 실행 위치 구하기
		//방법1-> File객체 이용하기(상대경로를 절대경로로 변환하기)
		File f2=new File(".");
		System.out.println("path: "+f2.getPath());
		System.out.println("absolutePath: "+f2.getAbsolutePath());
		
		//방법2->Path객체 이용하기(상대경로를 절대경로로 변환)
		Path myPath=Paths.get("");
		System.out.println("absolutePath: "+myPath.toAbsolutePath());
		
		// 방법3 => System.getProperty("user.dir") 명령 이용하기
		System.out.println("System 객체 absolutePath : "+System.getProperty("user.dir"));
		System.out.println();
		
		FileTest2 test=new FileTest2();
		test.displayFileList(f2);
		
		
	}
	//디렉토리(폴더)를 인수값으로 받아서 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 출력하는 메서드
	public void displayFileList(File dir) {
		//인수값으로 넘어론 값이 디렉토리 정보인지 확인
		if(!dir.isDirectory()) {
			System.err.println("디렉토리(폴더)만 가능합니다.");
			return;
		}
		System.out.println("["+dir.getAbsolutePath()+"]디렉토리 내용");
		
		//해당 디렉토리 아넹 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files=dir.listFiles();
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복
		for(File f: files) {
			String fileName=f.getName();
			String attr="";//파일 속성을 나타내는 변수(읽기, 쓰기, 히든, 디렉토리)
			String size=""; //파일크기
			
			if(f.isDirectory()) attr="<DIR>";
			else {
				size=f.length()+"";
				attr=f.canRead() ? "R":"";
				attr+=f.canWrite() ? "W":"";
				attr+=f.isHidden() ? "H":"";
			}
			System.out.printf("%s %5s %12s %s\n", df.format(new Date(f.lastModified())), attr, size, fileName);
		}
	}

}
