
package SeaHawk;



import java.awt.Graphics;

public abstract class ScreenObject
{
    int x;
    int y;
    int w;
    int h;


    public ScreenObject(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public ScreenObject(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

public void setWidth(int w)
{
    this.w = w;
}

public void setHeight(int h)
{
    this.h = h;
}

    public void draw(Graphics g)
    {

    }

}
