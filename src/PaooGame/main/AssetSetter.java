package PaooGame.main;

import PaooGame.Game;
import PaooGame.enemy.MST_Enemy;
import PaooGame.entity.NPC_Fen;
import PaooGame.objects.*;

public class AssetSetter {

    // Base Settings
    Game gp;

    public AssetSetter(Game gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;

        gp.obj[7] = new OBJ_Boots(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;

        gp.obj[8] = new OBJ_Skargun(gp);
        gp.obj[8].worldX = 22 * gp.tileSize;
        gp.obj[8].worldY = 30 * gp.tileSize;
    }

    public void setNPC() {
        gp.NPC[0] = new NPC_Fen(gp);
        gp.NPC[0].worldX = gp.tileSize * 23;
        gp.NPC[0].worldY = gp.tileSize * 30 - 1;
    }

    public void setMonster() {
        int k = 0;
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                gp.mst[k] = new MST_Enemy(gp);
                gp.mst[k].worldX = gp.tileSize * (23 + j);
                gp.mst[k].worldY = gp.tileSize * (15 + i);
                k++;
            }
        }
//
//        gp.mst[1] = new MST_Enemy(gp);
//        gp.mst[1].worldx = gp.tileSize * 24;
//        gp.mst[1].worldy = gp.tileSize * 25;
//
//        gp.mst[2] = new MST_Enemy(gp);
//        gp.mst[2].worldx = gp.tileSize * 23;
//        gp.mst[2].worldy = gp.tileSize * 27;
    }
}
