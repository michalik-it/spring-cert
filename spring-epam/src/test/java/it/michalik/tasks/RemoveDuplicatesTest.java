package it.michalik.tasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tasks.MaximalProfit;
import tasks.RemoveDuplicates;

@RunWith(BlockJUnit4ClassRunner.class)
public class RemoveDuplicatesTest {

	@Test
	public void testRemoveDuplicates() {
		String[] profits = {"ala", "ola", "echo", "ala"};
		String[] noDups = RemoveDuplicates.removeDuplicates(profits);
		
		Assert.assertTrue(noDups[0].equals("ala"));
		Assert.assertTrue(noDups[1].equals("ola"));
		Assert.assertTrue(noDups[2].equals("echo"));
		Assert.assertTrue(noDups.length == 3);
		
	}

	
}
