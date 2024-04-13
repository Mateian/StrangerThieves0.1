package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.main.GamePanel;

public class OBJ_Key extends Entity {
    public OBJ_Key(GamePanel gp) {
        super(gp);
        name = "Key";
        down = setup("/objects/key", gp.tileSize, gp.tileSize);
    }
}
