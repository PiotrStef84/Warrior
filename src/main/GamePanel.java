package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();

    // The key to use Thread is implementing Runnable
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); // adding keyHandler to game panel
        this.setFocusable(true); // With this, this GamePanel can be "focused" to receive key input
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        while(gameThread != null) {

            long currentTime = System.nanoTime();

            // 1. UPDATE: update information such as character positions
            update();
            // 2. DRAW: draw the screen with the updated information.
            repaint();
        }

    }

    public void update(){

        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed){
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.fillRect(200, 200, tileSize, tileSize);

        // Dispose of this graphics context and release any system resources that it's using
        g2.dispose(); // good practice to save some memory
    }
}
