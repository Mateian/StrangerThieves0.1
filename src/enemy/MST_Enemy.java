package enemy;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class MST_Enemy extends Entity {
    public MST_Enemy(GamePanel gp) {
        super(gp);

        spriteNumber = 1;
        name = "Enemy";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        type = 2;

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("/enemy/enemy_back_1");
        up2 = setup("/enemy/enemy_back_2");
        down1 = setup("/enemy/enemy_front_1");
        down2 = setup("/enemy/enemy_front_2");
        left1 = setup("/enemy/enemy_left_1");
        left2 = setup("/enemy/enemy_left_2");
        right1 = setup("/enemy/enemy_right_1");
        right2 = setup("/enemy/enemy_right_2");
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
    }
}
