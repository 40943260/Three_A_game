package main;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class map1 extends simple_object implements ActionListener
{

	player player1;
	public map1(player p1)
	{
		this.player1=p1;
		floor_2_0.setfoor(box_dat, box, "img/Ground Grass/box.png");
		floor_2_0.setfoor(stairs_dat, stairs, "img/Ground Grass/box.png");
		box[1].x=box[1].x-50;
		

			stairs[0].x=stairs[0].x+20;
			stairs[1].x=stairs[1].x+20;
			stairs[0].y=stairs[0].y+20;
			stairs[1].y=stairs[1].y+20;
	
			stairs[2].x=stairs[2].x+40;
			stairs[3].x=stairs[3].x+40;
			stairs[2].y=stairs[2].y+40;
			stairs[3].y=stairs[3].y+40;
			
			stairs[4].x=stairs[4].x+60;
			stairs[5].x=stairs[5].x+60;
			stairs[4].y=stairs[4].y+60;
			stairs[5].y=stairs[5].y+60;
			
			stairs[6].x=stairs[6].x+80;
			stairs[7].x=stairs[7].x+80;
			stairs[6].y=stairs[6].y+80;
			stairs[7].y=stairs[7].y+80;
			
			big_home.WIDTH=big_home.WIDTH-big_home_ct;
			big_home.HEIGHT=big_home.HEIGHT-big_home_ct;
			small_home2.WIDTH=small_home2.WIDTH-small_home2_ct;
			small_home2.HEIGHT=small_home2.HEIGHT-small_home2_ct;
			lud.WIDTH=lud.WIDTH-25;
		
	}
	int big_home_ct=50;
	int small_home2_ct=5;
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
	double map_long = 33*UNIT_SIZE;
	double map_long_dat=UNIT_SIZE*7;
	public void map_updat(double delta_time)
	{
		dat_X=player1.x;
		if(dat_X+player1.WIDTH>UNIT_SIZE*7 && map_long_dat<=map_long)
		{

			player1.x=dat_X-player1.run_speed*delta_time/10;
			map_long_dat+=player1.run_speed*delta_time/10;

			
			object_updat(delta_time,plank);
			object_updat(delta_time,plank2);
			object_updat(delta_time,plank3);
			object_updat(delta_time,d);
			object_updat(delta_time,box);
			object_updat(delta_time,stairs);
			object_updat(delta_time,Grass);
			object_updat(delta_time,soil);
			object_updat(delta_time,Grass2);
			object_updat(delta_time,soil2);
			object_updat(delta_time,Grass3);
			object_updat(delta_time,soil3);
			object_updat(delta_time);

		
		}
		if(dat_X+player1.WIDTH<UNIT_SIZE*5 && map_long_dat>=7*UNIT_SIZE)
		{

			player1.x=dat_X+player1.run_speed*delta_time/10;
			map_long_dat-=player1.run_speed*delta_time/10;

			
			bar_object_updat(delta_time,plank);
			bar_object_updat(delta_time,plank2);
			bar_object_updat(delta_time,plank3);
			bar_object_updat(delta_time,d);
			bar_object_updat(delta_time,box);
			bar_object_updat(delta_time,stairs);
			bar_object_updat(delta_time,Grass);
			bar_object_updat(delta_time,soil);
			bar_object_updat(delta_time,Grass2);
			bar_object_updat(delta_time,soil2);
			bar_object_updat(delta_time,Grass3);
			bar_object_updat(delta_time,soil3);
			bar_object_updat(delta_time);

			
		
		}
		if(dat_X<0)
		{
			player1.x=0;
		}	
		if(player1.x+player.WIDTH>=SCREEN_WIDTH-50)
		{
			player1.x=player1.run_speed*delta_time/10;
		}
	}
	door d =new door(40,6,1,1,"boss/boss_strip4.png",4);
	
	floor Grass=new floor(0,5,1,17,"img/Ground Grass/5.png");//x y h w
	floor soil=new floor(0,6,4,17,"img/Ground Grass/4.png");//x y h w

	floor Grass2=new floor(20,5,1,8,"img/Ground Grass/5.png");//x y h w
	floor soil2=new floor(20,6,4,8,"img/Ground Grass/4.png");//x y h w
	
	floor Grass3=new floor(29,7,1,15,"img/Ground Grass/5.png");//x y h w
	floor soil3=new floor(29,8,2,15,"img/Ground Grass/4.png");//x y h w
	
	floor_2_0 box[]=new floor_2_0[2];
	int box_dat[][]= {{6,4,1,2},{7,3,1,1}};
	floor_2_0 stairs[]=new floor_2_0[12];
	int stairs_dat[][]= {{28,6,1,1},{27,5,1,1}
						,{28,6,1,1},{27,5,1,1}
						,{28,6,1,1},{27,5,1,1}
						,{28,6,1,1},{27,5,1,1}
						,{27,5,1,1},{28,6,1,1},{29,7,1,1},{27,5,1,1}};
	npc plank =new npc(0,4,1,1,"npc/plank.png");
	npc plank2 =new npc(5,4,1,1,"npc/plank.png");
	npc plank3 =new npc(15,4,1,1,"npc/old_man.png");
	simple_drawing backgeand = new simple_drawing(0,0,8,16,"img/background.png");

	public void draw(double delta_time,Graphics g)
	{

		player1.gravity_ct=true;
		player1.R_stop=false;
		player1.L_stop=false;
		player1.U_stop=false;
	
		map_updat(delta_time);
		Grass.floor_Collision(player1);
		Grass2.floor_Collision(player1);
		Grass3.floor_Collision(player1);
		floor_2_0.floor_Collision(box,player1);
		floor_2_0.floor_Collision(stairs,player1);


		backgeand.draw(g);
		simple_draw(g);
//		Grass.drawFloor(g);
//		soil.drawFloor(g);
//		Grass2.drawFloor(g);
//		soil2.drawFloor(g);
//		Grass3.drawFloor(g);
//		soil3.drawFloor(g);
		
		floor_2_0.drawfoor(box,g);
		//floor_2_0.drawfoor(stairs,g);
		
		plank.draw(g);
		plank.Dialog_box("左右鍵移動",player1,g);
		plank2.draw(g);
		plank2.Dialog_box("上鍵飛行(注意左上角能量條，飛行需要消耗能量)",player1,g);
		plank3.draw(g);
		plank3.Dialog_box("前面的路被裝壞了 跳過去ㄅ",player1,g);
		d.draw_door(100,g);
		d.door_c(player1,1);
		player1.move(delta_time,g);

		drawAuxiliary_line(g);
	}
	
	public void simple_draw(Graphics g)
	{
		
		big_home.draw((int)(3200+simple_updat),100+big_home_ct,g);
		small_home.draw((int)(100+simple_updat), 100, g);
		small_home.draw((int)(1000+simple_updat), 100, g);
		small_home2.draw((int)(2100+simple_updat), 100+small_home2_ct, g);
		bk_g.draw((int)(500+simple_updat),400-10, g);
		bk_g.draw((int)(700+simple_updat),400-10, g);
		lud.draw((int)(900+simple_updat),100, g);
		lud.draw((int)(2700+simple_updat),100, g);
		drawFloor(g);
		buy.draw((int)(3000+simple_updat),490, g);
		buy.draw((int)(3200+simple_updat),490, g);
	}
	simple_drawing floor_img=new simple_drawing(0,0,2,4,"img/Ground Grass/a2.png");
	simple_drawing floor_img_bk=new simple_drawing(0,0,1,1,"img/Ground Grass/bka.png");
	simple_drawing bk_img=new simple_drawing(0,5,3,28,"img/Ground Grass/bk.png");
	simple_drawing bk_img2=new simple_drawing(0,5,1,28,"img/Ground Grass/bk.png");
	simple_drawing stairs_b_img=new simple_drawing(0,5,2,2,"img/Ground Grass/b3.png");
	simple_drawing floor_img2=new simple_drawing(0,0,1,3,"img/Ground Grass/a3.png");
	simple_drawing stairs_b2_img=new simple_drawing(0,0,1,2,"img/Ground Grass/bbb3.png");
	simple_drawing small_home=new simple_drawing(0,0,4,4,"img/small_home.png");
	simple_drawing small_home2=new simple_drawing(0,0,4,7,"img/small_home2.png");
	simple_drawing big_home=new simple_drawing(0,0,6,10,"img/big_home.png");
	simple_drawing buy=new simple_drawing(0,0,2,2,"img/攤販.png");
	simple_drawing bk_g=new simple_drawing(0,0,1,2,"img/ga.png");//草堆
	simple_drawing lud=new simple_drawing(0,0,4,1,"img/lu_deng.png");//路燈
	double simple_updat=0;
	public void drawFloor(Graphics g)
	{		

		bk_img.draw((int)(0+simple_updat),5*UNIT_SIZE,g);
		bk_img2.draw((int)(28*UNIT_SIZE+simple_updat),7*UNIT_SIZE,g);
		floor_img_bk.draw((int)(16*UNIT_SIZE+simple_updat-2),5*UNIT_SIZE-17,g);
		floor_img.draw((int)(0+simple_updat),5*UNIT_SIZE-20,g);
		floor_img.draw((int)(4*UNIT_SIZE+simple_updat),5*UNIT_SIZE-20,g);
		floor_img.draw((int)(8*UNIT_SIZE+simple_updat),5*UNIT_SIZE-20,g);
		floor_img.draw((int)(12*UNIT_SIZE+simple_updat),5*UNIT_SIZE-20,g);

		floor_img.draw((int)(20*UNIT_SIZE+simple_updat),5*UNIT_SIZE-20,g);
		floor_img.draw((int)(24*UNIT_SIZE+simple_updat),5*UNIT_SIZE-20,g);
		stairs_b_img.draw((int)(28*UNIT_SIZE+simple_updat),5*UNIT_SIZE-10,g);
		stairs_b2_img.draw((int)(28*UNIT_SIZE+simple_updat),7*UNIT_SIZE-10,g);
		

		floor_img2.draw((int)(30*UNIT_SIZE+simple_updat),7*UNIT_SIZE-20,g);
		floor_img2.draw((int)(33*UNIT_SIZE+simple_updat),7*UNIT_SIZE-20,g);
		floor_img2.draw((int)(36*UNIT_SIZE+simple_updat),7*UNIT_SIZE-20,g);
		floor_img2.draw((int)(39*UNIT_SIZE+simple_updat),7*UNIT_SIZE-20,g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
