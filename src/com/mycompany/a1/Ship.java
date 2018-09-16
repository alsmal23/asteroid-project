package com.mycompany.a1;

public abstract class Ship extends MoveableObject {
	
	private int missileCount;
    private MissileLauncher missileLauncher;
    private static final int MAX_MISSILES = 10;

    public Ship() {
    	missileCount = MAX_MISSILES;
    }
    
    abstract public void fireMissile();

	/**
	 * @return the missileCount
	 */
	public int getMissileCount() {
		return missileCount;
	}

	/**
	 * Shot a missile to decrement missile count by one
	 */
	public void shotMissile() { missileCount--; }
    
}
