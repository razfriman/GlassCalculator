package com.cse3345.f13.friman;

public class OperatorToken extends Token {
	public int mPrecedence;

	public OperatorToken(String value) {
		super(value);
		if (value.equals("+") || value.equals("-")) {
			mPrecedence = 2;
		} else if (value.equals("*") || value.equals("/")) {
			mPrecedence = 3;
		} else {
			mPrecedence = 0;
		}
	}
	
	public double computeOperator(double value1, double value2) {
		
		double result = 0;
		
		if (mValue.equals("+")) {
			result = value1 + value2;
		} else if (mValue.equals("-")) {
			result = value1 - value2;
		} else if (mValue.equals("*")) {
			result = value1 * value2;
		} else if (mValue.equals("/")) {
			result = value1 / value2;
		}
		
		return result;
	}
}