package com.carlospinan.nessdefender.engine.utils;

import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/**
 * 
 * @author Carlos Eduardo Pi–an Indacochea
 * 
 */
public class Utils {

	public static Bitmap decodeBitmap(Resources resource, int resourceID,
			Options options) {
		Bitmap bmp = BitmapFactory
				.decodeResource(resource, resourceID, options);
		return bmp;
	}

	public static float getRandomNumber(float start, float end) {
		Random random = new Random();
		float value = (random.nextFloat() * (end - start + 1) + start);
		return value;
	}

}
