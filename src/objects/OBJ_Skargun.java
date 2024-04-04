package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Skargun extends SuperObject {
    GamePanel gp;

    public OBJ_Skargun(GamePanel gp) {
        name = "Skargun";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/hidden_chest.png"));
            tool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
