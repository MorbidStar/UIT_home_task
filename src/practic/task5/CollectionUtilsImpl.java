package practic.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nedis.study.interfaces.t5.collections.CollectionUtils;

public class CollectionUtilsImpl implements CollectionUtils {

	@Override
	public Collection<Integer> union(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		
		IfArgsNullThrowException(a, b);
		
		Collection<Integer> result = new ArrayList<>(a);
		result.addAll(b);
		
		return result;
	}

	@Override
	public Collection<Integer> intersection(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		
		IfArgsNullThrowException(a, b);
		
		List<Integer> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>(b);
		
		for (int i = 0; i < b.size(); i++) {
			if (a.contains(tmp.get(i))) {
				result.add(tmp.get(i));
				a.remove(tmp.get(i));
			}
		}
		
		return result;
	}

	@Override
	public Set<Integer> unionWithoutDuplicate(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		
		IfArgsNullThrowException(a, b);
		
		Set<Integer> result = new HashSet<>(a);
		result.addAll(b);
		
		return new HashSet<Integer>(union(a,b));
	}

	@Override
	public Set<Integer> intersectionWithoutDuplicate(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		
		IfArgsNullThrowException(a, b);
		
		Set<Integer> result = new HashSet<>(a);
		
		result.retainAll(b);
		
		return result;
	}

	@Override
	public Collection<Integer> difference(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		
		IfArgsNullThrowException(a, b);
		
		Collection<Integer> result = new ArrayList<>(a);
		result.removeAll(b);
		
		return result;
	}
	
	private void IfArgsNullThrowException(Collection<Integer> a,
			Collection<Integer> b) {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
	}

}
