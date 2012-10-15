package com.carlospinan.nessdefender.engine;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class GameThread extends Thread implements EngineInterface {

	private static final long FPS = 60;
	private static long PERIOD = 1000 / FPS;
	private GameEngine engine = null;
	private SurfaceHolder holder = null;
	private boolean pause, running;

	public GameThread(GameEngine engine, SurfaceHolder holder) {
		this.engine = engine;
		this.holder = holder;
		pause = false;
		running = false;
	}

	@Override
	public void run() {
		super.run();
		Canvas canvas = null;
		while (running) {
			if (!pause) {
				try {
					canvas = holder.lockCanvas();
					synchronized (holder) {
						engine.update();
						engine.onDraw(canvas);
						try {
							Thread.sleep(FPS);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} finally {
					if (canvas != null) {
						holder.unlockCanvasAndPost(canvas);
					}
				}
			}
		}
		try {
			Thread.sleep(PERIOD);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onPause() {
		pause = true;
		running = false;
	}

	@Override
	public void onResume() {
		pause = false;
		running = true;
		run();
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
