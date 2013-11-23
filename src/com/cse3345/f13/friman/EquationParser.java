package com.cse3345.f13.friman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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
					validTokens.add("1");
				} else if (word.equals("two") || word.equals("to")
						|| word.equals("too")) {
					validTokens.add("2");
				} else if (word.equals("three")) {
					validTokens.add("3");
				} else if (word.equals("four")) {
					validTokens.add("4");
				} else if (word.equals("five")) {
					validTokens.add("5");
				} else if (word.equals("six")) {
					validTokens.add("6");
				} else if (word.equals("seven")) {
					validTokens.add("7");
				} else if (word.equals("eight")) {
					validTokens.add("8");
				} else if (word.equals("nine")) {
					validTokens.add("9");
				} else if (word.equals("ten")) {
					validTokens.add("10");
				} else if (word.equals("plus")) {
					validTokens.add("+");
				} else if (word.equals("minus") || word.equals("negative")) {
					validTokens.add("-");
				} else if (word.equals("times")) {
					validTokens.add("*");
				} else if (word.equals("divided")) {
					validTokens.add("/");
				} else if (word.equals("what") || word.equals("is")
						|| word.equals("by")) {
					continue;
				} else {
					validTokens.add(word);
				}
			}
		}

		output = TextUtils.join(" ", validTokens);

		return output;
	}
	
	public ArrayList<String> tokenizeEquation(String preprocessedInput) {
		ArrayList<String> tokens = new ArrayList<String>();
		
		String[] splitted = preprocessedInput.split("\\s");
		
		for(String token : splitted) {
			tokens.add(token.trim());
		}
		
		return tokens;
	}
	
	public void buildParseTree(ArrayList<String> tokens) {
		
		LinkedList<Token> outputQueue = new LinkedList<Token>();
		Stack<OperatorToken> operatorStack = new Stack<OperatorToken>();

		for (int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i);

			try {
				// Value
				double value = Double.parseDouble(token);
				outputQueue.add(new NumberToken(value));
				
			} catch (NumberFormatException e) {
				// Operator
				OperatorToken operator = new OperatorToken(token);
				
				while(operatorStack.peek().mPrecedence <= operator.mPrecedence) {
					outputQueue.add(operatorStack.pop());
				}
				
				operatorStack.push(operator);
			}
		}
		
		while(!operatorStack.isEmpty()) {
			outputQueue.add(operatorStack.pop());
		}
	}

	public double parseEquation(String input) {

		double result = 0;

		String preprocessed = preprocessEquation(input);
		
		ArrayList<String> tokens = tokenizeEquation(preprocessed);
		
		buildParseTree(tokens);

		// Parse and Build Tree

		return result;
	}
}
