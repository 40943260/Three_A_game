package Mosnter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.player;



public class eye_monster extends player
{
	public BufferedImage[] Rimg = new  BufferedImage[4];
	public BufferedImage[] Limg = new  BufferedImage[4];
	public BufferedImage[] atackRimg = new  BufferedImage[4];
	public BufferedImage[] atackLimg = new  BufferedImage[4];
	player p1;
	public eye_monster(player p1,int reference_x, int reference_y, int reference_HEIGHT, int reference_WIDTH) 
	{
		super(reference_x, reference_y, reference_HEIGHT, reference_WIDTH);
		cut_img("img/ms/eyeR.png",4,Rimg );
		cut_img("img/ms/eyeL.png",4,Limg);
		cut_img("img/ms/aReye.png",4,atackRimg );
		cut_img("img/ms/aLeye.png",4,atackLimg);
		this.p1=p1;
		life =4;
	}


	public void monsterMove(double delta_time,Graphics g)
	{
		if(life>0)
		{
			p1.Collision(this);
			attack(p1);
			gravity(delta_time);
	
			if(Math.abs(p1.x-x)<=300)
				bump(g);
			else
				Patrol(g);
		}
	}
	int ct=0;
	public long anmation_time = System.currentTimeMillis();
	public int admation_delay = 80;
	int moveCt =0;//0=R 1=L

	double move_long=0;
	public   double run_speed=0.15;
	public void Patrol(Graphics g)
	{
		if(moveCt==0)
		{
			x=x+run_speed;
			move_long=move_long+run_speed;
			if(move_long>=350)
			{
				moveCt=1;
				move_long=0;
			}
		}
		else
		{
			x=x-run_speed;
			move_long=move_long+run_speed;
			if(move_long>=350)
			{
				moveCt=0;
				move_long=0;
			}
		}
		if(System.currentTimeMillis()-anmation_time>=admation_delay)
		{
			anmation_time=System.currentTimeMillis();
			ct=(ct+1)%4;
		}
		if(moveCt==0)
			g.drawImage(Rimg[ct],(int)x,(int)y,width,height,this);
		else if(moveCt==1)
			g.drawImage(Limg[ct],(int)x,(int)y,width,height,this);
	}
	
	public long Invincible_ct = System.currentTimeMillis();
	int target_xdat;
	public long bumptime = System.currentTimeMillis();
	int bumptime_delay=0;
	public void bump(Graphics g)
	{
		
		
		if(x<p1.x)
		{
			if( System.currentTimeMillis()-bumptime>=bumptime_delay)
			{
							moveCt=0;
							bumptime=System.currentTimeMillis();
			}

		}
		else
		{
			if( System.currentTimeMillis()-bumptime>=bumptime_delay)
			{
							moveCt=1;
							bumptime=System.currentTimeMillis();
			}
		}
		if(moveCt==0)
		{
			x=x+run_speed*3;
			move_long=move_long+run_speed*3;
			if(move_long>=200)
			{
				moveCt=1;
				move_long=0;
			}
		}
		else
		{
			x=x-run_speed*3;
			move_long=move_long+run_speed*3;
			if(move_long>=200)
			{
				moveCt=0;
				move_long=0;
			}
		}
		if(System.currentTimeMillis()-anmation_time>=admation_delay)
		{
			anmation_time=System.currentTimeMillis();
			ct=(ct+1)%4;
		}
		if(moveCt==0)
			g.drawImage(atackRimg[ct],(int)x,(int)y,width,height,this);
		else if(moveCt==1)
			g.drawImage(atackLimg[ct],(int)x,(int)y,width,height,this);
	}
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
}
