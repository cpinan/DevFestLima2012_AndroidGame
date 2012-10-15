package com.carlospinan.nessdefender.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class GameEngine extends SurfaceView implements SurfaceHolder.Callback,
		EngineInterface {

	private GameTimer timerThread;
	private Context context;

	public GameEngine(Context context, AttributeSet attrs) {
		super(context, attrs);
		_init(context);
	}

	private void _init(Context context) {
		this.context = context;
		getHolder().addCallback(this);
		timerThread = new GameTimer(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		_loadResources();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}

	private void _loadResources() {

		if (timerThread != null) {
			timerThread.start();
		}
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	public void update() {

	}

	@Override
	public void onPause() {
		if (timerThread != null) {
			timerThread.onPause();
		}
	}

	@Override
	public void onResume() {
		if (timerThread != null) {
			timerThread.onResume();
		}
	}

}
