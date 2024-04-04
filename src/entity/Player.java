package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    KeyHandler keyH;

    public BufferedImage up, down, left, right;

    public final int screenX;
    public final int screenY;

    public boolean moving = false;
    public int hasKey = 0;
    public static boolean hasWeapon = false;
    int counterGun = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

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
        getImage();
    }

    public void setDefaultValues() {
        worldx = gp.tileSize * 24;
        worldy = gp.tileSize * 30 - 1;
        speed = 4;
        direction = "up";
    }

    public void getImage() {
        up = setup("/player/skar_back");
        up1 = setup("/player/skar_back_1");
        up2 = setup("/player/skar_back_2");
        down = setup("/player/skar_front");
        down1 = setup("/player/skar_front_1");
        down2 = setup("/player/skar_front_2");
        left = setup("/player/skar_left");
        left1 = setup("/player/skar_left_1");
        left2 = setup("/player/skar_left_2");
        right = setup("/player/skar_right");
        right1 = setup("/player/skar_right_1");
        right2 = setup("/player/skar_right_2");
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

            // Check NPC collision
            int NPCIdx = gp.cChecker.checkEntity(this, gp.NPC);
            intersectNPC(NPCIdx);

            // Jucatorul nu poate "inainta" daca interactioneaza cu un obiect/tile
            // cu coliziune
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
            if(spriteCounter > 10) {
                if(spriteNumber == 0) {
                    spriteNumber = 1;
                }
                if(spriteNumber == 1) {
                    spriteNumber = 2;
                } else if(spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNumber = 0;
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
                    counterGun++;
                        if(!hasWeapon) {
                            System.out.println("You picked Skargun!");

                            hasWeapon = true;
                        } else {
                            if(counterGun > 20) {
                                System.out.println("You already have a weapon!");
                                counterGun = 0;
                            }
                        }

                    break;
            }
        }
    }

    public void intersectNPC(int i) {
        if(i != 999) {
            System.out.println("You are hitting an NPC!");
        }
    }

    public void draw(Graphics2D graph2) {
        BufferedImage image = null;

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
        graph2.drawImage(image, screenX, screenY, null);

    }
}
