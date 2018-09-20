package com.mycompany.a1;

import java.util.Random;

public class SpaceStation extends FixedObject {
	
	private int blinkRate;
	
	public SpaceStation() {
		this.blinkRate = this.randomizeIntRange(0, 5);
	}
	
	
	
	@Override
	public String toString() {
		String ss = "Station: loc=" + this.getLocation() + " color=" + this.getColorString() + " rate=" + this.getBlinkRate(); 
		return ss;
	}

	/**
	 * @return the blinkRate
	 */
	public int getBlinkRate() { return blinkRate; }
	
	
}
