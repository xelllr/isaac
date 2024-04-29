package main;

import entity.Player;

import java.awt.*;

public class GamePanel extends javax.swing.JPanel implements Runnable {

    final int originalTilesSize = 16;
    final int scale = 3;

    public final int tilesSize = originalTilesSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tilesSize * maxScreenCol;
    final int screenHeight = tilesSize * maxScreenRow;

    double FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player(this, keyH);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            // On met à jour la position du joueur là dedans par exemple
            update();

            // Puis on dessine ces nouvelles infos
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e){
                e.printStackTrace();
            }

            }

        }

    public void update() {

        player.update();
    }

    public void paintComponent(Graphics g) { // Grapgics c'est le crayon en gros

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;
        player.draw(g2d);
        g2d.dispose();
    }
}

