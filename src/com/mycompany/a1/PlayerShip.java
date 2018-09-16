package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship {

    private int hearts;
    private static final int MAX_HEARTS = 3;
    private static final int START_X = 512;
    private static final int START_Y = 384;
    private SteerableMissileLauncher missileLauncher = new SteerableMissileLauncher();

    public PlayerShip() {
    	hearts = MAX_HEARTS;
    	this.setColor(ColorUtil.MAGENTA);
    	this.setX(START_X);    	
    	this.setY(START_Y);
    	this.setSpeed(0);
    	this.setDirection(0);
    }

    @Override
    public void move() {

    }

    @Override
    public void fireMissile() {
    	this.shotMissile();
    }
    
    @Override
    public String toString() {
    	String ps = "Player Ship: loc=" + this.getX() + "," + this.getY() + " color=" + this.getColorString() + " speed="
    			+ this.getSpeed() + " dir=" + this.getDirection() + " missiles=" + this.getMissileCount() + " Missile launcher dir=" + this.missileLauncher.getDirection();
    	return ps;
    }
}
