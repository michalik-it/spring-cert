package it.michalik.tasks;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tasks.Palindrome;

@RunWith(BlockJUnit4ClassRunner.class)
public class PalindromeTest {

	@Test
	public void shouldReturnTrueForOdd() {
		char[] src1 = "ana".toCharArray();
		Assert.assertTrue(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}

	@Test
	public void shouldReturnTrueForEven() {
		char[] src1 = "anna".toCharArray();
		Assert.assertTrue(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}
	
	@Test
	public void shouldReturnFalsWhenNotPalindrome() {
		char[] src1 = "anax".toCharArray();
		Assert.assertFalse(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}
	
	@Test
	public void shouldReturnTrueForOneLetter() {
		char[] src1 = "a".toCharArray();
		Assert.assertTrue(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}
	
	@Test
	public void shouldReturnTrueForTwoSameLetters() {
		char[] src1 = "aa".toCharArray();
		Assert.assertTrue(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}

	@Test
	public void shouldReturnFalseForEmpty() {
		char[] src1 = "".toCharArray();
		Assert.assertFalse(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}

	@Test
	public void shouldReturnFalseForNull() {
		char[] src1 = null;
		Assert.assertFalse(Palindrome.isPalindrom(ArrayUtils.toObject(src1)));
	}

}
