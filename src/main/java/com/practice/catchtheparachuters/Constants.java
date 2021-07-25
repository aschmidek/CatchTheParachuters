package com.practice.catchtheparachuters;

public interface Constants {

    //main game loop frequency   
    int TIMER_DELAY = 10;

    //screen size
    int SCREEN_WIDTH = 1200;
    int SCREEN_HEIGHT = 600;

    //allowed movement range  
    int MIN_X = 0;
    int MAX_X = 1000;
    int MIN_Y = 0;
    int MAX_Y = 450;

    //location of plane and boat
    int WATER_HEIGHT = 450;
    int SKY_HEIGHT = 50;

    //score related constants
    int MAX_STRIKES = 3;
    int SCORE_PER_PARASHOOTER = 10;

    //parachuter related constants
    double PARACHUTER_PROPABILITY = 0.01;   //the propability of a parachuter to jump in every game cycle
    int PARACHUTER_SAFE_DISTANCE_FROM_BOAT = 5;    //the vertical distance from boat for which we can cosider the parachuter safe

    //step size for each component 
    int PARACHUTER_STEP_SIZE = 5;
    int PLANE_STEP_SIZE = 1;
    int BOAT_STEP_SIZE = 30;

    //images
    String STRIKE_IMAGE = "src/images/boom.png";
    String PLANE_IMAGE = "src/images/plane.png";
    String BOAT_IMAGE = "src/images/boat.png";
    String PARACHUTER_IMAGE = "src/images/parachuter.png";

    //text
    String GAME_OVER_TEXT = "Game Over";
    String GAME_NAME = "Catch the parashooter";
    String SCORE_PREFIX = "Score: ";

    //score/strikes location related constants
    int SCORE_AREA_X = 10;
    int SCORE_AREA_Y = 30;
    int STRIKES_X = 10;
    int STRIKES_Y = 60;
    int STRIKES_SPACE = 50;

}
