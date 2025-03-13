package net.iouhase.imagegenerator;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageController {
    @FXML
    private ImageView image;

    @FXML
    private void initialize() {
        final int THREADS_SQRT = 2;
        double width = 1920;
        double height = 1080;

        WritableImage writableImage = new WritableImage((int)width, (int)height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        image.setImage(writableImage);

        for (int i = 0; i < THREADS_SQRT; i++) {
            for (int j = 0; j < THREADS_SQRT; j++) {
                double startX, startY;
                double endX, endY;
                startX = i * width / THREADS_SQRT;
                startY = j * height / THREADS_SQRT;
                endX = startX + width / THREADS_SQRT;
                endY = startY + height / THREADS_SQRT;

                Thread thread = new Thread(new DrawThread(pixelWriter, startX, startY, endX, endY));
                thread.start();
            }
        }
    }
}