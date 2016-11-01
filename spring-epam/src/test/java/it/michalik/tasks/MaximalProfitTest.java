package it.michalik.tasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tasks.MaximalProfit;

@RunWith(BlockJUnit4ClassRunner.class)
public class MaximalProfitTest {

	@Test
	public void testMaxProfit() {
		Integer[] profits = {9,5,6,99,4};
		Assert.assertTrue(MaximalProfit.getMaxProfit(profits).equals(99));
	}

	@Test
	public void whenSingleElementArrayReturnTheElement() {
		Integer[] profits = {9};
		Assert.assertTrue(MaximalProfit.getMaxProfit(profits).equals(9));
	}

	
	@Test
	public void whenNullArrayThenReturnNull() {
		Integer[] profits = null;
		Assert.assertTrue(MaximalProfit.getMaxProfit(profits) == null);
	}

}
