package tasks;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Palindrome {
	
	public static Boolean isPalindrom(Character[] src) {
		if (src == null || src.length == 0)
			return false;
		for (int i = 0; i < (src.length - 1) / 2; i++) {
			if(src[i] != src[src.length-1-i]) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isPalindrom_a1(Character[] src) {
		if (src == null)
			return false;
		String string = String.valueOf(ArrayUtils.toPrimitive(src));
		return StringUtils.isNoneBlank(string) && StringUtils.reverse(string).equals(string);
	}
}
