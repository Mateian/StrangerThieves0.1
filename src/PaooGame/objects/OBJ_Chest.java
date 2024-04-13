package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.main.GamePanel;

public class OBJ_Chest extends Entity {
    public OBJ_Chest(GamePanel gp) {
        super(gp);
        name = "Chest";
        down = setup("/objects/chest", gp.tileSize, gp.tileSize);
    }
}
