package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;




public class floor extends simple_object implements ImageObserver 
{
	Image img;
	
	
	
	public floor(int reference_x,int reference_y,int reference_floor_HEIGHT,int reference_floor_WIDTH,String path) 
	{
		super(reference_x,reference_y,reference_floor_HEIGHT,reference_floor_WIDTH);
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
		if(Collision((int)x,(int)y,height,width,(int)p1.x,(int)p1.y+p1.height,0,p1.width))
		{
			p1.gravity_ct=false;
			p1.jump_flag=false;
		
		}
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
