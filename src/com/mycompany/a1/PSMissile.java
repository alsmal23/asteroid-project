package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class PSMissile extends Missile {
	
	public PSMissile(Point2D location, int speed, int direction) {
		this.setLocation(location);
		this.setSpeed(speed);
		this.setDirection(direction);
		this.setColor(ColorUtil.WHITE);
		this.setFuel(this.getFuelCapacity());
	}
	@Override
	public String toString() {
		return "PS's Missile: loc=" + this.getLocation() + " color=" + this.getColorString() + " speed=" + this.getSpeed() + " dir=" + this.getDirection()
			+ " fuel=" + this.getFuel();
	}
}
