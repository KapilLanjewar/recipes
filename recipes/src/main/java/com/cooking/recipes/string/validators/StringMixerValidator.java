package com.cooking.recipes.string.validators;

public class StringMixerValidator {

	public static boolean validateCombinations(String[] combinations)
	{
		int size = combinations[0].length();
		
		for(String combination: combinations)
		{
			if(combination.length() != size)
				return false;
		}
		
		return true;
	}
	
}
