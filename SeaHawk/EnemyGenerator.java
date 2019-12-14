
package SeaHawk;


import java.awt.Image;

public class EnemyGenerator extends Thread
{
    ScreenManager sm;
    Image img;
    int n;


    public EnemyGenerator(ScreenManager sm, Image img)
    {
        this.sm = sm;
        this.img = img;
        
    }

    public Enemy randomBird()
    {
        int rnd = random(n);

        return new Enemy(sm.parent.getWidth(), random(sm.parent.getHeight()-300),1, img,6+random(2),sm);
    }

     public boolean random()
     {
         return (random(2)%2 == 0)?true:false;
     }

    public int random(int n)
    {
        return (int)(Math.random() * n);
    }


    @Override
    public void run()
    {
        while(true)
        {
            Enemy bird = randomBird();
            sm.addScreenObject(bird);
            Thread t = new Thread(bird);
            t.start();
             try {
                sleep(1000 + random(1500) );
            } catch (InterruptedException ex) {
            }
        }
    }

}
