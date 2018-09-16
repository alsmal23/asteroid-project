package com.mycompany.a1;

import com.codename1.ui.Form;


/**
 * Game --- class that acts as the controller for the Asteroids game
 * @author Alexandria Smallwood
 */
public class Game extends Form {

    private GameWorld gameWorld;

    /**
     * Constructor for the class Game
     * Initializes the gameWorld
     */
    public Game() {
        gameWorld = new GameWorld();
        gameWorld.init();
        play();
    }

    /**
     * Method that accepts and computes commands given by the user
     */
    private void play() {

    }
}

