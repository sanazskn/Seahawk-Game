
package SeaHawk;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Egg extends ScreenObject implements Runnable
{


    public Egg(int x, int y){


        super(x, y,20,10 );

    }

   


    @Override
    public void draw(Graphics g)
    {

        g.setColor(Color.GREEN);
        g.fillRect(x, y, w, h);


    }


    @Override
    public void run()
    {
        while(x > -20 )
        {

            x -= 2;
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
