package practic.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nedis.study.interfaces.t5.collections.ListUtils;

public class ListUtilsImpl implements ListUtils {

	@Override
	public List<String> asList(String... strings)
			throws IllegalArgumentException {
		
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null) {
				throw new IllegalArgumentException();
			}
		}
		
		return Arrays.asList(strings);
	}

	@Override
	public List<Double> sortedList(List<Double> data)
			throws IllegalArgumentException {
		
		if (data == null) {
			throw new IllegalArgumentException();
		}
		
		List<Double> result = new ArrayList<>();
		result.addAll(data);
		Collections.sort(result);
		Collections.reverse(result);
		return result;
	}

}
