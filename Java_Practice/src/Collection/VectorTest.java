package Collection;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체생성
		Vector v1 = new Vector();
		System.out.println("처음크기: "+v1.size());
		
		//데이터추가=>add(추가할 데이터)
		//반환값: 추가성공(true), 추가실패(false)
		v1.add("aaaaa");
		v1.add(new Integer(111));
		v1.add(123);//오토박싱
		v1.add('a');
		v1.add(true);
		boolean r=v1.add(3.14f);
		System.out.println("중간크기: "+v1.size());
		System.out.println("반환값: "+r);
		System.out.println();
		System.out.println("v1=>"+v1.toString());
		System.out.println();
		
		//데이터추가:add(index, date)->index번째에 데이터를 끼워넣는다.(반환값은 없다.)
		v1.add(1,"kkk");
		System.out.println("v1=>"+v1);
		System.out.println();
		
		//데이터 꺼내오기:get(index)
		//->'index'번째 데이터를 반환한다.
		int data=(int)v1.get(2);
		System.out.println("data=>"+data);
		String str=(String)v1.get(0);
		System.out.println("str=>"+str);
		System.out.println();
		
		//데이터 수정하기:set(index,새로운데이터)->index번째의 데이터를 새로운데이터로 덮어쓴다.
		//반환값: 삭제되기 이전의 원래 데이터
		String temp=(String)v1.set(0,"zzzz");
		System.out.println("v1=>"+v1);
		System.out.println("원래의 데이터:"+temp);
		System.out.println();
		
		//데이터 삭제하기:remove(index)->반환값: 삭제된 데이터
		temp=(String)v1.remove(0);
		System.out.println("v1=>"+v1);
		System.out.println("삭제된 데이터:"+temp);
		
		//데이터 삭제하기:remove(삭제할 데이터)->삭제할 데이터를 찾아서 삭제한다. 삭제할 데이터가 여러개이면 가장 앞에서부터 삭제
		//반환값: 삭제성공(true), 삭제실패(false)
		v1.remove("kkk");
		System.out.println("v1=>"+v1);
		v1.remove(new Integer(123)); //그냥123을 쓰면 인덱스로 인식해서 에러발생
		System.out.println("v1=>"+v1);
		v1.remove(new Character('a'));
		System.out.println("v1=>"+v1);
		v1.remove(3.14f);
		System.out.println("v1=>"+v1);
		v1.remove(true);
		System.out.println("v1=>"+v1);
		
		
		/*
		 제네릭 타입(Generic Type)==> 클래스 내부에서 사용할 데이터의 데이터 타입을 외부에서 지정하는 기법으로 객체를 선언할 때 <>안에 
		 그 객체의 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다. 이런식으로 선언하게되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 이 때 제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		 ==>제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환 없이 꺼내올 수 있다.
		 */
		Vector<String> v2=new Vector<String>();
		Vector<Integer> v3=new Vector<Integer>();
		
		v2.add("안녕하세요");
		String temp2=v2.get(0);
		
		Vector<Vector> vv=new Vector<Vector>();
		Vector<Vector<Vector>> vvv=new Vector<Vector<Vector>>();
		System.out.println();
		
		//전체데이터 삭제하기:clear()
		v2.clear();
		System.out.println("v2 size=>"+v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4=new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2=>"+v2);
		System.out.println("v4=>"+v4);
		
		//데이터삭제하기:removeAll(Collection 객체)->collection객체가 가지고 있는 모든 값을 삭제한다.
		System.out.println("======removerAll=======");
		v2.removeAll(v4); //v2에 있는 데이터 중 v4가 가지고 있는 데이터와 일치하는 것들을 모두 삭제한다.
		System.out.println("v2=>"+v2);
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		System.out.println();
		//출력(향상된 for문)
		for(String s:v2) {
			System.out.println(s);
		}
	}

}
