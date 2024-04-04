package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class NPC_Fen extends Entity {
    public int spriteNumber = 1;

    public NPC_Fen(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage() {
        down = setup("/npc/fen_front");
        down1 = setup("/npc/fen_scared_1");
        down2 = setup("/npc/fen_scared_2");
    }

    public void update() {
        // Sprite changer
        spriteCounter++;
        if (spriteCounter > 30) {
            if (spriteNumber == 0) {
                spriteNumber = 1;
            }
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D graph2) {
        BufferedImage image = null;
        int screenX = worldx - gp.player.worldx + gp.player.screenX;
        int screenY = worldy - gp.player.worldy + gp.player.screenY;

        if(worldx + gp.tileSize > gp.player.worldx - gp.player.screenX && worldx -gp.tileSize < gp.player.worldx + gp.player.screenX && worldy + gp.tileSize > gp.player.worldy - gp.player.screenY && worldy - gp.tileSize < gp.player.worldy + gp.player.screenY) {
            switch(direction) {
                case "up":
                    if(spriteNumber == 0) {
                        image = up;
                    }
                    if(spriteNumber == 1) {
                        image = up1;
                    }
                    if(spriteNumber == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if(spriteNumber == 0) {
                        image = down;
                    }
                    if(spriteNumber == 1) {
                        image = down1;
                    }
                    if(spriteNumber == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if(spriteNumber == 0) {
                        image = left;
                    }
                    if(spriteNumber == 1) {
                        image = left1;
                    }
                    if(spriteNumber == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if(spriteNumber == 0) {
                        image = right;
                    }
                    if(spriteNumber == 1) {
                        image = right1;
                    }
                    if(spriteNumber == 2) {
                        image = right2;
                    }
                    break;
            }
            graph2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
