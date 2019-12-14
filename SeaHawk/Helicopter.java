
package SeaHawk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JApplet;

public class Helicopter extends ScreenObject
{
    Image img2;
    Image img1;
    Image img3;
    ScreenManager sm;
    int dx = 15;
  
    
    Graphics2D d2;
    
    int var=1;
    
    

    public Helicopter(int x, int y, Image img1,Image img2,ScreenManager sm)
    {
        super(x, y, 80, 150 );
        this.img1 = img1;
        this.img2 = img2;
        this.sm = sm;

    }


    @Override
    public void draw(Graphics g)
    {
       // if(var>0)
            
       
        g.drawImage(img1, x, y, null);
 // if(var<0) {
       //if (var<0)
             //  g.drawImage(img2, x, y, null);
   //     g.drawImage(img3, x, y, null);
     //  sm.parent.init();
     // System.out.println("2");
        
    
    
    }
    

    public void right()
    {
        if(x + w + dx <= sm.parent.getWidth())
            x += dx;
       // img3=img1;
    }

    public void left()
    {
        if( x - dx >= 0)
            x -= dx;
                   // img3=img2;
    }

        public void up()
    {
     if (y>= -1)
       y -= dx;
     
    }
       

    public void down()
    {
    if (y + img1.getHeight(null)<= sm.parent.getHeight())
      y += dx;
    }


    public void fire()
    {
        Bullet bullet = new Bullet(x + img1.getWidth(null), y + (img1.getHeight(null)/2));
        sm.addScreenObject(bullet);
        Thread t = new Thread(bullet);
        t.start();
    }
     public void fireV()
    {
        VBullet bullet = new VBullet( y + (img1.getHeight(null)/2),x + img1.getWidth(null)/2);
        sm.addScreenObject(bullet);
        Thread t = new Thread(bullet);
        t.start();
    }




}
