package Chapter05;

import java.util.Arrays;
<<<<<<< HEAD
/*2ì°¨ì› ë°°ì—´
 * -í–‰ê³¼ ì—´ë¡œ êµ¬ì„±
 * (ì„ ì–¸í˜•ì‹)
 * íƒ€ì…ëª…[][] ë°°ì—´ëª…;
 * íƒ€ì…ëª…[] ë°°ì—´ëª…[];
 * íƒ€ì…ëª… ë°°ì—´ëª…[][];
 * (ìƒì„±ê·œì¹™)
 * -new ì—°ì‚°ì ì‚¬ìš©
 * íƒ€ì…ëª…[][] ë°°ì—´ëª…=new íƒ€ì…ëª…[í–‰ì˜ í¬ê¸°][ì—´ì˜ í¬ê¸°];
 * -ë°ì´í„°ë¥¼ ì •ì˜í•´ì„œ ì‚¬ìš©
 * íƒ€ì…ëª…[][] ë°°ì—´ëª…={{ë°ì´í„°,....},{ë°ì´í„°,....}}; ->ê° í–‰ë§ˆë‹¤ ì—´ì˜ ê°¯ìˆ˜ê°€ ë‹¬ë¼ì§ˆ ìˆ˜ ìˆë‹¤. ì´ê²ƒì„ 'ê°€ë³€ë°°ì—´'ì´ë¼ê³  í•œë‹¤.
 * (ê°€ë³€ë°°ì—´ ìƒì„±ê·œì¹™)
 * íƒ€ì…ëª…[][] ë°°ì—´ëª…=new íƒ€ì…ëª…[í–‰ì˜ í¬ê¸°][]; -> í–‰ì˜ í¬ê¸°ë§Œ ê³ ì •í•˜ê³  ì—´ì˜ í¬ê¸°ëŠ” ë¯¸ì •.
 * ë°°ì—´ëª…[0]=new íƒ€ì…ëª…[ì—´ì˜ í¬ê¸°]; ->0ë²ˆì§¸ í–‰ì˜ ì—´ì˜ í¬ê¸° ì„ ì–¸
 * ë°°ì—´ëª…[1]=new íƒ€ì…ëª…[ì—´ì˜ í¬ê¸°]; ->1ë²ˆì§¸ í–‰ì˜ ì—´ì˜ í¬ê¸° ì„ ì–¸
 */

public class TwoDimArray {

	public static void main(String[] args) {
		ArrayTest arrTest=new ArrayTest();
		arrTest.scoreArr();

	}

}
class ArrayTest{
	public void scoreArr(){
		//int[][] score=new int[7][8]; //ê° ìš”ì†Œë¥¼ ê°ê° ë„£ì„ ë•Œ ì´ë ‡ê²Œ ì„ ì–¸. 
		int[][] score={{60,80,60,70,85,0,0,1}, //0,0,1= ì´ì , í‰ê· , ë“±ìˆ˜
				{70,90,75,70,80,0,0,1},
				{90,80,50,60,60,0,0,1},
				{95,90,85,90,95,0,0,1},
				{50,65,55,60,70,0,0,1},
				{65,75,85,64,50,0,0,1},
				{75,95,95,95,90,0,0,1}};
		String[] score_nm={"ê°•ê°ì°¬","ì´ì„±ê³„","í™ê¸¸ë™","ì •ëª½ì£¼","ê¹€ìœ ì‹ ","ì´ìˆœì‹ ","ì „ìš°ì¹˜"};
		
		//ì´ì ê³¼ í‰ê· 
		for(int i=0; i<score.length;i++){ //2ì°¨ì› ë°°ì—´ì—ì„œ '.length'ëŠ” í–‰ì˜ ê°¯ìˆ˜
			for(int j=0; j<score[0].length-3; j++){ //2ì°¨ì› ë°°ì—´ì—ì„œ 'ë°°ì—´ëª….length'ê°€ ì—´ì˜ ê°¯ìˆ˜
				score[i][5]+=score[i][j]; //ì ìˆ˜ ì´í•©
			}
			score[i][6]+=(score[i][5]/5); //í‰ê· ì ìˆ˜
		}
		//ë“±ìˆ˜êµ¬í•˜ê¸°
		score=getRank(score);
		
		//ì¶œë ¥
		System.out.println("    ì´  ë¦„        êµ­ì–´   ì˜ì–´   ìˆ˜í•™  ê³¼í•™   ì‚¬íšŒ   ì´ì    í‰ê·    ë“±ìˆ˜");
		System.out.println("==========================================");
		for(int i=0; i<score.length; i++){ //ë°©ë²•1
			System.out.println(score_nm[i]+" ì ìˆ˜= "+Arrays.toString(score[i]));
		}
		System.out.println(" ì´  ë¦„   êµ­ì–´   ì˜ì–´  ìˆ˜í•™  ê³¼í•™   ì‚¬íšŒ  ì´ì    í‰ê·    ë“±ìˆ˜");
		System.out.println("=====================================");
		for(int i=0; i<score.length; i++){ //ë°©ë²•2
			System.out.printf("%5s",score_nm[i]);
			for(int j=0; j<score[i].length; j++){
				System.out.printf("%4d",score[i][j]);
			}
			System.out.println();
		}
		//ìˆ™ì œ1
		int[] index=hw1(score);
		System.out.println("ë“±ìˆ˜ ìˆœì„œëŒ€ë¡œ ì¶œë ¥ê²°ê³¼");
		for(int i=0; i<index.length; i++){
			System.out.println(score_nm[index[i]]+" ì ìˆ˜= "+Arrays.toString(score[index[i]]));
		}
		
		//ìˆ™ì œ2
		hw2();
		
	}
	public int[][] getRank(int[][] a){ //ë“±ìˆ˜ êµ¬í•˜ëŠ” ë©”ì†Œë“œ
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[i][5]<a[j][5]){
					a[i][7]++;
				}
			}
		}
		return a;
	}
	/*ìˆ™ì œ1. ìœ„ì˜ ê²°ê³¼ë¥¼ ë“±ìˆ˜ ìˆœìœ¼ë¡œ ì¶œë ¥í•˜ì‹œì˜¤.
	 *ìˆ™ì œ2. ë‹¤ìŒ ìë£Œë¡œ ë§‰ëŒ€ ê·¸ë˜í”„ë¥¼ ì‘ì„±í•˜ì‹œì˜¤
	 *	[ìë£Œ]: {25,55,45,40,50}
	 *	-ë§‰ëŒ€ ê·¸ë˜í”„ë¥¼ ë‹¤ìŒê³¼ ê°™ì´ ì¶œë ¥í•˜ì‹œì˜¤ (hint ìœ„ì—ì„œ ì•„ë˜ë¡œ ì¶œë ¥í•´ì•¼í•¨)
	 *-> ê³µí†µì : ìµœê³ ì ì„ 55, ìµœí•˜ì ì„ 25ë¡œ ë’€ì„ ë•Œ ((ê°’-25)/5)+1= ë³„ì˜ ê°¯ìˆ˜
	 *55|*
	 *50|*
	 *45|*   *
	 *40|*   *
	 *35|* * *
	 *30|* * *
	 *25|* * *
	*/
	public int[] hw1(int[][] a){
		int[] index=new int[a.length];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[j][7]==i+1) index[i]=j;
			}
		}
		return index;
	}
	public void hw2(){
		int[] arr={25,55,45,40,50};
		int[] starNum=new int[5]; //ë³„ì˜ ê°¯ìˆ˜
		String[][] str={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""}};
		String[] str1={"55|","50|","45|","40|","35|","30|","25|"};
		for(int i=0; i<arr.length; i++){ //ë³„ ê°¯ìˆ˜ë¥¼ êµ¬í•´ starNumë°°ì—´ì— ì‚½ì…
			starNum[i]=((arr[i]-25)/5)+1;
		}
		System.out.println(Arrays.toString(starNum)); //ì—­ìˆœìœ¼ë¡œ ë³„ ê°¯ìˆ˜ë§Œí¼ ì‚½ì…
		for(int i=0; i<str[i].length; i++){
			for(int j=str.length-1; j>(str.length-1)-starNum[i]; j--){
				str[j][i]="*";
			}
		}
		for(int i=0; i<str.length; i++){ 
			System.out.printf("%5s",str1[i]);
			for(int j=0; j<str[i].length; j++){
				System.out.printf("%4s",str[i][j]);
			}
			System.out.println();
		}
		System.out.println("       25  55  45  40  50");
	}
}


=======

/*2Â÷¿ø ¹è¿­
 * -Çà°ú ¿­·Î ±¸¼º
 * (¼±¾ğÇü½Ä)
 * Å¸ÀÔ¸í[][] ¹è¿­¸í;
 * Å¸ÀÔ¸í[] ¹è¿­¸í[];
 * Å¸ÀÔ¸í ¹è¿­¸í[][];
 * (»ı¼º±ÔÄ¢)
 * -new ¿¬»êÀÚ »ç¿ë
 * Å¸ÀÔ¸í[][] ¹è¿­¸í=new Å¸ÀÔ¸í[ÇàÀÇ Å©±â][¿­ÀÇ Å©±â];
 * -µ¥ÀÌÅÍ¸¦ Á¤ÀÇÇØ¼­ »ç¿ë
 * Å¸ÀÔ¸í[][] ¹è¿­¸í={{µ¥ÀÌÅÍ,....},{µ¥ÀÌÅÍ,....}}; ->°¢ Çà¸¶´Ù ¿­ÀÇ °¹¼ö°¡ ´Ş¶óÁú ¼ö ÀÖ´Ù. ÀÌ°ÍÀ» '°¡º¯¹è¿­'ÀÌ¶ó°í ÇÑ´Ù.
 * (°¡º¯¹è¿­ »ı¼º±ÔÄ¢)
 * Å¸ÀÔ¸í[][] ¹è¿­¸í=new Å¸ÀÔ¸í[ÇàÀÇ Å©±â][]; -> ÇàÀÇ Å©±â¸¸ °íÁ¤ÇÏ°í ¿­ÀÇ Å©±â´Â ¹ÌÁ¤.
 * ¹è¿­¸í[0]=new Å¸ÀÔ¸í[¿­ÀÇ Å©±â]; ->0¹øÂ° ÇàÀÇ ¿­ÀÇ Å©±â ¼±¾ğ
 * ¹è¿­¸í[1]=new Å¸ÀÔ¸í[¿­ÀÇ Å©±â]; ->1¹øÂ° ÇàÀÇ ¿­ÀÇ Å©±â ¼±¾ğ
 */

public class TwoDimArray {

	public static void main(String[] args) {
		ArrayTest arrTest=new ArrayTest();
		arrTest.scoreArr();

	}

}
class ArrayTest{
	public void scoreArr(){
		//int[][] score=new int[7][8]; //°¢ ¿ä¼Ò¸¦ °¢°¢ ³ÖÀ» ¶§ ÀÌ·¸°Ô ¼±¾ğ. 
		int[][] score={{60,80,60,70,85,0,0,1}, //0,0,1= ÃÑÁ¡, Æò±Õ, µî¼ö
				{70,90,75,70,80,0,0,1},
				{90,80,50,60,60,0,0,1},
				{95,90,85,90,95,0,0,1},
				{50,65,55,60,70,0,0,1},
				{65,75,85,64,50,0,0,1},
				{75,95,95,95,90,0,0,1}};
		String[] score_nm={"°­°¨Âù","ÀÌ¼º°è","È«±æµ¿","Á¤¸ùÁÖ","±èÀ¯½Å","ÀÌ¼ø½Å","Àü¿ìÄ¡"};
		
		//ÃÑÁ¡°ú Æò±Õ
		for(int i=0; i<score.length;i++){ //2Â÷¿ø ¹è¿­¿¡¼­ '.length'´Â ÇàÀÇ °¹¼ö
			for(int j=0; j<score[0].length-3; j++){ //2Â÷¿ø ¹è¿­¿¡¼­ '¹è¿­¸í.length'°¡ ¿­ÀÇ °¹¼ö
				score[i][5]+=score[i][j]; //Á¡¼ö ÃÑÇÕ
			}
			score[i][6]+=(score[i][5]/5); //Æò±ÕÁ¡¼ö
		}
		//µî¼ö±¸ÇÏ±â
		score=getRank(score);
		
		//Ãâ·Â
		System.out.println("    ÀÌ  ¸§        ±¹¾î   ¿µ¾î   ¼öÇĞ  °úÇĞ   »çÈ¸   ÃÑÁ¡   Æò±Õ   µî¼ö");
		System.out.println("==========================================");
		for(int i=0; i<score.length; i++){ //¹æ¹ı1
			System.out.println(score_nm[i]+" Á¡¼ö= "+Arrays.toString(score[i]));
		}
		System.out.println(" ÀÌ  ¸§   ±¹¾î   ¿µ¾î  ¼öÇĞ  °úÇĞ   »çÈ¸  ÃÑÁ¡   Æò±Õ   µî¼ö");
		System.out.println("=====================================");
		for(int i=0; i<score.length; i++){ //¹æ¹ı2
			System.out.printf("%5s",score_nm[i]);
			for(int j=0; j<score[i].length; j++){
				System.out.printf("%4d",score[i][j]);
			}
			System.out.println();
		}
		//¼÷Á¦1
		int[] index=hw1(score);
		System.out.println("µî¼ö ¼ø¼­´ë·Î Ãâ·Â°á°ú");
		for(int i=0; i<index.length; i++){
			System.out.println(score_nm[index[i]]+" Á¡¼ö= "+Arrays.toString(score[index[i]]));
		}
		
		//¼÷Á¦2
		hw2();
		
	}
	public int[][] getRank(int[][] a){ //µî¼ö ±¸ÇÏ´Â ¸Ş¼Òµå
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[i][5]<a[j][5]){
					a[i][7]++;
				}
			}
		}
		return a;
	}
	/*¼÷Á¦1. À§ÀÇ °á°ú¸¦ µî¼ö ¼øÀ¸·Î Ãâ·ÂÇÏ½Ã¿À.
	 *¼÷Á¦2. ´ÙÀ½ ÀÚ·á·Î ¸·´ë ±×·¡ÇÁ¸¦ ÀÛ¼ºÇÏ½Ã¿À
	 *	[ÀÚ·á]: {25,55,45,40,50}
	 *	-¸·´ë ±×·¡ÇÁ¸¦ ´ÙÀ½°ú °°ÀÌ Ãâ·ÂÇÏ½Ã¿À (hint À§¿¡¼­ ¾Æ·¡·Î Ãâ·ÂÇØ¾ßÇÔ)
	 *-> °øÅëÁ¡: ÃÖ°íÁ¡À» 55, ÃÖÇÏÁ¡À» 25·Î µ×À» ¶§ ((°ª-25)/5)+1= º°ÀÇ °¹¼ö
	 *55|*
	 *50|*
	 *45|*   *
	 *40|*   *
	 *35|* * *
	 *30|* * *
	 *25|* * *
	*/
	public int[] hw1(int[][] a){
		int[] index=new int[a.length];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				if(a[j][7]==i+1) index[i]=j;
			}
		}
		return index;
	}
	public void hw2(){
		int[] arr={25,55,45,40,50};
		int[] starNum=new int[5]; //º°ÀÇ °¹¼ö
		String[][] str={{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
				{"","","","",""},{"","","","",""}};
		String[] str1={"55|","50|","45|","40|","35|","30|","25|"};
		for(int i=0; i<arr.length; i++){ //º° °¹¼ö¸¦ ±¸ÇØ starNum¹è¿­¿¡ »ğÀÔ
			starNum[i]=((arr[i]-25)/5)+1;
		}
		System.out.println(Arrays.toString(starNum)); //¿ª¼øÀ¸·Î º° °¹¼ö¸¸Å­ »ğÀÔ
		for(int i=0; i<str[i].length; i++){
			for(int j=str.length-1; j>(str.length-1)-starNum[i]; j--){
				str[j][i]="*";
			}
		}
		for(int i=0; i<str.length; i++){ 
			System.out.printf("%5s",str1[i]);
			for(int j=0; j<str[i].length; j++){
				System.out.printf("%4s",str[i][j]);
			}
			System.out.println();
		}
		System.out.println("       25  55  45  40  50");
	}
}
>>>>>>> refs/remotes/origin/master
