
package SeaHawk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Hearts extends ScreenObject {
     int hearts=8;
    int h;
    int w;
    ScreenManager sm;
    
      public Hearts(int x, int y, int w, int h)
    {
        super( x, y, w, h );
    }
       public void substarctHearts(int dif)
    {
        if(hearts>0){
        hearts += dif;}
        else if(hearts==0)
            sm.parent.paint(null);
        
         
    }
       public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(hearts+"" , x, y);
    }


}
