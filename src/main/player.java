package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class player extends simple_object implements ImageObserver
{
		String fire_bgm = "gamemusic/RPG Voice Starter Pack/Type 1/attackok.wav";
		String damged_bgm = "gamemusic/RPG Voice Starter Pack/Type 1/damgeok.wav";
		public int life =10;
		public boolean Invincible = false;
		public BufferedImage[] LSubImg = new  BufferedImage[6];
		public BufferedImage[] RSubImg = new  BufferedImage[6];
		public BufferedImage[] MSubImg = new  BufferedImage[8];
		public BufferedImage[] NSubImg = new  BufferedImage[8];
		playerJump moveJump;
		protected player(int reference_x,int reference_y,int reference_HEIGHT,int reference_WIDTH)
		{
			super(reference_x,reference_y,reference_HEIGHT,reference_WIDTH);
			cut_img("cute/L.png",6,LSubImg );
			cut_img("cute/R.png",6,RSubImg );
			cut_img("cute/M.png",8,MSubImg );
			cut_img("cute/N.png",8,NSubImg);
			cut_attack(attackImg,"fireball_blue.png");
			cut_attack(attackImg2,"oppoFire.png");
			cut_energy(energyimg,"img/rad-rainbow-lifebar.png");
	
		}
		

	
	    
		public void draw_gameplaer(BufferedImage SubImg[],int Sprite_ct,Graphics g) 
		{
			drawimg(SubImg[Sprite_ct],g);
		}
		
		public int level=0;
		int RL_anmation_ct=0;
		int N_anmation_ct=0;
		public long anmation_time = System.currentTimeMillis();
		public int admation_delay = 80;
		public   double run_speed=5;
	

		public boolean R=false;
		public boolean L=false;
		public boolean  RN=false;
		public boolean  LN=true;
		public boolean U=false;

		
		public boolean R_stop=false;
		public boolean L_stop=false;

		public double y_dat=0;
		public boolean jump_flag=false;

		public long  move_time= System.currentTimeMillis();
		public long  move_time_updat= 0;
		
		public void moveleft(double delta_time)
		{
			if(!L_stop)
			{
				if(System.currentTimeMillis()-move_time>=move_time_updat)
				{
					move_time=System.currentTimeMillis();
					x=x-run_speed/10*delta_time;
				}
			}
		}
		public void moveRIGHT(double delta_time)
		{
			if(!R_stop)
				if(System.currentTimeMillis()-move_time>=move_time_updat)
				{
					move_time=System.currentTimeMillis();
					x=x+run_speed/10*delta_time;
				}
		}
		boolean jump_start=false;
		public long  jump_move_time2= System.currentTimeMillis();
		public long  jump_move_time_updat2= 250;
		public void movejump(double delta_time)
		{
			if(jump_start)
			{
				if(U_stop)
				{
					jump_start=false;
				}
				y=y-run_speed*delta_time/3;
				if(System.currentTimeMillis()-jump_move_time2>=jump_move_time_updat2)
				{
					jump_start=false;
					jump_move_time2=System.currentTimeMillis();
				}
			}
		}

		public void move(double delta_time,Graphics g)
		{

			draw_heat(g);
			attack(g);
			if(L==true )
			{
				moveleft(delta_time);
				draw_gameplaer(LSubImg,RL_anmation_ct,g); 
			}
			if(R==true)
			{
				moveRIGHT(delta_time);
				draw_gameplaer(RSubImg,RL_anmation_ct,g); 
			}
			if(LN==true )
			{
				draw_gameplaer(NSubImg,N_anmation_ct,g); 
			}
			if(RN==true )
			{
				draw_gameplaer(MSubImg,N_anmation_ct,g); 
			}
			if(U == true)
			{
				if(jump_flag==false)
				{
					jump_move_time2=System.currentTimeMillis();
					jump_start=true;
					jump_flag=true;
				}
			}	
			movejump(delta_time);
			gravity(delta_time);

			if(System.currentTimeMillis()-anmation_time >= admation_delay)
			{
				RL_anmation_ct+=1;
				N_anmation_ct+=1;
				anmation_time=System.currentTimeMillis();
				RL_anmation_ct=RL_anmation_ct%5;
				N_anmation_ct=N_anmation_ct%7;
			}

		}
		
	
		
		public boolean gravity_ct=false;
		public   double down_speed=5;
		public long  gravity_time= System.currentTimeMillis();//限制多久更新
		public long  gravity_time2= System.currentTimeMillis();//算地心引力
		public long  gravity_time_updat= 10;
		public  double g=9.8;
		public boolean gravity_flag=true;
		public void gravity(double delta_time)//重力是否開啟 
		{
			if(gravity_ct)
			{
				if(gravity_flag)//第一次瞬間要計入時間 拿來算 重利
				{
					gravity_time2= System.currentTimeMillis();
					gravity_flag=false;
				}
				if(System.currentTimeMillis()-gravity_time>=gravity_time_updat)
				{
					gravity_time=System.currentTimeMillis();
					if(!jump_start)
						y=y+(down_speed+delta_time/10*g*(System.currentTimeMillis()-gravity_time2)/1000.0)*delta_time/10.0;
				}
			}
			else
			{
				gravity_flag=true;
			}
		}
	


		boolean U_stop=false;
		public BufferedImage[] energyimg = new  BufferedImage[7];
		public void cut_energy( BufferedImage img[],String Sprite)
		{
				int how_much_move_y = 7;
				BufferedImage gameplaer =null;
				String path = "/"+Sprite;
				URL image_path=getClass().getResource(path);
				try 
				{
					gameplaer = ImageIO.read(image_path);
				} 
				catch (IOException e){}

				int tHeight = gameplaer.getHeight();
				int eWidth = gameplaer.getWidth();
				int eHeight=tHeight/how_much_move_y;
				int ct=0;
				for(int i=0;i<how_much_move_y;i++)
				{
					img[ct] =  gameplaer.getSubimage(0, i*eHeight, eWidth, eHeight);
					ct+=1;
				}
		}
		int energy_Ct;
		int life_dat=life;
		Image heat= new ImageIcon(ClassLoader.getSystemResource("cute/heart.png")).getImage();	
		public void draw_heat(Graphics g)//畫剩餘血量
		{
			if(life_dat!=life)
			{
				life_dat=life;
			    music_player player2 = new music_player(damged_bgm);
			    player2.start(); 
			}
			
			for(int i=0;i<life;i++)
			{
				g.drawImage(heat,i*30 , 0,30,30,this);
			}
		}
		public BufferedImage[] attackImg = new  BufferedImage[40];
		public BufferedImage[] attackImg2 = new  BufferedImage[40];
		public void cut_attack( BufferedImage img[],String Sprite)
		{
				int how_much_move_y = 10;
				int how_much_move_x = 4;
				BufferedImage gameplaer =null;
				String path = "/cute/"+Sprite;
				URL image_path=getClass().getResource(path);
				try 
				{
					gameplaer = ImageIO.read(image_path);
				} 
				catch (IOException e){}

				int tWidth = gameplaer.getWidth();
				int tHeight = gameplaer.getHeight();
				int eWidth=tWidth/how_much_move_x;
				int eHeight=tHeight/how_much_move_y;
				int ct=0;
				for(int i=0;i<how_much_move_y;i++)
					for(int j=0;j<how_much_move_x;j++)
					{
						img[ct] =  gameplaer.getSubimage(j*eWidth, i*eHeight, eWidth, eHeight);
						ct+=1;
					}
		}
		public boolean attack=false;
		public boolean attackct=false;
		long attack_time= System.currentTimeMillis();
		long attack_update=30;
		long attack_time2= System.currentTimeMillis();
		long attack_update2=1200;
		int attack_animation=0;
		int fire_x;
		int fire_y;
		int fire_W=UNIT_SIZE;
		int fire_H=UNIT_SIZE;
		int fire_speed=20;
		String rl_ct;
		public void attack(Graphics g)
		{
			if(attack && !attackct)
			{
				attack_animation=0;
				fire_y=(int)y;
				fire_x=(int)x+100;
				attackct=true;
				attack_time2= System.currentTimeMillis();
			    music_player player1 = new music_player(fire_bgm);
			    player1.start(); 
				if(RN==true || R==true )
					 rl_ct="R";
				else
					 rl_ct="L";
			}
			if(attackct)
			{
				if(rl_ct=="R")
					g.drawImage(attackImg[attack_animation],fire_x , fire_y,fire_W,fire_H,this);
				else
					g.drawImage(attackImg2[attack_animation],fire_x , fire_y,fire_W,fire_H,this);
				if(System.currentTimeMillis() - attack_time>=attack_update)
				{
					attack_time=System.currentTimeMillis();
					attack_animation=(attack_animation+1)%40;
					if(rl_ct=="R")
						fire_x=fire_x+fire_speed;
					else
						fire_x=fire_x-fire_speed;
				}
				if(System.currentTimeMillis()-attack_time2>=attack_update2)
				{
					attack_time2=System.currentTimeMillis();
					attack=false;
					attackct=false;
					fire_y=0;
					fire_x=0;
				}
			}
		}
		public long Invincible_ct=System.currentTimeMillis();
		public int Invincible_delay = 500;
		public void Collision(player ms)
		{
			if(Collision(fire_x,fire_y,fire_H,fire_W,(int)ms.x,(int)ms.y,ms.height,ms.width))
			{
				if(!ms.Invincible)
				{
					ms.life=ms.life-1;
					ms.Invincible=true;
				}
				if(System.currentTimeMillis()-Invincible_ct>=Invincible_delay && ms.Invincible==true)
				{
					ms.Invincible=false;
					Invincible_ct=System.currentTimeMillis();
				}

			}
		}
		@Override
		public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			return false;
		}
}