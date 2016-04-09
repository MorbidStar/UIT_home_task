package practic.task5;

import java.util.Map;

import nedis.study.interfaces.t5.collections.MapKey;
import nedis.study.interfaces.t5.collections.MapUtils;
import nedis.study.interfaces.t5.collections.MultiMap;

public class MapUtilsImpl implements MapUtils {

	@Override
	public MultiMap<MapKey, Integer> merge(Map<MapKey, Integer>... maps)
			throws IllegalArgumentException {
		maps[0].keySet();
		return null;
	}

}
