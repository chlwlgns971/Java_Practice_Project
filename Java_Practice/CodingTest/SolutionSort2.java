/*프로그래머스 정렬 level2 가장 큰 수
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.*/
import java.util.Arrays;


public class SolutionSort2 {

	public static void main(String[] args) {
		Swap sw=new Swap();
		String answer = "";
		int[] numbers={978,97};
		int[] remains=new int[numbers.length];
        int index=0;
        int max=0;
        int sum=0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]<10) remains[i]=numbers[i];
            else if(numbers[i]<100) remains[i]=numbers[i]/10;
            else if(numbers[i]<1000) remains[i]=numbers[i]/100;
            else if(numbers[i]==1000) remains[i]=1;
            else remains[i]=0;
        }
        for(int i=0; i<numbers.length; i++){
            max=remains[i];
            index=i;
            for(int j=i+1; j<numbers.length;j++){
                if(max<remains[j]){
                    max=remains[j];
                    index=j;
                }
                else if(max==remains[j]){
                    if(numbers[index]%10<numbers[j]%10){
                        max=remains[j];
                        index=j;
                    }
                    else if(numbers[index]%10==numbers[j]%10){
                        if(numbers[index]>numbers[j]){
                            max=remains[j];
                            index=j;
                        }
                    }
                }
            }
            sw.swap(numbers, i, index);
            sw.swap(remains, i, index);
        }
        for(int i=0; i<numbers.length; i++){
        	sum+=numbers[i];
        }
        if(sum==0) answer="0";
        else{
        	for(int i=0; i<numbers.length; i++){
                answer+=Integer.toString(numbers[i]);
            }
        }
        
        System.out.println(answer);

	}

}
class Swap{
	public int[] swap(int[] arr, int a, int b){
		int num=0;
		num=arr[a];
		arr[a]=arr[b];
		arr[b]=num;
		return arr;
	}
}