package com.mycompany.a1;


import java.util.Random;

import com.codename1.ui.geom.Point2D;

public abstract class MoveableObject extends GameObject {

    private int speed;
    private int direction; // 0 is N, 90 is E, 180 is S, 270 is W

    /**
     * Abstract method move
     */
    public void move() {
    	int angle = 90 - this.getDirection();
    	int deltaX = (int) (Math.cos(angle) * this.getSpeed());
    	int deltaY = (int) (Math.sin(angle) * this.getSpeed());
    	Point2D newLocation = new Point2D(this.getLocation().getX() + deltaX, this.getLocation().getY() + deltaY);
    	this.setLocation(newLocation);
    }

    public MoveableObject() {
    	this.speed = randomizeIntRange(0, 11);
    	this.direction = randomizeIntRange(0, 360);
    }


    /**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
    

}
