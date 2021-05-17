package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class simple_drawing  implements ImageObserver
{
	String path ;
	public   double x;
	public   double y;

	public   int reference_x;
	public   int reference_y;
	
	public   int reference_floor_WIDTH;
	public   int reference_floor_HEIGHT;
	
	public   int WIDTH;
	public   int HEIGHT;
	int UNIT_SIZE=100;
	Image img;
	public simple_drawing(int x,int y,int reference_floor_HEIGHT,int reference_floor_WIDTH,String path)
	{
		this.x=x*UNIT_SIZE;
		this.y=y*UNIT_SIZE;
		reference_x=x;
		reference_y=y;
		this.reference_floor_WIDTH= reference_floor_WIDTH;
		this.reference_floor_HEIGHT=reference_floor_HEIGHT;
		this.path=path;
		WIDTH=UNIT_SIZE*reference_floor_WIDTH;
		HEIGHT=UNIT_SIZE*reference_floor_HEIGHT;
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();

	}
	public simple_drawing(String a,int x,int y,int reference_floor_HEIGHT,int reference_floor_WIDTH,String path)
	{
		this.x=x;
		this.y=y;
		this.path=path;
		WIDTH=reference_floor_WIDTH;
		HEIGHT=reference_floor_HEIGHT;
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();
	}
	public simple_drawing(int x,int y,String path)
	{
		this.x=x;
		this.y=y;
		this.path=path;
		img= new ImageIcon(ClassLoader.getSystemResource(path)).getImage();

		WIDTH=img.getWidth(null);
		HEIGHT=img.getHeight(null);
	}
	public void draw(Graphics g)
	{
		g.drawImage(img,(int)x, (int)y,this.WIDTH,this.HEIGHT,this);
	}
	public void draw(int w,Graphics g)
	{
		for(int i=0;i<reference_floor_WIDTH;i+=w)
			g.drawImage(img,(int)(x+i*UNIT_SIZE), (int)(y-20),UNIT_SIZE*w,HEIGHT,this);
	}
	public void draw(int x,int y,int w,int h,Graphics g)
	{
		g.drawImage(img,x, y,w,h,this);
	}
	public void draw(int x,int y,Graphics g)
	{
		g.drawImage(img,x, y,WIDTH,HEIGHT,this);
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
