package net.iouhase.imagegenerator;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ImageController {
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {

        int scale = 2;
        int width = 1280;
        int height = 720;

        GraphicsContext gc = canvas.getGraphicsContext2D();


        for (int i = 0; i < width / scale; i++) {
            for (int j = 0; j < height / scale; j++) {
                gc.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
                gc.fillRect(i * scale, j * scale, scale, scale);
            }
        }
    }
}