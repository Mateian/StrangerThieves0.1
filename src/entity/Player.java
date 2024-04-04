package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;
    public static boolean hasWeapon = false;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenWidth / 2 - (gp.tileSize * 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldx = gp.tileSize * 24;
        worldy = gp.tileSize * 30 - 1;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage() {
        up1 = setup("skar_back_1");
        up2 = setup("skar_back_2");
        down1 = setup("skar_front_1");
        down2 = setup("skar_front_2");
        left1 = setup("skar_left_1");
        left2 = setup("skar_left_2");
        right1 = setup("skar_right_1");
        right2 = setup("skar_right_2");
    }

    public BufferedImage setup(String imageName) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = tool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void update() {
        // Caracterul se va misca doar cand sunt active tastele de miscare
        // folosindu-ne de acest if
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if(keyH.upPressed) {
                direction = "up";

            } else if(keyH.downPressed) {
                direction = "down";

            } else if(keyH.rightPressed) {
                direction = "right";

            } else if(keyH.leftPressed) {
                direction = "left";

            }
            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check object collision
            int objectIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            // if collision is false, player can move
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
            spriteCounter++;
            if(spriteCounter > 10) {
                if(spriteNumber == 1) {
                    spriteNumber = 2;
                } else if(spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i) {
        if(i != 999) {
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey > 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You opened the door!");
                    } else {
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Boots":
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
                case "Skargun":
                    if(!hasWeapon) {
                        System.out.println("You picked Skargun!");
                        hasWeapon = true;
                    } else {
                        System.out.println("You already have a weapon!");
                    }
                    break;
            }
        }
    }

    public void draw(Graphics2D graph2) {
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNumber == 1) {
                    image = up1;
                }
                if(spriteNumber == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = down1;
                }
                if(spriteNumber == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber == 1) {
                    image = left1;
                }
                if(spriteNumber == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1) {
                    image = right1;
                }
                if(spriteNumber == 2) {
                    image = right2;
                }
                break;
        }
        graph2.drawImage(image, screenX, screenY, null);

    }
}
