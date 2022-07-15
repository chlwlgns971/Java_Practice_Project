package MVC;

public class MVCTest {

	public static void main(String[] args) {
		/*
		 MVC(Model, View, Controller)패턴
		 MVC패턴의 로직을 처리하는 클래스들
		 	-VO,DRO=>데이터를 저장하는 역할만 하는 클래스
		 		(VO=Value Object, DTO=Data Transfer Object)=> DB테이블에서 1개의 레코드를 저장할 클래스
		 	
		 	-DAO=>SQL문을 서버에 보내서 결과를 얻어오는 역할을 수행하는 클래스
		 		(DAO=Data Access Object)
		 	-Service=>일을 수행하는 중간 관리자와 같은 역할을 수행하는 클래스
		 	Service는 일이 있으면 그 일에 필요한 DAO를 호출해서 일을 처리한 후 처리 결과를 Controller에 전달한다.
		 	
		 	Controller=> 비지니스 로직이 시작되는 곳으로 사용자의 요청에 맞는 일을 Service에게 시키고, 
		 	Service가 보내온 처리결과를 화면등에 반영시키는 역할을 수행
		 	
		 	Controller -> Service -> DTO -> DB서버 -> DAO-> Service-> Controller
		 	보통은 DTO/VO -> DAO/Service interface-> DAO -> Controller순으로 작성한다.
		 */

	}

}
