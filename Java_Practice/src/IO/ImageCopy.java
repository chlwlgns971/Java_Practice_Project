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
		File img=new File("d:/d_other/images/펭귄.jpg");
		if(!img.exists()) {
			System.out.println(img.getName()+"파일이 없습니다.");
		}
		else {
			try {
				byte[] arr=new byte[(int)img.length()];
				DataInputStream inS=new DataInputStream(new FileInputStream(img));
				FileOutputStream outS=new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
				//방법1
//				for(int i=0; i<img.length(); i++) {
//					arr[i]=(byte)inS.read();
//				}
//				outS.write(arr);
				
				//방법2
//				int data;
//				while((data=inS.read())!=-1) {
//					outS.write(data);
//				}
				
				//방법3
				int len=0;
				while((len=inS.read(arr))>0) {
					outS.write(arr,0,len);
				}
//				int len=0;
//				len=inS.read(arr);
//				outS.write(arr,0,len);
				
				outS.flush();
				
				inS.close();
				outS.close();
				System.out.println("복사완료!");
			} catch (IOException e) {
				// TODO: handle exception
			}

		}	
	}

}