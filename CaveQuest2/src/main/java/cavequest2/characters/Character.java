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
        return this.stack.getTranslateX() + (this.stack.getWidth() / 2);
    }

    public double getTranslateY() {
        return this.stack.getTranslateY() + (this.stack.getHeight() / 2);
    }

    public double getRotate() {
        return this.stack.getRotate();
    }

    public Rectangle getShape() {
        Rectangle rect = new Rectangle();
        rect.setX(this.getTranslateX());
        rect.setY(this.getTranslateY());
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

    public Boolean collision() {
        double forwardX = Math.sin(Math.toRadians(getRotate()));
        double forwardY = Math.cos(Math.toRadians(getRotate()));

        forwardX *= 5;
        forwardY *= 5;

        for (Shape wall : CaveQuest2App.walls) {
            if (wall.contains(getTranslateX() + forwardX, getTranslateY() - forwardY)) {
                return true;
            }
        }
        return false;
    }

}
