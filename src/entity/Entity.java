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
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public String direction = "down";
    public int actionCounter = 0;
    public int spriteCounter = 0;
    public int spriteNumber = 0;
    public boolean invincible = false;
    boolean shooting = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dead = false;
    public int invincibleCounter = 0;
    int deadCounter = 0;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    String dialogs[] = new String[25];
    int dialogIndex = 0;
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int type; // 0 - player, 1 - npc, 2 - monster

    // Character Status
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public BufferedImage setup(String path, int width, int height) {
        UtilityTool tool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(path + ".png"));
            image = tool.scaleImage(image, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

//    De adaugat la clasele care au toate sprite-urile
//    caracterului disponibile in toate directiile.

    public void talk() {
        if (dialogs[dialogIndex] == null) {
            dialogIndex = 0;
        }
        gp.ui.dialogText = dialogs[dialogIndex];
        dialogIndex++;

        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "left":
                direction = "right";
                break;
            case "down":
                direction = "up";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    public void draw(Graphics2D graph2) {
        BufferedImage image = null;
        int screenX = worldx - gp.player.worldx + gp.player.screenX;
        int screenY = worldy - gp.player.worldy + gp.player.screenY;

        if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenX && worldx - gp.tileSize < gp.player.worldx + gp.player.screenX && worldy + gp.tileSize > gp.player.worldy - gp.player.screenY && worldy - gp.tileSize < gp.player.worldy + gp.player.screenY) {
            switch (direction) {
                case "up":
                    if (spriteNumber == 0) {
                        image = up;
                    }
                    if (spriteNumber == 1) {
                        image = up1;
                    }
                    if (spriteNumber == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNumber == 0) {
                        image = down;
                    }
                    if (spriteNumber == 1) {
                        image = down1;
                    }
                    if (spriteNumber == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNumber == 0) {
                        image = left;
                    }
                    if (spriteNumber == 1) {
                        image = left1;
                    }
                    if (spriteNumber == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNumber == 0) {
                        image = right;
                    }
                    if (spriteNumber == 1) {
                        image = right1;
                    }
                    if (spriteNumber == 2) {
                        image = right2;
                    }
                    break;
            }
            if(invincible) {
                graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
            }

            if(dead == true) {
                deadAnim(graph2);
            }
            graph2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
    public void deadAnim(Graphics2D graph2) {
        deadCounter++;

        int i = 5;

        if(deadCounter <= i) {
            changeAlpha(graph2, 0f);
        }
        if(deadCounter > i && deadCounter <= i * 2) {
            changeAlpha(graph2,1f);
        }
        if(deadCounter > i * 2 && deadCounter <= i * 3) {
            changeAlpha(graph2,0f);
        }
        if(deadCounter > i * 3 && deadCounter <= i * 4) {
            changeAlpha(graph2,1f);
        }
        if(deadCounter > i * 4 && deadCounter <= i * 5) {
            changeAlpha(graph2,0f);
        }
        if(deadCounter > i * 5 && deadCounter <= i * 6) {
            changeAlpha(graph2,1f);
        }
        if(deadCounter > i * 6 && deadCounter <= i * 7) {
            changeAlpha(graph2,0f);
        }
        if(deadCounter > i * 7) {
            dead = false;
            alive = false;
        }
    }
    public void changeAlpha(Graphics2D graph2, float alpha) {
        graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    }
    public void setAction() {
    }

//    Functie de adaugat in clasele in care se doreste implementarea AI-ului

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
        gp.cChecker.checkEntity(this, gp.NPC);
        gp.cChecker.checkEntity(this, gp.mst);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if (this.type == 2 && contactPlayer) {
            if (!gp.player.invincible) {
                gp.player.life--;
                gp.player.invincible = true;
            }
        }

        if (!collisionOn) {
            switch (direction) {
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
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
}
