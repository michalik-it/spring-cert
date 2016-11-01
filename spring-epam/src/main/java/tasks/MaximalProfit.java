package tasks;

import java.util.Arrays;

public class MaximalProfit {
	public static Integer getMaxProfit(Integer[] profits) {

		return profits == null ? null : Arrays.asList(profits).stream().reduce((a, b) -> a > b ? a : b).get();
	}
}
