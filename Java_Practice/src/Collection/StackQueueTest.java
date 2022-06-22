package Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 	-Stack ==>후입선출(LIFO)
 	
 	
 	-Queue ==>선입선출(FIFO)
 */
public class StackQueueTest {

	public static void main(String[] args) {
		/*
		Stack명령
		1. 자료입력: push(입력값)
		2. 자료출력: pop()==> 자료를 꺼내온 후 자료를 stack에서 삭제한다. ,peek()==>삭제없이 자료를 꺼내온다.
		*/
		Stack<String> stack=new Stack<String>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("이순신");
		stack.push("강감찬");
		
		System.out.println("stack => "+stack);
		
		String date=stack.pop();
		System.out.println("꺼내온 값: "+date);
		System.out.println("꺼내온 값: "+stack.pop());
		System.out.println("stack => "+stack);
		
		stack.push("성춘향");
		System.out.println("stack => "+stack);
		
		System.out.println("꺼내온 값: "+stack.pop());
		System.out.println("stack => "+stack);
		System.out.println();
		
		System.out.println("꺼내온 값: "+stack.peek());
		System.out.println("stack => "+stack);
		System.out.println();
		
		/*
		 Queue 명령
		 	-자료입력: offer(입력값)
		 	-자료출력: poll()==> 자료를 꺼내오고 꺼내온 자료를 queue에서 삭제
		 			peek()==>삭제없이 자료를 꺼내온다.
		 */
		//queue객체 생성
		Queue<String> queue=new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("이순신");
		queue.offer("강감찬");
		System.out.println("queue=> "+queue);
		
		String temp=queue.poll();
		System.out.println("꺼내온 값: "+temp);
		System.out.println("꺼내온 값: "+queue.poll());
		System.out.println("queue=> "+queue);
		
		queue.offer("성춘향");
		System.out.println("queue=> "+queue);
		System.out.println("꺼내온 값: "+queue.poll());
		System.out.println("queue=> "+queue);
		
		System.out.println("꺼내온 값: "+queue.peek());
		System.out.println("queue=> "+queue);
	}

}
