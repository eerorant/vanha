
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class CaveQuestApp extends Application{
    
    @Override
    public void start(Stage ikkuna) {
        Pane layout = new Pane();
        layout.setPrefSize(600, 600);
        Scene scene = new Scene(layout, 600, 600);
        Knight knight = new Knight(300, 300);
        ImageView imageView = knight.getImageView();
        
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), true);
        });

        scene.setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), false);
        });
        
        new AnimationTimer() {

            @Override
            public void handle(long now) {
                knight.control(pressedButtons);
            }
        }.start();
        

        layout.getChildren().add(imageView);

        ikkuna.setScene(scene);
        ikkuna.setTitle("Cave Quest");
        ikkuna.show();
    }
    public static void main(String[] args) {
        launch(CaveQuestApp.class);
    }
}
