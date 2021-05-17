package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class simple_object  implements ImageObserver
{

	public static final int SCREEN_WIDTH=1600;
	public static final int SCREEN_HEIGHT=800;
	public static  final int UNIT_SIZE=100;
	int life;
	public   int reference_x;
	public   int reference_y;
	public   double x;
	public   double y;

	public   int reference_WIDTH;
	public   int reference_HEIGHT;
	public   int width;
	public   int height;
	public simple_object()
	{}
	public void drawAuxiliary_line(Graphics g)
	{

		for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++)
		{
			g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
		}
		for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++)
		{
			g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
		}
	}
	public simple_object(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH)
	{
		this.reference_x=reference_x;
		this.reference_y=reference_y;
		x=reference_x*UNIT_SIZE;
		y=reference_y*UNIT_SIZE;
		this.reference_WIDTH= reference_WIDTH;
		this.reference_HEIGHT=reference_HEIGHT;
		width=UNIT_SIZE*reference_WIDTH;
		height=UNIT_SIZE*reference_HEIGHT;
	}
	public void drawimg( BufferedImage img,Graphics g)
	{
		g.drawImage(img,(int)x,(int)y,width,height,this);
	}
	public void cut_img(String Sprite,int how_much_move,BufferedImage Imgage[]) 
	{
		BufferedImage gameplaer =null;
		String path = "/"+Sprite;
		URL image_path=getClass().getResource(path);
		try 
		{
			gameplaer = ImageIO.read(image_path);
		} 
		catch (IOException e){}

		int tWidth = gameplaer.getWidth();
		int tHeight = gameplaer.getHeight();
		int eWidth=tWidth/how_much_move;
		int eHeight=tHeight;
		for(int i=0;i<how_much_move;i++)
			Imgage[i] =  gameplaer.getSubimage(i*eWidth, 0, eWidth, eHeight);
	}
	
	public void cut_img(String Sprite,int how_much_moveX,int how_much_moveY,BufferedImage Imgage[][]) 
	{
		BufferedImage gameplaer =null;
		String path = "/"+Sprite;
		URL image_path=getClass().getResource(path);
		try 
		{
			gameplaer = ImageIO.read(image_path);
		} 
		catch (IOException e){}

		int tWidth = gameplaer.getWidth();
		int tHeight = gameplaer.getHeight();
		int eWidth=tWidth/how_much_moveX;
		int eHeight=tHeight/how_much_moveY;
		for(int i=0;i<how_much_moveY;i++)
			for(int j=0;j<how_much_moveX;j++)
				Imgage[i][j] =  gameplaer.getSubimage(j*eWidth, i*eHeight, eWidth, eHeight);
	}
	public static boolean Collision(int x,int y,int h,int w,int x1,int y1,int h1,int w1)
	{

		int f_x_ul = x;//¥ª¤W¨¤
		int f_y_ul = y;
		
		int f_x_ur = x+w;//¥k¤W¨¤
		int f_y_ur = y;
		
		int f_x_dl = x;
		int f_y_dl = y+h;//¥ª¤U¨¤
		
		int f_x_dr = x+w;
		int f_y_dr = y+h;//¥k¤U¨¤

//---------------------------------------------------------------			
		int bat_x_ul = x1;//¥ª¤W¨¤
		int bat_y_ul = y1;
		
		int bat_x_ur = x1+w1;//¥k¤W¨¤
		int bat_y_ur = y1;
		
		int bat_x_dl = x1;
		int bat_y_dl = y1+h1;//¥ª¤U¨¤
		
		int bat_x_dr = x1+w1;
		int bat_y_dr = y1+h1;//¥k¤U¨¤


		if( f_x_ur > bat_x_ul && bat_x_ur>f_x_ul )
		{
			if(bat_y_ul<f_y_dl && f_y_ul<bat_y_dl)
			{
				return true;
			}
		}
		return false;
	}
	

	
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
