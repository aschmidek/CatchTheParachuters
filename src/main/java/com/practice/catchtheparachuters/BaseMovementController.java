/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters;

/**
 * @author User
 * @param <T> model of type MovingComponentModel
 * The controller base class of all moving elements
 */
public abstract class BaseMovementController<T extends BaseMovingComponentModel> implements Constants {

    protected T model;

    public BaseMovementController(T model) {
        this.model = model;
    }

    public void move() {

        int steps = model.steps;
        Direction direction = model.getDirection();

        int x = model.getX();
        int y = model.getY();

        switch (direction) {
            case RIGHT:
                if (x >= MAX_X) {
                    screenLimitExeeded(direction);
                } else {
                    model.incrementX(steps);
                }
                break;

            case LEFT:
                if (x <= MIN_X) {
                    screenLimitExeeded(direction);
                } else {
                    model.decrementX(steps);
                }
                break;

            case DOWN:
                if (y >= MAX_Y) {
                    screenLimitExeeded(direction);
                } else {
                    model.incrementY(steps);
                }
                break;
        }
    }

    public T getModel() {
        return model;
    }

    //descendents will define what to do when screen limit is exceeded.   
    protected abstract void screenLimitExeeded(Direction direction);
}
