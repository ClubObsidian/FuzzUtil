/*
   Copyright 2019 Club Obsidian and contributors.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.clubobsidian.fuzzutil.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.clubobsidian.fuzzutil.StringFuzz;

public class StringFuzzUtilTest {

	private static final String TEST = "test";
	
	@Test
	public void testNull()
	{
		String nullString = null;
		String normalize = StringFuzz.normalize(nullString);
		assertTrue("Normalized string is not null with a null input", normalize == null);
	}
	
	@Test
	public void testNormalize()
	{
		String toNormalize = "\t\n___-T-e-s-t-   -_";
		String normalize = StringFuzz.normalize(toNormalize);
		assertTrue("String normalize failed", normalize.equals(TEST));
	}
	
	@Test
	public void testFuzzyEqual()
	{
		String input = "\t\n___-T-e-s-t-   -_";
		String comparison = "test";
		boolean areEqual = StringFuzz.fuzzyEqual(input, comparison);
		assertTrue("String fuzzy equal failed", areEqual);
	}
}