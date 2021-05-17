package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class trap extends simple_object implements ImageObserver 
{

	public int UNIT_SIZE=100;
	

	public trap(int x,int y,int reference_floor_WIDTH,int reference_floor_HEIGHT)
	{
		super(x,y,reference_floor_WIDTH,reference_floor_HEIGHT);
		SubImg = new BufferedImage[8];
		cut_img("img/trap/spike_trap_full.png",8,SubImg);

	}

	public BufferedImage SubImg[];

	int trap_ct=0;
	long trap_animtion_ct = System.currentTimeMillis();
	long trap_ct_delay=100;
	int oppo_draw = 1;
	int how_much_move = 8;
	public void draw_trap( player f1,Graphics g)
	{

	
		for(int i=0;i<reference_WIDTH;i++)
		{
			g.drawImage(SubImg[trap_ct],(int)x+i*100,(int)y,100,100,this);	
		}
		attack(f1);
		if(System.currentTimeMillis()-trap_animtion_ct>=trap_ct_delay)
		{
			trap_animtion_ct=System.currentTimeMillis();
			trap_ct+=oppo_draw;
		}
		if(trap_ct==how_much_move-1 || trap_ct==0)
		{
			oppo_draw=oppo_draw*-1;
			if(trap_ct==how_much_move-1)
				trap_ct=trap_ct-1;
			if(trap_ct==0)
				trap_ct=trap_ct+1;
		}
	}
	public long Invincible_ct = System.currentTimeMillis();
	public int Invincible_delay = 500;
	
	public void attack(player p1)
	{
		if(Collision((int)x,(int)y,height,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			if(!p1.Invincible)
			{
				p1.life-=1;
				p1.Invincible=true;
			}
			if(System.currentTimeMillis()-Invincible_ct>=Invincible_delay && p1.Invincible==true)
			{
					p1.Invincible=false;
					Invincible_ct=System.currentTimeMillis();
			}
		}
	}
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
