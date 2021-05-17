package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class map2 extends simple_object implements ActionListener
{
	player player1;
	double simple_updat=0;
	public map2(player p1)
	{
		this.player1=p1;
	}
	public void object_updat(double delta_time,simple_object floor)//方塊2.0單ㄍㄚ鋪帶她
	{
		floor.x-=player1.run_speed*delta_time/10;
	}
	public void object_updat(double delta_time,simple_object floor[])//方塊2.0陣列ㄍㄚ鋪帶她
	{
		for(int i=0;i<floor.length;i++)
		{
			object_updat(delta_time,floor[i]);
		}
	}
	public void object_updat(double delta_time)//方塊2.0單ㄍㄚ鋪帶她
	{
		simple_updat-=player1.run_speed*delta_time/10;
	}
	public void bar_object_updat(double delta_time)//方塊2.0單ㄍㄚ鋪帶她
	{
		simple_updat+=player1.run_speed*delta_time/10;
	}
	public void bar_object_updat(double delta_time,simple_object floor)//方塊2.0單ㄍㄚ鋪帶她
	{
		floor.x+=player1.run_speed*delta_time/10;
	}
	public void bar_object_updat(double delta_time,simple_object floor[])//方塊2.0陣列ㄍㄚ鋪帶她
	{
		for(int i=0;i<floor.length;i++)
		{
			bar_object_updat(delta_time,floor[i]);
		}
	}

	static double dat_X;
	double map_long = 100*UNIT_SIZE;
	double map_long_dat=UNIT_SIZE*7;
	public void map_updat(double delta_time)
	{
		dat_X=player1.x;
		if(dat_X+player1.WIDTH>UNIT_SIZE*7 && map_long_dat<=map_long)
		{
			player1.x=dat_X-player1.run_speed*delta_time/10;
			map_long_dat+=player1.run_speed*delta_time/10;
			object_updat(delta_time);
			object_updat(delta_time,Grass);
			object_updat(delta_time,d);
		}
		if(dat_X+player1.WIDTH<UNIT_SIZE*5 && map_long_dat>=7*UNIT_SIZE)
		{

			player1.x=dat_X+player1.run_speed*delta_time/10;
			map_long_dat-=player1.run_speed*delta_time/10;
			bar_object_updat(delta_time);
			bar_object_updat(delta_time,Grass);
			bar_object_updat(delta_time,d);

		
		}
		if(dat_X<0)
		{
			player1.x=0;
		}	
		if(player1.x+player.WIDTH>=SCREEN_WIDTH-50)
		{
			player1.x=player1.x-2;
		}
	}
	
	floor Grass=new floor(0,7,1,48,"img/Ground Grass/5.png");//x y h w
	door d =new door(31,5,2,2,"npc/rogue spritesheet calciumtrice.png",10,10);
	simple_drawing backgeand = new simple_drawing(0,0,8,16,"img/background.png");
	public void draw(double delta_time,Graphics g)
	{
		player1.gravity_ct=true;
		player1.R_stop=false;
		player1.L_stop=false;
		player1.U_stop=false;
		map_updat(delta_time);
		Grass.floor_Collision(player1);

		backgeand.draw(g);
		Grass.drawFloor(g);
		simple_draw(g);
		d.draw_door(0, 200, g);
		d.door_c(player1,2);
		player1.move(delta_time,g);
	}
	public void simple_draw(Graphics g)
	{
		
//		big_home.draw(3200+simple_updat,100+big_home_ct,g);
//		small_home.draw(100+simple_updat, 100, g);
//		small_home.draw(1000+simple_updat, 100, g);
//		small_home2.draw(2100+simple_updat, 100+small_home2_ct, g);
//		bk_g.draw(500+simple_updat,400-10, g);
//		bk_g.draw(700+simple_updat,400-10, g);
//		lud.draw(900+simple_updat,100, g);
//		lud.draw(2700+simple_updat,100, g);
		small_home.draw((int)(0+simple_updat),3*100, g);
		small_home2.draw((int)(4*100+simple_updat),3*100, g);
		small_home.draw((int)(11*100+simple_updat),3*100, g);
		big_home.draw((int)(16*100+simple_updat),1*100, g);
		bk_g.draw((int)(3*100+simple_updat),6*100, g);
		bk_g.draw((int)(10*100+simple_updat),6*100, g);
		bk_g.draw((int)(14*100+simple_updat),6*100, g);

		water_p.draw((int)(27*100+simple_updat),1*100, g);
		small_home.draw((int)(32*100+simple_updat),3*100, g);
		small_home.draw((int)(36*100+simple_updat),3*100, g);
		drawFloor(g);

//		buy.draw(3000+simple_updat,490, g);
//		buy.draw(3200+simple_updat,490, g);
	}
	simple_drawing floor_img=new simple_drawing(0,0,2,4,"img/Ground Grass/a2.png");
	simple_drawing bk_img=new simple_drawing(0,7,1,20,"img/Ground Grass/bk.png");
//	simple_drawing bk_img2=new simple_drawing(0,5,1,28,"img/Ground Grass/bk.png");
//	simple_drawing stairs_b_img=new simple_drawing(0,5,2,2,"img/Ground Grass/b3.png");
//	simple_drawing floor_img2=new simple_drawing(0,0,1,3,"img/Ground Grass/a3.png");
//	simple_drawing stairs_b2_img=new simple_drawing(0,0,1,2,"img/Ground Grass/bbb3.png");
	simple_drawing small_home=new simple_drawing(0,0,4,4,"img/small_home.png");
	simple_drawing small_home2=new simple_drawing(0,0,4,7,"img/small_home2.png");
	simple_drawing big_home=new simple_drawing(0,0,6,10,"img/big_home.png");
//	simple_drawing buy=new simple_drawing(0,0,2,2,"img/攤販.png");
	simple_drawing bk_g=new simple_drawing(0,0,1,2,"img/ga.png");//草堆
//	simple_drawing lud=new simple_drawing(0,0,4,1,"img/lu_deng.png");//路燈
	simple_drawing water_p=new simple_drawing(0,0,6,4,"img/噴水.png");//噴水池
	public void drawFloor(Graphics g)
	{		

//		bk_img.draw(0+simple_updat,5*UNIT_SIZE,g);
//		bk_img2.draw(28*UNIT_SIZE+simple_updat,7*UNIT_SIZE,g);
//		floor_img_bk.draw(16*UNIT_SIZE+simple_updat-2,5*UNIT_SIZE-17,g);	
		bk_img.draw(g);
		floor_img.draw((int)(0+simple_updat),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(4*UNIT_SIZE+simple_updat-2),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(8*UNIT_SIZE+simple_updat-4),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(12*UNIT_SIZE+simple_updat-6),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(16*UNIT_SIZE+simple_updat-8),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(20*UNIT_SIZE+simple_updat-10),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(24*UNIT_SIZE+simple_updat-12),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(28*UNIT_SIZE+simple_updat-14),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(32*UNIT_SIZE+simple_updat-16),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(36*UNIT_SIZE+simple_updat-18),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(40*UNIT_SIZE+simple_updat-20),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(44*UNIT_SIZE+simple_updat-22),7*UNIT_SIZE-20,g);
		floor_img.draw((int)(48*UNIT_SIZE+simple_updat-24),7*UNIT_SIZE-20,g);
	
//		floor_img.draw(20*UNIT_SIZE+simple_updat,5*UNIT_SIZE-20,g);
//		floor_img.draw(24*UNIT_SIZE+simple_updat,5*UNIT_SIZE-20,g);
//		stairs_b_img.draw(28*UNIT_SIZE+simple_updat,5*UNIT_SIZE-10,g);
//		stairs_b2_img.draw(28*UNIT_SIZE+simple_updat,7*UNIT_SIZE-10,g);
//		
//
//		floor_img2.draw(30*UNIT_SIZE+simple_updat,7*UNIT_SIZE-20,g);
//		floor_img2.draw(33*UNIT_SIZE+simple_updat,7*UNIT_SIZE-20,g);
//		floor_img2.draw(36*UNIT_SIZE+simple_updat,7*UNIT_SIZE-20,g);
//		floor_img2.draw(39*UNIT_SIZE+simple_updat,7*UNIT_SIZE-20,g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
