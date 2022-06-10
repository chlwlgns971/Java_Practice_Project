package Game;

public class Item {
	String name;
	int maxHp,maxMp,att,def;
	
	Item(String name, int maxHp, int maxMp, int att, int def){
		this.name=name;
		this.maxHp=maxHp;
		this.maxMp=maxMp;
		this.att=att;
		this.def=def;
	}
	
	String itemInfo() {
		String info=this.name+":";
		if(maxHp>0)info+="체력+"+maxHp;
		if(maxMp>0)info+="마나+"+maxMp;
		if(att>0)info+="공격+"+att;
		if(def>0)info+="방어+"+def;
		return info;
				
	}
}
