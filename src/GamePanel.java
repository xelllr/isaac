import java.awt.*;

public class GamePanel extends javax.swing.JPanel implements Runnable {

    final int originalTilesSize = 16;
    final int scale = 3;

    final int tilesSize = originalTilesSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tilesSize * maxScreenCol;
    final int screenHeight = tilesSize * maxScreenRow;

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while(gameThread != null) {

            // System.out.println("Caca");
            // On met à jour la position du joueur là dedans par exemple
            update();

            // Puis on dessine ces nouvelles infos
            repaint();

            }

        }

    public void update() {

    }

    public void paintComponent(Graphics g) { // Grapgics c'est le crayon en gros

        super.paintComponent(g);
    }
}

