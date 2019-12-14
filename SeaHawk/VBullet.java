
package SeaHawk;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VBullet extends ScreenObject implements Runnable
{


    public VBullet(int x, int y){


        super(x, y,20,10 );


    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(y, x, w, h);


    }


    @Override
    public void run()
    {
        while(x + h  >= 0)
        {
          x++;
            try {
                Thread.currentThread().sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
