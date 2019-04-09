package cavequest2;


import cavequest2.characters.Character;
import cavequest2.characters.Zombie;
import cavequest2.characters.Skeleton;
import cavequest2.characters.Knight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;



public class CaveQuest2App extends Application {

    public static List<Shape> walls = new ArrayList<>();
    public static List<Character> mobs = new ArrayList<>();

    @Override
    public void start(Stage ikkuna) {
        //Here we define the layout, scene and the knight
        Pane layout = new Pane();
        layout.setPrefSize(600, 600);
        Scene scene = new Scene(layout, 600, 600);
        Knight knight = new Knight(300, 300);

        Skeleton skele = new Skeleton(120, 120);
        Zombie zomb = new Zombie(180, 120);

        this.mobs.add(skele);
        this.mobs.add(zomb);
        for (Character mob : this.mobs) {
            layout.getChildren().add(mob.getStackPane());
        }

        //walls is the list of walls, i.e. collisionable obstacles
        Border border = new Border();
        this.walls.add(border.getBorder());
        for (Shape wall : walls) {
            layout.getChildren().add(wall);
        }

        //Here we define movement. We use a hashmap and AnimationTimer() to make the movement a smooth 60 fps
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
                if (knight.intersects()) {
                    stop();
                }
            }
        }.start();

        layout.getChildren().add(knight.getStackPane());
        ikkuna.setScene(scene);
        ikkuna.setTitle("Cave Quest");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(CaveQuest2App.class);
    }
}
