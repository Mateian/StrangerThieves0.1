package main;
import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        if(hit(23, 29, "any")) {
            giveDamage(gp.dialogState);
        }
        if(hit(25, 40, "any")) {
            heal(gp.dialogState);
        }
    }

    public void giveDamage(int gameState) {
        gp.gameState = gameState;
        gp.ui.dialogText = "Ai luat damage!";
        gp.player.life--;
    }

    public void heal(int gameState) {
        gp.gameState = gameState;
        gp.ui.dialogText = "Ai luat heal!";
        gp.player.life = gp.player.maxLife;
    }

    public boolean hit(int eventColumn, int eventRow, String direction) {
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldx + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldy + gp.player.solidArea.y;
        eventRect.x = eventColumn * gp.tileSize + eventRect.x;
        eventRect.y = eventColumn * gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)) {
            if(gp.player.direction.contentEquals(direction) || direction.contentEquals("any")) {
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;


        return hit;
    }
}
