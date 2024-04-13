package PaooGame.main;

import PaooGame.Game;
import PaooGame.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class UtilityTool {

    // Scale "original" in "width" x "height"
    public BufferedImage scaleImage(BufferedImage original, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D graph2 = scaledImage.createGraphics();
        graph2.drawImage(original, 0, 0, width, height, null);
        graph2.dispose();

        return scaledImage;
    }

    public BufferedImage cropImage(BufferedImage spriteSheet, int x, int y, int tileWidth, int tileHeight) {
        return spriteSheet.getSubimage(x, y, tileWidth, tileHeight);
    }
}
