package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Chest extends Entity {
    public OBJ_Chest(Game gp) {
        super(gp);
        name = "Chest";
        down = setup("/objects/chest", gp.tileSize, gp.tileSize);
    }
}
