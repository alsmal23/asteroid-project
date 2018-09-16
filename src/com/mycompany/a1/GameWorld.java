package com.mycompany.a1;

import java.util.ArrayList;

public class GameWorld {

    private static final int MAX_WIDTH = 1024;
    private static final int MAX_HEIGHT = 768;
    private ArrayList<GameObject> gameObjects;

    public GameWorld() {

    }

    /**
     * Initialize game objects and setup the game
     */
    public void init() {

    }

    public int getMaxWidth() { return MAX_WIDTH; }
    public int getMaxHeight() { return MAX_HEIGHT; }
}
