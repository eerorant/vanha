
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
    
    public void faceRight() {
        imageView.setRotate(90);
    }
    
    public void faceDown() {
        imageView.setRotate(180);
    }
    
    public void faceLeft() {
        imageView.setRotate(-90);
    }
    
    public void control(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            faceUp();
            this.imageView.setTranslateY(this.imageView.getTranslateY() - 5);
        } else if (event.getCode() == KeyCode.RIGHT) {
            faceRight();
            this.imageView.setTranslateX(this.imageView.getTranslateX() + 5);
        } else if (event.getCode() == KeyCode.DOWN) {
            faceDown();
            this.imageView.setTranslateY(this.imageView.getTranslateY() + 5);
        } else if (event.getCode() == KeyCode.LEFT) {
            faceLeft();
            this.imageView.setTranslateX(this.imageView.getTranslateX() - 5);
        }
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
