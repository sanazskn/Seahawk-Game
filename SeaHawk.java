
package SeaHawk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JApplet;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class SeaHawk extends JApplet implements KeyListener
{
    EnemyGenerator bg;
    ScreenManager sm;
    Score score;
    Hearts hearts;
    Image img;
    Helicopter gun;
    Image img1 ;
    Image img2 ;
    Image ship;
    BackGround backg;
    ShipG shpG;
    Image back;
    boolean win=true;
    AudioClip audioClip1;
    AudioClip audioClip2;
    Image enemy;

    @Override
    public void init()
    {
        
            img = getImage(getCodeBase(),"0.png");
         ship=getImage(getCodeBase(), "ship.gif");
         img1 = getImage(getCodeBase(), "helicopter.png");
         img2=getImage(getCodeBase(),"helicopter1.png");
         back=getImage(getCodeBase(), "sea.gif");
     //    enemy=getImage(getCodeBase(),"0.png");

        setFocusable(true);
        setSize(800,600);
        this.addKeyListener(this);
        sm = new ScreenManager(this);
         
        backg=new BackGround(0,0,sm.parent.getWidth(),sm.parent.getHeight(),sm,gun,back);
        sm.addScreenObject(backg);
        audioClip2 = getAudioClip(getCodeBase(),"matrix.wav" );
        audioClip2.play();
        audioClip1 = getAudioClip(getCodeBase(),"EXPLODE.WAV" );
       bg = new EnemyGenerator(sm,img);
//bg=new EnemyGenerator(sm,img,enemy);
        shpG=new ShipG(sm,ship);

        gun = new Helicopter(( getWidth() - 80 )/2, getHeight()-150, img1,img2, sm);

        score = new Score( getWidth()-90, getHeight()-20, 90, 20 );
        hearts=new Hearts(getWidth()-100,getHeight()-40,100,40);
        backg=new BackGround(0,0,sm.parent.getWidth(),sm.parent.getHeight(),sm,gun,back);
        
        sm.addScreenObject(backg);
        
    }

    @Override
    public void start ()
    {
        sm.start();
        Thread t=new Thread(backg);
        t.start();
        sm.addScreenObject(gun);
        
        sm.addScreenObject(score);
        sm.addScreenObject(hearts);
        bg.start();
        shpG.start();


    }



    @Override
    public void stop(){
        sm.finish();
    }
 
    public void paint(Graphics g)
    {
        sm.draw(g);

         if(hearts.hearts==0){
             stop();
             g.setColor(Color.black);
             g.fillRect(0,0,getWidth(),getHeight());
             g.setColor(Color.red);
             g.setFont(new Font("Arial",Font.BOLD,100));
             g.drawString("GameOver", 100, 200);
             g.setColor(Color.green);
             g.drawString("score:"+score.score,150 , 350);
         }

      }
   
  
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                gun.left();
               // sm.parent.getImage(getCodeBase(),"helicopter1");
                break;
            case KeyEvent.VK_RIGHT:
                gun.right();
                break;
            case KeyEvent.VK_SPACE:
                gun.fire();
                break;
            case KeyEvent.VK_UP:
                gun.up();
                break;
                 case KeyEvent.VK_F1:
                 {
                gun.fireV();
                audioClip1.play();
                 }
                     break;
            case KeyEvent.VK_DOWN:
                gun.down();
                break;
            

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}