package com.practice.catchtheparachuters.boat;

import com.practice.catchtheparachuters.Direction;
import com.practice.catchtheparachuters.BaseMovementController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *BoatController controls the movement of the boat by listening to key strokes
 */

public class BoatController extends BaseMovementController<BoatModel> implements KeyListener {

    public BoatController(BoatModel boat) {
        super(boat);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //do nothing. Boat Only moved when arrows are pressed. 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            model.setDirection(Direction.LEFT);
        } else if (key == KeyEvent.VK_RIGHT) {
            model.setDirection(Direction.RIGHT);
        }
        move();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing. Boat Only moved when arrows are pressed.                
    }

    @Override
    protected void screenLimitExeeded(Direction direction) {
        //Stop Moving - So do nothing
    }
}
