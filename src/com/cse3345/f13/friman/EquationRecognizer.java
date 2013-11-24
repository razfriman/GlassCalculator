package com.cse3345.f13.friman;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;

/**
 * 
 * @author Raz Friman
 * @version 1.0 The main activity class. This class handles all of the actions
 *          associated with the application.
 */
public class EquationRecognizer extends Activity {

	private static final int SPEECH_REQUEST = 0;
	
	private GestureDetector mGestureDetector;
	private EquationParser mEquationParser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Inflate the main view
		setContentView(R.layout.card_equation_recognizer);

		// Add a gesture recognizer to handle the tap event
		mGestureDetector = createGestureDetector(this);

		// Instantiate an EquationParser class to parse the input equations
		mEquationParser = new EquationParser();
	}

	@Override
	protected void onResume() {
		super.onResume();

		ArrayList<String> voiceResults = getIntent().getExtras()
				.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
		String spokenText = voiceResults.get(0);
		
		calculateResult(spokenText);
	}
	
	private void displaySpeechRecognizer() {
	    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	    startActivityForResult(intent, SPEECH_REQUEST);
	}
	
	private void calculateResult(String spokenText) {
		
		String convertedInput = mEquationParser.preprocessEquation(spokenText);
		
		double result = mEquationParser.parseEquation(spokenText);
		
		// Set the input
		TextView inputTextView = (TextView) findViewById(R.id.input_expression_text_view);
		inputTextView.setText(convertedInput);
		
		// Set the result
		TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
		resultTextView.setText("Answer: " + result);		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.ask_again) {
			displaySpeechRecognizer();
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	        Intent data) {
	    if (requestCode == SPEECH_REQUEST && resultCode == RESULT_OK) {
	        ArrayList<String> voiceResults = data.getStringArrayListExtra(
	                RecognizerIntent.EXTRA_RESULTS);
	        String spokenText = voiceResults.get(0);
	        
	        calculateResult(spokenText);
	    }
	    super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu
		getMenuInflater().inflate(R.menu.equation_recognizer, menu);
		return true;
	}

	/**
	 * 
	 * @param context
	 * @return a GestureDetector that handles all of the gesture events
	 */
	private GestureDetector createGestureDetector(Context context) {
		GestureDetector gestureDetector = new GestureDetector(context);
		// Create a base listener for generic gestures
		gestureDetector.setBaseListener(new GestureDetector.BaseListener() {
			@Override
			public boolean onGesture(Gesture gesture) {
				if (gesture == Gesture.TAP) {
					// Open the options menu when the user performs a tap event
					openOptionsMenu();
					return true;
				} else if (gesture == Gesture.TWO_TAP) {
					// do something on two finger tap
					return true;
				} else if (gesture == Gesture.SWIPE_RIGHT) {
					// do something on right (forward) swipe
					return true;
				} else if (gesture == Gesture.SWIPE_LEFT) {
					// do something on left (backwards) swipe
					return true;
				}
				return false;
			}
		});

		gestureDetector.setFingerListener(new GestureDetector.FingerListener() {
			@Override
			public void onFingerCountChanged(int previousCount, int currentCount) {
				// do something on finger count changes
			}
		});

		gestureDetector.setScrollListener(new GestureDetector.ScrollListener() {
			@Override
			public boolean onScroll(float displacement, float delta,
					float velocity) {
				// do something on scrolling
				return true;
			}
		});
		return gestureDetector;
	}

	/**
	 * Send generic motion events to the gesture detector
	 */
	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		if (mGestureDetector != null) {
			return mGestureDetector.onMotionEvent(event);
		}
		return false;
	}
}
