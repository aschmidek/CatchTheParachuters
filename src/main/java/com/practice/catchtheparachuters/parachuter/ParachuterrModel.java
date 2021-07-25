/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.parachuter;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovingComponentModel;

/**
 *
 * @author User
 */
public class ParachuterrModel extends BaseMovingComponentModel implements Constants {

    private boolean alive = true;
    private boolean safe = false;

    public ParachuterrModel() {
        super(PARACHUTER_IMAGE);
        direction = Direction.DOWN;
        y = SKY_HEIGHT;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}
