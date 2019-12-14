
package SeaHawk;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score extends ScreenObject{
    
    int score = 0;
    int w;
    int h;
Hearts hrt;
int scores=0;
    public Score(int x, int y, int w, int h)
    {
        super( x, y, w, h );
    }


    public void addScore(int dif)
    {
        score += dif;
       // if(hrt.hearts==0){
         //   scores=score;
            
      //  }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.green);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(score+"" , x, y);
        //if(hrt.hearts==0){
            //scores=score;
        //if(hrt.hearts==0){
            
        //}
    }
  

}
