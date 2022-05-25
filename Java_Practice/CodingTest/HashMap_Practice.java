import java.util.*;

public class HashMap_Practice {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		//"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"
<<<<<<< HEAD
		//ê°ì²´ ì €ìž¥
		map.put("muzi", "frodo");
		map.put("apeach", "frodo");
		map.put("frodo", "neo");
		map.put("muzi", "neo");
		map.put("apeach", "muzi");
		System.out.println("ì´ Entry ìˆ˜: "+map.size());
		
		//ê°ì²´ì°¾ê¸°
		System.out.println("muzi: "+map.get("muzi"));
		
		//ê°ì²´ë¥¼ í•˜ë‚˜ì”© ì²˜ë¦¬
		Set<String> keySet=map.keySet();
		Iterator<String> keyIterator=keySet.iterator();
		while(keyIterator.hasNext()){
			String key=keyIterator.next();
			String value=map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
	}

}
=======
		//°´Ã¼ ÀúÀå
		map.put("muzi", "frodo");
		map.put("apeach", "frodo");
		map.put("frodo", "neo");
		map.put("muzi", "neo");
		map.put("apeach", "muzi");
		System.out.println("ÃÑ Entry ¼ö: "+map.size());
		
		//°´Ã¼Ã£±â
		System.out.println("muzi: "+map.get("muzi"));
		
		//°´Ã¼¸¦ ÇÏ³ª¾¿ Ã³¸®
		Set<String> keySet=map.keySet();
		Iterator<String> keyIterator=keySet.iterator();
		while(keyIterator.hasNext()){
			String key=keyIterator.next();
			String value=map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
	}

}
>>>>>>> refs/remotes/origin/master
