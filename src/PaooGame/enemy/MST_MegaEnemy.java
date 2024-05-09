package PaooGame.enemy;

import PaooGame.Game;
import PaooGame.entity.Entity;
import PaooGame.objects.OBJ_Bullet;
import PaooGame.objects.OBJ_MegaBullet;

import java.util.Random;

public class MST_MegaEnemy extends Entity {
    // Base Settings
    Game gp;

    public MST_MegaEnemy(Game gp) {
        super(gp);

        this.gp = gp;

        spriteNumber = 1;
        name = "Mega_Enemy";
        speed = 3;
        maxLife = 6;
        life = maxLife;
        type = 2;
        projectile = new OBJ_MegaBullet(gp);
        attack = 2;
        projectile.attack = 3;

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup(6, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        up2 = setup(7, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        down1 = setup(4, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        down2 = setup(5, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        left1 = setup(2, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        left2 = setup(3, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        right1 = setup(0,0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
        right2 = setup(1, 0, "/enemy/mega_enemy_spritesheet", gp.originalTileSize, gp.originalTileSize);
    }

    public void setAction() {
        actionCounter++;

        if(actionCounter == 60) {
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
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
            shotCounter = 0;
        }
    }
    public void dmgReact() {
        actionCounter = 0;
        direction = gp.player.direction;
    }
}
