package PaooGame.objects;

import PaooGame.entity.Entity;
import PaooGame.Game;

public class OBJ_Heart extends Entity {
    public OBJ_Heart(Game gp) {
        super(gp);
        name = "Heart";
        image = setup("/objects/full_heart", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/half_heart", gp.tileSize, gp.tileSize);
        image3 = setup("/objects/black_heart", gp.tileSize, gp.tileSize);
    }
}

