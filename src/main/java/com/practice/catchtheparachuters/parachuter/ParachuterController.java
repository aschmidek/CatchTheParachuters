package com.practice.catchtheparachuters.parachuter;

import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovementController;
import com.practice.catchtheparachuters.boat.BoatModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ParachuterController controls the movement of the parachute in every game refresh cycle 
 * and decides when a parachute is dead or safe
 */

public class ParachuterController extends BaseMovementController<ParachuterrModel> implements ActionListener {

    private BoatModel boatModel; //aware of boat model so that we can tell when a parachte is safe

    public ParachuterController(ParachuterrModel model, BoatModel boatModel) {
        super(model);
        model.setDirection(Direction.DOWN);
        this.boatModel = boatModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        if (model.isAlive()
                && WATER_HEIGHT - model.getY() < PARACHUTER_SAFE_DISTANCE_FROM_BOAT
                && model.getX() >= boatModel.getX()
                && model.getX() <= boatModel.getX() + boatModel.getWidth()) {
            model.setSafe(true);
        }
    }

    @Override
    protected void screenLimitExeeded(Direction direction) {
        model.setAlive(false);
    }
}
