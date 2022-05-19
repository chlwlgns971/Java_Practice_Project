import java.util.*;

public class HashMap_Practice {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		//"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"
		//按眉 历厘
		map.put("muzi", "frodo");
		map.put("apeach", "frodo");
		map.put("frodo", "neo");
		map.put("muzi", "neo");
		map.put("apeach", "muzi");
		System.out.println("醚 Entry 荐: "+map.size());
		
		//按眉茫扁
		System.out.println("muzi: "+map.get("muzi"));
		
		//按眉甫 窍唱究 贸府
		Set<String> keySet=map.keySet();
		Iterator<String> keyIterator=keySet.iterator();
		while(keyIterator.hasNext()){
			String key=keyIterator.next();
			String value=map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
	}

}