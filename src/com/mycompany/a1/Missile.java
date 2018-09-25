package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;


public abstract class Missile extends MoveableObject {
	
	private int fuel;
	private static int FUEL_CAPACITY = 10;
	
	public Missile() {
		this.setColor(ColorUtil.WHITE);
		this.fuel = FUEL_CAPACITY;
	}
	
	@Override
	public void move() {
		super.move();
		fuel--;
		//check if fuel == 0 then take out
	}
	
	public boolean isFuelEmpty() {
		if (this.fuel == 0)
			return true;
		else
			return false;
	}
	
	public Missile(Point2D location, int speed, int direction) {
		this.setLocation(location);
		this.setSpeed(speed);
		this.setDirection(direction);
		this.setColor(ColorUtil.WHITE);
		this.fuel = FUEL_CAPACITY;
	}

	/**
	 * @return the fuel level
	 */
	public int getFuel() {
		return fuel;
	}
	
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public int getFuelCapacity() {
		return FUEL_CAPACITY;
	}

}
