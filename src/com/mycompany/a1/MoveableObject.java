package com.mycompany.a1;


import java.util.Random;

public abstract class MoveableObject extends GameObject {

    private int speed;
    private int direction; // 0 is N, 90 is E, 180 is S, 270 is W

    public abstract void move();

    public MoveableObject() {
        randomizeSpeed();
        randomizeDirection();
    }

    public MoveableObject(int speed, int direction) {
        if (speed <= 10 && speed >= 0)
            this.speed = speed;
        else
            randomizeSpeed();
        if (direction <= 359 && direction >= 0)
            this.direction = direction;
        else
            randomizeDirection();
    }

    /**
     * Randomize speed from 0-10
     */
    private void randomizeSpeed() {
        Random rng = new Random();
        this.speed = rng.nextInt(11);
    }

    /**
     * Randomize direction from 0-359
     */
    private void randomizeDirection() {
        Random rng = new Random();
        this.direction = rng.nextInt(360);
    }

}
