package com.carlospinan.nessdefender.engine.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class Sprite {

	private float x, y;
	private float width, height;
	private Bitmap bmpSprite;
	private Matrix matrix;
	private boolean visible;
	private boolean debugMode;
	private Paint paint;
	private Paint paintDebug;

	public Sprite(Bitmap bmpSprite, float x, float y) {
		this.x = x;
		this.y = y;
		this.bmpSprite = bmpSprite;
		width = bmpSprite.getWidth();
		height = bmpSprite.getHeight();
		matrix = new Matrix();
		paint = new Paint();
		visible = true;
		debugMode = false;
		paintDebug = new Paint();
		paintDebug.setARGB(128, 0, 255, 0);
	}

	public void onDraw(Canvas canvas) {
		if (visible) {
			matrix.reset();
			matrix.postTranslate(x, y);
			canvas.drawBitmap(bmpSprite, matrix, paint);
			if (debugMode) {
				canvas.drawRect(getBounds(), paintDebug);
			}
		}
	}

	public RectF getBounds() {
		return new RectF(x, y, x + width, x + height);
	}

	public boolean isCollide(Sprite sp) {
		return sp != null && getBounds().intersect(sp.getBounds()) && visible
				&& sp.isVisible();
	}

	public boolean isCollide(RectF rect) {
		return rect != null && getBounds().intersect(rect) && visible;
	}

	public void unloadResources() {
		if (bmpSprite != null) {
			if (!bmpSprite.isRecycled()) {
				bmpSprite.recycle();
			}
			bmpSprite = null;
		}
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void move(float speedX, float speedY) {
		x += speedX;
		y += speedY;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Bitmap getBmpSprite() {
		return bmpSprite;
	}

	public void setBmpSprite(Bitmap bmpSprite) {
		this.bmpSprite = bmpSprite;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Paint getPaintDebug() {
		return paintDebug;
	}

	public void setPaintDebug(Paint paintDebug) {
		this.paintDebug = paintDebug;
	}
}
