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
		MultiMap<MapKeyImpl, Integer> map2 = new MultiMapImpl();
		map.put(new MapKeyImpl("OK"), 5);
		map.put(new MapKeyImpl("OK"), 6);
		map.put(new MapKeyImpl("OK"), 7);
		map.put(new MapKeyImpl("OKay"), 4);
		System.out.println("------------------");
		System.out.println(map.size());
		System.out.println(map2.size());
		map2.putAll(map);
		System.out.println(map2.size());
//		System.out.println(map.countValues(new MapKeyImpl("OK")));
		System.out.println(map.get(new MapKeyImpl("OKay")));
	}

}
