/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.parachuter;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.boat.BoatModel;
import com.practice.catchtheparachuters.plane.PlaneModel;
import java.util.Collection;
import java.util.LinkedList;

/**
 * ParachuterManager is a Singleton in charge of creating a parachute randomly and removing parachutes when they are 
 * safe or dead. This is done in each game cycle
 */
public enum ParachuterManager implements Constants {
    INSTANCE;
    
    Collection<ParachuterController> parachuterControllers = new LinkedList();

    public ParachuterController createParashooter(PlaneModel planeModel, BoatModel boatModel) {
        //decide if parashooter should jump.
        if (Math.random() < PARACHUTER_PROPABILITY) {
            ParachuterrModel parashooter = new ParachuterrModel();
            parashooter.setX(planeModel.getX()); //located under the plane
            ParachuterController controller = new ParachuterController(parashooter, boatModel);
            parachuterControllers.add(controller);
            return controller;
        } else {
            return null;
        }
    }

    public Collection<ParachuterController> findDeadParashooters() {
        Collection<ParachuterController> deadParashooters = new LinkedList();
        for (ParachuterController parashooterController : parachuterControllers) {
            if (!parashooterController.getModel().isAlive()) {
                deadParashooters.add(parashooterController);
            }
        }
        parachuterControllers.removeAll(deadParashooters);
        return deadParashooters;
    }

    public Collection<ParachuterController> findSavedParashooters() {
        Collection<ParachuterController> safeParashooters = new LinkedList();
        for (ParachuterController parashooterController : parachuterControllers) {
            if (parashooterController.getModel().isSafe()) {
                safeParashooters.add(parashooterController);
            }
        }
        parachuterControllers.removeAll(safeParashooters);
        return safeParashooters;
    }

}
