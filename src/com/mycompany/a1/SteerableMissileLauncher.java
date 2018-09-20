package com.mycompany.a1;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable {
	
	public SteerableMissileLauncher() {
		this.setSpeed(0);
    	this.setDirection(0);
	}

    @Override
    public void changeDirection(int direction) {

    }

	@Override
	public void steerRight() {
		this.setDirection((this.getDirection() + 7) % 360);
		
	}

	@Override
	public void steerLeft() {
		// TODO Auto-generated method stub
		
	}
}
