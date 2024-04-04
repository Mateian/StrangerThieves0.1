package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldx, worldy;
    public int speed;
    public BufferedImage up, up1, up2, left, left1, left2, down, down1, down2, right, right1, right2;
    public String direction;
    public int actionCounter = 0;
    public int spriteCounter = 0;
    public int spriteNumber = 0;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public BufferedImage setup(String path) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(path + ".png"));
            image = tool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return image;
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

    public void setAction() {}
    // Functie de adaugat in clasele in care se doreste implementarea AI-ului
//    public void setAction() {
//        actionCounter++;
//
//        if(actionCounter == 120) {
//            Random random = new Random();
//            int i = random.nextInt(100) + 1;
//            System.out.println(i);
//            if(i <= 25) {
//                direction = "up";
//            } else if(i > 25 && i <= 50) {
//                direction = "left";
//            } else if(i > 50 && i <= 75) {
//                direction = "right";
//            } else if(i > 75 && i <= 100) {
//                direction = "down";
//            }
//            actionCounter = 0;
//        }
//    }
    public void update() {

        // AI
        setAction();

        // Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);
        if(!collisionOn) {
            switch(direction) {
                case "up":
                    worldy -= speed;
                    break;
                case "down":
                    worldy += speed;
                    break;
                case "left":
                    worldx -= speed;
                    break;
                case "right":
                    worldx += speed;
                    break;
            }
        }

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
}
