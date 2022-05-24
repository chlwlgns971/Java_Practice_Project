/*���α׷��ӽ� ���� level2 ���� ū ��
0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.

0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.*/
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