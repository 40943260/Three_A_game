package main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mosnter.eye_monster;


public class map4 extends simple_object implements ActionListener
{
	player player1;
	int simple_updat=0;
	public map4(player p1)
	{
		this.player1=p1;
		floor_2_0.setfoor(box_dat, box, "img/Ground Grass/box.png");
		test1 =new eye_monster(player1,18,0,1,1);

		grass_7x2.WIDTH=grass_7x2.WIDTH+30;
		grass_7x2.HEIGHT=grass_7x2.HEIGHT+20;
		grass_7x2.y=grass_7x2.y-20;
		grass_7x2.x=grass_7x2.x-25;
		//floor_2_0.setfoor(box_dat, box, "img/Ground Grass/box.png");
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

	static double dat_X;
	int map_long = 70*UNIT_SIZE;
	int map_long_dat=UNIT_SIZE*7;
	public void map_updat(double delta_time)
	{
		dat_X=player1.x;
		if(dat_X+player1.WIDTH>UNIT_SIZE*7 && map_long_dat<=map_long)
		{
			player1.x=dat_X-2;
			map_long_dat+=player1.run_speed*10;
			object_updat(delta_time,Grass);
			object_updat(delta_time,Grass2);
			object_updat(delta_time,Grass3);
			object_updat(delta_time,Grass4);
			object_updat(delta_time,Grass5);
			object_updat(delta_time,Grass6);
			object_updat(delta_time,Grass7);
			object_updat(delta_time,Grass8);
			object_updat(delta_time,Grass9);
			object_updat(delta_time,box);
			
			object_updat(delta_time,trap1);
			object_updat(delta_time,trap2);
			
			object_updat(delta_time,grass_7x2);
			object_updat(delta_time,grass_4x4);
			object_updat(delta_time,grass_4x6);
			object_updat(delta_time,grass_11x3);
			object_updat(delta_time,oppa8x2);
			object_updat(delta_time,test1);
			
		
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
	
	floor Grass=new floor(0,6,1,7,"img/Ground Grass/5.png");//x y h w 
	floor Grass2=new floor(9,4,1,4,"img/Ground Grass/5.png");//x y h w 
	floor Grass3=new floor(12,2,1,4,"img/Ground Grass/5.png");//x y h w 
	floor Grass4=new floor(15,5,1,11,"img/Ground Grass/5.png");//x y h w 
	floor Grass5=new floor(18,2,1,5,"img/Ground Grass/5.png");//x y h w 
	floor Grass6=new floor(27,7,1,7,"img/Ground Grass/5.png");//x y h w
	floor Grass7=new floor(36,3,1,7,"img/Ground Grass/5.png");//x y h w
	floor Grass8=new floor(41,6,1,7,"img/Ground Grass/5.png");//x y h w 
	floor Grass9=new floor(50,5,1,14,"img/Ground Grass/5.png");//x y h w
	floor_2_0 box[]=new floor_2_0[6];
	int box_dat[][]= {{27,4,1,1},{29,5,1,1},{31,3,1,1},{33,2,1,1},{54,0,2,8},{66,5,3,14}};
	trap trap1=new trap(15,4,1,11);
	trap trap2=new trap(27,6,1,7);
	public void draw(double delta_time,Graphics g)
	{

		player1.gravity_ct=true;
		player1.R_stop=false;
		player1.L_stop=false;
		player1.U_stop=false;
		map_updat(delta_time);

	
		Grass.drawFloor(player1, g);
		Grass2.drawFloor(player1, g);
		Grass3.drawFloor(player1, g);
		Grass4.drawFloor(player1, g);
		Grass5.drawFloor(player1, g);
		Grass6.drawFloor(player1, g);
		Grass7.drawFloor(player1, g);
		Grass8.drawFloor(player1, g);
		Grass9.drawFloor(player1, g);

		floor_2_0.drawfoor(box,player1,g);


		simple_draw(g);
		trap1.draw_trap(player1, g);
		trap2.draw_trap(player1, g);
		player1.move(delta_time,g);
		drawNpc(g);
		drawMs(delta_time,g);
		drawAuxiliary_line(g);
		System.out.println(map_long_dat);
	}
	public void simple_draw(Graphics g)
	{
		drawFloor(g);
	}
	simple_drawing oppa8x2=new simple_drawing(54,0,2,8,"img/bkimg/2x8oppa.png");
	simple_drawing grass_7x2=new simple_drawing(0,6,2,7,"img/bkimg/7x2grass.png");
	simple_drawing grass_4x4=new simple_drawing(9,4,4,4,"img/bkimg/4x4grass.png");
	simple_drawing grass_4x6=new simple_drawing(12,2,6,4,"img/bkimg/4x6Grass.png");
	simple_drawing grass_11x3=new simple_drawing(15,5,3,11,"img/bkimg/11x3grass.png");
	public void drawFloor(Graphics g)
	{	
		oppa8x2.draw(g);

		grass_7x2.draw(g);
		grass_4x6.draw(g);
		grass_4x4.draw(g);
		grass_11x3.draw(g);
	} 

	eye_monster test1 ;
	void drawMs(double delta_time,Graphics g)
	{
		test1.gravity_ct=true;
		Grass5.floor_Collision(test1);
		Grass4.floor_Collision(test1);
		Grass6.floor_Collision(test1);
		Grass3.floor_Collision(test1);
		test1.monsterMove(delta_time,g);
	}

	void drawNpc(Graphics g)
	{
		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
