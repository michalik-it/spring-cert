package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	
	public static String[] removeDuplicates(String[] src) {
		List<String> result = new ArrayList<>();
		for (String string : src) {
			if (!result.contains(string))
				result.add(string);
		}
		return result.stream().toArray(size -> new String[size]);
	}

	public static String[] removeDuplicates_a2(String[] src) {
		return Arrays.asList(src).stream().distinct().toArray(s -> new String[s]);
	}

	public static String[] removeDuplicates_a1(String[] src) {
		Set<String> set = new LinkedHashSet<>(Arrays.asList(src));
		return (String[]) set.stream().toArray(s -> new String[s]);
	}
}
