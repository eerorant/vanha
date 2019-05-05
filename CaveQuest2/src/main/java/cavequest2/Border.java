package cavequest2;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import static javafx.scene.shape.Shape.subtract;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Luokka luo rajat pelin tasoille. Se arpoo rajat ja luo kahdeksankulmion.
 * 
 */
public class Border {

    private Shape area;

    public Border() {
        Random random = new Random();

        //random points
        double x1 = (double) random.nextInt(100);
        double y1 = (double) random.nextInt(100);
        double x2 = (double) 100 + random.nextInt(400);
        double y2 = (double) random.nextInt(100);
        double x3 = (double) 500 + random.nextInt(100);
        double y3 = (double) random.nextInt(100);
        double x4 = (double) 500 + random.nextInt(100);
        double y4 = (double) 100 + random.nextInt(400);
        double x5 = (double) 500 + random.nextInt(100);
        double y5 = (double) 500 + random.nextInt(100);
        double x6 = (double) 100 + random.nextInt(400);
        double y6 = (double) 500 + random.nextInt(100);
        double x7 = (double) random.nextInt(100);
        double y7 = (double) 500 + random.nextInt(100);
        double x8 = (double) random.nextInt(100);
        double y8 = (double) 100 + random.nextInt(400);

        Polygon poly = new Polygon();
        poly.getPoints().addAll(new Double[]{0.0, 0.0, 600.0, 0.0, 600.0, 600.0, 0.0, 600.0});

        Polygon randomPolygon = new Polygon();
        randomPolygon.getPoints().addAll(new Double[]{x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7, x8, y8});

        this.area = subtract(poly, randomPolygon);
        this.area.setFill(Color.LIGHTGRAY);

    }

    public Shape getBorder() {
        return this.area;
    }
}
