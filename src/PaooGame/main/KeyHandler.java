package PaooGame.main;

import PaooGame.Game;
import PaooGame.entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    // Base Settings
    Game gp;

    // keyPressed - is the key pressed?
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean ePressed;
    public boolean shotPressed;

    // Debug
    public boolean toggleDebugInfo = false;

    public KeyHandler(Game gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Menu State
        if(gp.gameState == gp.menuState) {
            if(code == KeyEvent.VK_UP) {
                gp.ui.commandNumber--;
                if(gp.ui.commandNumber < 0) {
                    gp.ui.commandNumber = 2;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                gp.ui.commandNumber++;
                if(gp.ui.commandNumber > 2) {
                    gp.ui.commandNumber = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNumber == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNumber == 1) {
                    // mai tarziu
                }
                if(gp.ui.commandNumber == 2) {
                    System.exit(0);
                }
            }
        }

        // Play State
        else if(gp.gameState == gp.playState) {
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
            if(code == KeyEvent.VK_SPACE) {
                shotPressed = true;
            }

            // Debug
            if(code == KeyEvent.VK_T) {
                if(!toggleDebugInfo) {
                    toggleDebugInfo = true;
                } else {
                    toggleDebugInfo = false;
                }
            }
            if(code == KeyEvent.VK_R) {
                gp.tileMng.loadMap("/maps/level01.txt");
            }
        }

        // Pause State
        else if(gp.gameState == gp.pauseState) {
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
        }

        // Dialog State
        else if(gp.gameState == gp.dialogState) {
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
        if(code == KeyEvent.VK_SPACE) {
            shotPressed = false;
        }
    }
}
