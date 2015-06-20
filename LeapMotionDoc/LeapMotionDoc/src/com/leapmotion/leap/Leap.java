package com.leapmotion.leap;

public class Leap {
	public static float getEPSILON()
	{
		return LeapJNI.EPSILON_get();
	}
}
