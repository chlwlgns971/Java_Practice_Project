import java.util.*;

public class HashMap_Practice {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		//"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"
		//��ü ����
		map.put("muzi", "frodo");
		map.put("apeach", "frodo");
		map.put("frodo", "neo");
		map.put("muzi", "neo");
		map.put("apeach", "muzi");
		System.out.println("�� Entry ��: "+map.size());
		
		//��üã��
		System.out.println("muzi: "+map.get("muzi"));
		
		//��ü�� �ϳ��� ó��
		Set<String> keySet=map.keySet();
		Iterator<String> keyIterator=keySet.iterator();
		while(keyIterator.hasNext()){
			String key=keyIterator.next();
			String value=map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
	}

}