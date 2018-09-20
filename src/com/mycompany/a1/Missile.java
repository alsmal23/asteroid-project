package com.mycompany.a1;

import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;


public class Missile extends MoveableObject {
	
	private int fuel;
	private static int FUEL_CAPACITY = 10;
	
	public Missile() {
		this.setColor(ColorUtil.WHITE);
		this.fuel = FUEL_CAPACITY;
	}
	
	public Missile(Point2D location, int speed, int direction) {
		this.setLocation(location);
		this.setSpeed(speed + 5);
		this.setDirection(direction);
		this.setColor(ColorUtil.WHITE);
		this.fuel = FUEL_CAPACITY;
	}
	
	@Override
	public void move() {
		
	}

	/**
	 * @return the fuel
	 */
	public int getFuel() {
		return fuel;
	}

	@Override
	public String toString() {
		return "PS's Missile: loc=" + this.getLocation() + " color=" + this.getColorString() + " speed=" + this.getSpeed() + " dir=" + this.getDirection()
			+ " fuel=" + this.fuel;
	}
}
