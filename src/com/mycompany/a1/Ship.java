package com.mycompany.a1;

public abstract class Ship extends MoveableObject {
	
	private int missileCount;
    private MissileLauncher missileLauncher = new MissileLauncher();

    public Ship() {
    	missileCount = 0;
    	this.missileLauncher.setDirection(this.getDirection());
    	this.missileLauncher.setSpeed(this.getSpeed());
    }
    
    abstract public Missile fireMissile();

	/**
	 * @return the missileCount
	 */
	public int getMissileCount() {
		return missileCount;
	}
	
	/**
	 * Checks if ship has missiles
	 * @return
	 */
	public boolean hasMissiles() {
		if (missileCount != 0)
			return true;
		else 
			return false;
	}

	/**
	 * Shot a missile to decrement missile count by one
	 */
	public void shotMissile() { missileCount--; }
	
	public void setMissileCount(int missiles) { this.missileCount = missiles; }
    
}
