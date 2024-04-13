package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Skargun extends Entity {
    public OBJ_Skargun(Game gp) {
        super(gp);
        name = "Skargun";
        down = setup("/objects/hidden_chest", gp.tileSize, gp.tileSize);
        collision = true;
        solidArea.x = 0;
        solidArea.y = 20;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
