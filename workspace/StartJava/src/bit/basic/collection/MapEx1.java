package bit.basic.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

public class MapEx1 {
	public void mapProcess() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "딸기");//ENTRY(KEY|VALUE)
		map.put(2, "딸기");//KEY|VALUE
		map.put(3, "레몬");
		map.put(4, "멜론");
//		System.out.println(map);
		
		Iterator<Integer> itor = map.keySet().iterator();
		while (itor.hasNext()) {
			Integer key = itor.next();
			System.out.println("key:"+key+" Value="+map.get(key));
		}
		
		Iterator<Entry<Integer, String>> itor2 
		= map.entrySet().iterator();
		
		for(;itor2.hasNext();) {
			Entry<Integer, String> entry = itor2.next();
			System.out.println(entry.getKey()+"/"+entry.getValue());
		}
	}
	public void mapProcess2( ) {
		HashMap<String, Object> data1 = new HashMap<String, Object>();
		data1.put("empno", "7612");
		data1.put("name", "홍길동");
		data1.put("sal", "4000");
		
		HashMap<String, Object> data2 = new HashMap<String, Object>();
		data2.put("empno", "7613");
		data2.put("name", "김아무개");
		data2.put("sal", "4000");
		
		Vector<HashMap<String, Object>> vector =
				new Vector<HashMap<String, Object>>();
		vector.add(data1);
		vector.add(data2);
		
		Iterator<HashMap<String, Object>> vitor = vector.iterator();
		while (vitor.hasNext()) {
			HashMap<String, Object> node = vitor.next();
			Iterator<Entry<String, Object>> eitor = 
					node.entrySet().iterator();
			for(;eitor.hasNext();) {
				Entry<String, Object> entry = eitor.next();
				System.out.println(entry.toString());
			}
		}
		
	}
	public static void main(String[] args) {
		MapEx1 m = new MapEx1();
		m.mapProcess2();
	}
}
