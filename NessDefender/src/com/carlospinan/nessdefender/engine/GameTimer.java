package com.carlospinan.nessdefender.engine;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class GameTimer extends Timer implements EngineInterface {

	private Timer timerThread = null;
	private static final long FPS = 60;
	private static long PERIOD = 1000 / FPS;
	private GameEngine engine;

	public GameTimer(GameEngine engine) {
		this.engine = engine;
	}

	public void start() {
		setTimer();
	}

	private void setTimer() {
		if (timerThread == null) {
			timerThread = new Timer();
			timerThread.schedule(new TimerTask() {

				@Override
				public void run() {
					if (engine != null) {
						engine.update();
						engine.postInvalidate();
					}
				}
			}, PERIOD);
		}
	}

	@Override
	public void onPause() {
		if (timerThread != null) {
			timerThread.purge();
			timerThread.cancel();
			timerThread = null;
		}
	}

	@Override
	public void onResume() {
		setTimer();
	}

}
