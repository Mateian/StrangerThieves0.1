package objects;

import main.GamePanel;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool tool = new UtilityTool();

    public void draw(Graphics2D graph2, GamePanel gp) {
        int screenX = worldX - gp.player.worldx + gp.player.screenX;
        int screenY = worldY - gp.player.worldy + gp.player.screenY;

        if(worldX + gp.tileSize > gp.player.worldx - gp.player.screenX && worldX -gp.tileSize < gp.player.worldx + gp.player.screenX && worldY + gp.tileSize > gp.player.worldy - gp.player.screenY && worldY - gp.tileSize < gp.player.worldy + gp.player.screenY) {
            graph2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
