package fstt_parking;
import java.awt.*;
import java.util.concurrent.Semaphore;
import javax.swing.*;

/**
 *
 * @author fatah
 */
public class Parking extends JPanel {
    
     ImageIcon image;
     ImageIcon Car;
     static boolean[] blocEtat ; //true=full & false=empty
     static Semaphore semaphoreEntree ;
     static Semaphore semaphoreSortie ;
     
     public Parking(){
   
         semaphoreEntree =new Semaphore(1,true);
         semaphoreSortie =new Semaphore(1,false);
         blocEtat =new boolean[4];
         for(int i=0 ; i<blocEtat.length;i++)
         {
               blocEtat[i]=false ; 
         }
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
          image =new ImageIcon("src/img/parking.jpg");
          image.paintIcon(this, g, WIDTH,WIDTH);
          
         // Car =new ImageIcon("D:\\1.png");
         // Car.paintIcon(this, g, WIDTH,190);
         
         
    }

    

}
