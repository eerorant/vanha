package cavequest2;


import cavequest2.characters.Character;
import cavequest2.characters.Zombie;
import cavequest2.characters.Skeleton;
import cavequest2.characters.Knight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class CaveQuest2App extends Application {

    public static List<Shape> walls = new ArrayList<>();
    public static List<Character> mobs = new ArrayList<>();
    public static Pane layout = new Pane();
    private Scene scene = new Scene(this.layout, 600, 600);
    private int level = 1;
    public static int score = 0;
    

    @Override
    public void start(Stage ikkuna) {
        //Here we define the layout and scene for the main menu
        Label instructions = new Label("Use the arrow keys to move and Space bar to attack.");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(4);
        grid.setHgap(12);
        Scene sceneMenu = new Scene(grid, 600, 600);
        
        
        TextField name = new TextField();
        name.setMaxWidth(100);
        Button start = new Button("Start game");
        start.setOnAction((event) -> {
            ikkuna.setScene(this.scene);
        });

        Label nameFieldLabel = new Label("Name:");
        grid.add(nameFieldLabel, 0, 0);
        grid.add(name, 1, 0);
        grid.add(start, 1, 1);
        grid.add(instructions, 1, 2);
        
        this.initiateLevel();
        Knight knight = new Knight(300, 300);
        this.layout.getChildren().add(knight.getStackPane());

        //Here we define movement. We use a hashmap and AnimationTimer() to make the movement a smooth 60 fps
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        scene.setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), true);
        });

        scene.setOnKeyReleased(event -> {
            pressedButtons.put(event.getCode(), false);
        });

        //We use the variable timeNow to control the knight's attack speed
        new AnimationTimer() {
            
           @Override
            public void handle(long timeNow) {
                if (mobs.size() == 0) {
                    level++;
                    initiateLevel();
                    knight.getStackPane().setTranslateX(300);
                    knight.getStackPane().setTranslateY(300);
                    layout.getChildren().add(knight.getStackPane());
                }
                knight.control(pressedButtons, timeNow);
                
                for (Character c : mobs) {
                    c.control();
                }
                
                if (knight.intersects()) {
                    System.out.println("Game over");
                    stop();
                }
            }
        }.start();

        ikkuna.setScene(sceneMenu);
        ikkuna.setTitle("Cave Quest");
        ikkuna.show();
    }
    
    /**
     * metodi aloittaa uuden tason
     */
    public void initiateLevel() {
        //Here we define the game's layout and scene
        this.layout.setPrefSize(600, 600);
        this.layout.getChildren().clear();


        //Here we define the characters, and the mobs, randomness is used for placing the mobs
        Random ran = new Random();
        for (int i = 0; i < this.level; i++) {
            if (i % 2 == 0) {
                Skeleton skele = new Skeleton(100 + ran.nextInt(100), 100 + ran.nextInt(400));
                this.mobs.add(skele);
            } else {
                Zombie zomb = new Zombie(400 + ran.nextInt(100), 100 + ran.nextInt(400));
                this.mobs.add(zomb);
            }
        }

        //Here we add the characters to the layout
        for (Character mob : this.mobs) {
            this.layout.getChildren().add(mob.getStackPane());
        }

        //walls is the list of walls, i.e. collisionable obstacles
        this.walls.clear();
        Border border = new Border();
        this.walls.add(border.getBorder());
        for (Shape wall : walls) {
            this.layout.getChildren().add(wall);
        }
    }

    public static void main(String[] args) {
        launch(CaveQuest2App.class);
    }
}