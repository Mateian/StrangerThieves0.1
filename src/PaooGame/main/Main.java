package PaooGame.main;

import javax.swing.*;

import static java.lang.System.getProperty;

public class Main {

    public static void main(String[] args) {
        // Window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Stranger Thieves");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGame();

        // End
    }
}
