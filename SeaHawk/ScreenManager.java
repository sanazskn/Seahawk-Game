
package SeaHawk;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;

public class ScreenManager extends Thread
{
    ArrayList<ScreenObject> objList;
    Image offScr;
    Graphics offGr;
    JApplet parent;
    boolean finished = false;


    public ScreenManager(JApplet parent)
    {
        objList = new ArrayList<ScreenObject>(50);
        this.parent = parent;
        offScr = parent.createImage(parent.getWidth(),parent.getHeight());
        offGr = offScr.getGraphics();

    }


    public void addScreenObject(ScreenObject scrObj)
    {
        objList.add(scrObj);
    }


    public void removeScreenObject(ScreenObject scrObj)
    {
        objList.remove(scrObj);
    }

    public void draw(Graphics g)
    {
        checkConflict();

        offGr.clearRect(0, 0, parent.getWidth(),parent.getHeight());

        for(ScreenObject  scrObj : objList)
        {
            scrObj.draw(offGr);
        }

        g.drawImage(offScr, 0, 0, parent);
        

    }

    @Override
    public void run()
    {


        while (!finished)
        {
            parent.repaint();
            try {
                sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(ScreenManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void finish()
    {
        finished = true;
    }



        private void checkConflict() {

        ArrayList<Enemy> brl = new ArrayList<Enemy>(10);
        ArrayList<Bullet> bll = new ArrayList<Bullet>(10);
        ArrayList<Egg>egl = new ArrayList<Egg>(30);
        ArrayList<Helicopter> heli=new ArrayList<Helicopter>(10);
        ArrayList<VBullet>vbullet=new ArrayList<VBullet>(10);
        ArrayList<Ship>ship=new ArrayList<Ship>(10);
        ArrayList<ShipBullet>shipb=new ArrayList<ShipBullet>(10);
        Score score=null;
Hearts heart=null;
        for (ScreenObject scrObj : objList) {
            if (scrObj instanceof Enemy) {
                brl.add((Enemy) scrObj);
            }
            if (scrObj instanceof Bullet) {
                bll.add((Bullet) scrObj);
            }
            if (scrObj instanceof Score) {
                score = (Score) scrObj;
            }
            if(scrObj instanceof Hearts){
                heart=(Hearts) scrObj;
            }
            if (scrObj instanceof Egg) {
                egl.add((Egg) scrObj);
            }
             if (scrObj instanceof Helicopter) {
                heli.add((Helicopter)scrObj);}
                if(scrObj instanceof VBullet){
                    vbullet.add((VBullet)scrObj);
                    
                }
                if(scrObj instanceof Ship){
                    ship.add((Ship) scrObj);
            }
                if(scrObj instanceof ShipBullet){
                    shipb.add((ShipBullet) scrObj );
                }
        }

       for(Enemy br:brl)
           for(Bullet bl:bll){
                int bx = bl.x + bl.w / 2;
                    int by = bl.y;

                    if (bx <= br.x + br.w && bx >= br.x &&
                        by <= br.y + br.h && by >= br.y) {
                        removeScreenObject(br);
                        removeScreenObject(bl);

                        score.addScore(+100);

              
                      
                    }

           }
       for(Enemy br:brl)
           for(VBullet vbl:vbullet){
                int vbx = vbl.x + vbl.w *2;
                    int vby = vbl.y;

                    if (vby <= br.x + br.w && vby >= br.x &&
                        vbx <= br.y + br.h && vbx >= br.y) {
                        br.live=false;
                        removeScreenObject(br);
                        removeScreenObject(vbl);

                        score.addScore(+100);
                    }}
     
       for(Ship shp:ship)
           for(VBullet bl1:vbullet){
               int vbx=bl1.x +bl1.w/2;
               int vby=bl1.y;
           
               if( vby<=shp.x + shp.w && vby>=shp.x &&
                       vbx<=shp.y +shp.h && vbx>=shp.y){
                   shp.alive=false;
                   removeScreenObject(shp);
                   removeScreenObject(bl1);
                   score.addScore(+100);
               }
           }

 for(Helicopter helicopter:heli )
           for(Egg egg:egl){
               int ex=egg.x+egg.w/2;
               int ey=egg.y;
               if(ex<=helicopter.x+helicopter.w&& ex>helicopter.x&&
                       ey<helicopter.y+helicopter.h&&ey>helicopter.y){
                  
            	   score.addScore(-50);
                   heart.substarctHearts(-1);
            	   removeScreenObject(egg);
               }
               for(Helicopter helli:heli)
                   for(ShipBullet shipbb:shipb){
                       int shx=shipbb.x+shipbb.w/2;
                       int shy=shipbb.y;
                       if(shy<=helli.x+helli.w&& shy>helli.x && shx<helli.y + helli.h && shx >helli.y){
                            
                           score.addScore(-50);
                           heart.substarctHearts(-1);
                           removeScreenObject(shipbb);
                       }
                       
                       
                   }
//               for(Helicopter hlc:heli )
//           for(ShipBullet shipbull:shipb){
//               int shbx=shipbull.x+shipbull.w/2;
//               int shby=shipbull.y;
//               if(shbx<=helicopter.x+helicopter.w&& shbx>helicopter.x&&
//                       shby<helicopter.y+helicopter.h&&shby>helicopter.y){
//                  
//            	   score.addScore(-50);
//                   heart.substarctHearts(-1);
//            	   removeScreenObject(shipbull);
//               } 

    }
}}
