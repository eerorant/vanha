package cavequest2.characters;

import cavequest2.CaveQuest2App;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;



public class Knight extends Character {
    
    private long timeOfAttack;
    private ImageView swing;
    private StackPane swingStack;

    public Knight(double X, double Y) {
        super("file:knight.png", X, Y);
        speed = 2;
        Image image = new Image("File:swing.png");
        this.swing = new ImageView(image);
        this.swingStack = new StackPane();
        this.swingStack.getChildren().add(swing);
    }

    public void control(Map<KeyCode, Boolean> pressedButtons, long timeNow) {
        //There's a half a second cooldown on attacking
        if (timeNow - this.timeOfAttack > 100000000) {
            CaveQuest2App.layout.getChildren().remove(this.swingStack);
        }
        if (pressedButtons.getOrDefault(KeyCode.SPACE, false) && (timeNow - this.timeOfAttack > 500000000)) {
            attack();
            this.timeOfAttack = timeNow;
        }
        
        
        if (pressedButtons.getOrDefault(KeyCode.UP, false)) {
            if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                faceUpLeft();
            } else if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                faceUpRight();
            } else {
                faceUp();
            }
            move();
        } else if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
            if (pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
                faceDownRight();
            } else {
                faceRight();
            }
            move();
        } else if (pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
            if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                faceDownLeft();
            } else {
                faceDown();
            }
            move();
        } else if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
            faceLeft();
            move();
        }
    }

    public Boolean intersects() {
        for (Character mob : CaveQuest2App.mobs) {
            Shape area = Shape.intersect(this.getShape(), mob.getShape());
            if (area.getBoundsInLocal().getWidth() != -1) {
                return true;
            }
        }
        return false;
    }
    
    public void attack() {
        System.out.println(CaveQuest2App.mobs.size());
        double forwardX = Math.sin(Math.toRadians(getRotate()));
        double forwardY = Math.cos(Math.toRadians(getRotate()));
        forwardX *= 18;
        forwardY *= 18;
        
        CaveQuest2App.layout.getChildren().add(this.swingStack);
        this.swingStack.setTranslateX(this.getTranslateX() + forwardX);
        this.swingStack.setTranslateY(this.getTranslateY() - forwardY);
        this.swingStack.setRotate(this.getRotate());
        
        for (int i = 0; i < CaveQuest2App.mobs.size(); i++) {
            Character mob = CaveQuest2App.mobs.get(i);
            if (mob.getShape().intersects(this.swingStack.getBoundsInParent())) {
                CaveQuest2App.mobs.remove(i);
                CaveQuest2App.layout.getChildren().remove(i);
                System.out.println("Hit!");
            }
        }
    }
}
