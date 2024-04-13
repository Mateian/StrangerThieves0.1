package PaooGame.enemy;

import PaooGame.objects.OBJ_Bullet;
import PaooGame.entity.Entity;
import PaooGame.Game;

import java.util.Random;

public class MST_Enemy extends Entity {
    Game gp;
    public MST_Enemy(Game gp) {
        super(gp);

        this.gp = gp;

        spriteNumber = 1;
        name = "Enemy";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        type = 2;
        projectile = new OBJ_Bullet(gp);

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("/enemy/enemy_back_1", gp.tileSize, gp.tileSize);
        up2 = setup("/enemy/enemy_back_2", gp.tileSize, gp.tileSize);
        down1 = setup("/enemy/enemy_front_1", gp.tileSize, gp.tileSize);
        down2 = setup("/enemy/enemy_front_2", gp.tileSize, gp.tileSize);
        left1 = setup("/enemy/enemy_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/enemy/enemy_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/enemy/enemy_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/enemy/enemy_right_2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {
        actionCounter++;

        if(actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if(i <= 25) {
                direction = "up";
            } else if(i > 25 && i <= 50) {
                direction = "left";
            } else if(i > 50 && i <= 75) {
                direction = "right";
            } else if(i > 75 && i <= 100) {
                direction = "down";
            }
            actionCounter = 0;
        }
        int i = new Random().nextInt(100) + 1;
        if(i > 99 && !projectile.alive && shotCounter == 30) {
            projectile.set(worldx, worldy, direction, true, this);
            gp.projectileList.add(projectile);
            shotCounter = 0;
        }
    }
    public void dmgReact() {
        actionCounter = 0;
        direction = gp.player.direction;
    }
}
