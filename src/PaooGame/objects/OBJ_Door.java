package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Door extends Entity {
    public OBJ_Door(Game gp) {
        super(gp);
        name = "Door";
        down = setup("/objects/door", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
