/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.plane;

import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovementController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *PlaneController controls the movement of the plane in every game refresh cycle
 */

public class PlaneController extends BaseMovementController<PlaneModel> implements ActionListener {

    public PlaneController(PlaneModel model) {
        super(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }

    @Override
    protected void screenLimitExeeded(Direction direction) {
        if (direction == Direction.RIGHT) {
            model.setX(MIN_X);
        }
    }
}
