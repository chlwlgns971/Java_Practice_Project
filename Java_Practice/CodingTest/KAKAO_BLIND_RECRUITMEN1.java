import java.util.Arrays;
/*
<<<<<<< HEAD
 * ì •ë‹µ: [2, 1, 1, 0]
 * í…ŒìŠ¤íŠ¸ ì¼€ì´ìŠ¤ëŠ” ë§žì·„ì§€ë§Œ, ë‹¤ë¥¸ ì¼€ì´ìŠ¤ì—ì„œ ì‹œê°„ì´ˆê³¼ ë° ëŸ°íƒ€ìž„ ì—ëŸ¬ë°œìƒ.
 * hashmapì„ í•™ìŠµí•˜ê³  ë‹¤ì‹œ í•´ë´ì•¼ í•  í•„ìš”ì„±ì´ ìžˆìŒ
 */

public class KAKAO_BLIND_RECRUITMEN1 {

	public static void main(String[] args) {
		Solution solu=new Solution();
		String[] id_list={"muzi","frodo","apeach","neo"};
		String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int[] asw=solu.solution(id_list,report,2);
		System.out.println(Arrays.toString(asw));

	}

}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int count=0;
        int[] answer =new int[id_list.length]; 
        int[] reported_count =new int[id_list.length]; //ì‹ ê³ ë‹¹í•œ íšŸìˆ˜
        int[] blocked =new int[id_list.length]; //ì •ì§€ë‹¹í•˜ëŠ” ìœ ì €
        for(int i=0; i<report.length-1; i++){ //ì¤‘ë³µì œê±°
            for(int j=i+1; j<report.length; j++){
                if(report[i].equals(report[j])){
                    report[j]="";
                }
            }
        }
        for(int i=0; i<report.length; i++){ //ì¤‘ë³µì œê±°í•œ ì‹ ê³ íšŸìˆ˜ ì¹´ìš´íŠ¸
        	if(report[i]!="") count++;
        }
        String[] str=new String[2];
        String[] report_id=new String[count]; //ì‹ ê³ í•œ ì‚¬ëžŒ
        String[] reported_id=new String[count]; //ì‹ ê³ ë‹¹í•œì‚¬ëžŒ
        for(int i=0; i<report.length; i++){
            str[0]="";
            str[1]="";
            if(report[i]=="") continue;
            else{
                str=report[i].split(" ");
                report_id[i]=str[0];
                reported_id[i]=str[1];
            }
        }
        System.out.println(Arrays.toString(reported_id));
        for(int i=0; i<reported_id.length; i++){//ì‹ ê³  ë‹¹í•œ íšŸìˆ˜ ì¹´ìš´íŠ¸
            for(int j=0; j<id_list.length; j++){
            	if(reported_id[i]!=null){
            		if(reported_id[i].equals(id_list[j])) reported_count[j]+=1;
            	}
            }
        }
        System.out.println("reported_count "+Arrays.toString(reported_count));
        for(int i=0; i<id_list.length; i++){
        	if(reported_count[i]>=k) blocked[i]=1;
        	else blocked[i]=0;
        }
        System.out.println("blocked "+Arrays.toString(blocked));
        for(int i=0; i<blocked.length; i++){
        	if(blocked[i]==1){
        		for(int j=0; j<report.length; j++){
        			if(reported_id[j].contains(id_list[i])){
        				str=report[j].split(" ");
        				for(int z=0; z<id_list.length; z++){
        					if(id_list[z].equals(str[0])) answer[z]+=1;
        				}
        			}
        		}
        	}
        }
        return answer;
    }
}
=======
 * Á¤´ä: [2, 1, 1, 0]
 * Å×½ºÆ® ÄÉÀÌ½º´Â ¸ÂÃèÁö¸¸, ´Ù¸¥ ÄÉÀÌ½º¿¡¼­ ½Ã°£ÃÊ°ú ¹× ·±Å¸ÀÓ ¿¡·¯¹ß»ý.
 * hashmapÀ» ÇÐ½ÀÇÏ°í ´Ù½Ã ÇØºÁ¾ß ÇÒ ÇÊ¿ä¼ºÀÌ ÀÖÀ½
 */

public class KAKAO_BLIND_RECRUITMEN1 {

	public static void main(String[] args) {
		Solution solu=new Solution();
		String[] id_list={"muzi","frodo","apeach","neo"};
		String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int[] asw=solu.solution(id_list,report,2);
		System.out.println(Arrays.toString(asw));

	}

}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int count=0;
        int[] answer =new int[id_list.length]; 
        int[] reported_count =new int[id_list.length]; //½Å°í´çÇÑ È½¼ö
        int[] blocked =new int[id_list.length]; //Á¤Áö´çÇÏ´Â À¯Àú
        for(int i=0; i<report.length-1; i++){ //Áßº¹Á¦°Å
            for(int j=i+1; j<report.length; j++){
                if(report[i].equals(report[j])){
                    report[j]="";
                }
            }
        }
        for(int i=0; i<report.length; i++){ //Áßº¹Á¦°ÅÇÑ ½Å°íÈ½¼ö Ä«¿îÆ®
        	if(report[i]!="") count++;
        }
        String[] str=new String[2];
        String[] report_id=new String[count]; //½Å°íÇÑ »ç¶÷
        String[] reported_id=new String[count]; //½Å°í´çÇÑ»ç¶÷
        for(int i=0; i<report.length; i++){
            str[0]="";
            str[1]="";
            if(report[i]=="") continue;
            else{
                str=report[i].split(" ");
                report_id[i]=str[0];
                reported_id[i]=str[1];
            }
        }
        System.out.println(Arrays.toString(reported_id));
        for(int i=0; i<reported_id.length; i++){//½Å°í ´çÇÑ È½¼ö Ä«¿îÆ®
            for(int j=0; j<id_list.length; j++){
            	if(reported_id[i]!=null){
            		if(reported_id[i].equals(id_list[j])) reported_count[j]+=1;
            	}
            }
        }
        System.out.println("reported_count "+Arrays.toString(reported_count));
        for(int i=0; i<id_list.length; i++){
        	if(reported_count[i]>=k) blocked[i]=1;
        	else blocked[i]=0;
        }
        System.out.println("blocked "+Arrays.toString(blocked));
        for(int i=0; i<blocked.length; i++){
        	if(blocked[i]==1){
        		for(int j=0; j<report.length; j++){
        			if(reported_id[j].contains(id_list[i])){
        				str=report[j].split(" ");
        				for(int z=0; z<id_list.length; z++){
        					if(id_list[z].equals(str[0])) answer[z]+=1;
        				}
        			}
        		}
        	}
        }
        return answer;
    }
}
>>>>>>> refs/remotes/origin/master
