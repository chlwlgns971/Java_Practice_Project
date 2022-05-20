import java.util.*;
public class SolutionSort1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] array = {1, 5, 2, 6, 3, 7, 4}	;
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = s.solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}

}
class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] arr=Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[i]=arr[commands[i][2]-1];
        }
        return answer;
    }
}