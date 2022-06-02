package Chapter11;

import java.util.Arrays;

public class ArrayCopyEx {

	public static void main(String[] args) {
		char[] src=new char[] {'k','o','r','e','a','s','e','o','u','l'};
		char[] tar=new char[src.length];
		char[] dest=new char[8];
		
		//깊은복사-배열 공간을 별도로 확보(별도의 배열 생성)한 후 내용을 copy
		for(int i=0; i<src.length; i++) {
			tar[i]=src[i];
		}
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(tar));
		
		System.arraycopy(src, 2, dest, 0, dest.length);
		System.out.println(Arrays.toString(dest));
		
		char[] ch;
		ch=dest;
		System.out.println("ch: "+ch);
		System.out.println("dest: "+dest);
	}

}
