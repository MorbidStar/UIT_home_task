package practic.task5;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import nedis.study.interfaces.t5.collections.SetUtils;

public class SetUtilslJava7 implements SetUtils {

	@Override
	public SortedSet<String> orderedSet(Collection<Integer> collection1,
			Set<String> set2) throws NullPointerException {
		
		if (collection1 == null || set2 == null) {
			throw new NullPointerException();
		}
		
		SortedSet<String> sortSet = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		Iterator<Integer> iter = collection1.iterator();
		
		while (iter.hasNext()) {
			sortSet.add(iter.next().toString());
		}
		
		sortSet.addAll(set2);
		
		return sortSet;
		
	}

	@Override
	public Set<Integer> customOrderSet(int val1, int val2, int val3, int val4,
			int val5) {
		// TODO Auto-generated method stub
		return null;
	}

}
