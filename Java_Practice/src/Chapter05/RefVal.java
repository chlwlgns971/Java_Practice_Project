package Chapter05;

import java.util.Arrays;

/*
참조형변수: 주소를 저장하고 있는 변수 ->배열, 객체 잠조변수, 열거형, 인터페이스
	==, != 연산자는 참조형 변수에 저장된 값(주소)를 비교
	내용비교는 equals()를 사용
*/
/*
Chapter05 배열
	-동일타입의 데이터를 연속된 기억공간에 저장하고 일괄적인 처리를 수행 할 수 있는 기억공간
	-선언->초기화->사용
	-선언된 배열의 크기는 늘리거나 줄일 수 없다.
배열선언
	-타입[] 배열명;
	-타입[] 배열명=new 타입명[크키];
	-타입[] 배열명={값1,값2....};
*/

public class RefVal {

	public static void main(String[] args) {
		TestArrays ta=new TestArrays();
		ta.lotto();
		ta.sampleArray();
	}

}
class TestArrays{
	public void sampleArray(){
		int[] num=new int[5];
		String[] name=new String[5];
		name[0]="홍길동";
		name[1]="홍길순";
		name[2]="강감찬";
		name[3]="이성계";
		name[4]="조현우";
		num[0]=90;
		num[1]=80;
		num[2]=70;
		num[3]=60;
		num[4]=40;
		for(int i=0; i<name.length; i++){
			System.out.println(name[i]+"의 점수는 "+num[i]+"입니다.");
		}
	}
	public void lotto(){ //가끔 중복 나옴. 해결 필요
		int[] num=new int[6];
		int rand=0;
		for(int i=0; i<num.length; i++){
			rand=(int)(Math.random()*45+1);
			if (i==0) num[i]=rand;
			else{
				for(int j=0; j<i; j++){
					if(rand==num[j]) i--;
				}
			}
			num[i]=rand;
		}
		Arrays.sort(num); //정렬
		System.out.println("로또번호 "+Arrays.toString(num));
	}
}