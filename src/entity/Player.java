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

        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getImage();
    }

    public void setDefaultValues() {
        worldx = gp.tileSize * 24;
        worldy = gp.tileSize * 30 - 1;
        speed = 4;
        direction = "up";
        maxLife = 6;
        life = maxLife;
    }

    public void getImage() {
        // Moving Images
        up = setup("/player/skar_back", gp.tileSize, gp.tileSize);
        up1 = setup("/player/skar_back_1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/skar_back_2", gp.tileSize, gp.tileSize);
        down = setup("/player/skar_front", gp.tileSize, gp.tileSize);
        down1 = setup("/player/skar_front_1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/skar_front_2", gp.tileSize, gp.tileSize);
        left = setup("/player/skar_left", gp.tileSize, gp.tileSize);
        left1 = setup("/player/skar_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/skar_left_2", gp.tileSize, gp.tileSize);
        right = setup("/player/skar_right", gp.tileSize, gp.tileSize);
        right1 = setup("/player/skar_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/skar_right_2", gp.tileSize, gp.tileSize);

        // Attack Images
        attackUp1 = setup("/player/skar_attack_back_1", gp.tileSize, gp.tileSize);
        attackUp2 = setup("/player/skar_attack_back_2", gp.tileSize, gp.tileSize);
        attackDown1 = setup("/player/skar_attack_front_1", gp.tileSize, gp.tileSize);
        attackDown2 = setup("/player/skar_attack_front_2", gp.tileSize, gp.tileSize);
        attackLeft1 = setup("/player/skar_attack_left_1", gp.tileSize, gp.tileSize);
        attackLeft2 = setup("/player/skar_attack_left_2", gp.tileSize, gp.tileSize);
        attackRight1 = setup("/player/skar_attack_right_1", gp.tileSize, gp.tileSize);
        attackRight2 = setup("/player/skar_attack_right_2", gp.tileSize, gp.tileSize);
    }

    public void update() {

        if(attacking) {
            attacking();
        }

        // Caracterul se va misca doar cand sunt active tastele de miscare
        // folosindu-ne de acest if
        else if(keyH.ePressed || keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
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

            // Check Monster collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.mst);
            damageFromMonster(monsterIndex);

            // Check Event
            gp.eHandler.checkEvent();

            // Jucatorul nu poate "inainta" daca interactioneaza cu un obiect/tile
            // cu coliziune
            if(!collisionOn && !keyH.ePressed) {
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

            gp.keyH.ePressed = false;

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

        if(invincible) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void attacking() {
        spriteCounter++;

        if(spriteCounter <= 12) {
            spriteNumber = 1;
        }
        if(spriteCounter > 12 && spriteCounter <= 24) {
            spriteNumber = 2;

            // Salveaza valoarea curenta
            int currentWorldX = worldx;
            int currentWorldY = worldy;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // update
            switch(direction) {
                case "up":
                    worldy -= attackArea.height;
                    break;
                case "down":
                    worldy += attackArea.height;
                    break;
                case "left":
                    worldx -= attackArea.width;
                    break;
                case "right":
                    worldx += attackArea.width;
            }
            // Area solida devine area de atac
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Verifica daca exista un inamic in zona
            int mstIndex = gp.cChecker.checkEntity(this, gp.mst);
            damageEnemy(mstIndex);

            worldx = currentWorldX;
            worldy = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCounter > 24 && spriteCounter <= 36) {
            spriteNumber = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }
    public void damageEnemy(int i) {
        if(i != 999) {
            if(!gp.mst[i].invincible) {
                gp.playSE(5);
                gp.mst[i].life--;
                gp.mst[i].invincible = true;

                if(gp.mst[i].life <= 0) {
                    gp.mst[i].dead = true;
                    gp.playSE(6);
                }
            }
        }
    }

    public void damageFromMonster(int i) {
        if(i != 999) {
            if(!invincible) {
                life--;
                invincible = true;
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
        if(gp.keyH.ePressed) {
            if(i != 999) {
                gp.gameState = gp.dialogState;
                gp.NPC[i].talk();
            } else {
                attacking = true;
            }
        }
        gp.keyH.ePressed = false;
    }

    public void draw(Graphics2D graph2) {
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(!attacking) {
                    if(spriteNumber == 0) {
                        image = up;
                    }
                    if(spriteNumber == 1) {
                        image = up1;
                    }
                    if(spriteNumber == 2) {
                        image = up2;
                    }
                }
                if(attacking) {
                    if(spriteNumber == 0) {
                        spriteNumber = 1;
                    }
                    if(spriteNumber == 1) {
                        image = attackUp1;
                    }
                    if(spriteNumber == 2) {
                        image = attackUp2;
                    }
                }
                break;
            case "down":
                if(!attacking) {
                    if(spriteNumber == 0) {
                        image = down;
                    }
                    if(spriteNumber == 1) {
                        image = down1;
                    }
                    if(spriteNumber == 2) {
                        image = down2;
                    }
                }
                if(attacking) {
                    if(spriteNumber == 0) {
                        spriteNumber = 1;
                    }
                    if(spriteNumber == 1) {
                        image = attackDown1;
                    }
                    if(spriteNumber == 2) {
                        image = attackDown2;
                    }
                }
                break;
            case "left":
                if(!attacking) {
                    if(spriteNumber == 0) {
                        image = left;
                    }
                    if(spriteNumber == 1) {
                        image = left1;
                    }
                    if(spriteNumber == 2) {
                        image = left2;
                    }
                }
                if(attacking) {
                    if(spriteNumber == 0) {
                        spriteNumber = 1;
                    }
                    if(spriteNumber == 1) {
                        image = attackLeft1;
                    }
                    if(spriteNumber == 2) {
                        image = attackLeft2;
                    }
                }
                break;
            case "right":
                if(!attacking) {
                    if(spriteNumber == 0) {
                        image = right;
                    }
                    if(spriteNumber == 1) {
                        image = right1;
                    }
                    if(spriteNumber == 2) {
                        image = right2;
                    }
                }
                if(attacking) {
                    if(spriteNumber == 0) {
                        spriteNumber = 1;
                    }
                    if(spriteNumber == 1) {
                        image = attackRight1;
                    }
                    if(spriteNumber == 2) {
                        image = attackRight2;
                    }
                }
                break;
        }
        if(invincible) {
            graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }

        graph2.drawImage(image, screenX, screenY, null);

        graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // Debug
        graph2.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        graph2.setColor(Color.white);
        graph2.drawString("Invincible: " + invincibleCounter, 10, 400);
    }
}
