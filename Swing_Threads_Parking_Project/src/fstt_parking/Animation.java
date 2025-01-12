package fstt_parking;
import java.util.logging.Level;
import java.util.logging.Logger;
import static fstt_parking.Car.state;

/**
 *
 * @author fatah
 */
public class Animation {
    
   static boolean notExit=false ;
    
    public static void moveIN(Car c , int xMax)
    {
        
               while(c.x<=xMax)
            {
           
                 if(c.x==290) notExit=true  ;
                 if(c.x==430) notExit=true  ;
                 if(c.x==560) notExit=true  ;
                 if(c.x==700) notExit=true  ;
                
                for(int i =0 ; i<4 ; i++){
                  if(Car.state[i]==true &&  c.x<=Car.postionExitCar[i]) // car is moving out from bloc 
                {
                    try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
              }

                  
               }
                
                 c.x+=10;
                 c.setLocation(c.x, c.y);
                try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
  
             }
    
            notExit=false;
        
    }
    
    public static void parking(Car c)
    {
             while(c.y>=30)
            {  
            c.setIconParking(c.id);
            c.y-=10;
            c.setLocation(c.x, c.y);
             try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
             
             notExit=false;

  
    }
    
    public static void exitParking(Car c  )
    {
        
     
        while(notExit)
        {
            ;
        }
        
        while(c.y<=140)
           {
               c.y+=10;
              c.setLocation(c.x, c.y);
             try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
             
           }
        

        
    }
    
     public static void moveOut(Car c)
    {
               while(c.x<=1080)
            {  
                 c.setIconExitParking(c.id);
                 c.x+=10;
                 c.setLocation(c.x, c.y);
                try { 
                    Thread.sleep(100);  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
  
             }
               notExit=false;
    
              c.x=-200;
              c.y=160;
        
    }
    
    
    
}

