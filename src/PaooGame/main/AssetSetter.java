package PaooGame.main;

import PaooGame.enemy.MST_Enemy;
import PaooGame.entity.NPC_Fen;
import PaooGame.objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldx = 23 * gp.tileSize;
        gp.obj[0].worldy = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldx = 23 * gp.tileSize;
        gp.obj[1].worldy = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldx = 38 * gp.tileSize;
        gp.obj[2].worldy = 8 * gp.tileSize;

        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldx = 10 * gp.tileSize;
        gp.obj[3].worldy = 11 * gp.tileSize;

        gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldx = 8 * gp.tileSize;
        gp.obj[4].worldy = 28 * gp.tileSize;

        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldx = 12 * gp.tileSize;
        gp.obj[5].worldy = 22 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldx = 10 * gp.tileSize;
        gp.obj[6].worldy = 7 * gp.tileSize;

        gp.obj[7] = new OBJ_Boots(gp);
        gp.obj[7].worldx = 37 * gp.tileSize;
        gp.obj[7].worldy = 42 * gp.tileSize;

        gp.obj[8] = new OBJ_Skargun(gp);
        gp.obj[8].worldx = 22 * gp.tileSize;
        gp.obj[8].worldy = 30 * gp.tileSize;
    }

    public void setNPC() {
        gp.NPC[0] = new NPC_Fen(gp);
        gp.NPC[0].worldx = gp.tileSize * 23;
        gp.NPC[0].worldy = gp.tileSize * 30 - 1;
    }

    public void setMonster() {
        int k = 0;
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                gp.mst[k] = new MST_Enemy(gp);
                gp.mst[k].worldx = gp.tileSize * (23 + j);
                gp.mst[k].worldy = gp.tileSize * (15 + i);
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
