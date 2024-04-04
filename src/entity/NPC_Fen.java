package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class NPC_Fen extends Entity {
    int spriteNumber = 1;

    public NPC_Fen(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
    }

    public void getImage() {
        down = setup("/npc/fen_front");
        down1 = setup("/npc/fen_scared_1");
        down2 = setup("/npc/fen_scared_2");
        left = setup("/npc/fen_happy");
    }
}
