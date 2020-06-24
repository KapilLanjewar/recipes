package com.cooking.recipes.testers;

import com.cooking.recipes.string.processors.Mixer;
import com.cooking.recipes.string.processors.StringMixer;

public class StringMixerTester {

	public static void main(String[] args) {
		
		System.out.println(1);
		
		String[] values = {"abc", "pqr", "123"};
		
		Mixer mixer = new StringMixer();
		String result = mixer.getMixedString(values);
		System.out.println("Result :: " + result);
		
		System.out.println(2);
		
	}
	
}
