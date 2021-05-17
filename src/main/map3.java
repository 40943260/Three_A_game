package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mosnter.eye_monster;


public class map3 extends simple_object implements ActionListener
{
	player player1;
	double simple_updat=0;
	public map3(player p1)
	{
		this.player1=p1;	
		floor_2_0.setfoor(box_dat, box, "img/Ground Grass/box.png");
		grass_7x1.WIDTH=grass_7x1.WIDTH+30;
		grass_7x1.HEIGHT=grass_7x1.HEIGHT+20;
		grass_7x1.y=grass_7x1.y-20;
		grass_7x1.x=grass_7x1.x-25;
		

		grass_7x2.WIDTH=grass_7x2.WIDTH+30;
		grass_7x2.HEIGHT=grass_7x2.HEIGHT+20;
		test1 =new eye_monster(player1,32,1,1,1);
		test2 =new eye_monster(player1,44,1,1,1);
		test3 =new eye_monster(player1,56,1,1,1);

		
		grass_14x2.WIDTH=grass_14x2.WIDTH+30;
		grass_14x2.HEIGHT=grass_14x2.HEIGHT+20;
		grass_14x2.y=grass_14x2.y-20;
		grass_14x2.x=grass_14x2.x-25;
	}
	public void object_updat(double delta_time,simple_object floor)//方塊2.0單ㄍㄚ鋪帶她
	{
		floor.x-=player1.run_speed*delta_time/10;
	}
	public void object_updat(double delta_time,simple_drawing sim)//方塊2.0單ㄍㄚ鋪帶她
	{
		sim.x-=player1.run_speed*delta_time/10;
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
	public void bar_object_updat(double delta_time,simple_drawing sim)//方塊2.0單ㄍㄚ鋪帶她
	{
		sim.x+=player1.run_speed*delta_time/10;
	}
	static double dat_X;
	double map_long = 59*UNIT_SIZE;
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
			object_updat(delta_time,Grass2);
			object_updat(delta_time,Grass3);
			object_updat(delta_time,Grass4);
			object_updat(delta_time,Grass5);
			object_updat(delta_time,Grass6);
			object_updat(delta_time,Grass7);
			object_updat(delta_time,box);
			object_updat(delta_time,trap1);
			object_updat(delta_time,grass_4x1);
			object_updat(delta_time,grass_4x4);
			object_updat(delta_time,grass_5x5);
			object_updat(delta_time,grass_7x1);
			object_updat(delta_time,grass_4x2);
			object_updat(delta_time,grass_14x2);
			object_updat(delta_time,bg_7x1);
			object_updat(delta_time,test1);
			object_updat(delta_time,test2);
			object_updat(delta_time,test3);
			object_updat(delta_time,teacher);
			object_updat(delta_time,d);
		}
		
		if(dat_X+player1.WIDTH<UNIT_SIZE*5 && map_long_dat>=7*UNIT_SIZE)
		{

			player1.x=dat_X+player1.run_speed*delta_time/10;
			map_long_dat-=player1.run_speed*delta_time/10;
			bar_object_updat(delta_time);
			bar_object_updat(delta_time,Grass);
			bar_object_updat(delta_time,Grass2);
			bar_object_updat(delta_time,Grass3);
			bar_object_updat(delta_time,Grass4);
			bar_object_updat(delta_time,Grass5);
			bar_object_updat(delta_time,Grass6);
			bar_object_updat(delta_time,Grass7);
			bar_object_updat(delta_time,box);
			bar_object_updat(delta_time,trap1);
			bar_object_updat(delta_time,grass_4x1);
			bar_object_updat(delta_time,grass_4x4);
			bar_object_updat(delta_time,grass_5x5);
			bar_object_updat(delta_time,grass_7x1);
			bar_object_updat(delta_time,grass_4x2);
			bar_object_updat(delta_time,grass_14x2);
			bar_object_updat(delta_time,bg_7x1);
			bar_object_updat(delta_time,test1);
			bar_object_updat(delta_time,test2);
			bar_object_updat(delta_time,test3);
			bar_object_updat(delta_time,teacher);
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
	
	floor Grass=new floor(0,7,1,4,"img/Ground Grass/5.png");//x y h w
	floor Grass2=new floor(3,4,1,4,"img/Ground Grass/5.png");//x y h w
	floor Grass3=new floor(9,5,1,4,"img/Ground Grass/5.png");//x y h w
	floor Grass4=new floor(13,7,1,7,"img/Ground Grass/5.png");//x y h w
	floor Grass5=new floor(14,3,1,5,"img/Ground Grass/5.png");//x y h w
	floor Grass6=new floor(36,6,1,8,"img/Ground Grass/5.png");//x y h w
	floor Grass7=new floor(54,6,1,25,"img/Ground Grass/5.png");//x y h w
	floor_2_0 box[]=new floor_2_0[4];
	int box_dat[][]= {{22,4,4,4},{26,6,4,4},{32,6,4,4},{44,6,4,7}};
	trap trap1=new trap(13,6,1,7);
	door d =new door(66,4,2,2,"npc/rogue spritesheet calciumtrice.png",10,10);
	simple_drawing backgeand = new simple_drawing(0,0,8,16,"img/background.png");
	public void draw(double delta_time,Graphics g)
	{
		player1.gravity_ct=true;
		player1.R_stop=false;
		player1.L_stop=false;
		player1.U_stop=false;
		map_updat(delta_time);

		backgeand.draw(g);
	


		d.draw_door(0, 200, g);
		d.door_c(player1,3);

		Grass.floor_Collision(player1);
		Grass2.floor_Collision(player1);
		Grass3.floor_Collision(player1);

		Grass4.floor_Collision(player1);
		Grass5.floor_Collision(player1);
		Grass6.floor_Collision(player1);
		Grass7.floor_Collision(player1);
		//floor_2_0.drawfoor(box,player1,g);
		floor_2_0.floor_Collision(box,player1);


		simple_draw(g);
		trap1.draw_trap(player1, g);
		player1.move(delta_time,g);
		drawNpc(g);
		drawMs(delta_time,g);
		drawAuxiliary_line(g);


	}
	public void simple_draw(Graphics g)
	{
		drawFloor(g);
	}
	simple_drawing grass_4x1=new simple_drawing(0,7,1,4,"img/bkimg/4x1grass.png");
	simple_drawing grass_4x4=new simple_drawing(3,4,4,4,"img/bkimg/4x4grass.png");
	simple_drawing grass_5x5=new simple_drawing(14,3,5,5,"img/bkimg/5x5grass.png");
	simple_drawing grass_7x1=new simple_drawing(13,7,1,7,"img/bkimg/7x1grass.png");
	simple_drawing grass_7x2=new simple_drawing(13,7,2,7,"img/bkimg/7x2grass.png");
	simple_drawing grass_4x2=new simple_drawing(26,6,2,4,"img/bkimg/4x2grass.png");
	simple_drawing grass_14x2=new simple_drawing(54,6,2,14,"img/bkimg/14x2grass.png");
	simple_drawing bg_7x1=new simple_drawing(35,5,1,9,"img/bkimg/7x1bg.png");
	public void drawFloor(Graphics g)
	
	{	
		grass_4x4.draw(g);	
		grass_4x1.draw(g);

		grass_4x4.draw((int)(9*100+simple_updat),5*100,g);	
		grass_5x5.draw(g);
		
		grass_7x1.draw(g);
		grass_4x4.draw((int)(22*100+simple_updat),4*100,g);	
		grass_4x2.draw(g);
		grass_4x4.draw((int)(32*100+simple_updat),6*100,g);	
		bg_7x1.draw((int)(35*100+simple_updat+40),5*100+30,g);	
		grass_7x2.draw((int)(44*100+simple_updat),6*100-20,g);
		grass_14x2.draw(g);
	} 
	eye_monster test1 ;
	eye_monster test2 ;
	eye_monster test3 ;
	void drawMs(double delta_time,Graphics g)
	{
		test1.gravity_ct=true;
		Grass.floor_Collision(test1);
		Grass2.floor_Collision(test1);
		Grass3.floor_Collision(test1);
		Grass4.floor_Collision(test1);
		Grass5.floor_Collision(test1);
		Grass6.floor_Collision(test1);
		
		test2.gravity_ct=true;
		Grass.floor_Collision(test2);
		Grass2.floor_Collision(test2);
		Grass3.floor_Collision(test2);
		Grass4.floor_Collision(test2);
		Grass5.floor_Collision(test2);
		Grass6.floor_Collision(test2);
		
		test3.gravity_ct=true;
		Grass.floor_Collision(test3);
		Grass2.floor_Collision(test3);
		Grass3.floor_Collision(test3);
		Grass4.floor_Collision(test3);
		Grass5.floor_Collision(test3);
		Grass6.floor_Collision(test3);
		Grass7.floor_Collision(test3);
		floor_2_0.floor_Collision(box,test1);
		floor_2_0.floor_Collision(box,test2);
		floor_2_0.floor_Collision(box,test3);
		test1.monsterMove(delta_time,g);
		test2.monsterMove(delta_time,g);
		test3.monsterMove(delta_time,g);
	}
	npc teacher =new npc(4,2,2,2,"npc/rogue spritesheet calciumtrice.png",10,10);
	String teacher_talk_dat[]= {"運用飛行(放向鍵上鍵)能力飛過坑洞或障礙物","注意左上角飛行能量，用完要停下等待才能飛行","使用空白建攻擊魔物"};
	int teacher_talk_ct=0;
	void drawNpc(Graphics g)
	{

		teacher.draw(0, 10, 200, g);
		teacher.Dialog_box(teacher_talk_dat[teacher_talk_ct],player1,g);
		if(teacher.next_box((int)(9*100+simple_updat),4*100,(int)(11*100+simple_updat),3*100,player1,1))
			teacher_talk_ct=1;
		if(teacher.next_box((int)(26*100+simple_updat),5*100,(int)(28*100+simple_updat),4*100,player1,1))
			teacher_talk_ct=2;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
