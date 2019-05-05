package cavequest2.characters;

import cavequest2.CaveQuest2App;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eero
 */

/**
 *Character-luokka on yliluokka ritarille ja hirviöille.
 *
 * @param   imageFile   hahmon kuvatiedoston sijainti
 * @param   X   hahmon x-koordinaatti
 * @param Y hahmon y-koordinaatti
 */
public class Character {

    private StackPane stack = new StackPane();
    double speed = 1;
    private Image image;

    public Character(String imageFile, double X, double Y) {
        this.image = new Image(imageFile);
        this.stack.getChildren().add(new ImageView(image));
        this.stack.setTranslateX(X);
        this.stack.setTranslateY(Y);
    }
    
    public double getTranslateX() {
        return this.stack.getTranslateX();
    }
    
    public double getTranslateY() {
        return this.stack.getTranslateY();
    }

    public double getCenterX() {
        return this.stack.getTranslateX() + (this.stack.getWidth() / 2);
    }

    public double getCenterY() {
        return this.stack.getTranslateY() + (this.stack.getHeight() / 2);
    }

    public double getRotate() {
        return this.stack.getRotate();
    }

    /**
     * metodia käytetään collisionia testatessa, eli siis jos ritari osuu hirviöön.
     * @return hahmon muotoinen ja kokoinen suorakulmio
     */
    public Rectangle getShape() {
        Rectangle rect = new Rectangle();
        rect.setX(this.getCenterX());
        rect.setY(this.getCenterY());
        rect.setWidth(this.image.getWidth());
        rect.setHeight(this.image.getHeight());
        return rect;
    }

    public void faceUp() {
        this.stack.setRotate(0);
    }

    public void faceUpRight() {
        this.stack.setRotate(45);
    }

    public void faceRight() {
        this.stack.setRotate(90);
    }

    public void faceDownRight() {
        this.stack.setRotate(135);
    }

    public void faceDown() {
        this.stack.setRotate(180);
    }

    public void faceDownLeft() {
        this.stack.setRotate(225);
    }

    public void faceLeft() {
        this.stack.setRotate(270);
    }

    public void faceUpLeft() {
        this.stack.setRotate(315);
    }
    
    public void turnRight() {
        this.stack.setRotate(this.stack.getRotate() + 45);
        if (this.getRotate() >= 360) {
            this.stack.setRotate(this.getRotate() - 360);
        }
    }
    
    public void turnLeft() {
        this.stack.setRotate(this.stack.getRotate() - 45);
        if (this.getRotate() <= 0) {
            this.stack.setRotate(this.getRotate() + 360);
        }
    }
    
    /**
     * metodi liikuttaa hahmoa sen katsomaan suuntaan. Jos hahmon edessä on seinä, hahmo ei liiku.
     */
    public void move() {
        if (collision()) {
            return;
        }
        double changeX = Math.sin(Math.toRadians(getRotate()));
        double changeY = Math.cos(Math.toRadians(getRotate()));

        changeX *= speed;
        changeY *= speed;

        this.stack.setTranslateX(this.stack.getTranslateX() + changeX);
        this.stack.setTranslateY(this.stack.getTranslateY() - changeY);
    }

    public StackPane getStackPane() {
        return this.stack;
    }

    /**
     * Metodi testaa onko hahmon edessä seinä.
     * @return true, jos edessä on seinä.
     */
    public Boolean collision() {
        double forwardX = Math.sin(Math.toRadians(getRotate()));
        double forwardY = Math.cos(Math.toRadians(getRotate()));

        forwardX *= 5;
        forwardY *= 5;

        for (Shape wall : CaveQuest2App.walls) {
            if (wall.contains(getCenterX() + forwardX, getCenterY() - forwardY)) {
                return true;
            }
        }
        return false;
    }
    
    public void control() {
        
    }

}
