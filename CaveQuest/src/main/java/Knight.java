
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Point2D;


public class Knight {
    private ImageView imageView;
    
    public Knight(double X, double Y) {
        Image image = new Image("file:hahmo.png");
        this.imageView = new ImageView(image);
        this.imageView.setX(X);
        this.imageView.setY(Y);
        
    }
    
    public void faceUp() {
        imageView.setRotate(0);
    }
    
    public void faceUpRight() {
        imageView.setRotate(45);
    }
    
    public void faceRight() {
        imageView.setRotate(90);
    }
    
    public void faceDownRight() {
        imageView.setRotate(135);
    }
    
    public void faceDown() {
        imageView.setRotate(180);
    }
    
    public void faceDownLeft() {
        imageView.setRotate(225);
    }
    
    public void faceLeft() {
        imageView.setRotate(270);
    }
    
    public void faceUpLeft() {
        imageView.setRotate(315);
    }
    
    public void control(Map<KeyCode, Boolean> pressedButtons) {
        if (pressedButtons.getOrDefault(KeyCode.UP, false)) {
            if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                faceUpLeft();
            }
            else if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                faceUpRight();
            } else {
                faceUp();
            }
            move();
        }
        else if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
            if (pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
                faceDownRight();
            } else {
                faceRight();
            }
            move();
        }
        else if (pressedButtons.getOrDefault(KeyCode.DOWN, false)) {
            if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                faceDownLeft();
            } else {
                faceDown();
            }
            move();
        }
        else if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
            faceLeft();
            move();
        }
        
    }
    
    public void move() {
        double changeX = Math.sin(Math.toRadians(getRotate()));
        double changeY = Math.cos(Math.toRadians(getRotate()));

        this.imageView.setTranslateX(this.imageView.getTranslateX() + changeX);
        this.imageView.setTranslateY(this.imageView.getTranslateY() - changeY);
    }
    
    
    public double getRotate() {
        return this.imageView.getRotate();
    }
    
    public double getX() {
        return this.imageView.getX();
    }
    
    public double getY() {
        return this.imageView.getY();
    }
    
    public ImageView getImageView() {
        return this.imageView;
    }



    
    
}
