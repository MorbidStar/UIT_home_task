package practic.task5;

import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import nedis.study.interfaces.t5.collections.CollectionUtils;
import nedis.study.interfaces.t5.collections.ListUtils;
import nedis.study.interfaces.t5.collections.MapKey;
import nedis.study.interfaces.t5.collections.MultiMap;
import nedis.study.interfaces.t5.collections.SetUtils;

public class Launcher {

	public static void main(String[] args) {
		
		MultiMap<MapKeyImpl, Integer> map = new MultiMapImpl();
		Map<MapKeyImpl, Integer> map2 = new HashMap();
		map.put(new MapKeyImpl("OK"), 5);
		map.put(new MapKeyImpl("OK"), 6);
		map.put(new MapKeyImpl("OK"), 7);
		map.put(new MapKeyImpl("OKay"), 4);
		map2.put(new MapKeyImpl("OKay"), 33);
		System.out.println("------------------");
		System.out.println(map.countValues(new MapKeyImpl("OKay")));
		map.putAll(map2);
		System.out.println(map.countValues(new MapKeyImpl("OKay")));
		System.out.println(map.values());
	}

}
