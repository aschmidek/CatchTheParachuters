/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.game;

import com.practice.catchtheparachuters.BaseMovingComponentModel;
import java.util.Collection;
import java.util.LinkedList;


public class GameModel {

    private int points = 0;
    private int strikes = 0;

    private Collection<BaseMovingComponentModel> allComponents = new LinkedList();

    public GameModel(Collection allComponents) {
        this.allComponents = allComponents;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementPoints(int incerementBy) {
        this.points += incerementBy;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public void incrementStrikes(int incerementBy) {
        this.strikes += incerementBy;
    }

    public Collection<BaseMovingComponentModel> getAllComponents() {
        return allComponents;
    }

    public void setAllComponents(Collection<BaseMovingComponentModel> allComponents) {
        this.allComponents = allComponents;
    }
}
