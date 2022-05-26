package Homework;

public class SalesManageEx {

	public static void main(String[] args) {
		Customer cust = new Customer();
	    cust.buy(new Tv(),2);
	    cust.buy(new Computer(),4);
	    cust.buy(new Audio(),3);
	    cust.buy(new Tv(),1);
	    cust.buy(new Computer(),1);
	    cust.buy(new Audio(),1);
	    cust.summary();
	    cust.refund(new Audio(),2); //refund(환불할 품목,환불 갯수)
	    cust.refund(new Tv(),1); 
	    
	}

}
