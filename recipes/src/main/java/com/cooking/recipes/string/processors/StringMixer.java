package com.cooking.recipes.string.processors;

import com.cooking.recipes.string.validators.StringMixerValidator;

public class StringMixer implements Mixer {

	public String getMixedString(String[] combinations)
	{
		if(!StringMixerValidator.validateCombinations(combinations))
		{
			throw new RuntimeException("Combinations aren't of same size.");
		}
		
		StringBuilder result = new StringBuilder();
		traverse(combinations, result, 0);
		return result.toString();
	}
	
	private static void traverse(String[] combinations, StringBuilder result, int count)
	{
		for(String combination: combinations)
		{
			if(count < combination.length())
			result.append(combination.charAt(count));
		}
		
		if(count < combinations[0].length())
		{
			++count;
			traverse(combinations, result, count);
		}
	}
	
}
