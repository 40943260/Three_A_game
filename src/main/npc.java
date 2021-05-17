package main;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class npc extends simple_object implements ImageObserver
{

	static final int UNIT_SIZE = 100;
	
	
	Image img;
	public npc(int floor_x,int floor_y,int reference_floor_HEIGHT,int reference_floor_WIDTH,String path) 
	{
		super(floor_x,floor_y,reference_floor_HEIGHT,reference_floor_WIDTH); 
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
	}
	public BufferedImage[][] Bimg2 ;
	int how_moveX;
	int how_moveY;
	npc(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH,String path,int how_moveX,int how_moveY)
	{
		super(reference_x,reference_y,reference_HEIGHT,reference_WIDTH);
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();	
		Bimg2=new BufferedImage[how_moveY][how_moveX];
		cut_img(path,how_moveX,how_moveY,Bimg2);
		this.how_moveX=how_moveX;
		this.how_moveY=how_moveY;
	}
	
	long time = System.currentTimeMillis();
	int ct=0;
	public void draw(int mod,int how_move,int delaytime,Graphics g)
	{
		if(System.currentTimeMillis()-time>=delaytime)
		{
			ct=(ct+1)%how_move;
			time=System.currentTimeMillis();
		}
		g.drawImage(Bimg2[mod][ct],(int)x,(int)y,width,height,this);
	}

	public void draw(Graphics g)
	{
		g.drawImage(img,(int)x,(int)y,width,height,this);
	}



	Image box= new ImageIcon(ClassLoader.getSystemResource("npc/button.png")).getImage();	
	public void  Dialog_box(String txt,player p1,Graphics g)
	{
		if(Collision((int)x,(int)y,height,width,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			g.drawImage(box,0,UNIT_SIZE*5,SCREEN_WIDTH,UNIT_SIZE*3,this);
			
		    Font font = new Font("Serif", Font.PLAIN,60);
		    g.setFont(font);
		    g.drawString(txt, UNIT_SIZE+50, UNIT_SIZE*6);
		}
	}
	public void  next_box(int box_x,int box_y,int go_tox,int go_toy,player p1)
	{
		if(Collision(box_x,box_y,100,100,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			this.x=go_tox;
			this.y=go_toy;
		}
	}

	public boolean  next_box(int box_x,int box_y,int go_tox,int go_toy,player p1,int x)
	{
		if(Collision(box_x,box_y,100,100,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			this.x=go_tox;
			this.y=go_toy;
			return true;
		}
		return false;
	}
	public boolean  next_box(int box_x,int box_y,int go_tox,int go_toy,player p1,int x,Graphics g)
	{
		g.drawImage(box,box_x,box_y,UNIT_SIZE,UNIT_SIZE,this);
		if(Collision(box_x,box_y,100,100,(int)p1.x,(int)p1.y,p1.height,p1.width))
		{
			this.x=go_tox;
			this.y=go_toy;
			return true;
		}
		return false;
	}






	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
