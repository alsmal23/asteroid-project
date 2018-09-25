package com.mycompany.a1;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable {
	
	public SteerableMissileLauncher() {
		this.setSpeed(0);
    	this.setDirection(0);
	}

	@Override
	public void steerRight() {
		this.setDirection((this.getDirection() + 7) % 360);
		
	}

	@Override
	public void steerLeft() {
		int temp = this.getDirection() - 7;
		if (temp < 0)
			this.setDirection(360 + temp);
		else
			this.setDirection(temp);
		
	}
}
