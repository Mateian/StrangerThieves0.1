package main;

import entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean ePressed;

    // Debug
    public boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Play State
        if(gp.gameState == gp.playState) {
            if(code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if(code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if(code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if(code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_E) {
                ePressed = true;
            }
            if(code == KeyEvent.VK_G) {
                if(Player.hasWeapon) {
                    Player.hasWeapon = false;
                    System.out.println("Weapon dropped!");
                }
            }

            // Debug
            if(code == KeyEvent.VK_T) {
                if(!checkDrawTime) {
                    checkDrawTime = true;
                } else {
                    checkDrawTime = false;
                }
            }
        }

        // Pause State
        if(gp.gameState == gp.pauseState) {
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
        }

        // Dialog State
        if(gp.gameState == gp.dialogState) {
            if(code == KeyEvent.VK_E) {
                gp.gameState = gp.playState;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
