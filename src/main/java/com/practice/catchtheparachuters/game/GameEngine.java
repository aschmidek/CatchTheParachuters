/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.game;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.BaseMovingComponentModel;
import com.practice.catchtheparachuters.boat.BoatController;
import com.practice.catchtheparachuters.boat.BoatModel;
import com.practice.catchtheparachuters.parachuter.ParachuterController;
import com.practice.catchtheparachuters.parachuter.ParachuterManager;
import com.practice.catchtheparachuters.plane.PlaneController;
import com.practice.catchtheparachuters.plane.PlaneModel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.Timer;

/**
 *
 * Main Game Controller - runs the main game loop and syncs all game modules
 */

public class GameEngine implements Constants, ActionListener {

    final private GameBoard gameBoard;
    final private GameModel gameModel;

    private Timer timer;

    final private PlaneModel planeModel;
    final private PlaneController planeController;

    final private BoatModel boatModel;
    final private BoatController boatController;

    final private ParachuterManager parachuterManager = ParachuterManager.INSTANCE;

    final private LinkedList<BaseMovingComponentModel> allComponents = new LinkedList();
    final private LinkedList<ActionListener> timeBasedControllers = new LinkedList();

    Image boomImage;

    public GameEngine() {

        //Create Plane
        planeModel = new PlaneModel();
        allComponents.add(planeModel);
        planeController = new PlaneController(planeModel);
        timeBasedControllers.add(planeController);

        //Create Boat
        boatModel = new BoatModel();
        allComponents.add(boatModel);
        this.boatController = new BoatController(boatModel);

        gameModel = new GameModel(allComponents);
        gameBoard = new GameBoard(gameModel);
    }

    public void run() {
        gameBoard.run();
        gameBoard.addKeyListener(this.boatController);
        timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //call all timeBasedControllers to update model
        for (ActionListener controller : timeBasedControllers) {
            controller.actionPerformed(e);
        }

        //randomly get a parachuter
        ParachuterController parashooterController = parachuterManager.createParashooter(planeModel, boatModel);
        if (parashooterController != null) {
            timeBasedControllers.add(parashooterController);
            allComponents.add(parashooterController.getModel());
        }

        //handle safe parachuters
        Collection<ParachuterController> safeParashooters = parachuterManager.findSavedParashooters();
        gameModel.incrementPoints(safeParashooters.size() * SCORE_PER_PARASHOOTER);
        removeParashootersFromGame(safeParashooters);

        //handle dead parachuters
        Collection<ParachuterController> deadParashooters = parachuterManager.findDeadParashooters();
        gameModel.incrementStrikes(deadParashooters.size());
        removeParashootersFromGame(deadParashooters);

        //check if we need to end the game 
        if (gameModel.getStrikes() >= MAX_STRIKES) {
            this.gameBoard.repaint();
            timer.stop();
            gameBoard.endGame();
        }

        //repaint UI
        this.gameBoard.repaint();
    }

    private void removeParashootersFromGame(Collection<ParachuterController> controllers) {
        timeBasedControllers.removeAll(controllers);
        for (ParachuterController parashooterController : controllers) {
            allComponents.remove(parashooterController.getModel());
        }
    }
}
