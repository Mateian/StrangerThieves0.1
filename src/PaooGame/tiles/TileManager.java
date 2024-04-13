package PaooGame.tiles;

import PaooGame.main.GamePanel;
import PaooGame.main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[20];
        mapTile = new int[gp.maxWorldColumn][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/level01.txt");
    }

    public void getTileImage() {
        setup(0, "grass", false);
        setup(1, "gravel", false);
        setup(2, "tree", true);
        setup(3, "house_door_reversed", true);
        setup(4, "house_wall", true);
        setup(5, "planks", false);
        setup(6, "roof_left", true);
        setup(7, "roof_middle", true);
        setup(8, "roof_right", true);
        setup(9, "stairs", false);
        setup(10, "plank_fence", true);
        setup(11, "grass_fence", true);
        setup(12, "hidden_chest", false);
        setup(13, "flower_bush", false);
    }

    public void setup(int index, String imageName, boolean collision) {
        UtilityTool tool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/level01/" + imageName +".png"));
            tile[index].image = tool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {
        try{
            InputStream in = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int column = 0;
            int row = 0;

            while(column < gp.maxWorldColumn && row < gp.maxWorldRow) {
                String line = br.readLine();
                while(column < gp.maxWorldColumn) {
                    String[] numbers = line.split(" ");
                    int number = Integer.parseInt(numbers[column]);
                    mapTile[column][row] = number;
                    column += 1;
                }
                if(column == gp.maxWorldColumn) {
                    column = 0;
                    row += 1;
                }
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graph2) {
        int worldColumn = 0;
        int worldRow = 0;

        while(worldColumn < gp.maxWorldColumn && worldRow < gp.maxWorldRow) {
            int tileNumber = mapTile[worldColumn][worldRow];

            int worldX = worldColumn * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldx + gp.player.screenX;
            int screenY = worldY - gp.player.worldy + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldx - gp.player.screenX && worldX -gp.tileSize < gp.player.worldx + gp.player.screenX && worldY + gp.tileSize > gp.player.worldy - gp.player.screenY && worldY - gp.tileSize < gp.player.worldy + gp.player.screenY) {
                graph2.drawImage(tile[tileNumber].image, screenX, screenY, null);
            }
            worldColumn += 1;
            if(worldColumn == gp.maxWorldColumn) {
                worldColumn = 0;
                worldRow += 1;
            }
        }
    }
}
