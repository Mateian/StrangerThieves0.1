package PaooGame.entity;

import PaooGame.Game;

public class Projectile extends Entity {
    Entity ent;
    public Projectile(Game gp) {
        super(gp);
    }
    public void set(int worldX, int worldY, String dir, boolean alive, Entity ent) {
        this.worldx = worldX;
        this.worldy = worldY;
        this.direction = dir;
        this.alive = alive;
        this.ent = ent;
        this.life = this.maxLife;
    }
    public void update() {
        if(ent == gp.player) {
            int mstIndex = gp.cChecker.checkEntity(this, gp.mst);
            if(mstIndex != 999) {
                gp.player.damageEnemy(mstIndex, attack);
                alive = false;
            }
        } else {
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(!gp.player.invincible && contactPlayer) {
                dmgPlayer(attack);
                alive = false;
            }
        }

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

        life--;
        if(life <= 0) {
            alive = false;
        }
        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNumber == 1 || spriteNumber == 0) {
                spriteNumber = 2;
            } else if(spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }
}
