package com.mycompany.a1;

public abstract class Ship extends MoveableObject {
	
	private int missileCount;
    private MissileLauncher missileLauncher;
    private static final int MAX_MISSILES = 10;

    abstract public void fireMissile();

}
