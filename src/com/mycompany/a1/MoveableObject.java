package com.mycompany.a1;


import java.util.Random;

public abstract class MoveableObject extends GameObject {

    private int speed;
    private int direction; // 0 is N, 90 is E, 180 is S, 270 is W

    /**
     * Abstract method move
     */
    public abstract void move();

    public MoveableObject() {
    	this.speed = randomizeIntRange(0, 11);
    	this.direction = randomizeIntRange(0, 360);
    }

    public MoveableObject(int speed, int direction) {
        if (speed <= 10 && speed >= 0)
            this.speed = speed;
        else
        	this.speed = randomizeIntRange(0, 11);
        if (direction <= 359 && direction >= 0)
            this.direction = direction;
        else
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
