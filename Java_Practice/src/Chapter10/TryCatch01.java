package Chapter10;
import java.util.Scanner;
import java.util.Map;
/*자바의 예외
- 에외란 error에 일종이며, 발생시 시스템 및 프로그램을 수행 불능상태 만들고 비정상적 종료됨  
- 이를 막기 위해 예외 처리를 통해, 시스템 및 프로그램을 정상종료로 유도
1) 예외의 종류 
 . Exception - 컴파일 시점에 발생하는 예외
 . Runtime Exception - 프로그램 실행시에 발생하는 예외
 . java.lang.Exception 제공 - 최상위 예외 클래스 (Object -> Throwable  -> Error
                                                                 |->Exception |-> Exception
                                                                              |-> runtime Exception  )
 
2) 사용형식 
   try {
          ...
      } catch(예외1) {
        ...
    } catch(예외2) {
        ...
       ...
    }
  . try block - 예외가 발생할 가능성이 있는 명령문(들)
  . catch block - 에외 발생시 수행할 명령문(들) 
    catch(예외클래스명 변수명){
         변수명.printStackTrace();
         System.out.println("  ");
    catch(예외클래스명 변수명){
         변수명.printStackTrace();
         System.out.println("  ");
    finally {
        ....
    }
    
    - 복수개의 catch block를 사용하는 경우 상위 예외클래스가 하위 예외클래보다 아래에 위치 
      Exception class는 가장 아래 위치해야 됨   
    - finally block은 예외가 발생하든 하지 않든 반드시 실행할 명령문(들) 기술

 3) 예외 미루기 
 . 메소드 내부에서 예외가 발생할 수 있는 코드를 작성할 때, try-catch 블록으로 예외 처리 하는 것이 기본
 . 메소드를 호출한 곳으로 예외 처리를 미룰 수 있음. 
 . throws 사용 - 메서드 선언부 끝에 기술하며, 
   메서드에서 처리하지 않은 예외를 예외를 호출한 곳으로 떠넘기는 역할 
 (기술형식)
   public void method1(){
      try {
          method2();                              
      catch(Exception e){                        <------|예외처리
          e.printStackTrace();                       |   
      }                                         |  
   }                                                        |
                                                            |
   public void method2() throws Exception{                  |
      CLass cs=Class.forName("java.lang,String2");     ------예외발생      
  
   }
   
 . main()메서드에 throws Exception 사용은 바람직하지 않음
   -> try ~ catch 사용이 바람직 함      
 
4) try-with-resource
 . JDK 1.7부터 추가된 기능으로 입출력, 소켓, 커넥션풀 등 연결/종료가 무조건 한 쌍이 되어야 하는 로직의 경우 유용하게 사용
 . 객체 생성 코드를 작성하고 close()를 명시하지 않아도 try 블럭을 벗어나는 순간 자동으로 close()가 호출 됨 
 . 개발자가 명시적으로 닫아주지 않아도 되기때문에 코드가 간결해짐 
 . 예)- 패키지 2
   public class CloseableResource implements AutoCloseable{
     public void exceptionWork(boolean isException) throws WorkException {
         System.out.println("exceptionWork("+isException+") 호출됨");
         if (isException) {
             throw new WorkException("called WorkException");
         }
      }

     @Override
     public void close() throws CloseException {
         System.out.println("close() 호출됨");
         throw new CloseException("called CloseExceptiond");
     }
     
     
 5) 사용자 예외클래스 생성 
 . Exception class를 생속 받아 생성 
 (사용형식) 
   클래스명 extends Exception{
     public 클래스명(String msg){
        super(msg);
     }
   }          
     
예제 1] 정수형 배열 5개에 100~500 의 값을 저장하고 인쇄는 코드를 배열 인덱스의 범위에 따른 예외처리를 고려하여 작성하시오…  
예제 2] java.util 패키지의  Map객체를 생성하고 Map 객체에 저장됨 문자열을 숫자로 변환하여 반환하는 메서드를 작성하시오. 
      단, 생성된 객체가 null point이거나 숫자형식에 어긋날는 경우 객체 생성 메서드를 호출하는 메서드에서 예외를 처리하시오…
예제 3] [0-3]사이의 난수를 발생시켜 0의 값이 나오면 예외를 발생시키는 메서드를 작성하고 이 메서드를 호출하는 곳(main())에서
      예외처리를 하도록 프로그램을 작성하시오. 또, 사용자 예외클래스를 생성하여 사용하시오.  
예제 4] try - with - resource 구문을 사용하여 파일처리를 수행하는 메서드를 작성하시오…              
예제 5] 응용프로그램을 설치할때 메모리와 저장공간을 체크하여 부족한 경우 예외를 발생시키는 사용자 예외클래스를 생성하고 
      이를 이용하는 프로그램 작성            
*/
public class TryCatch01 {

	public static void main(String[] args) {
		//예제1
		Solution s1=new Solution();
		s1.sol1();
		//예제2
		Map map=null;
		try {
			int num=s1.sol2(map);
		} 
		catch (NullPointerException e) {
			System.out.println("오류원인: "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("오류원인: "+e.getMessage());
		}
		//예제3
		UseException ue=new UseException();
		try {
	         ue.useExcept();
	         
	      }catch(RandException e) {
	         System.out.println("오류 원인 : "+ e.getMessage());
	         
	      }catch(Exception e) {
	         System.out.println("오류 원인 : "+ e.getMessage());
	         
	      }
	      
	      
	      System.out.println("시스템 종료");
	      
	      
	      //예제5
	      try {
	    	  startInstall();
	    	  copyFile();
	      }
	      catch(SpaceException e) {
	    	  System.out.println("에러메세지: "+e.getMessage());
	    	  e.printStackTrace();
	    	  System.out.println("공간 확보 후 다시 설치 바람");
	      }
	      catch(MemoryException e) {
	    	  System.out.println("에러메세지: "+e.getMessage());
	    	  e.printStackTrace();
	    	  System.out.println("메모리 확보 후 다시 설치 바람");
	      }
	      
	}
	public static void startInstall() throws MemoryException, SpaceException{
		if(!enoughSpace()) {
			throw new SpaceException("설치공간 부족");
		}
		else if(!enoughMemory()) {
			throw new MemoryException("메모리 부족");
		}
	}
	public static void copyFile() {
		
	}
	public static void deleteFile() {
		
	}
	public static boolean enoughSpace() {
		return false;
	}
	public static boolean enoughMemory() {
		return false;
	}
}
class Solution{
	Scanner sc=new Scanner(System.in);
	public void sol1() {
		int[] arr=new int[5];
		int num=0;
		try {
			System.out.println("100을 저장할 인덱스를 입력하세요.");
			num=sc.nextInt();
			arr[num]=100;
			System.out.println("200을 저장할 인덱스를 입력하세요.");
			num=sc.nextInt();
			arr[num]=200;
			System.out.println("300을 저장할 인덱스를 입력하세요.");
			num=sc.nextInt();
			arr[num]=300;
			System.out.println("400을 저장할 인덱스를 입력하세요.");
			num=sc.nextInt();
			arr[num]=400;
			System.out.println("500을 저장할 인덱스를 입력하세요.");
			num=sc.nextInt();
			arr[num]=500;
		} 
		catch (Exception e) {
			System.out.println("잘못된 인덱스 값입니다.");
		}
	}
	public int sol2(Map map) throws NullPointerException, Exception{
		int res=Integer.parseInt(map.get("홍길돌").toString());
		return res;
	}
	
}
