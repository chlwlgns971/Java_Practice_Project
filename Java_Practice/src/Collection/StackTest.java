package Collection;

import java.util.Stack;

public class StackTest {
	//웹페이지에서 스택 활용기능 간단하게 구현테스트
	public static void main(String[] args) {
		Browser br=new Browser();
		br.goURL("1.네이버");
		br.history();
		
		br.goURL("2. 야후");
		br.history();
		
		br.goURL("3. 구글");
		br.goURL("4. 다음");
		br.history();
		
		System.out.println("뒤로가기 후..");
		br.goBack();
		br.history();
		
		System.out.println("앞으로가기 후...");
		br.goFroward();
		br.history();
		
		System.out.println("새로운 사이트 방문 후...");
		br.goURL("5.네이트");
		br.history();
	}

}

//웹브라우저의 앞으로가지, 뒤로가기 기능 구현하기(Stack이용)
class Browser {
	private Stack<String> back; //이전 방문내역이 저장될 스택
	private Stack<String> forward; //다음 방문내역이 저장될 스택
	private String currentURL;
	
	//생성자
	public Browser() {
		back=new Stack<String>();
		forward=new Stack<String>();
		currentURL="";
	}
	
	//사이트를 방문하는 메서드=>매개변수에는 방문할 URL이 들어간다
	public void goURL(String url) {
		System.out.println(url+" 사이트에 접속합니다...");
		
		if(currentURL!=null && !"".equals(currentURL)) {
			back.push(currentURL); //현재페이지를 back스택에 추가한다.
		}
		forward.clear(); //forward정보를 모두 삭제
		currentURL=url; //현재 페이지를 방문한 페이지로 변경
	}
	//뒤로가기
	public void goBack() {
		//back스택이 비었는지 여부를 검사한다. ==> isEmpty()메서드 사용
		//isEmpty()=>List가 비어있으면 true, 그렇지 않으면 false반환
		if(!back.isEmpty()) {
			forward.push(currentURL); //현재페이지를 forward에 추가
			currentURL=back.pop(); // back에서 꺼내와 현재페이지로 한다.
		}
	}
	//앞으로 가기
	public void goFroward() {
		if(!forward.isEmpty()) {
			back.push(currentURL); //현재 페이지를 back에 추가
			currentURL=forward.pop(); //forward에서 꺼내와 현재페이지로 한다.
		}
	}
	//방문기록 확인하기
	public void history() {
		System.out.println("========================");
		System.out.println("   방     문    기   록");
		System.out.println("========================");
		System.out.println("back => "+back);
		System.out.println("forward => "+forward);
		System.out.println("현재페이지 => "+currentURL);
		System.out.println("========================");
		System.out.println();
	}
	
}