package Chapter05;

import java.util.Arrays;
import java.util.Scanner;

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

public class Array {

	public static void main(String[] args) {
		TestArrays ta=new TestArrays();
		//ta.lotto();
		//ta.sampleArray();
		//ta.integerArr(); //입력값의 합과 평균 구하기
		//ta.evenOddDetect(); //짝수 홀수 구하기
		//ta.minMaxDetect(); //최대최소구하기
		//ta.sortArr1(); //오름차순 정렬
		ta.sortArr2(); //내림차순 정렬
		ta.bubbleSort(); //버블정렬 
	}

}
class TestArrays{
	Scanner sc=new Scanner(System.in);
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
	public void lotto(){ //가끔 중복 나옴. 해결 필요->05.13 해결
		int[] num=new int[6];
		int rand=0;
		for(int i=0; i<num.length; i++){
			rand=(int)(Math.random()*45+1);
			if (i==0) num[i]=rand;
			else{
				for(int j=0; j<i; j++){
					if(rand==num[j]){
						i--;
						break;
					}
					else if(j==(i-1)) num[i]=rand;
				}
			}
		}
		Arrays.sort(num); //정렬
		System.out.println("로또번호 "+Arrays.toString(num));
	}
	public void integerArr(){ //정수 10개를 입력받아 합과 평균 구하기
		int[] intArr1=new int[10];
		int sum=0;
		for(int i=0; i<intArr1.length; i++){
			System.out.print("정수를 입력하세요: ");
			intArr1[i]=sc.nextInt();
			sum+=intArr1[i];
		}
		for(int su:intArr1) System.out.print(su+","); //강화for문. 타입변수:배열명 형식으로 사용하고 배열 데이터값을 모두 꺼내준다.
		System.out.println("\n"+Arrays.toString(intArr1));
		System.out.println("입력받은 정수들의 합은 "+sum+"입니다.");
		System.out.println("입력받은 정수들의 평균은 "+((double)sum/intArr1.length)+"입니다.");
		
	}
	public void evenOddDetect(){ //문제2 배열의 크기가 10인 정수형 배열을 만들고 키보드로 값을 입력받아 홀수와 짝수의 갯수를 출력하시오.
		int[] intArr=new int[10];
		int odd=0; //홀수
		int even=0; //짝수
		for(int i=0; i<intArr.length; i++){
			System.out.print("정수를 입력하세요: ");
			intArr[i]=sc.nextInt();
			if(intArr[i]%2==0) even+=1;
			else odd+=1;
		}
		System.out.println("짝수의 갯수: "+even);
		System.out.println("홀수의 갯수: "+odd);
	}
	public void minMaxDetect(){ //문제3: 배열의 크기가 10인 정수형 배열을 만들고 값을 입력받아 최댓값과 최솟값을 출력하시오.
		int[] intArr=new int[10];
		int min=0;
		int max=0;
		for(int i=0; i<intArr.length; i++){
			System.out.print("정수를 입력하세요: ");
			intArr[i]=sc.nextInt();
		}
		min=intArr[0];
		for(int i=0; i<intArr.length; i++){
			if(intArr[i]<min) min=intArr[i];
			if(intArr[i]>max) max=intArr[i];
		}
		System.out.println("최댓값: "+max);
		System.out.println("최솟값: "+min);
	}
	public void sortArr1(){ //문제4: 배열의 크기가 10인 정수형 배열을 만들고 값을 입력받아 정렬하시오.(오름차순 정렬)
		int[] intArr=new int[10];
		int min=0;
		int index=0; //교체할 인덱스값
		for(int i=0; i<intArr.length; i++){
			System.out.print("정수를 입력하세요: ");
			intArr[i]=sc.nextInt();
		}
		for(int i=0; i<intArr.length; i++){
			min=intArr[i];
			for(int j=i; j<intArr.length; j++){
				if (intArr[j]<=min) {
					min=intArr[j];
					index=j;
				}
			}
			//배열값 교체
			swap(intArr,i,index);
			
		}
		System.out.println("오름차순 선택정렬 결과: "+Arrays.toString(intArr));
	}
	public void sortArr2(){ //문제4: 배열의 크기가 10인 정수형 배열을 만들고 값을 입력받아 정렬하시오.(내림차순 정렬)
		int[] intArr=new int[10];
		int max=0;
		int index=0; //교체할 인덱스값
		for(int i=0; i<intArr.length; i++){
			System.out.print("정수를 입력하세요: ");
			intArr[i]=sc.nextInt();
		}
		for(int i=0; i<intArr.length; i++){
			max=intArr[i];
			for(int j=i; j<intArr.length; j++){
				if (intArr[j]>=max) {
					max=intArr[j];
					index=j;
				}
			}
			//배열값 교체
			swap(intArr,i,index);
		}
		System.out.println("내림차순 선택정렬 결과: "+Arrays.toString(intArr));
	}
	public void bubbleSort(){
		int[] num=new int[7];
		for(int i=0; i<num.length; i++){
			System.out.print("정수를 입력하세요: ");
			num[i]=sc.nextInt();
		}
		for(int i=1; i<num.length; i++){
			for(int j=0; j<num.length-1; j++){
				if(num[j]>num[j+1]) {
					//배열값 교체 
					swap(num,j,j+1);
				}
			}
		}
		System.out.println("버블정렬 결과: "+Arrays.toString(num));
	}
	public int[] swap(int[] arr,int i, int j){ //배열값 교체 메소드
		int a=0; //임시저장공간
		a=arr[i];
		arr[i]=arr[j];
		arr[j]=a;
		return arr;
	}
}