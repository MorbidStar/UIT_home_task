package practic.task5;

import java.util.Map;

import nedis.study.interfaces.t5.collections.MapKey;
import nedis.study.interfaces.t5.collections.MapUtils;
import nedis.study.interfaces.t5.collections.MultiMap;

public class MapUtilsImpl implements MapUtils {

	@SuppressWarnings("unchecked")
	@Override
	public MultiMap<MapKey, Integer> merge(Map<MapKey, Integer>... maps)
			throws IllegalArgumentException {
		
		for (int i = 0; i < maps.length; i++) {
			if (maps[i] == null) {
				throw new IllegalArgumentException();
			}
		}
		
		MultiMap result = new MultiMapImpl();
		
		for (int i = 0; i < maps.length; i++) {
			result.putAll(maps[i]);
		}
		
		return result;
	}

}
