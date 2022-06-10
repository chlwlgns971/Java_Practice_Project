package Game;

public class Monster {
	String name;
	int maxHp, maxMp, hp, mp, att, def, exp;
	Item[] items;
	
	Monster(String name, int maxHp, int maxMp, int att, int def, int exp, Item[] items){
		this.name=name;
		this.maxHp=maxHp;
		this.maxMp=maxMp;
		this.hp=maxHp;
		this.mp=maxMp;
		this.att=att;
		this.def=def;
		this.exp=exp;
		this.items=items;
	}
	void attack(Character c) {
		int dmg=this.att-c.def;
		dmg=(dmg<=0)? 1:(dmg);
		c.hp=c.hp<dmg? 0:c.hp-dmg;
		System.out.println(name+"(이)가 공격으로 "+c.name+"에게 "+dmg+"만큼 데미지를 주었습니다.");
		System.out.println(c.name+"의 남은 체력: "+c.hp);
		System.out.println();
	}
	Item itemDrop() {
		return items[(int)Math.random()*items.length];
	}
}
