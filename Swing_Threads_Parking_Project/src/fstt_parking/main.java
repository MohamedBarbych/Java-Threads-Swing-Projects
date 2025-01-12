package fstt_parking;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author fatah
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) {
    
        
        JFrame frame = new JFrame("Parking Simulator");
        Parking panel = new Parking();
        frame.setContentPane(panel);
        panel.setLayout(null);
        frame.setSize(2120, 1320);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Car> cars=new ArrayList<Car>();
        
        Car c1 = new Car(1);
        Car c2 = new Car(2);
        Car c3 = new Car(3);
        Car c4 = new Car(4);
        Car c5 = new Car(5);
        Car c6 = new Car(6);
        Car c7 = new Car(7);
        Car c8 = new Car();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        Thread t5 = new Thread(c5);
        Thread t6 = new Thread(c6);
        Thread t7 = new Thread(c7);
        Thread t8 = new Thread(c7);

        panel.add(c1);
        panel.add(c2);
        panel.add(c3);
        panel.add(c4);
        panel.add(c5);
        panel.add(c6);
        panel.add(c7);
        panel.add(c8);
       
      for(int i=1 ; i<=3 ; i++)
      {   
          Car c = new Car(i); 
          cars.add(c);
          panel.add(c);
       } 
      
      for(Car c : cars)
      {
          Thread t=new Thread(c);
          t.start();
      }
      frame.setVisible(true);
       
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t5.start();
       t6.start();
       t7.start();
       t8.start();

    }

}
