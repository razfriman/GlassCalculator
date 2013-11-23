package com.cse3345.f13.friman;

public class NumberToken extends Token {
	public double mDoubleValue;

	public NumberToken(double value) {
		super(Double.toString(value));
		mDoubleValue = value;
	}
}
