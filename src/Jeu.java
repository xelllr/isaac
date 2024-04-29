import org.w3c.dom.css.Rect;

import javax.swing.* ;
import java.awt.* ;
import java.util.ArrayList;
import java.util.Random;

class MaFenetre extends JFrame {

   JPanel pan ;

   MaFenetre(){
      setSize(320,200+50);
      ArrayList<MovingObject> balls = new ArrayList<MovingObject>();

      pan = new Paneau(new Scene(balls)) ;
      setContentPane(pan) ;
   }
}



class Paneau extends JPanel {

   Scene balls;

   Paneau(Scene p){
      super();
      this.balls = p ;
      System.out.println(this.balls);
   }

   @Override
   public void paintComponent (Graphics g){
      this.balls.objects.forEach((p) -> {
         final Rectangle rect = p.getRect();
         g.fillRect (rect.x,rect.y,rect.width, rect.height);
         p.deplace();
      });
   }
}



public class Jeu {

   public static void main(String[] args) throws InterruptedException {

      System.setProperty("sun.java2d.opengl", "true"); /* pour animation fluide */

      MaFenetre fen = new MaFenetre() ;

      fen.setVisible(true);

      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      while (true){
         fen.repaint() ; 
         Thread.sleep(10);
      }

   }
}
