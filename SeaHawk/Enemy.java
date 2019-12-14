

package SeaHawk;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Enemy extends ScreenObject implements Runnable
{
public boolean live=true;
    Image img;
    ScreenManager sm;
    int dx ;
    int sleep;
    Egg egg;

    public Enemy(int x, int y,int dx, Image img, int sleep, ScreenManager sm)
    {
        super( x, y, img.getWidth(null), img.getHeight(null) );
        this.img = img;
        this.sm = sm;
        this.sleep = sleep;
        this.dx = dx;
    }

     public int random(int n)
    {
        return (int)(Math.random() * n);
    }


    @Override
    public void draw(Graphics g)
    {
        g.drawImage(img, x, y, null);

    }

    @Override
    public void run()
    {
        while(x <= sm.parent.getWidth()+1 || x > -1 &&live)
        {
            x-=dx;
            if(random(400)<2)
            {
                 egg = new Egg(x,y+(img.getHeight(null)/2));
                 sm.addScreenObject(egg);
                 Thread t = new Thread(egg);
                 t.start();
            }
            try {
                Thread.currentThread().sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        sm.removeScreenObject(this);
        System.gc();


    }


}
