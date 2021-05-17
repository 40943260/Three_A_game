package main;

import java.awt.Graphics;
import java.io.IOException;


public class playerJump extends Thread
{
	player p1;

	playerJump(player p1)
	{
		this.p1=p1;
	}

	public double jump_v=10;
	public long  jump_move_time= System.currentTimeMillis();
	public long  jump_move_time_updat= 25;
	public long  jump_move_time2= System.currentTimeMillis();
	public long  jump_move_time_updat2= 250;
	boolean stop=true;
	long last_time = System.nanoTime();
	int delta_time;
	long time ;
	 
	public void run()
	{
		jump_move_time2=System.currentTimeMillis();
		stop=false;
		int i=0;
		while(stop==false &&System.currentTimeMillis()-jump_move_time2<=jump_move_time_updat2)
		{

			time = System.nanoTime();
			delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;
			
			System.out.println(delta_time);
			try
			{
			    Thread.sleep(1000/500);
			}
			catch(InterruptedException ex){}
			if(System.currentTimeMillis()-jump_move_time>=jump_move_time_updat)
			{
					p1.y=p1.y-jump_v*delta_time;
					jump_move_time=System.currentTimeMillis();
			}
		}
	}
}
