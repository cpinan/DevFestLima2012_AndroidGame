package com.carlospinan.nessdefender;

import android.app.Activity;
import android.os.Bundle;

import com.carlospinan.nessdefender.engine.GameEngine;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class NessDefenderActivity extends Activity {

	private GameEngine svNessEngine = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ness_defender);
		svNessEngine = (GameEngine) findViewById(R.id.svNessEngine);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (svNessEngine != null) {
			svNessEngine.onPause();
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus
				&& svNessEngine != null
				&& android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
			svNessEngine.onResume();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (svNessEngine != null
				&& android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
			svNessEngine.onResume();
		}
	}

}
