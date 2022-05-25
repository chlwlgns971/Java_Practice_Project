package Chapter05;

import java.util.Arrays;
import java.util.Scanner;

<<<<<<< HEAD
/*5ê°œì˜ ì˜ì–´ ë‹¨ì–´ ì¤‘ ìž„ì˜ì˜ ë‹¨ì–´ë¥¼ ì„ íƒí•˜ì—¬ ë‹¨ì–´ë¥¼ êµ¬ì„±í•˜ëŠ” ì² ìžë¥¼ ì„žì€ í›„ ì‚¬ìš©ìžì—ê²Œ ì œì‹œí•˜ë©´ ì‚¬ìš©ìžê°€ ê·¸ ë‹¨ì–´ë¥¼ ë§žì¶”ëŠ” ê²Œìž„
 * +ì‹œë„ íšŸìˆ˜ë„ ì¶œë ¥í•˜ì‹œì˜¤
 */

public class WordScramble {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int rand=(int)(Math.random()*5);
		String[] word={"apple","tumblr","window","computer","button"}; 
		String str=""; //ì•ŒíŒŒë²³ ìˆœì„œë¥¼ ì„žì€ ë‹¨ì–´ë¥¼ ì €ìž¥í•˜ëŠ” ë³€ìˆ˜
		int[] randNum=new int[word[rand].length()]; //ì¤‘ë³µì œê±°ëœ ì¸ë±ìŠ¤ ë‚œìˆ˜ê°’ì´ ì €ìž¥ë˜ëŠ” ë°°ì—´
		for(int i=0; i<word[rand].length(); i++){ //ëžœë¤ìœ¼ë¡œ ì¸ë±ìŠ¤ê°’ì„ ìƒì„±í•˜ê³  ì¤‘ë³µì œê±°
			randNum[i]=(int)(Math.random()*word[rand].length());
			for(int j=0; j<i; j++){
				if(randNum[i]==randNum[j]) i--;
			}
			
		}
		//System.out.println(Arrays.toString(randNum)); //ëžœë¤ìœ¼ë¡œ ìƒì„±ëœ ì¸ë±ìŠ¤ ìˆœì„œ
		for(int i=0; i<randNum.length; i++){
			str+=word[rand].substring(randNum[i], randNum[i]+1); //substring(a,b)=stringì„ aì¸ë±ìŠ¤ë¶€í„° bì¸ë±ìŠ¤ ì „ê¹Œì§€ ìž˜ë¼ëƒ„
		}
		
		String asw="";
		while(true){
			System.out.println(str);
			System.out.print("ì •ë‹µì„ ìž…ë ¥í•´ì£¼ì„¸ìš”(ì†Œë¬¸ìž): ");
			asw=sc.nextLine();
			if (asw.equals(word[rand])){
				System.out.println("ì •ë‹µìž…ë‹ˆë‹¤.");
				break;
			}
			else System.out.println("ì •ë‹µì´ ì•„ë‹™ë‹ˆë‹¤.");
		}

	}

}

//public String suffle(String str){ //ì„ ìƒë‹˜ì´ ë§Œë“œì‹  ì•Œê³ ë¦¬ì¦˜
//	char[] ch=str.toCharArray();
//	for(int i=0; i<=100000; i++){
//		int r1=(int)(Math.random()*ch.length);
//		char temp=ch[0];
//		ch[0]=ch[r1];
//		ch[r1]=temp;
//	}
//	retirm(new String(ch))
//}
=======
/*5°³ÀÇ ¿µ¾î ´Ü¾î Áß ÀÓÀÇÀÇ ´Ü¾î¸¦ ¼±ÅÃÇÏ¿© ´Ü¾î¸¦ ±¸¼ºÇÏ´Â Ã¶ÀÚ¸¦ ¼¯Àº ÈÄ »ç¿ëÀÚ¿¡°Ô Á¦½ÃÇÏ¸é »ç¿ëÀÚ°¡ ±× ´Ü¾î¸¦ ¸ÂÃß´Â °ÔÀÓ
 * +½Ãµµ È½¼öµµ Ãâ·ÂÇÏ½Ã¿À
 */

public class WordScramble {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int rand=(int)(Math.random()*5);
		String[] word={"apple","tumblr","window","computer","button"}; 
		String str=""; //¾ËÆÄºª ¼ø¼­¸¦ ¼¯Àº ´Ü¾î¸¦ ÀúÀåÇÏ´Â º¯¼ö
		int[] randNum=new int[word[rand].length()]; //Áßº¹Á¦°ÅµÈ ÀÎµ¦½º ³­¼ö°ªÀÌ ÀúÀåµÇ´Â ¹è¿­
		for(int i=0; i<word[rand].length(); i++){ //·£´ýÀ¸·Î ÀÎµ¦½º°ªÀ» »ý¼ºÇÏ°í Áßº¹Á¦°Å
			randNum[i]=(int)(Math.random()*word[rand].length());
			for(int j=0; j<i; j++){
				if(randNum[i]==randNum[j]) i--;
			}
			
		}
		//System.out.println(Arrays.toString(randNum)); //·£´ýÀ¸·Î »ý¼ºµÈ ÀÎµ¦½º ¼ø¼­
		for(int i=0; i<randNum.length; i++){
			str+=word[rand].substring(randNum[i], randNum[i]+1); //substring(a,b)=stringÀ» aÀÎµ¦½ººÎÅÍ bÀÎµ¦½º Àü±îÁö Àß¶ó³¿
		}
		
		String asw="";
		while(true){
			System.out.println(str);
			System.out.print("Á¤´äÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä(¼Ò¹®ÀÚ): ");
			asw=sc.nextLine();
			if (asw.equals(word[rand])){
				System.out.println("Á¤´äÀÔ´Ï´Ù.");
				break;
			}
			else System.out.println("Á¤´äÀÌ ¾Æ´Õ´Ï´Ù.");
		}

	}

}

//public String suffle(String str){ //¼±»ý´ÔÀÌ ¸¸µå½Å ¾Ë°í¸®Áò
//	char[] ch=str.toCharArray();
//	for(int i=0; i<=100000; i++){
//		int r1=(int)(Math.random()*ch.length);
//		char temp=ch[0];
//		ch[0]=ch[r1];
//		ch[r1]=temp;
//	}
//	retirm(new String(ch))
//}
>>>>>>> refs/remotes/origin/master
