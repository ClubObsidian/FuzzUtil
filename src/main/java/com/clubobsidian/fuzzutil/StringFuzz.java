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
package com.clubobsidian.fuzzutil;

import java.util.ArrayList;
import java.util.List;

import com.clubobsidian.fuzzutil.rule.StringRule;
import com.clubobsidian.fuzzutil.rule.impl.LowercaseRule;
import com.clubobsidian.fuzzutil.rule.impl.SpaceRule;
import com.clubobsidian.fuzzutil.rule.impl.DashesRule;
import com.clubobsidian.fuzzutil.rule.impl.TrimRule;
import com.clubobsidian.fuzzutil.rule.impl.UnderscoreRule;

public final class StringFuzz {

	private StringFuzz() {}
	
	private static List<StringRule> normalizeRules;
	
	static 
	{
		normalizeRules = new ArrayList<>();
		normalizeRules.add(new LowercaseRule());
		normalizeRules.add(new DashesRule());
		normalizeRules.add(new SpaceRule());
		normalizeRules.add(new TrimRule());
		normalizeRules.add(new UnderscoreRule());
	}
	
	public static String normalize(final String input)
	{
		if(input == null)
			return null;
		
		String normalizedInput = input;
		for(StringRule rule : normalizeRules)
		{
			normalizedInput = rule.applyRule(normalizedInput);
		}
		return normalizedInput;
	}
}