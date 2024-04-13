package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Boots extends Entity {
    public OBJ_Boots(Game gp) {
        super(gp);
        name = "Boots";
        down = setup("/objects/boots", gp.tileSize, gp.tileSize);
    }
}
