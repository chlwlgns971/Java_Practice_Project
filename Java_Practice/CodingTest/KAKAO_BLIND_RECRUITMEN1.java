import java.util.Arrays;
/*
 * 정답: [2, 1, 1, 0]
 * 테스트 케이스는 맞췄지만, 다른 케이스에서 시간초과 및 런타임 에러발생.
 * hashmap을 학습하고 다시 해봐야 할 필요성이 있음
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
        int[] reported_count =new int[id_list.length]; //신고당한 횟수
        int[] blocked =new int[id_list.length]; //정지당하는 유저
        for(int i=0; i<report.length-1; i++){ //중복제거
            for(int j=i+1; j<report.length; j++){
                if(report[i].equals(report[j])){
                    report[j]="";
                }
            }
        }
        for(int i=0; i<report.length; i++){ //중복제거한 신고횟수 카운트
        	if(report[i]!="") count++;
        }
        String[] str=new String[2];
        String[] report_id=new String[count]; //신고한 사람
        String[] reported_id=new String[count]; //신고당한사람
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
        for(int i=0; i<reported_id.length; i++){//신고 당한 횟수 카운트
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