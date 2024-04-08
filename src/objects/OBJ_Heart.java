package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends SuperObject {
    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/full_heart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/half_heart.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/black_heart.png"));
            image = tool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = tool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = tool.scaleImage(image3, gp.tileSize, gp.tileSize);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

