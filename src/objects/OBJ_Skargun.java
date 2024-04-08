package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Skargun extends Entity {
    public OBJ_Skargun(GamePanel gp) {
        super(gp);
        name = "Skargun";
        down = setup("/objects/hidden_chest");
        collision = true;
        solidArea.x = 0;
        solidArea.y = 20;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
