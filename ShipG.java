
package SeaHawk;
import java.awt.Color;
import java.awt.Image;



public class ShipG extends Thread {
    ScreenManager sm;
    boolean finished=false;
    Image shipImg;

    public ShipG(ScreenManager sm,Image shipImg){
       this.sm=sm;
       this.shipImg=shipImg;
    }

    public void run(){
        while(!finished){

            Ship ship =randomShip();
            sm.addScreenObject(ship);

            Thread t= new Thread(ship);
            t.start();
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
             }

        }
    }

     public int random(int m){
        return (int )(m*Math.random());
    }

     private Ship randomShip() {
        int w=30;
        int h=30;
        int x=10;
        int y=sm.parent.getHeight()-130 ;
        int sleep =25;

        return new Ship(x, y, w, h, sleep, sm,shipImg);
     }



}
