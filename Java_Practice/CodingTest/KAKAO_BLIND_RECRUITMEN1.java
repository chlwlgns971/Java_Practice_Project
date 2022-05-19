import java.util.Arrays;
/*
 * ����: [2, 1, 1, 0]
 * �׽�Ʈ ���̽��� ��������, �ٸ� ���̽����� �ð��ʰ� �� ��Ÿ�� �����߻�.
 * hashmap�� �н��ϰ� �ٽ� �غ��� �� �ʿ伺�� ����
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
        int[] reported_count =new int[id_list.length]; //�Ű���� Ƚ��
        int[] blocked =new int[id_list.length]; //�������ϴ� ����
        for(int i=0; i<report.length-1; i++){ //�ߺ�����
            for(int j=i+1; j<report.length; j++){
                if(report[i].equals(report[j])){
                    report[j]="";
                }
            }
        }
        for(int i=0; i<report.length; i++){ //�ߺ������� �Ű�Ƚ�� ī��Ʈ
        	if(report[i]!="") count++;
        }
        String[] str=new String[2];
        String[] report_id=new String[count]; //�Ű��� ���
        String[] reported_id=new String[count]; //�Ű���ѻ��
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
        for(int i=0; i<reported_id.length; i++){//�Ű� ���� Ƚ�� ī��Ʈ
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
