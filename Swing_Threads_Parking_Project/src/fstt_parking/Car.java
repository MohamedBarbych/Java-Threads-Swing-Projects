package fstt_parking;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fatah
 */
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Car extends JLabel implements Runnable {
    private int carNumber;
    private JLabel carLabel;
    private JLabel barrierLabel;
    ImageIcon car;
    int id;
    int x;
    int y;
    static boolean[] state;
    static int[] postionExitCar;
    private ImageIcon barrierImage;

    public Car() {
        this.id = 1;
        this.x = -200;
        this.y = 160;
        car = new ImageIcon("src/img/car" + this.id + ".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
        state = new boolean[4];
        postionExitCar = new int[4];
        for (int i = 0; i < state.length; i++) {
            state[i] = false;
        }
        for (int i = 0; i < postionExitCar.length; i++) {
            postionExitCar[i] = -300;
        }
        // Chargement de l'image de la barrière
        barrierImage = new ImageIcon("src/img/barriere.png");
    }

    public Car(int id) {
        this.id = id;
        this.x = -200;
        this.y = 160;
        car = new ImageIcon("src/img/car" + this.id + ".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
        state = new boolean[4];
        postionExitCar = new int[4];
        for (int i = 0; i < state.length; i++) {
            state[i] = false;
        }
        for (int i = 0; i < postionExitCar.length; i++) {
            postionExitCar[i] = -300;
        }
        // Chargement de l'image de la barrière
        barrierImage = new ImageIcon("src/img/barriere.jpg");
    }

    // Méthode pour ouvrir la barrière
    public void ouvrirBarriere() {
        barrierLabel = new JLabel(barrierImage);
        barrierLabel.setBounds(300, 200, 200, 100); // Position initiale de la barrière
        JPanel parkingPanel = (JPanel) this.getParent();
        parkingPanel.add(barrierLabel); // Ajout de la barrière au panel du parking

        // Animation pour ouvrir la barrière
        for (int i = 0; i < 200; i += 5) {
            barrierLabel.setBounds(300 + i, 200, 200, 100);
            try {
                TimeUnit.MILLISECONDS.sleep(50); // Délai pour l'animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Suppression de la barrière une fois l'animation terminée
        parkingPanel.remove(barrierLabel);
        parkingPanel.revalidate();
        parkingPanel.repaint();
    }
     
 
   public void setIconParking(int i)
   {
       car=new ImageIcon("src/img/car"+i+"_"+i+".png");
       this.setIcon(car);
   }
    public void setIconExitParking(int i)
   {
        car=new ImageIcon("src/img/car"+this.id+".png");
        this.setIcon(car);
   }
    
    
     public void  entrePark()
    {
        
        System.out.println("car "+this.id+" is Parking");
        int[] c=new int[4] ;
        
        for(int i =0 ; i<c.length;i++) // initialise to empty
        {
            c[i]=0;
        }
        
        for(int i=0 ; i<4 ; i++) // check if blocs is empty
        {
            if(!Parking.blocEtat[i])
            {
               c[i]=1;
            }
   
        }
            
        int b=0 ;
         for(int i=0 ; i<4 ; i++) 
        {
            if(c[i]==1)
            {
               b++;
            }
   
        }

        if(b==0) {
            for(int i=0 ; i<state.length;i++)
         {
            if(state[i])
                {
                    try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
              
               }
         }
            
            System.out.println("Empty blocs : "+b);
            Animation.moveIN(this,1080);
        } 
      
        if(b==1){ 
                      if(c[0]==1){
                System.out.println("Empty bloc : 1 ");
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this,  290);
                Animation.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(c[1]==1)
            {               
                 System.out.println("Empty bloc : 2 ");
                 System.out.println("Target bloc : 2 ");
                 Animation.moveIN(this, 430);
                 Animation.parking(this);
                 Parking.blocEtat[1]=true;
            }
            else if(c[2]==1) 
            {
                System.out.println("Empty bloc : 3 ");
                 System.out.println("Target bloc : 3 ");
                 Animation.moveIN(this,560);
                 Animation.parking(this);
                 Parking.blocEtat[2]=true;
            }
            else if(c[3]==1) 
            {
                System.out.println("Empty bloc : 4 ");
                 System.out.println("Target bloc : 4 ");
                 Animation.moveIN(this,700);
                 Animation.parking(this);
                 Parking.blocEtat[3]=true;
            }           
        }
        
       
        if(b==2){         
            int x= (int)(Math.random() * 2) + 1 ;
           // System.out.println("x: "+x);
            if(c[0]==1 && c[1]==1){ //1 and 2  
               System.out.println("Empty blocs : 1 , 2 "); 
                if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this, 290);
                Animation.parking(this);
                Parking.blocEtat[0]=true; 
                }
                else {
                System.out.println("Target bloc : 2 ");
                Animation.moveIN(this, 430);
                Animation.parking(this);
                Parking.blocEtat[1]=true;
                }
            }
            else if(c[0]==1 && c[2]==1) //1 and 3
            {
                System.out.println("Empty blocs : 1 , 3 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this,290);
                Animation.parking(this);
                Parking.blocEtat[0]=true; 
                }
                else {
                System.out.println("Target bloc : 3 ");
                Animation.moveIN(this,560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
                }
            }
           
            else if(c[0]==1 && c[3]==1) // 1 and 4
            {
                System.out.println("Empty blocs : 1 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this, 290);
                Animation.parking(this);
                Parking.blocEtat[0]=true; 
                }
                else {
                System.out.println("Target bloc : 4 ");
                Animation.moveIN(this, 700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
                }
            }
             else if(c[1]==1 && c[2]==1) // 2 and 3
            {
                System.out.println("Empty blocs : 2 , 3 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 2 ");
                Animation.moveIN(this, 430);
                Animation.parking(this);
                Parking.blocEtat[1]=true; 
                }
                else {
                System.out.println("Target bloc : 3 ");
                Animation.moveIN(this, 560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
                }
            }
             else if(c[1]==1 && c[3]==1) // 2 and 4
            {
                System.out.println("Empty blocs : 2 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 2 ");
                Animation.moveIN(this,430);
                Animation.parking(this);
                Parking.blocEtat[1]=true; 
                }
                else {
                System.out.println("Target bloc : 4 ");
                Animation.moveIN(this,700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
                }
            }
             else if(c[2]==1 && c[3]==1) // 3 and 4
            {
                System.out.println("Empty blocs : 3 , 4 ");
                 if(x==1)
                {
                System.out.println("Target bloc : 3 ");
                Animation.moveIN(this,560);
                Animation.parking(this);
                Parking.blocEtat[2]=true; 
                }
                else {
                System.out.println("Target bloc : 4 ");
                Animation.moveIN(this, 700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
                }
            }
            
        }
        
        
        if(b==3)
        {
            
            int x= (int)(Math.random() * 3) + 1 ;
            //System.out.println("x: "+x);
            
            if(c[0]==1 && c[1]==1 && c[2]==1) // 1 2 3
            {  
            System.out.println("Empty blocs : 1 , 2 , 3 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this,290);
                Animation.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Animation.moveIN(this, 430);
                Animation.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 3 ");
                Animation.moveIN(this, 560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
            }
            }
            
             if(c[0]==1 && c[1]==1 && c[3]==1) //1 2 4
            {
                
            System.out.println("Empty blocs : 1 , 2 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this, 290);
                Animation.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Animation.moveIN(this, 430);
                Animation.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 4 ");
                Animation.moveIN(this,700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
            }
            }
              if(c[0]==1 && c[2]==1 && c[3]==1) //1 3 4
            {
                
            System.out.println("Empty blocs : 1 , 3 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this, 290);
                Animation.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 3 ");
                Animation.moveIN(this, 560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==3)
            {
                 System.out.println("Target bloc : 4 ");
                Animation.moveIN(this, 700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
            }
            }
             if(c[1]==1 && c[2]==1 && c[3]==1) //2 3 4
            {
                
            System.out.println("Empty blocs : 2 , 3 , 4 ");
            if(x==1)
            {
                System.out.println("Target bloc : 2 ");
                Animation.moveIN(this,430);
                Animation.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 3 ");
                Animation.moveIN(this,560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==3)
            {
                System.out.println("Target bloc : 4 ");
                Animation.moveIN(this,700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
            }
            }    
            
        }
        
        
        if(b==4)
        {
            int x= (int)(Math.random() * 4) + 1 ;
            //System.out.println("x: "+x);
            
            System.out.println("Empty blocs : 1 , 2 , 3 , 4 ");
            if(x==1)
            {
                
                System.out.println("Target bloc : 1 ");
                Animation.moveIN(this, 290);
                Animation.parking(this);
                Parking.blocEtat[0]=true;
            }
            else if(x==2)
            {
                 System.out.println("Target bloc : 2 ");
                Animation.moveIN(this, 430);
                Animation.parking(this);
                Parking.blocEtat[1]=true;
            }
            else if(x==3)
            {
                System.out.println("Target bloc : 3 ");
                Animation.moveIN(this,  560);
                Animation.parking(this);
                Parking.blocEtat[2]=true;
            }
            else if(x==4)
            {
                System.out.println("Target bloc : 4 ");
                Animation.moveIN(this, 700);
                Animation.parking(this);
                Parking.blocEtat[3]=true;
            }
            
        }
   
        
     /*
        Animation.moveIN(this, this.x, this.y, 290);

        if(Parking.blocEtat[0]==false)
        {
              Animation.parking(this, this.x, this.y);
              Parking.blocEtat[0]=true;
        }
        else
        {
           Animation.moveIN(this, this.x, this.y, 430);
             if(Parking.blocEtat[1]==false)
        {
              Animation.parking(this, this.x, this.y);
               Parking.blocEtat[1]=true;
        }
             else {
              Animation.moveIN(this, this.x, this.y,560);
             if(Parking.blocEtat[2]==false)
        {
              Animation.parking(this, this.x, this.y);
               Parking.blocEtat[2]=true;
             }

             else {

             Animation.moveIN(this, this.x, this.y, 1000);

             }

        }
    }
        
        */
    }
     public void sortiPark()
    {
        System.out.println("car "+this.id+" is going out");
        
          
           if(this.x<=300) // bloc 1
           {   
              state[0]=true ;
              postionExitCar[0]=this.x;
              Animation.exitParking(this);
              state[0]=false ;
              postionExitCar[0]=-300;
              Parking.blocEtat[0]=false;
              Animation.moveOut(this);
             
           }
            if(this.x>=290 && this.x<=450) //bloc 2
           {  
              state[1]=true ;
              postionExitCar[1]=this.x;
              Animation.exitParking(this);
              state[1]=false ;
              postionExitCar[1]=-300;
              Parking.blocEtat[1]=false;
              Animation.moveOut(this);    
              
           }
            if(x>=450 && x<=700) // bloc 3
           {
              state[2]=true ;
              postionExitCar[2]=this.x;
              Animation.exitParking(this);
              state[2]=false ;
              postionExitCar[2]=-300;
              Parking.blocEtat[2]=false;
              Animation.moveOut(this);    
             
           }
             if(x>=700 && x<=1080) // bloc 4
           {  
              state[3]=true ;
              postionExitCar[3]=this.x;
              Animation.exitParking(this);
              state[3]=false ;
              postionExitCar[3]=-300;
              Parking.blocEtat[3]=false;
              Animation.moveOut(this);    
              
           }
             
           
             
     }

    @Override
     public void run() {
   
        try {
            
           // Random random = new Random();
            int x= (int)(Math.random() * 10000) + 6000 ;
            System.out.println("car : "+this.id+" Parking Time(s) : "+x/1000);  
           
            Parking.semaphoreEntree.acquire(); 
            this.entrePark();
            Parking.semaphoreEntree.release();
           
            Thread.sleep(x);
            
            Parking.semaphoreSortie.acquire();
            this.sortiPark();
           // Thread.sleep(6000);
            Parking.semaphoreSortie.release();
            
            // Thread.sleep(6000);
            
            // if(random.nextBoolean()) Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


}

