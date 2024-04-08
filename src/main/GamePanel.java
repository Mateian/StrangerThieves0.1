package main;

import entity.Entity;
import entity.NPC_Fen;
import entity.Player;
import jdk.jfr.Event;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings - standard
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenColumn = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenColumn;
    public final int screenHeight = tileSize * maxScreenRow;
    public double forShowFPS = 0;

    // Setari ale Lumii
    public final int maxWorldColumn = 50;
    public final int maxWorldRow = 50;

    // FPS
    int FPS = 60;

    // System
    TileManager tileMng = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    // Entities & Objects
    public Player player = new Player(this, keyH);
    public Entity[] obj = new Entity[10];
    public Entity[] NPC = new Entity[10];
    ArrayList<Entity> entityList = new ArrayList<>();


    // Game State
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 0;
    public final int dialogState = 2;
    public final int menuState = 3;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
//        playMusic(0);
        gameState = menuState;
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Programul va rula aceasta metoda si va repeta
    // instructiunile din aceasta pana cand se va inchide
    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1) {
                if(gameState == pauseState) {
                    ui.drawPauseScreen();
                }
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000) {
                forShowFPS = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        if(gameState == playState) {
            player.update();
            for(int i = 0; i < NPC.length; ++i) {
                if(NPC[i] != null) {
                    NPC[i].update();
                }
            }
        }
        if(gameState == pauseState) {
            ui.drawPauseScreen();
        }
    }

    public void paintComponent(Graphics graph) {

        super.paintComponent(graph);

        Graphics2D graph2 = (Graphics2D)graph;

        // Debug
        long drawStart = 0;
        if(keyH.checkDrawTime) {
            drawStart = System.nanoTime();
        }

        // Menu
        if(gameState == menuState) {
            ui.draw(graph2);
        } else {

        //  Tile
            tileMng.draw(graph2);

        //  Add all entities in the List
            entityList.add(player);

            for(int i = 0; i < NPC.length; ++i) {
                if(NPC[i] != null) {
                    entityList.add(NPC[i]);
                }
            }
            for(int i = 0; i < obj.length; ++i) {
                if(obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }

            // Sort
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldy, e2.worldy);
                    return result;
                }
            });

            // Draw Entities
            for(int i = 0; i < entityList.size(); ++i) {
                entityList.get(i).draw(graph2);
            }

            // Empty Entity List
            entityList.clear();

            // UI
            ui.draw(graph2);
        }

        // Debug
        if(keyH.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            graph2.setColor(Color.white);
            graph2.drawString("Draw Time: " + passed, 10, 400);
        }
        graph2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }
}
