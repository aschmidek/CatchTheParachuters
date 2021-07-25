package com.practice.catchtheparachuters.boat;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovingComponentModel;


public class BoatModel extends BaseMovingComponentModel implements Constants {

    public BoatModel() {
        super(BOAT_IMAGE);
        direction = Direction.RIGHT;
        y = WATER_HEIGHT;
        steps = BOAT_STEP_SIZE;
    }
}
