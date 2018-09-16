package com.mycompany.a1;

import java.util.Random;

public class SpaceStation extends FixedObject {
	
	private int blinkRate;
	
	public SpaceStation() {
		randomizeBlinkRate();
	}
	
	
	
	@Override
	public String toString() {
		String ss = "Station: loc=" + this.getX() + "," + this.getY() + " color=" + this.getColorString() + " rate=" + this.getBlinkRate(); 
		return ss;
	}

	/**
	 * @return the blinkRate
	 */
	public int getBlinkRate() { return blinkRate; }
	
	private void randomizeBlinkRate() {
		Random rng = new Random();
        this.blinkRate = rng.nextInt(5);
	}
	
}
