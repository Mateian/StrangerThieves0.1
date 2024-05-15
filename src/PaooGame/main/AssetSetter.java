package PaooGame.main;

import PaooGame.Game;
import PaooGame.enemy.MST_Enemy;
import PaooGame.enemy.MST_HEAD;
import PaooGame.enemy.MST_MegaEnemy;
import PaooGame.entity.Entity;
import PaooGame.entity.NPC_Fen;
import PaooGame.entity.NPC_HEAD;
import PaooGame.objects.*;

import java.util.ArrayList;
import java.util.stream.Collector;

public class AssetSetter {

    // Base Settings
    Game gp;

    public AssetSetter(Game gp) {
        this.gp = gp;
    }
    public void setObject() {
        int mapNum;
        int k;
        ArrayList<Entity>[] chest = new ArrayList[30];
        for(int i = 0; i < 30; ++i) {
            chest[i] = new ArrayList<Entity>();
        }
        int chestNum = 0;
        // Level 1 Objects
        mapNum = 0;
        k = 0;
        gp.obj[mapNum][k] = new OBJ_SkargunChest(gp);
        gp.obj[mapNum][k].worldX = 22 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 30 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Heart(gp);
        gp.obj[mapNum][k].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 30 * gp.tileSize;
        ++k;

        // Level 2 Objects
        k = 0;
        mapNum++;
        gp.spawnedDoors = 0;

        // Weapons

        // Doors
        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 19 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 13 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 38 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 32 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 14 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 33 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 9 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 40 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 38 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        gp.obj[mapNum][k] = new OBJ_Door(gp);
        gp.obj[mapNum][k].worldX = 33 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 10 * gp.tileSize;
        ++k;
        gp.spawnedDoors++;

        // Cards

        // Chests
        chest[chestNum].add(new OBJ_HealPotion(gp));
        chest[chestNum].add(new OBJ_Electron(gp));
        chest[chestNum].add(new OBJ_Card(gp));
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 38 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 42 * gp.tileSize;
        ++k;
        chestNum++;
        chest[chestNum].add(new OBJ_HealPotion(gp));
        chest[chestNum].add(new OBJ_KTPY(gp));
        chest[chestNum].add(new OBJ_Card(gp));
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 20 * gp.tileSize;
        ++k;
        chestNum++;
        chest[chestNum].add(new OBJ_HealPotion(gp));
        chest[chestNum].add(new OBJ_Electron(gp));
        chest[chestNum].add(new OBJ_Snaipa(gp));
        chest[chestNum].add(new OBJ_HealPotion(gp));
        chest[chestNum].add(new OBJ_Card(gp));
        chest[chestNum].add(new OBJ_Card(gp));
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 44 * gp.tileSize;
        ++k;
        chestNum++;
        chest[chestNum].add(new MST_Enemy(gp));;
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 25 * gp.tileSize;
        ++k;
        chestNum++;
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        chestNum++;
        chest[chestNum].add(new OBJ_HealPotion(gp));
        chest[chestNum].add(new OBJ_Electron(gp));
        gp.obj[mapNum][k] = new OBJ_Chest(gp, chest[chestNum]);
        gp.obj[mapNum][k].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 15 * gp.tileSize;
        ++k;
        chestNum++;

        // Level 3 Objects
        k = 0;
        mapNum++;
        gp.obj[mapNum][k] = new OBJ_BrokenChest(gp);
        gp.obj[mapNum][k].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 9 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 12 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 19 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Chair(gp);
        gp.obj[mapNum][k].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 5 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 9 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 10 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 9 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 20 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 24 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 24 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 41 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 5 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 5 * gp.tileSize;
        ++k;
//        gp.obj[mapNum][k] = new OBJ_Stone(gp, true);
//        gp.obj[mapNum][k].worldX = 33 * gp.tileSize;
//        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
//        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 41 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 40 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 10 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 41 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 8 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Stone(gp, false);
        gp.obj[mapNum][k].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 9 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 29 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 29 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 38 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 11 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Plant(gp);
        gp.obj[mapNum][k].worldX = 38 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 8 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Chair(gp);
        gp.obj[mapNum][k].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 9 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Chair(gp);
        gp.obj[mapNum][k].worldX = 17 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_BrokenChest(gp);
        gp.obj[mapNum][k].worldX = 33 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 8 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_BrokenChest(gp);
        gp.obj[mapNum][k].worldX = 29 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 10 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 10 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 13 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 6 * gp.tileSize;
        ++k;
        gp.obj[mapNum][k] = new OBJ_Bottle(gp);
        gp.obj[mapNum][k].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][k].worldY = 7 * gp.tileSize;
        ++k;
    }
    public void setNPC() {
        int mapNum;
        int k;
        // Level 1 NPCs
        mapNum = 0;
        k = 0;
        gp.NPC[mapNum][k] = new NPC_Fen(gp);
        gp.NPC[mapNum][k].worldX = gp.tileSize * 23;
        gp.NPC[mapNum][k].worldY = gp.tileSize * 30;
        k++;
        // Level 2 NPCs
        mapNum++;
        // HEAD
        gp.NPC[mapNum][k] = new NPC_HEAD(gp);
        gp.NPC[mapNum][k].worldX = gp.tileSize * 40;
        gp.NPC[mapNum][k].worldY = gp.tileSize * 12; //12
        k++;

        // Fen
        gp.NPC[mapNum][k] = new NPC_Fen(gp);
        gp.NPC[mapNum][k].worldX = gp.tileSize * 42; // 41
        gp.NPC[mapNum][k].worldY = gp.tileSize * 12; // 12
        k++;

        // Level 3 NPCs
        mapNum++;
        k = 0;

        // Fen
        gp.NPC[mapNum][k] = new NPC_Fen(gp);
        gp.NPC[mapNum][k].worldX = gp.tileSize * 40; // 41
        gp.NPC[mapNum][k].worldY = gp.tileSize * 22; // 12
        k++;
    }
    public void setMonster() {
        // Level 1 Monsters
        int mapNum = 0;
        int k = 0;

        // Zona 1
        for(int i = 0; i < 5; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (23 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 15;
            k++;
        }

        // Zona 2
        for(int i = 0; i < 5; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (15 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 19;
            k++;
        }
        gp.level1Score = k;

        // Level 2 Monsters
        mapNum = 1;
        k = 0;

        // Zona 1
        for(int i = 0; i < 5; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (19 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * (31 + i);
            k++;
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (19 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * (32 + i);
            k++;
        }

        // Zona 2
        for(int i = 0; i < 4; ++i) {
            gp.mst[mapNum][k] = new MST_MegaEnemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (17 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 20;
            k++;
        }

        // Zona 3
        for(int i = 0; i < 2; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (31 + i + 1);
            gp.mst[mapNum][k].worldY = gp.tileSize * 20;
            k++;
        }

        // Zona 4
        for(int i = 0; i < 2; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (14 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 7;
            k++;
        }
        gp.level2Score = k;

        // Level 3 Monsters
        mapNum = 2;
        k = 0;

        for(int i = 0; i < 6; ++i) {
            gp.mst[mapNum][k] = new MST_Enemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (10 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 26;
            k++;
        }
        for(int i = 0; i < 4; ++i) {
            gp.mst[mapNum][k] = new MST_MegaEnemy(gp);
            gp.mst[mapNum][k].worldX = gp.tileSize * (10 + i);
            gp.mst[mapNum][k].worldY = gp.tileSize * 27;
            k++;
        }
        gp.level3Score = k;

        gp.mst[mapNum][k] = new OBJ_Stone(gp, true);
        gp.mst[mapNum][k].worldX = 33 * gp.tileSize;
        gp.mst[mapNum][k].worldY = 12 * gp.tileSize;
        ++k;

        // HEAD
        gp.mst[mapNum][k] = new MST_HEAD(gp);
        gp.mst[mapNum][k].worldX = 41 * gp.tileSize;
        gp.mst[mapNum][k].worldY = 24 * gp.tileSize;
        ++k;
    }
}
