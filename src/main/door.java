package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class door extends simple_object implements ImageObserver  
{		
	Image img;

	door(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH,String path)
	{
		super(reference_x,reference_y,reference_HEIGHT,reference_WIDTH);
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
	}
	public BufferedImage[] Bimg ;
	int how_move;
	door(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH,String path,int how_move)
	{
		super(reference_x,reference_y,reference_HEIGHT,reference_WIDTH);
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
		Bimg=new BufferedImage[how_move];
		cut_img(path,how_move, Bimg);
		this.how_move=how_move;
	}
	public BufferedImage[][] Bimg2 ;
	int how_moveX;
	int how_moveY;
	door(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH,String path,int how_moveX,int how_moveY)
	{
		super(reference_x,reference_y,reference_HEIGHT,reference_WIDTH);
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
		Bimg2=new BufferedImage[how_moveY][how_moveX];
		cut_img(path,how_moveX,how_moveY,Bimg2);
		this.how_moveX=how_moveX;
		this.how_moveY=how_moveY;
	}
	public  void draw_door(Graphics g)
	{
		g.drawImage(img,(int)x,(int)y,width,height,this);
	}
	long time = System.currentTimeMillis();
	int ct=0;
	public  void draw_door(int delaytime,Graphics g)	
	{
		if(System.currentTimeMillis()-time>=delaytime)
		{
			ct=(ct+1)%how_move;
			time=System.currentTimeMillis();
		}
		g.drawImage(Bimg[ct],(int)x,(int)y,width,height,this);
	}
	public  void draw_door(int mod,int delaytime,Graphics g)	
	{
		if(System.currentTimeMillis()-time>=delaytime)
		{
			ct=(ct+1)%how_moveX;
			time=System.currentTimeMillis();
		}
		g.drawImage(Bimg2[mod][ct],(int)x,(int)y,width,height,this);
	}
	public void door_c(player p1,int level)
	{
		if(Collision((int)x,(int)y,height,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			p1.level=level;
			p1.x=0;
			p1.y=0;
		}
	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

}
