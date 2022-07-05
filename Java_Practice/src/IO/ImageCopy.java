package IO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageCopy {
	
	/*
	 문제) 'd:/d_other'폴더에 저장되어 있는 '펭귄.jpg'파일을 'd:/d_other/연습용' 폴더에 
	 '복사본_펭귄.jpg'파일로 복사하는 프로그램을 작성하시오
	 */
	public static void main(String[] args) {
		try {
			File img=new File("d:/d_other/images/펭귄.jpg");
			byte[] arr=new byte[(int)img.length()];
			DataInputStream inS=new DataInputStream(new FileInputStream(img));
			int c; //읽어온 데이터를 저장할 변수
			for(int i=0; i<img.length(); i++) {
				c=inS.read();
				arr[i]=(byte) c;
			}
			inS.close();
			
			FileOutputStream outS=new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			outS.write(arr);
			outS.close();
			System.out.println("복사완료!");
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}