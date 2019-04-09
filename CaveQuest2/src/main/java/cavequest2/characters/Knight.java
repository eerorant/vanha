package cavequest2.characters;

import cavequest2.CaveQuest2App;
import java.util.Map;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Shape;



public class Knight extends Character {

    public Knight(double X, double Y) {
        super("file:knight.png", X, Y);
        speed = 2;
    }

    public void control(Map<KeyCode, Boolean> pressedButtons) {
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
}
