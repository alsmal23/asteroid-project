package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;


public class PlayerShip extends Ship implements ISteerable {

    private static final int MAX_MISSILES = 10;
    private static final int START_X = 512;
    private static final int START_Y = 384;
    private SteerableMissileLauncher missileLauncher = new SteerableMissileLauncher();

    public PlayerShip() {
    	this.setColor(ColorUtil.MAGENTA);
    	this.setLocation(new Point2D(START_X, START_Y));
    	this.setSpeed(0);
    	this.setDirection(0);
    	this.setMissileCount(MAX_MISSILES);
    }

    @Override
    public PSMissile fireMissile() {
    	this.shotMissile();
    	return new PSMissile(this.getLocation(), this.getSpeed() + 5, this.missileLauncher.getDirection());
    }
    
    @Override
    public String toString() {
    	String ps = "Player Ship: loc=" + this.getLocation() + " color=" + this.getColorString() + " speed="
    			+ this.getSpeed() + " dir=" + this.getDirection() + " missiles=" + this.getMissileCount() + " Missile launcher dir=" + this.missileLauncher.getDirection();
    	return ps;
    }
    
    /**
     * Increase speed of player ship by 2 (20%)
     */
    public void increaseSpeed() {
    	this.setSpeed(this.getSpeed() + 2);
    }
    
    /**
     * Decrease speed of player ship by 2 (20%)
     */
    public void decreaseSpeed() {
    	if (this.getSpeed() < 2) 
    		this.setSpeed(0);
    	else
    		this.setSpeed(this.getSpeed() - 2);
    }

	/**
	 * Steer the ship to the right by 10
	 */
	@Override
	public void steerRight() {
		this.setDirection((this.getDirection() + 10) % 360);
	}

	/**
	 * Steer the ship to the left by 10
	 */
	@Override
	public void steerLeft() {
		int temp = this.getDirection() - 10;
		if (temp < 0)
			this.setDirection(360 + temp);
		else
			this.setDirection(temp);
	}
	
	/**
	 * Steer the ship's missile launcher
	 */
	public void steerMissileLauncher() {
		this.missileLauncher.steerRight();
	}
	
	/**
	 * Reset player ship back to the center of screen
	 */
	public void resetLocation() {
		this.setLocation(new Point2D(START_X, START_Y));
	}
	
	public void reloadMissiles() {
		this.setMissileCount(MAX_MISSILES);
	}
}
