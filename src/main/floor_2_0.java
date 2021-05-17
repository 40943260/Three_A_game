package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;





public class floor_2_0  extends simple_object  implements ImageObserver  
{

	public static void setfoor(int dat[][],floor_2_0 floor[],String path)
	{
		for(int i=0;i<floor.length;i++)
			floor[i]=new floor_2_0(dat[i][0],dat[i][1],dat[i][2],dat[i][3],path);
	}
	public static void drawfoor(floor_2_0 floor[],Graphics g)
	{
		for(int i=0;i<floor.length;i++)
			floor[i].drawFloor(g);
	}
	public static void drawfoor(floor_2_0 floor[],player p1,Graphics g)
	{
		for(int i=0;i<floor.length;i++)
			floor[i].drawFloor(p1,g);
	}
	Image img;
	public floor_2_0(int reference_x, int reference_y, int reference_HEIGHT, int reference_WIDTH,String path) 
	{
		super(reference_x, reference_y, reference_HEIGHT, reference_WIDTH);
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
	}
	public void drawFloor(Graphics g)
	{		
		for(int i=0;i<reference_WIDTH;i++)
		{
			for(int j=0;j<reference_HEIGHT;j++)	
			{
					g.drawImage(img,(int)x+UNIT_SIZE*i,(int)y+UNIT_SIZE*j,UNIT_SIZE,UNIT_SIZE,this);
			}
		}
	}
	public void drawFloor(player p1,Graphics g)
	{		
		for(int i=0;i<reference_WIDTH;i++)
		{
			for(int j=0;j<reference_HEIGHT;j++)	
			{
					g.drawImage(img,(int)x+UNIT_SIZE*i,(int)y+UNIT_SIZE*j,UNIT_SIZE,UNIT_SIZE,this);
			}
		}
		floor_Collision(p1);
	}
	
	public void floor_Collision(player p1)
	{
		if(Collision((int)x,(int)y,height,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{	
			if(Collision((int)x,(int)y-50,height/2,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
			{
				p1.gravity_ct=false;
				p1.jump_flag=false;

			}
			if(Collision((int)x-50,(int)y+30,height-30,width/2,(int)p1.x,(int)p1.y,p1.height,p1.width))
				p1.R_stop=true;
			if(Collision((int)x+width,(int)y+30,height-30,width/2,(int)p1.x,(int)p1.y,p1.height,p1.width))
				p1.L_stop=true;
			if(Collision((int)x,(int)y+height+30,height,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
			{
				p1.U_stop=true;
				p1.y=p1.y+20;
			}

		}
	}
	public static void floor_Collision(floor_2_0 f[],player p1)
	{
		for(int i=0;i<f.length;i++)
			f[i].floor_Collision(p1);
	}
	
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

}
