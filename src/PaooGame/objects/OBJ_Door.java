package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.main.GamePanel;

public class OBJ_Door extends Entity {
    public OBJ_Door(GamePanel gp) {
        super(gp);
        name = "Door";
        down = setup("/objects/door", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
