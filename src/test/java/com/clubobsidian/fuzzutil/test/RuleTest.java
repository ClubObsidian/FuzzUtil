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

import com.clubobsidian.fuzzutil.rule.StringRule;
import com.clubobsidian.fuzzutil.rule.impl.DashesRule;
import com.clubobsidian.fuzzutil.rule.impl.LowercaseRule;
import com.clubobsidian.fuzzutil.rule.impl.SpaceRule;
import com.clubobsidian.fuzzutil.rule.impl.TrimRule;
import com.clubobsidian.fuzzutil.rule.impl.UnderscoreRule;

public class RuleTest {

	private static final String TEST = "test";
	
	@Test
	public void testDashes()
	{
		String dashes = "-t-e-s-t-";
		StringRule rule = new DashesRule();
		assertTrue("Dashes rule failed", rule.applyRule(dashes).equals(TEST));
	}
	
	@Test
	public void testLowercase()
	{
		String lowercase = "tEsT";
		StringRule rule  = new LowercaseRule();
		assertTrue("Lowercase rule failed", rule.applyRule(lowercase).equals(TEST));
	}
	
	@Test
	public void testSpace()
	{
		String lowercase = "t  e  st   ";
		StringRule rule  = new SpaceRule();
		assertTrue("Space rule failed", rule.applyRule(lowercase).equals(TEST));
	}
	
	@Test
	public void testTrim()
	{
		String trim = "    \ttest\n   ";
		StringRule rule  = new TrimRule();
		assertTrue("Trim rule failed", rule.applyRule(trim).equals(TEST));	
	}
	
	@Test
	public void testUndescore()
	{
		String trim = "___t__e_st";
		StringRule rule  = new UnderscoreRule();
		assertTrue("Underscore rule failed", rule.applyRule(trim).equals(TEST));	
	}
}