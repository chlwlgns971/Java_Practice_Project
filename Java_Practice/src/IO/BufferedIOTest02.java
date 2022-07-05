package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자기반의 Buffered 스트림 사용 예제
		 try {
			FileReader fr=new FileReader(".\\src\\IO\\FileTest1.java");
			BufferedReader br=new BufferedReader(fr);
			
			String temp="";
//			for(int i=1;(temp=br.readLine())!=null; i++) {
//				System.out.printf("%4d: %s\n",i,temp);
//			}
			int i=1;
			while((temp=br.readLine())!=null) {
				System.out.printf("%4d: %s\n",i,temp);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
