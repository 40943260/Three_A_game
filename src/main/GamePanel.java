package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class GamePanel extends JPanel  implements ActionListener
{

	static final int SCREEN_WIDTH=1600;
	static final int SCREEN_HEIGHT=800;
	static final int UNIT_SIZE = 100;
	static final int DELAY = 1;
	Timer timer;
	player player1=new player(0,0,1,1);
	long t1,t2,dt,sleepTime;
	long peroid = 1000/120;					//计算每一次循环需要的执行时间，单位：毫秒

	GamePanel()
	{
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MykeyAdapter());
		timer = new Timer(DELAY,this);
		timer.start();
		t1=System.nanoTime();	

		
	}
	long last_time = System.nanoTime();
	double delta_time;
	long time ;
	 
	public long fps_time = System.currentTimeMillis();
	public int fps_cout =0;
	public int fps_dat=100000;
	public void paintComponent(Graphics g)
	{		
		

		time = System.nanoTime();
		delta_time = ((time - last_time) / 1000000);
		last_time = time;
		
		//System.out.println(delta_time);
		try 
		{
			Thread.sleep(1000/120);
		}catch(InterruptedException ex) 
		{
		}

		super.paintComponent(g);
		//draw(g);

		draw(delta_time,g);
		
		fps_cout=fps_cout+1;
		if(System.currentTimeMillis() - fps_time>=1000)
		{
			fps_dat=fps_cout;
			fps_cout=0;
			fps_time=System.currentTimeMillis();
		}
	    Font font = new Font("Serif", Font.PLAIN,20);
	    g.setFont(font);
		g.drawString(String.valueOf(fps_dat), 100,100);
		
		repaint();//在畫一次
	}
	
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
	
	floor test=new floor(0,5,1,16,"img/Ground Grass/5.png");//x y h w
	floor_2_0 test2=new floor_2_0(3,4,1,2,"img/Ground Grass/box.png");//x y h w
	map1 leval1_map = new map1(player1);
	map2 leval2_map = new map2(player1);
	map3 leval3_map = new map3(player1);
	map4 leval4_map = new map4(player1);
	boolean lelord=true;
	public long  lelord_time= System.currentTimeMillis();//限制多久更新
	public void draw(double delta_time,Graphics g)
	{
	
		if(lelord)
		{
			if(System.currentTimeMillis()-lelord_time>=1000)
			{
				lelord=false;
			}
		}
		else if(player1.level==0)
			leval1_map.draw(delta_time,g);
		else if(player1.level==1)
			leval2_map.draw(delta_time,g);
		else if(player1.level==2)
			leval3_map.draw(delta_time,g);
		else if(player1.level==3)
			leval4_map.draw(delta_time,g);

	}
	public class MykeyAdapter extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_SPACE:
					player1.attack=true;
					break;
				case KeyEvent.VK_LEFT:
					player1.L=true;
					player1.R=false;
					player1.LN=false;
					player1.RN=false;
					break;
				case KeyEvent.VK_RIGHT:
					player1.R=true;
					player1.L=false;
					player1.LN=false;
					player1.RN=false;
					break;
				case KeyEvent.VK_UP:
							player1.U =true;

	
					break;
			}
		}

		    
		public void keyReleased(KeyEvent e) 
		{	
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_SPACE:
					break;
				case KeyEvent.VK_UP:
					  player1.U=false; 
					break;
				default:
					if(player1.R==true)
					{
						player1.R=false;
						player1.RN=true;
					}
					else if(player1.L==true)
					{
						player1.L=false;
						player1.LN=true;
					}	
					break;
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub	
		
	}



}
