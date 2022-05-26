package Homework;

import java.util.Arrays;

//1. 반품메서드 구현(refund)
//2. 구매수량을 반영한 구매메서드(buy) 

public abstract class Product {
	   int price; // 제품의 가격
	   int bonusPoint; // 제품구매 시 제공하는 보너스점수
	   
	   Product(int price) {
	      this.price = price;
	      bonusPoint = (int)(price/10.0); // 보너스점수는 제품가격의 10%
	   }
	   Product() {}
}
class Customer {
	   int money = 1000; // 소유금액
	   int bonusPoint = 0; // 보너스점수
	   int i = 0;//Product 배열의 index
	   int count=0;
	   Product[] cart=new Product[10];
	   
	   void buy(Product p, int cnt) {
	      if(money < p.price*cnt) {
	         System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
	         return;
	      }
	      count=0;
	      money -= p.price*cnt; // 가진 돈에서 구입한 제품의 가격을 뺀다.
	      bonusPoint += p.bonusPoint*cnt; // 제품의 보너스 점수를 추가한다.
	      for(int j=0; j<cnt; j++) {
	    	  cart[i++] = p; // 제품을 Product[] cart에 저장한다.
	      }
	      for(int j=0; j<cart.length; j++){
	    	  if(cart[j]!=null) {
	    		  if(p.toString().equals(cart[j].toString())) count++;
	    	  }
	      }
	      System.out.println(p + "을/를 구입하셨습니다.");
	      System.out.println("지금까지 구매한 "+p+"의 갯수는 "+count+"개입니다.");
	      System.out.println("지금까지 구매한 모든 상품의 갯수는 "+i+"개입니다.");
	      System.out.println(Arrays.toString(cart));
	      System.out.println();
	   }
	   //반품메서드 
	   void refund(Product p, int count){
		   System.out.println("환불을 진행하고 있습니다.");
		   String str=p.toString();
	       money+=p.price;
	       bonusPoint-=p.bonusPoint;
	       for(int j=0; j<cart.length; j++) {
	    	   if(cart[j]!=null) {
	    		   if(str.equals(cart[j].toString())) {
		    		   if(count==0) break;
		    		   else{
		    			   cart[j]=null;
		    			   count--;
		    		   }
		    	   }
	    	   }
	       }
	       if(count==0) {
	    	   System.out.println(p+"의 환불을 완료하였습니다.");
		       summary();
	       }
	       else {
	    	   System.out.println(p+"를 구매하지 않았습니다.");
		       summary();
	       }
	   }
	   void summary() { // 구매한 물품에 대한 정보를 요약해서 보여 준다.
	      int sum = 0; // 구입한 물품의 가격합계
	      String itemList =""; // 구입한 물품목록
	      // 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
	      for(int i=0; i<cart.length;i++) {
	         if(cart[i]!=null) {
		         sum += cart[i].price;
		         itemList += cart[i].toString() + ", ";
	         }
	       }
	      System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
	      System.out.println("구입하신 제품은 " + itemList + "입니다.");
	      System.out.println();
	  }
}
class Audio extends Product {
	   Audio(){ 
	      super(50); 
	   }
	   @Override
	   public String toString(){
	      return "Audio"; 
	   }
}
class Computer extends Product {
	   Computer() { 
	      super(200); 
	   }
	   @Override
	   public String toString() { 
	      return "Computer"; 
	   }
}
class Tv extends Product{
	   Tv(){
	   // 조상클래스의 생성자 Product(int price)를 호출한다.
	   super(100); // Tv의 가격을 100만원으로 한다.
	   }
	   // Object클래스의 toString()을 오버라이딩한다.
	   @Override
	   public String toString() { 
	      return "Tv"; 
	   }
}
