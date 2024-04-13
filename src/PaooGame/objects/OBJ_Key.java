package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Key extends Entity {
    public OBJ_Key(Game gp) {
        super(gp);
        name = "Key";
        down = setup("/objects/key", gp.tileSize, gp.tileSize);
    }
}
