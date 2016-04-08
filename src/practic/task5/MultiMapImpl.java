package practic.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.MXBean;

import nedis.study.interfaces.t5.collections.MultiMap;

public class MultiMapImpl implements MultiMap<MapKeyImpl, Integer> {
	
	private Map<MapKeyImpl, List<Integer>> maps = new HashMap<>();

	@Override
	public void clear() {
		maps.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return maps.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return maps.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<MapKeyImpl, Integer>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return maps.isEmpty();
	}

	@Override
	public Set<MapKeyImpl> keySet() {
		return maps.keySet();
	}

	@Override
	public Integer put(MapKeyImpl key, Integer value) {
		List<Integer> list = new ArrayList<>();
		
		if (maps.containsKey(key)) {
			list.addAll(maps.get(key));
		}
		
		list.add(value);
		maps.put(key, list);
		
		if (list.size() == 1) {
			return null;
		} else {
			return maps.get(key).get(list.size()-2);
		}
	}

	@Override
	public void putAll(Map<? extends MapKeyImpl, ? extends Integer> m) {
//		Set<? extends MapKeyImpl> set = new HashSet<>();
//		List<Integer> list = new ArrayList<>();
//		
//		set = m.keySet();
//		list.addAll(m.values());
//		
//		for (MapKeyImpl iter : set) {
//			maps.put(iter, list);
//		}
//		System.out.println(list);
	}

	@Override
	public int size() {
		return maps.size();
	}

	@Override
	public Collection<Integer> values() {
		return (Collection)maps.values();
	}

	@Override
	public int countValues(MapKeyImpl key) {
		return maps.get(key).size();
	}

	@Override
	public Integer get(Object key) {
		List<Integer> list = new ArrayList<>();
		
		if (maps.containsKey(key)) {
			list.addAll(maps.get(key));
		} else {
			return null;
		}
		
		return list.get(list.size()-1);
	}

	@Override
	public Integer remove(Object key) {
		
		if (maps.containsKey(key)) {
		maps.remove(key);
		return 1;
		}
		
		return 0;
	}

	@Override
	public Iterator<Integer> valuesIterator(MapKeyImpl key) {
		// TODO Auto-generated method stub
		return null;
	}

}
