package practic.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		for (List<Integer> list : maps.values()) {
			if (list.contains(value)) {
				return true;
			}
		}
		return false;
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
		
		return maps.get(key).get(list.size()-1);
	}

	@Override
	public void putAll(Map<? extends MapKeyImpl, ? extends Integer> m) {
		for (Entry<? extends MapKeyImpl, ? extends Integer> iter : m.entrySet()) {
			put(iter.getKey(), iter.getValue());
		}
	}

	@Override
	public int size() {
		return maps.size();
	}

	@Override
	public Collection<Integer> values() {
		
		Collection<Integer> result = new ArrayList<>();
		
		for (List<Integer> iter : maps.values()) {
			result.addAll(iter);
		}
		
		return result;
	}

	@Override
	public int countValues(MapKeyImpl key) {
		List<Integer> list = new ArrayList<>();
		return list == null ? 0 : list.size();
	}

	@Override
	public Integer get(Object key) {
		List<Integer> list = maps.get(key);
		return list == null ? null : list.get(list.size() - 1);
	}

	@Override
	public Integer remove(Object key) {
		maps.remove(key);
		return null;
	}

	@Override
	public Iterator<Integer> valuesIterator(MapKeyImpl key) {
		List<Integer> list = maps.get(key);
		return list == null ? Collections.EMPTY_LIST.iterator() : list.iterator();
	}

}
