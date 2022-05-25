<<<<<<< HEAD
/*í”„ë¡œê·¸ëž˜ë¨¸ìŠ¤ ì •ë ¬ level2 ê°€ìž¥ í° ìˆ˜
0 ë˜ëŠ” ì–‘ì˜ ì •ìˆ˜ê°€ ì£¼ì–´ì¡Œì„ ë•Œ, ì •ìˆ˜ë¥¼ ì´ì–´ ë¶™ì—¬ ë§Œë“¤ ìˆ˜ ìžˆëŠ” ê°€ìž¥ í° ìˆ˜ë¥¼ ì•Œì•„ë‚´ ì£¼ì„¸ìš”.

ì˜ˆë¥¼ ë“¤ì–´, ì£¼ì–´ì§„ ì •ìˆ˜ê°€ [6, 10, 2]ë¼ë©´ [6102, 6210, 1062, 1026, 2610, 2106]ë¥¼ ë§Œë“¤ ìˆ˜ ìžˆê³ , ì´ì¤‘ ê°€ìž¥ í° ìˆ˜ëŠ” 6210ìž…ë‹ˆë‹¤.

0 ë˜ëŠ” ì–‘ì˜ ì •ìˆ˜ê°€ ë‹´ê¸´ ë°°ì—´ numbersê°€ ë§¤ê°œë³€ìˆ˜ë¡œ ì£¼ì–´ì§ˆ ë•Œ, ìˆœì„œë¥¼ ìž¬ë°°ì¹˜í•˜ì—¬ ë§Œë“¤ ìˆ˜ ìžˆëŠ” ê°€ìž¥ í° ìˆ˜ë¥¼ ë¬¸ìžì—´ë¡œ ë°”ê¾¸ì–´ return í•˜ë„ë¡ solution í•¨ìˆ˜ë¥¼ ìž‘ì„±í•´ì£¼ì„¸ìš”.

ì œí•œ ì‚¬í•­
numbersì˜ ê¸¸ì´ëŠ” 1 ì´ìƒ 100,000 ì´í•˜ìž…ë‹ˆë‹¤.
numbersì˜ ì›ì†ŒëŠ” 0 ì´ìƒ 1,000 ì´í•˜ìž…ë‹ˆë‹¤.
ì •ë‹µì´ ë„ˆë¬´ í´ ìˆ˜ ìžˆìœ¼ë‹ˆ ë¬¸ìžì—´ë¡œ ë°”ê¾¸ì–´ return í•©ë‹ˆë‹¤.*/
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
=======
/*ÇÁ·Î±×·¡¸Ó½º Á¤·Ä level2 °¡Àå Å« ¼ö
0 ¶Ç´Â ¾çÀÇ Á¤¼ö°¡ ÁÖ¾îÁ³À» ¶§, Á¤¼ö¸¦ ÀÌ¾î ºÙ¿© ¸¸µé ¼ö ÀÖ´Â °¡Àå Å« ¼ö¸¦ ¾Ë¾Æ³» ÁÖ¼¼¿ä.

¿¹¸¦ µé¾î, ÁÖ¾îÁø Á¤¼ö°¡ [6, 10, 2]¶ó¸é [6102, 6210, 1062, 1026, 2610, 2106]¸¦ ¸¸µé ¼ö ÀÖ°í, ÀÌÁß °¡Àå Å« ¼ö´Â 6210ÀÔ´Ï´Ù.

0 ¶Ç´Â ¾çÀÇ Á¤¼ö°¡ ´ã±ä ¹è¿­ numbers°¡ ¸Å°³º¯¼ö·Î ÁÖ¾îÁú ¶§, ¼ø¼­¸¦ Àç¹èÄ¡ÇÏ¿© ¸¸µé ¼ö ÀÖ´Â °¡Àå Å« ¼ö¸¦ ¹®ÀÚ¿­·Î ¹Ù²Ù¾î return ÇÏµµ·Ï solution ÇÔ¼ö¸¦ ÀÛ¼ºÇØÁÖ¼¼¿ä.

Á¦ÇÑ »çÇ×
numbersÀÇ ±æÀÌ´Â 1 ÀÌ»ó 100,000 ÀÌÇÏÀÔ´Ï´Ù.
numbersÀÇ ¿ø¼Ò´Â 0 ÀÌ»ó 1,000 ÀÌÇÏÀÔ´Ï´Ù.
Á¤´äÀÌ ³Ê¹« Å¬ ¼ö ÀÖÀ¸´Ï ¹®ÀÚ¿­·Î ¹Ù²Ù¾î return ÇÕ´Ï´Ù.*/
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
>>>>>>> refs/remotes/origin/master
