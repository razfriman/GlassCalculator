package com.cse3345.f13.friman;

import java.util.ArrayList;

import android.text.TextUtils;

public class EquationParser {

	public EquationParser() {

	}

	private String preprocessEquation(String input) {
		String output = "";

		ArrayList<String> validTokens = new ArrayList<String>();
		
		for (String word : input.split("\\s+")) {
			if (word.length() > 0) {

				if (word.equals("one") || word.equals("won")) {
					word = "1";
				} else if (word.equals("two") || word.equals("to")
						|| word.equals("too")) {
					word = "2";
				} else if (word.equals("three")) {

				} else if (word.equals("four")) {

				} else if (word.equals("five")) {

				} else if (word.equals("six")) {

				} else if (word.equals("seven")) {

				} else if (word.equals("eight")) {

				} else if (word.equals("nine")) {

				} else if (word.equals("ten")) {

				} else if (word.equals("plus")) {

				} else if (word.equals("minus")) {

				} else if (word.equals("negative")) {

				} else if (word.equals("times")) {

				} else if (word.equals("three")) {

				} else if (word.equals("what") || word.equals("is") || word.equals("by")) {
					continue;
				}
			}
		}
		
		output = TextUtils.join(" ", validTokens); 

		return output;
	}

	public EquationTree parseEquation(String input) {

		EquationTree parseTree = new EquationTree();

		String preprocessed = preprocessEquation(input);

		// Tokenize
		// Split using: (?<=[-+*/])|(?=[-+*/])

		// Parse and Build Tree

		return parseTree;
	}
}
