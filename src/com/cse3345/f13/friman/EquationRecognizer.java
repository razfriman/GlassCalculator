package com.cse3345.f13.friman;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EquationRecognizer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card_equation_recognizer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.equation_recognizer, menu);
		return true;
	}

}
