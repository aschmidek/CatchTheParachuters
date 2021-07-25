/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.catchtheparachuters.game;

import com.practice.catchtheparachuters.Constants;
import com.practice.catchtheparachuters.BaseMovingComponentModel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User //holds all components of the game - controllers, models and
 * board UI
 */
public class GameBoard extends JPanel implements Constants {

    GameModel gameModel;
    Image boomImage;
    JFrame gameFrame;

    public GameBoard(GameModel gameModel) {
        this.gameModel = gameModel;
        ImageIcon ii = new ImageIcon(STRIKE_IMAGE);
        boomImage = ii.getImage();
    }

    public void run() {
        gameFrame = new JFrame(GAME_NAME);
        gameFrame.add(this);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
        gameFrame.setFocusable(true);
        gameFrame.setLayout(new BorderLayout());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(SCORE_PREFIX + gameModel.getPoints(), SCORE_AREA_X, SCORE_AREA_Y);
        int strikesCounter = gameModel.getStrikes();
        while (strikesCounter > 0) {
            g2d.drawImage(boomImage, STRIKES_X + STRIKES_SPACE * (strikesCounter - 1), STRIKES_Y, this);
            strikesCounter--;
        }

        Iterator<BaseMovingComponentModel> components = gameModel.getAllComponents().iterator();
        while (components.hasNext()) {
            BaseMovingComponentModel movingComponent = components.next();
            g2d.drawImage(movingComponent.getImage(), movingComponent.getX(),
                    movingComponent.getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void addKeyListener(KeyListener listener) {
        this.gameFrame.addKeyListener(listener);
    }

    void endGame() {
        JOptionPane.showMessageDialog(this.gameFrame,
                GAME_OVER_TEXT,
                GAME_NAME,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
