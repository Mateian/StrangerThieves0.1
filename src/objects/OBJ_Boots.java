package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends Entity {
    public OBJ_Boots(GamePanel gp) {
        super(gp);
        name = "Boots";
        down = setup("/objects/boots", gp.tileSize, gp.tileSize);
    }
}
