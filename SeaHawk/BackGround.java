
package SeaHawk;
import java.awt.Graphics;
import java.awt.Image;

public class BackGround extends ScreenObject implements Runnable {
    Image sea;
     ScreenManager sm;
    int dx=20;
    int sleep=50;

    Helicopter hlc;
    
    public BackGround(int x, int y, int w, int h, ScreenManager sm,Helicopter hlc,Image sea){
       super(x,y,w,h);
        this.sm=sm;
        this.hlc=hlc;
        this.sea=sea;

    }
      @Override
    public void run() {
        while(true){

       x=x+dx*hlc.var;
       if(x>sm.parent.getWidth()||x<0){
                x=0;
       }

 try {
         Thread.currentThread(). sleep(1000  );
            } catch (InterruptedException ex) {
            }
    
    
}
      }
    public void draw(Graphics g){

        g.drawImage(sea,x, y , null);
        g.drawImage(sea,x-w, y , null);
        g.drawImage(sea,x+w, y , null);

}
  
    
}
