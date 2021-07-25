package com.practice.catchtheparachuters;

import com.practice.catchtheparachuters.game.GameEngine;

/**
 * Launch point
 */

public class Main {

    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.run();
    }
}