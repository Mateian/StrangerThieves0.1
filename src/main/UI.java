package main;

import objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    Graphics2D graph2;
    GamePanel gp;
    Font arial_40, arial_80B, console_40B;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String dialogText = "";
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    UtilityTool tool = new UtilityTool();

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        console_40B = new Font("Console", Font.BOLD, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D graph2) {

        if(gameFinished) {
            graph2.setFont(arial_40);
            graph2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!";
            textLength = (int)graph2.getFontMetrics().getStringBounds(text, graph2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);
            graph2.drawString(text, x, y);

            text = "Your time is: " + dFormat.format(playTime);
            textLength = (int)graph2.getFontMetrics().getStringBounds(text, graph2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 4);
            graph2.drawString(text, x, y);

            graph2.setFont(arial_80B);
            graph2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int)graph2.getFontMetrics().getStringBounds(text, graph2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 2);
            graph2.drawString(text, x, y);

            gp.gameThread = null;
        } else {


            graph2.setFont(arial_40);
            graph2.setColor(Color.white);
            graph2.drawImage(keyImage, 25, 25, gp.tileSize, gp.tileSize, null);
            graph2.drawString("x " + gp.player.hasKey, 74, 65);

            // Time
            if(gp.gameState == gp.playState) {
                playTime +=(double)1/60;
            }
            graph2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 65);

            // Message
            if(messageOn) {

                graph2.setFont(graph2.getFont().deriveFont(30F));
                graph2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;

                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

            this.graph2 = graph2;

            graph2.setFont(arial_40);
            graph2.setColor(Color.white);

            if(gp.gameState == gp.playState) {
            }
            if(gp.gameState == gp.pauseState) {
                drawPauseScreen();
            }
            drawFPS(gp.forShowFPS);

            // Dialog State
            if(gp.gameState == gp.dialogState) {
                drawDialogScreen();
            }
        }
    }

    public void drawDialogScreen() {
        // Window - fereastra dialogului
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - 4 * gp.tileSize;
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        x += gp.tileSize;
        y += gp.tileSize;
        graph2.setFont(graph2.getFont().deriveFont(Font.PLAIN, 28));

        for(String line : dialogText.split("\n")) {
            graph2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color clr = new Color(0, 0 ,0, 210);
        graph2.setColor(clr);
        graph2.fillRoundRect(x, y, width, height, 35, 35);

        clr = new Color(255, 255, 255);
        graph2.setColor(clr);
        graph2.setStroke(new BasicStroke(5));
        graph2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);

    }

    public void drawPauseScreen() {
        graph2.setFont(graph2.getFont().deriveFont(Font.PLAIN, 80));
        String text = "PAUSED";
        int x = xCenter(text);
        int y = gp.screenHeight / 2;


        graph2.drawString(text, x, y);
    }

    public void drawFPS(double FPS) {
        graph2.setColor(Color.white);
        graph2.setFont(console_40B);
        graph2.setFont(graph2.getFont().deriveFont(Font.PLAIN, 20));
        String text = "FPS: " + FPS;
        graph2.drawString(text, gp.screenWidth - 2 * gp.tileSize, gp.originalTileSize);
    }

    public int xCenter (String text) {
        int length = (int)graph2.getFontMetrics().getStringBounds(text, graph2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
