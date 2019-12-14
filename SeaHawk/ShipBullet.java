
package SeaHawk;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class ShipBullet extends ScreenObject implements Runnable {
    int dy =20;
    int sleep=100 ;
    ScreenManager sm;

    public ShipBullet(int x, int y, int w, int h,  ScreenManager sm) {
        super(x, y, w, h);
        this.sm=sm;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);

        g.fillRect(x+30, y, 30, 15);

     }

    public void run() {
       while(y+h>0){
            y=y -dy;
            try {
                Thread.currentThread().sleep(sleep);
            } catch (InterruptedException ex) {
            }

        }

        sm.removeScreenObject(this);

     }
    



}
