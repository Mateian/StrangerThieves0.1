package objects;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Bullet extends Projectile {
    GamePanel gp;
    public OBJ_Bullet(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Bullet";
        speed = 20;
        maxLife = 15;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }
    public void getImage() {
        up1=up2=up=down1=down2=down=left1=left2=left=right1=right2=right = setup("/objects/bullet", gp.tileSize, gp.tileSize);
    }
}
