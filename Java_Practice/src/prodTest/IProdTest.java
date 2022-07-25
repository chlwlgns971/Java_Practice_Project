package prodTest;

import java.util.List;

public class IProdTest {
	
	private IProdService service;

	public IProdTest() {
		service=IProdServiceImpl.getInstance();
	}
	public void selectAll() {
		List<ProdVO> list=service.selectAll();
		
		for(ProdVO prod : list) {
			String id=prod.getProd_id();
			String name=prod.getProd_name();
			String lgu=prod.getProd_lgu();
			String buyer=prod.getProd_buyer();
			int cost=prod.getProd_cost();
			int price=prod.getProd_price();
			int sale=prod.getProd_sale();
			
			System.out.println(id+"\t"+name+"\t"+lgu+"\t"+buyer+"\t"+cost+"\t"+price+"\t"+sale+"\t");
		}
		
	}
	public static void main(String[] args) {
		new IProdTest().selectAll();
	}

}
