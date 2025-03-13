package net.iouhase.imagegenerator;


import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class DrawThread implements Runnable {
    final PixelWriter writer;
    double startX, startY;
    double endX, endY;

    public DrawThread(PixelWriter writer, double startX, double startY, double endX, double endY) {
        this.writer = writer;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void run() {
        for (double x = startX; x < endX; x++) {
            for (double y = startY; y < endY; y++) {
                synchronized (writer) {
                    writer.setColor((int) x, (int) y, new Color(Math.random(), Math.random(), Math.random(), 1));
                }
            }
        }
    }
}
