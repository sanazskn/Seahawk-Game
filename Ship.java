
package SeaHawk;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Ship extends ScreenObject implements Runnable{
public boolean alive=true;
     int dx =2;
	 public int sleep=10 ;
	 ScreenManager sm;
         Image shipImg1;
         

     public Ship(int x, int y, int w, int h, int sleep, ScreenManager sm,Image shipImg1 ) {
	        super(x, y, w, h);
	        this.sm=sm;
	        this.sleep=sleep;
                this.shipImg1=shipImg1;
                
	    }

    

     public void fire(){
         ShipBullet shBullet = new ShipBullet(20+x+(3*w)/4, y+5, 10, 10, sm);
         sm.addScreenObject(shBullet);
         Thread t = new Thread(shBullet);
         t.start();
     }

     public void draw(Graphics g) {
        
         g.drawImage(shipImg1, x, y, null);

	     }

      @Override
	    public void run() {

	        while(x<sm.parent.getWidth()&& alive){
	             x=x+ dx;
	            if(x%((sm.parent.getWidth())/5)==0){
	            	fire();
	            }
	            try {
	              Thread.currentThread().sleep(sleep);
	            	} catch (InterruptedException ex) {
	            }

	        }

	        sm.removeScreenObject(this);

	     }

}
