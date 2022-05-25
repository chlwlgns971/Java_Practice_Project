package Chapter05;

import java.util.Arrays;
import java.util.Scanner;

/*
<<<<<<< HEAD
ì°¸ì¡°í˜•ë³€ìˆ˜: ì£¼ì†Œë¥¼ ì €ì¥í•˜ê³  ìˆëŠ” ë³€ìˆ˜ ->ë°°ì—´, ê°ì²´ ì ì¡°ë³€ìˆ˜, ì—´ê±°í˜•, ì¸í„°í˜ì´ìŠ¤
	==, != ì—°ì‚°ìëŠ” ì°¸ì¡°í˜• ë³€ìˆ˜ì— ì €ì¥ëœ ê°’(ì£¼ì†Œ)ë¥¼ ë¹„êµ
	ë‚´ìš©ë¹„êµëŠ” equals()ë¥¼ ì‚¬ìš©
*/
/*
Chapter05 ë°°ì—´
	-ë™ì¼íƒ€ì…ì˜ ë°ì´í„°ë¥¼ ì—°ì†ëœ ê¸°ì–µê³µê°„ì— ì €ì¥í•˜ê³  ì¼ê´„ì ì¸ ì²˜ë¦¬ë¥¼ ìˆ˜í–‰ í•  ìˆ˜ ìˆëŠ” ê¸°ì–µê³µê°„
	-ì„ ì–¸->ì´ˆê¸°í™”->ì‚¬ìš©
	-ì„ ì–¸ëœ ë°°ì—´ì˜ í¬ê¸°ëŠ” ëŠ˜ë¦¬ê±°ë‚˜ ì¤„ì¼ ìˆ˜ ì—†ë‹¤.
ë°°ì—´ì„ ì–¸
	-íƒ€ì…[] ë°°ì—´ëª…;
	-íƒ€ì…[] ë°°ì—´ëª…=new íƒ€ì…ëª…[í¬í‚¤];
	-íƒ€ì…[] ë°°ì—´ëª…={ê°’1,ê°’2....};
*/

public class Array {

	public static void main(String[] args) {
		TestArrays ta=new TestArrays();
		//ta.lotto();
		//ta.sampleArray();
		//ta.integerArr(); //ì…ë ¥ê°’ì˜ í•©ê³¼ í‰ê·  êµ¬í•˜ê¸°
		//ta.evenOddDetect(); //ì§ìˆ˜ í™€ìˆ˜ êµ¬í•˜ê¸°
		//ta.minMaxDetect(); //ìµœëŒ€ìµœì†Œêµ¬í•˜ê¸°
		//ta.sortArr1(); //ì˜¤ë¦„ì°¨ìˆœ ì •ë ¬
		ta.sortArr2(); //ë‚´ë¦¼ì°¨ìˆœ ì •ë ¬
		ta.bubbleSort(); //ë²„ë¸”ì •ë ¬ 
	}

}
class TestArrays{
	Scanner sc=new Scanner(System.in);
	public void sampleArray(){
		int[] num=new int[5];
		String[] name=new String[5];
		name[0]="í™ê¸¸ë™";
		name[1]="í™ê¸¸ìˆœ";
		name[2]="ê°•ê°ì°¬";
		name[3]="ì´ì„±ê³„";
		name[4]="ì¡°í˜„ìš°";
		num[0]=90;
		num[1]=80;
		num[2]=70;
		num[3]=60;
		num[4]=40;
		for(int i=0; i<name.length; i++){
			System.out.println(name[i]+"ì˜ ì ìˆ˜ëŠ” "+num[i]+"ì…ë‹ˆë‹¤.");
		}
	}
	public void lotto(){ //ê°€ë” ì¤‘ë³µ ë‚˜ì˜´. í•´ê²° í•„ìš”->05.13 í•´ê²°
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
		Arrays.sort(num); //ì •ë ¬
		System.out.println("ë¡œë˜ë²ˆí˜¸ "+Arrays.toString(num));
	}
	public void integerArr(){ //ì •ìˆ˜ 10ê°œë¥¼ ì…ë ¥ë°›ì•„ í•©ê³¼ í‰ê·  êµ¬í•˜ê¸°
		int[] intArr1=new int[10];
		int sum=0;
		for(int i=0; i<intArr1.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
			intArr1[i]=sc.nextInt();
			sum+=intArr1[i];
		}
		for(int su:intArr1) System.out.print(su+","); //ê°•í™”forë¬¸. íƒ€ì…ë³€ìˆ˜:ë°°ì—´ëª… í˜•ì‹ìœ¼ë¡œ ì‚¬ìš©í•˜ê³  ë°°ì—´ ë°ì´í„°ê°’ì„ ëª¨ë‘ êº¼ë‚´ì¤€ë‹¤.
		System.out.println("\n"+Arrays.toString(intArr1));
		System.out.println("ì…ë ¥ë°›ì€ ì •ìˆ˜ë“¤ì˜ í•©ì€ "+sum+"ì…ë‹ˆë‹¤.");
		System.out.println("ì…ë ¥ë°›ì€ ì •ìˆ˜ë“¤ì˜ í‰ê· ì€ "+((double)sum/intArr1.length)+"ì…ë‹ˆë‹¤.");
		
	}
	public void evenOddDetect(){ //ë¬¸ì œ2 ë°°ì—´ì˜ í¬ê¸°ê°€ 10ì¸ ì •ìˆ˜í˜• ë°°ì—´ì„ ë§Œë“¤ê³  í‚¤ë³´ë“œë¡œ ê°’ì„ ì…ë ¥ë°›ì•„ í™€ìˆ˜ì™€ ì§ìˆ˜ì˜ ê°¯ìˆ˜ë¥¼ ì¶œë ¥í•˜ì‹œì˜¤.
		int[] intArr=new int[10];
		int odd=0; //í™€ìˆ˜
		int even=0; //ì§ìˆ˜
		for(int i=0; i<intArr.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
			intArr[i]=sc.nextInt();
			if(intArr[i]%2==0) even+=1;
			else odd+=1;
		}
		System.out.println("ì§ìˆ˜ì˜ ê°¯ìˆ˜: "+even);
		System.out.println("í™€ìˆ˜ì˜ ê°¯ìˆ˜: "+odd);
	}
	public void minMaxDetect(){ //ë¬¸ì œ3: ë°°ì—´ì˜ í¬ê¸°ê°€ 10ì¸ ì •ìˆ˜í˜• ë°°ì—´ì„ ë§Œë“¤ê³  ê°’ì„ ì…ë ¥ë°›ì•„ ìµœëŒ“ê°’ê³¼ ìµœì†Ÿê°’ì„ ì¶œë ¥í•˜ì‹œì˜¤.
		int[] intArr=new int[10];
		int min=0;
		int max=0;
		for(int i=0; i<intArr.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
			intArr[i]=sc.nextInt();
		}
		min=intArr[0];
		for(int i=0; i<intArr.length; i++){
			if(intArr[i]<min) min=intArr[i];
			if(intArr[i]>max) max=intArr[i];
		}
		System.out.println("ìµœëŒ“ê°’: "+max);
		System.out.println("ìµœì†Ÿê°’: "+min);
	}
	public void sortArr1(){ //ë¬¸ì œ4: ë°°ì—´ì˜ í¬ê¸°ê°€ 10ì¸ ì •ìˆ˜í˜• ë°°ì—´ì„ ë§Œë“¤ê³  ê°’ì„ ì…ë ¥ë°›ì•„ ì •ë ¬í•˜ì‹œì˜¤.(ì˜¤ë¦„ì°¨ìˆœ ì •ë ¬)
		int[] intArr=new int[10];
		int min=0;
		int index=0; //êµì²´í•  ì¸ë±ìŠ¤ê°’
		for(int i=0; i<intArr.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
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
			//ë°°ì—´ê°’ êµì²´
			swap(intArr,i,index);
			
		}
		System.out.println("ì˜¤ë¦„ì°¨ìˆœ ì„ íƒì •ë ¬ ê²°ê³¼: "+Arrays.toString(intArr));
	}
	public void sortArr2(){ //ë¬¸ì œ4: ë°°ì—´ì˜ í¬ê¸°ê°€ 10ì¸ ì •ìˆ˜í˜• ë°°ì—´ì„ ë§Œë“¤ê³  ê°’ì„ ì…ë ¥ë°›ì•„ ì •ë ¬í•˜ì‹œì˜¤.(ë‚´ë¦¼ì°¨ìˆœ ì •ë ¬)
		int[] intArr=new int[10];
		int max=0;
		int index=0; //êµì²´í•  ì¸ë±ìŠ¤ê°’
		for(int i=0; i<intArr.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
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
			//ë°°ì—´ê°’ êµì²´
			swap(intArr,i,index);
		}
		System.out.println("ë‚´ë¦¼ì°¨ìˆœ ì„ íƒì •ë ¬ ê²°ê³¼: "+Arrays.toString(intArr));
	}
	public void bubbleSort(){
		int[] num=new int[7];
		for(int i=0; i<num.length; i++){
			System.out.print("ì •ìˆ˜ë¥¼ ì…ë ¥í•˜ì„¸ìš”: ");
			num[i]=sc.nextInt();
		}
		for(int i=1; i<num.length; i++){
			for(int j=0; j<num.length-1; j++){
				if(num[j]>num[j+1]) {
					//ë°°ì—´ê°’ êµì²´ 
					swap(num,j,j+1);
				}
			}
		}
		System.out.println("ë²„ë¸”ì •ë ¬ ê²°ê³¼: "+Arrays.toString(num));
	}
	public int[] swap(int[] arr,int i, int j){ //ë°°ì—´ê°’ êµì²´ ë©”ì†Œë“œ
		int a=0; //ì„ì‹œì €ì¥ê³µê°„
=======
ÂüÁ¶Çüº¯¼ö: ÁÖ¼Ò¸¦ ÀúÀåÇÏ°í ÀÖ´Â º¯¼ö ->¹è¿­, °´Ã¼ ÀáÁ¶º¯¼ö, ¿­°ÅÇü, ÀÎÅÍÆäÀÌ½º
	==, != ¿¬»êÀÚ´Â ÂüÁ¶Çü º¯¼ö¿¡ ÀúÀåµÈ °ª(ÁÖ¼Ò)¸¦ ºñ±³
	³»¿ëºñ±³´Â equals()¸¦ »ç¿ë
*/
/*
Chapter05 ¹è¿­
	-µ¿ÀÏÅ¸ÀÔÀÇ µ¥ÀÌÅÍ¸¦ ¿¬¼ÓµÈ ±â¾ï°ø°£¿¡ ÀúÀåÇÏ°í ÀÏ°ıÀûÀÎ Ã³¸®¸¦ ¼öÇà ÇÒ ¼ö ÀÖ´Â ±â¾ï°ø°£
	-¼±¾ğ->ÃÊ±âÈ­->»ç¿ë
	-¼±¾ğµÈ ¹è¿­ÀÇ Å©±â´Â ´Ã¸®°Å³ª ÁÙÀÏ ¼ö ¾ø´Ù.
¹è¿­¼±¾ğ
	-Å¸ÀÔ[] ¹è¿­¸í;
	-Å¸ÀÔ[] ¹è¿­¸í=new Å¸ÀÔ¸í[Å©Å°];
	-Å¸ÀÔ[] ¹è¿­¸í={°ª1,°ª2....};
*/

public class Array {

	public static void main(String[] args) {
		TestArrays ta=new TestArrays();
		//ta.lotto();
		//ta.sampleArray();
		//ta.integerArr(); //ÀÔ·Â°ªÀÇ ÇÕ°ú Æò±Õ ±¸ÇÏ±â
		//ta.evenOddDetect(); //Â¦¼ö È¦¼ö ±¸ÇÏ±â
		//ta.minMaxDetect(); //ÃÖ´ëÃÖ¼Ò±¸ÇÏ±â
		//ta.sortArr1(); //¿À¸§Â÷¼ø Á¤·Ä
		ta.sortArr2(); //³»¸²Â÷¼ø Á¤·Ä
		ta.bubbleSort(); //¹öºíÁ¤·Ä 
	}

}
class TestArrays{
	Scanner sc=new Scanner(System.in);
	public void sampleArray(){
		int[] num=new int[5];
		String[] name=new String[5];
		name[0]="È«±æµ¿";
		name[1]="È«±æ¼ø";
		name[2]="°­°¨Âù";
		name[3]="ÀÌ¼º°è";
		name[4]="Á¶Çö¿ì";
		num[0]=90;
		num[1]=80;
		num[2]=70;
		num[3]=60;
		num[4]=40;
		for(int i=0; i<name.length; i++){
			System.out.println(name[i]+"ÀÇ Á¡¼ö´Â "+num[i]+"ÀÔ´Ï´Ù.");
		}
	}
	public void lotto(){ //°¡²û Áßº¹ ³ª¿È. ÇØ°á ÇÊ¿ä->05.13 ÇØ°á
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
		Arrays.sort(num); //Á¤·Ä
		System.out.println("·Î¶Ç¹øÈ£ "+Arrays.toString(num));
	}
	public void integerArr(){ //Á¤¼ö 10°³¸¦ ÀÔ·Â¹Ş¾Æ ÇÕ°ú Æò±Õ ±¸ÇÏ±â
		int[] intArr1=new int[10];
		int sum=0;
		for(int i=0; i<intArr1.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			intArr1[i]=sc.nextInt();
			sum+=intArr1[i];
		}
		for(int su:intArr1) System.out.print(su+","); //°­È­for¹®. Å¸ÀÔº¯¼ö:¹è¿­¸í Çü½ÄÀ¸·Î »ç¿ëÇÏ°í ¹è¿­ µ¥ÀÌÅÍ°ªÀ» ¸ğµÎ ²¨³»ÁØ´Ù.
		System.out.println("\n"+Arrays.toString(intArr1));
		System.out.println("ÀÔ·Â¹ŞÀº Á¤¼öµéÀÇ ÇÕÀº "+sum+"ÀÔ´Ï´Ù.");
		System.out.println("ÀÔ·Â¹ŞÀº Á¤¼öµéÀÇ Æò±ÕÀº "+((double)sum/intArr1.length)+"ÀÔ´Ï´Ù.");
		
	}
	public void evenOddDetect(){ //¹®Á¦2 ¹è¿­ÀÇ Å©±â°¡ 10ÀÎ Á¤¼öÇü ¹è¿­À» ¸¸µé°í Å°º¸µå·Î °ªÀ» ÀÔ·Â¹Ş¾Æ È¦¼ö¿Í Â¦¼öÀÇ °¹¼ö¸¦ Ãâ·ÂÇÏ½Ã¿À.
		int[] intArr=new int[10];
		int odd=0; //È¦¼ö
		int even=0; //Â¦¼ö
		for(int i=0; i<intArr.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			intArr[i]=sc.nextInt();
			if(intArr[i]%2==0) even+=1;
			else odd+=1;
		}
		System.out.println("Â¦¼öÀÇ °¹¼ö: "+even);
		System.out.println("È¦¼öÀÇ °¹¼ö: "+odd);
	}
	public void minMaxDetect(){ //¹®Á¦3: ¹è¿­ÀÇ Å©±â°¡ 10ÀÎ Á¤¼öÇü ¹è¿­À» ¸¸µé°í °ªÀ» ÀÔ·Â¹Ş¾Æ ÃÖ´ñ°ª°ú ÃÖ¼Ú°ªÀ» Ãâ·ÂÇÏ½Ã¿À.
		int[] intArr=new int[10];
		int min=0;
		int max=0;
		for(int i=0; i<intArr.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			intArr[i]=sc.nextInt();
		}
		min=intArr[0];
		for(int i=0; i<intArr.length; i++){
			if(intArr[i]<min) min=intArr[i];
			if(intArr[i]>max) max=intArr[i];
		}
		System.out.println("ÃÖ´ñ°ª: "+max);
		System.out.println("ÃÖ¼Ú°ª: "+min);
	}
	public void sortArr1(){ //¹®Á¦4: ¹è¿­ÀÇ Å©±â°¡ 10ÀÎ Á¤¼öÇü ¹è¿­À» ¸¸µé°í °ªÀ» ÀÔ·Â¹Ş¾Æ Á¤·ÄÇÏ½Ã¿À.(¿À¸§Â÷¼ø Á¤·Ä)
		int[] intArr=new int[10];
		int min=0;
		int index=0; //±³Ã¼ÇÒ ÀÎµ¦½º°ª
		for(int i=0; i<intArr.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
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
			//¹è¿­°ª ±³Ã¼
			swap(intArr,i,index);
			
		}
		System.out.println("¿À¸§Â÷¼ø ¼±ÅÃÁ¤·Ä °á°ú: "+Arrays.toString(intArr));
	}
	public void sortArr2(){ //¹®Á¦4: ¹è¿­ÀÇ Å©±â°¡ 10ÀÎ Á¤¼öÇü ¹è¿­À» ¸¸µé°í °ªÀ» ÀÔ·Â¹Ş¾Æ Á¤·ÄÇÏ½Ã¿À.(³»¸²Â÷¼ø Á¤·Ä)
		int[] intArr=new int[10];
		int max=0;
		int index=0; //±³Ã¼ÇÒ ÀÎµ¦½º°ª
		for(int i=0; i<intArr.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
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
			//¹è¿­°ª ±³Ã¼
			swap(intArr,i,index);
		}
		System.out.println("³»¸²Â÷¼ø ¼±ÅÃÁ¤·Ä °á°ú: "+Arrays.toString(intArr));
	}
	public void bubbleSort(){
		int[] num=new int[7];
		for(int i=0; i<num.length; i++){
			System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
			num[i]=sc.nextInt();
		}
		for(int i=1; i<num.length; i++){
			for(int j=0; j<num.length-1; j++){
				if(num[j]>num[j+1]) {
					//¹è¿­°ª ±³Ã¼ 
					swap(num,j,j+1);
				}
			}
		}
		System.out.println("¹öºíÁ¤·Ä °á°ú: "+Arrays.toString(num));
	}
	public int[] swap(int[] arr,int i, int j){ //¹è¿­°ª ±³Ã¼ ¸Ş¼Òµå
		int a=0; //ÀÓ½ÃÀúÀå°ø°£
>>>>>>> refs/remotes/origin/master
		a=arr[i];
		arr[i]=arr[j];
		arr[j]=a;
		return arr;
	}
}