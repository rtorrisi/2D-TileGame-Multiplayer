package dev.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import dev.tilegame.Game;

//standard size 256x256
public class Assets implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int sWidth=Game.grid, sHeight=Game.grid;
	
	public static void init(){
		
		menuImage = ImageLoader.loadImage("/textures/menu.png");
		playImage = ImageLoader.loadImage("/textures/menu_play.png");
		settingImage = ImageLoader.loadImage("/textures/menu_setting.png");
		creditsImage = ImageLoader.loadImage("/textures/menu_credits.png");
		
		//PLAYER #########################		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		pg_idle = new BufferedImage[1];
		pg_idle[0] = sheet.crop(0, sHeight*2, sWidth, sHeight);
		
		pg_front = new BufferedImage[9];
		pg_front[0] = sheet.crop(0, sHeight*10, sWidth, sHeight);
		pg_front[1] = sheet.crop(sWidth, sHeight*10, sWidth, sHeight);
		pg_front[2] = sheet.crop(sWidth*2, sHeight*10, sWidth, sHeight);
		pg_front[3] = sheet.crop(sWidth*3, sHeight*10, sWidth, sHeight);
		pg_front[4] = sheet.crop(sWidth*4, sHeight*10, sWidth, sHeight);
		pg_front[5] = sheet.crop(sWidth*5, sHeight*10, sWidth, sHeight);
		pg_front[6] = sheet.crop(sWidth*6, sHeight*10, sWidth, sHeight);
		pg_front[7] = sheet.crop(sWidth*7, sHeight*10, sWidth, sHeight);
		pg_front[8] = sheet.crop(sWidth*8, sHeight*10, sWidth, sHeight);
		
		pg_right = new BufferedImage[9];
		pg_right[0] = sheet.crop(0, sHeight*11, sWidth, sHeight);
		pg_right[1] = sheet.crop(sWidth, sHeight*11, sWidth, sHeight);
		pg_right[2] = sheet.crop(sWidth*2, sHeight*11, sWidth, sHeight);
		pg_right[3] = sheet.crop(sWidth*3, sHeight*11, sWidth, sHeight);
		pg_right[4] = sheet.crop(sWidth*4, sHeight*11, sWidth, sHeight);
		pg_right[5] = sheet.crop(sWidth*5, sHeight*11, sWidth, sHeight);
		pg_right[6] = sheet.crop(sWidth*6, sHeight*11, sWidth, sHeight);
		pg_right[7] = sheet.crop(sWidth*7, sHeight*11, sWidth, sHeight);
		pg_right[8] = sheet.crop(sWidth*8, sHeight*11, sWidth, sHeight);
		
		pg_back = new BufferedImage[9];
		pg_back[0] = sheet.crop(0, sHeight*8, sWidth, sHeight);
		pg_back[1] = sheet.crop(sWidth, sHeight*8, sWidth, sHeight);
		pg_back[2] = sheet.crop(sWidth*2, sHeight*8, sWidth, sHeight);
		pg_back[3] = sheet.crop(sWidth*3, sHeight*8, sWidth, sHeight);
		pg_back[4] = sheet.crop(sWidth*4, sHeight*8, sWidth, sHeight);
		pg_back[5] = sheet.crop(sWidth*5, sHeight*8, sWidth, sHeight);
		pg_back[6] = sheet.crop(sWidth*6, sHeight*8, sWidth, sHeight);
		pg_back[7] = sheet.crop(sWidth*7, sHeight*8, sWidth, sHeight);
		pg_back[8] = sheet.crop(sWidth*8, sHeight*8, sWidth, sHeight);
		
		pg_left = new BufferedImage[9];
		pg_left[0] = sheet.crop(0, sHeight*9, sWidth, sHeight);
		pg_left[1] = sheet.crop(sWidth, sHeight*9, sWidth, sHeight);
		pg_left[2] = sheet.crop(sWidth*2, sHeight*9, sWidth, sHeight);
		pg_left[3] = sheet.crop(sWidth*3, sHeight*9, sWidth, sHeight);
		pg_left[4] = sheet.crop(sWidth*4, sHeight*9, sWidth, sHeight);
		pg_left[5] = sheet.crop(sWidth*5, sHeight*9, sWidth, sHeight);
		pg_left[6] = sheet.crop(sWidth*6, sHeight*9, sWidth, sHeight);
		pg_left[7] = sheet.crop(sWidth*7, sHeight*9, sWidth, sHeight);
		pg_left[8] = sheet.crop(sWidth*8, sHeight*9, sWidth, sHeight);

		
		//PG2		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player2.png"));
		pg2_idle = new BufferedImage[1];
		pg2_idle[0] = sheet.crop(0, sHeight*2, sWidth, sHeight);
		
		pg2_front = new BufferedImage[9];
		pg2_front[0] = sheet.crop(0, sHeight*10, sWidth, sHeight);
		pg2_front[1] = sheet.crop(sWidth, sHeight*10, sWidth, sHeight);
		pg2_front[2] = sheet.crop(sWidth*2, sHeight*10, sWidth, sHeight);
		pg2_front[3] = sheet.crop(sWidth*3, sHeight*10, sWidth, sHeight);
		pg2_front[4] = sheet.crop(sWidth*4, sHeight*10, sWidth, sHeight);
		pg2_front[5] = sheet.crop(sWidth*5, sHeight*10, sWidth, sHeight);
		pg2_front[6] = sheet.crop(sWidth*6, sHeight*10, sWidth, sHeight);
		pg2_front[7] = sheet.crop(sWidth*7, sHeight*10, sWidth, sHeight);
		pg2_front[8] = sheet.crop(sWidth*8, sHeight*10, sWidth, sHeight);
		
		pg2_right = new BufferedImage[9];
		pg2_right[0] = sheet.crop(0, sHeight*11, sWidth, sHeight);
		pg2_right[1] = sheet.crop(sWidth, sHeight*11, sWidth, sHeight);
		pg2_right[2] = sheet.crop(sWidth*2, sHeight*11, sWidth, sHeight);
		pg2_right[3] = sheet.crop(sWidth*3, sHeight*11, sWidth, sHeight);
		pg2_right[4] = sheet.crop(sWidth*4, sHeight*11, sWidth, sHeight);
		pg2_right[5] = sheet.crop(sWidth*5, sHeight*11, sWidth, sHeight);
		pg2_right[6] = sheet.crop(sWidth*6, sHeight*11, sWidth, sHeight);
		pg2_right[7] = sheet.crop(sWidth*7, sHeight*11, sWidth, sHeight);
		pg2_right[8] = sheet.crop(sWidth*8, sHeight*11, sWidth, sHeight);
		
		pg2_back = new BufferedImage[9];
		pg2_back[0] = sheet.crop(0, sHeight*8, sWidth, sHeight);
		pg2_back[1] = sheet.crop(sWidth, sHeight*8, sWidth, sHeight);
		pg2_back[2] = sheet.crop(sWidth*2, sHeight*8, sWidth, sHeight);
		pg2_back[3] = sheet.crop(sWidth*3, sHeight*8, sWidth, sHeight);
		pg2_back[4] = sheet.crop(sWidth*4, sHeight*8, sWidth, sHeight);
		pg2_back[5] = sheet.crop(sWidth*5, sHeight*8, sWidth, sHeight);
		pg2_back[6] = sheet.crop(sWidth*6, sHeight*8, sWidth, sHeight);
		pg2_back[7] = sheet.crop(sWidth*7, sHeight*8, sWidth, sHeight);
		pg2_back[8] = sheet.crop(sWidth*8, sHeight*8, sWidth, sHeight);
		
		pg2_left = new BufferedImage[9];
		pg2_left[0] = sheet.crop(0, sHeight*9, sWidth, sHeight);
		pg2_left[1] = sheet.crop(sWidth, sHeight*9, sWidth, sHeight);
		pg2_left[2] = sheet.crop(sWidth*2, sHeight*9, sWidth, sHeight);
		pg2_left[3] = sheet.crop(sWidth*3, sHeight*9, sWidth, sHeight);
		pg2_left[4] = sheet.crop(sWidth*4, sHeight*9, sWidth, sHeight);
		pg2_left[5] = sheet.crop(sWidth*5, sHeight*9, sWidth, sHeight);
		pg2_left[6] = sheet.crop(sWidth*6, sHeight*9, sWidth, sHeight);
		pg2_left[7] = sheet.crop(sWidth*7, sHeight*9, sWidth, sHeight);
		pg2_left[8] = sheet.crop(sWidth*8, sHeight*9, sWidth, sHeight);
		
		//TILE #########################
	//PAGE 1
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/page1.png"));
		a1 = sheet.crop(0, 0, sWidth, sHeight); tileList.add(a1);
		a2 = sheet.crop(sWidth, 0, sWidth, sHeight); tileList.add(a2);
		a3 = sheet.crop(sWidth*2, 0, sWidth, sHeight); tileList.add(a3);
		a4 = sheet.crop(sWidth*3, 0, sWidth, sHeight); tileList.add(a4);
		a5 = sheet.crop(sWidth*4, 0, sWidth, sHeight); tileList.add(a5);
		a6 = sheet.crop(sWidth*5, 0, sWidth, sHeight); tileList.add(a6);
		
		a7 = sheet.crop(0, sHeight, sWidth, sHeight); tileList.add(a7);
		a8 = sheet.crop(sWidth, sHeight, sWidth, sHeight); tileList.add(a8);
		a9 = sheet.crop(sWidth*2, sHeight, sWidth, sHeight); tileList.add(a9);
		a10 = sheet.crop(sWidth*3, sHeight, sWidth, sHeight); tileList.add(a10);
		a11 = sheet.crop(sWidth*4, sHeight, sWidth, sHeight); tileList.add(a11);
		a12 = sheet.crop(sWidth*5, sHeight, sWidth, sHeight); tileList.add(a12);
		
		a13 = sheet.crop(0, sHeight*2, sWidth, sHeight); tileList.add(a13);
		a14 = sheet.crop(sWidth, sHeight*2, sWidth, sHeight); tileList.add(a14);
		a15 = sheet.crop(sWidth*2, sHeight*2, sWidth, sHeight); tileList.add(a15);
		a16 = sheet.crop(sWidth*3, sHeight*2, sWidth, sHeight); tileList.add(a16);
		a17 = sheet.crop(sWidth*4, sHeight*2, sWidth, sHeight); tileList.add(a17);
		a18 = sheet.crop(sWidth*5, sHeight*2, sWidth, sHeight); tileList.add(a18);
		 
		a19 = sheet.crop(0, sHeight*3, sWidth, sHeight); tileList.add(a19);
		a20 = sheet.crop(sWidth, sHeight*3, sWidth, sHeight); tileList.add(a20);
		a21 = sheet.crop(sWidth*2, sHeight*3, sWidth, sHeight); tileList.add(a21);
		a22 = sheet.crop(sWidth*3, sHeight*3, sWidth, sHeight); tileList.add(a22);
		a23 = sheet.crop(sWidth*4, sHeight*3, sWidth, sHeight); tileList.add(a23);
		a24 = sheet.crop(sWidth*5, sHeight*3, sWidth, sHeight); tileList.add(a24);
		
		a25 = sheet.crop(0, sHeight*4, sWidth, sHeight); tileList.add(a25);
		a26 = sheet.crop(sWidth, sHeight*4, sWidth, sHeight); tileList.add(a26);
		a27 = sheet.crop(sWidth*2, sHeight*4, sWidth, sHeight); tileList.add(a27);
		a28 = sheet.crop(sWidth*3, sHeight*4, sWidth, sHeight); tileList.add(a28);
		a29 = sheet.crop(sWidth*4, sHeight*4, sWidth, sHeight); tileList.add(a29);
		a30 = sheet.crop(sWidth*5, sHeight*4, sWidth, sHeight); tileList.add(a30);
		 
		a31 = sheet.crop(0, sHeight*5, sWidth, sHeight); tileList.add(a31);
		a32 = sheet.crop(sWidth, sHeight*5, sWidth, sHeight); tileList.add(a32);
		a33 = sheet.crop(sWidth*2, sHeight*5, sWidth, sHeight); tileList.add(a33);
		a34 = sheet.crop(sWidth*3, sHeight*5, sWidth, sHeight); tileList.add(a34);
		a35 = sheet.crop(sWidth*4, sHeight*5, sWidth, sHeight); tileList.add(a35);
		a36 = sheet.crop(sWidth*5, sHeight*5, sWidth, sHeight); tileList.add(a36);
		
		a37 = sheet.crop(0, sHeight*6, sWidth, sHeight); tileList.add(a37);
		a38 = sheet.crop(sWidth, sHeight*6, sWidth, sHeight); tileList.add(a38);
		a39 = sheet.crop(sWidth*2, sHeight*6, sWidth, sHeight); tileList.add(a39);
		a40 = sheet.crop(sWidth*3, sHeight*6, sWidth, sHeight); tileList.add(a40);
		a41 = sheet.crop(sWidth*4, sHeight*6, sWidth, sHeight); tileList.add(a41);
		a42 = sheet.crop(sWidth*5, sHeight*6, sWidth, sHeight); tileList.add(a42);
		
		a43 = sheet.crop(0, sHeight*7, sWidth, sHeight); tileList.add(a43);
		a44 = sheet.crop(sWidth, sHeight*7, sWidth, sHeight); tileList.add(a44);
		a45 = sheet.crop(sWidth*2, sHeight*7, sWidth, sHeight); tileList.add(a45);
		a46 = sheet.crop(sWidth*3, sHeight*7, sWidth, sHeight); tileList.add(a46);
		a47 = sheet.crop(sWidth*4, sHeight*7, sWidth, sHeight); tileList.add(a47);
		a48 = sheet.crop(sWidth*5, sHeight*7, sWidth, sHeight); tileList.add(a48);
		
		a49 = sheet.crop(0, sHeight*8, sWidth, sHeight); tileList.add(a49);
		a50 = sheet.crop(sWidth, sHeight*8, sWidth, sHeight); tileList.add(a50);
		a51 = sheet.crop(sWidth*2, sHeight*8, sWidth, sHeight); tileList.add(a51);
		a52 = sheet.crop(sWidth*3, sHeight*8, sWidth, sHeight); tileList.add(a52);
		a53 = sheet.crop(sWidth*4, sHeight*8, sWidth, sHeight); tileList.add(a53);
		a54 = sheet.crop(sWidth*5, sHeight*8, sWidth, sHeight); tileList.add(a54);
		
		a55 = sheet.crop(0, sHeight*9, sWidth, sHeight); tileList.add(a55);
		a56 = sheet.crop(sWidth, sHeight*9, sWidth, sHeight); tileList.add(a56);
		a57= sheet.crop(sWidth*2, sHeight*9, sWidth, sHeight); tileList.add(a57);
		a58 = sheet.crop(sWidth*3, sHeight*9, sWidth, sHeight); tileList.add(a58);
		a59 = sheet.crop(sWidth*4, sHeight*9, sWidth, sHeight); tileList.add(a59);
		a60 = sheet.crop(sWidth*5, sHeight*9, sWidth, sHeight); tileList.add(a60);
		 
		a61 = sheet.crop(0, sHeight*10, sWidth, sHeight); tileList.add(a61);
		a62 = sheet.crop(sWidth, sHeight*10, sWidth, sHeight); tileList.add(a62);
		a63 = sheet.crop(sWidth*2, sHeight*10, sWidth, sHeight); tileList.add(a63);
		a64 = sheet.crop(sWidth*3, sHeight*10, sWidth, sHeight); tileList.add(a64);
		a65 = sheet.crop(sWidth*4, sHeight*10, sWidth, sHeight); tileList.add(a65);
		a66 = sheet.crop(sWidth*5, sHeight*10, sWidth, sHeight); tileList.add(a66);
 
		a67 = sheet.crop(0, sHeight*11, sWidth, sHeight); tileList.add(a67);
		a68 = sheet.crop(sWidth, sHeight*11, sWidth, sHeight); tileList.add(a68);
		a69 = sheet.crop(sWidth*2, sHeight*11, sWidth, sHeight); tileList.add(a69);
		a70 = sheet.crop(sWidth*3, sHeight*11, sWidth, sHeight); tileList.add(a70);
		a71 = sheet.crop(sWidth*4, sHeight*11, sWidth, sHeight); tileList.add(a71);
		a72 = sheet.crop(sWidth*5, sHeight*11, sWidth, sHeight); tileList.add(a72);
		
	//PAGE 2
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/page2.png"));
		b1 = sheet.crop(0, 0, sWidth, sHeight); tileList.add(b1);
		b2 = sheet.crop(sWidth, 0, sWidth, sHeight); tileList.add(b2);
		b3 = sheet.crop(sWidth*2, 0, sWidth, sHeight); tileList.add(b3);
		b4 = sheet.crop(sWidth*3, 0, sWidth, sHeight); tileList.add(b4);
		b5 = sheet.crop(sWidth*4, 0, sWidth, sHeight); tileList.add(b5);
		b6 = sheet.crop(sWidth*5, 0, sWidth, sHeight); tileList.add(b6);
		
		b7 = sheet.crop(0, sHeight, sWidth, sHeight); tileList.add(b7);
		b8 = sheet.crop(sWidth, sHeight, sWidth, sHeight); tileList.add(b8);
		b9 = sheet.crop(sWidth*2, sHeight, sWidth, sHeight); tileList.add(b9);
		b10 = sheet.crop(sWidth*3, sHeight, sWidth, sHeight); tileList.add(b10);
		b11 = sheet.crop(sWidth*4, sHeight, sWidth, sHeight); tileList.add(b11);
		b12 = sheet.crop(sWidth*5, sHeight, sWidth, sHeight); tileList.add(b12);
		
		b13 = sheet.crop(0, sHeight*2, sWidth, sHeight); tileList.add(b13);
		b14 = sheet.crop(sWidth, sHeight*2, sWidth, sHeight); tileList.add(b14);
		b15 = sheet.crop(sWidth*2, sHeight*2, sWidth, sHeight); tileList.add(b15);
		b16 = sheet.crop(sWidth*3, sHeight*2, sWidth, sHeight); tileList.add(b16);
		b17 = sheet.crop(sWidth*4, sHeight*2, sWidth, sHeight); tileList.add(b17);
		b18 = sheet.crop(sWidth*5, sHeight*2, sWidth, sHeight); tileList.add(b18);
		
		b19 = sheet.crop(0, sHeight*3, sWidth, sHeight); tileList.add(b19);
		b20 = sheet.crop(sWidth, sHeight*3, sWidth, sHeight); tileList.add(b10);
		b21 = sheet.crop(sWidth*2, sHeight*3, sWidth, sHeight); tileList.add(b21);
		b22 = sheet.crop(sWidth*3, sHeight*3, sWidth, sHeight); tileList.add(b22);
		b23 = sheet.crop(sWidth*4, sHeight*3, sWidth, sHeight); tileList.add(b23);
		b24 = sheet.crop(sWidth*5, sHeight*3, sWidth, sHeight); tileList.add(b24);
		
		b25 = sheet.crop(0, sHeight*4, sWidth, sHeight); tileList.add(b25);
		b26 = sheet.crop(sWidth, sHeight*4, sWidth, sHeight); tileList.add(b26);
		b27 = sheet.crop(sWidth*2, sHeight*4, sWidth, sHeight); tileList.add(b27);
		b28 = sheet.crop(sWidth*3, sHeight*4, sWidth, sHeight); tileList.add(b28);
		b29 = sheet.crop(sWidth*4, sHeight*4, sWidth, sHeight); tileList.add(b29);
		b30 = sheet.crop(sWidth*5, sHeight*4, sWidth, sHeight); tileList.add(b30);
		
		b31 = sheet.crop(0, sHeight*5, sWidth, sHeight); tileList.add(b31);
		b32 = sheet.crop(sWidth, sHeight*5, sWidth, sHeight); tileList.add(b32);
		b33 = sheet.crop(sWidth*2, sHeight*5, sWidth, sHeight); tileList.add(b33);
		b34 = sheet.crop(sWidth*3, sHeight*5, sWidth, sHeight); tileList.add(b34);
		b35 = sheet.crop(sWidth*4, sHeight*5, sWidth, sHeight); tileList.add(b35);
		b36 = sheet.crop(sWidth*5, sHeight*5, sWidth, sHeight); tileList.add(b36);
		
		b37 = sheet.crop(0, sHeight*6, sWidth, sHeight); tileList.add(b37);
		b38 = sheet.crop(sWidth, sHeight*6, sWidth, sHeight); tileList.add(b38);
		b39 = sheet.crop(sWidth*2, sHeight*6, sWidth, sHeight); tileList.add(b39);
		b40 = sheet.crop(sWidth*3, sHeight*6, sWidth, sHeight); tileList.add(b40);
		b41 = sheet.crop(sWidth*4, sHeight*6, sWidth, sHeight); tileList.add(b41);
		b42 = sheet.crop(sWidth*5, sHeight*6, sWidth, sHeight); tileList.add(b42);
		
		b43 = sheet.crop(0, sHeight*7, sWidth, sHeight); tileList.add(b43);
		b44 = sheet.crop(sWidth, sHeight*7, sWidth, sHeight); tileList.add(b44);
		b45 = sheet.crop(sWidth*2, sHeight*7, sWidth, sHeight); tileList.add(b45);
		b46 = sheet.crop(sWidth*3, sHeight*7, sWidth, sHeight); tileList.add(b46);
		b47 = sheet.crop(sWidth*4, sHeight*7, sWidth, sHeight); tileList.add(b47);
		b48 = sheet.crop(sWidth*5, sHeight*7, sWidth, sHeight); tileList.add(b48);
		 
		b49 = sheet.crop(0, sHeight*8, sWidth, sHeight); tileList.add(b49);
		b50 = sheet.crop(sWidth, sHeight*8, sWidth, sHeight); tileList.add(b50);
		b51 = sheet.crop(sWidth*2, sHeight*8, sWidth, sHeight); tileList.add(b51);
		b52 = sheet.crop(sWidth*3, sHeight*8, sWidth, sHeight); tileList.add(b52);
		b53 = sheet.crop(sWidth*4, sHeight*8, sWidth, sHeight); tileList.add(b53);
		b54 = sheet.crop(sWidth*5, sHeight*8, sWidth, sHeight); tileList.add(b54);
		 
		b55 = sheet.crop(0, sHeight*9, sWidth, sHeight); tileList.add(b55);
		b56 = sheet.crop(sWidth, sHeight*9, sWidth, sHeight); tileList.add(b56);
		b57= sheet.crop(sWidth*2, sHeight*9, sWidth, sHeight); tileList.add(b57);
		b58 = sheet.crop(sWidth*3, sHeight*9, sWidth, sHeight); tileList.add(b58);
		b59 = sheet.crop(sWidth*4, sHeight*9, sWidth, sHeight); tileList.add(b59);
		b60 = sheet.crop(sWidth*5, sHeight*9, sWidth, sHeight); tileList.add(b60);
		
		b61 = sheet.crop(0, sHeight*10, sWidth, sHeight); tileList.add(b61);
		b62 = sheet.crop(sWidth, sHeight*10, sWidth, sHeight); tileList.add(b62);
		b63 = sheet.crop(sWidth*2, sHeight*10, sWidth, sHeight); tileList.add(b63);
		b64 = sheet.crop(sWidth*3, sHeight*10, sWidth, sHeight); tileList.add(b64);
		b65 = sheet.crop(sWidth*4, sHeight*10, sWidth, sHeight); tileList.add(b65);
		b66 = sheet.crop(sWidth*5, sHeight*10, sWidth, sHeight); tileList.add(b66);

		b67 = sheet.crop(0, sHeight*11, sWidth, sHeight); tileList.add(b67);
		b68 = sheet.crop(sWidth, sHeight*11, sWidth, sHeight); tileList.add(b68);
		b69 = sheet.crop(sWidth*2, sHeight*11, sWidth, sHeight); tileList.add(b69);
		b70 = sheet.crop(sWidth*3, sHeight*11, sWidth, sHeight); tileList.add(b70);
		b71 = sheet.crop(sWidth*4, sHeight*11, sWidth, sHeight); tileList.add(b71);
		b72 = sheet.crop(sWidth*5, sHeight*11, sWidth, sHeight); tileList.add(b72);
		 
	//PAGE 3
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/page3.png"));
		c1 = sheet.crop(0, 0, sWidth, sHeight); itemList.add(c1);
		c2 = sheet.crop(sWidth, 0, sWidth, sHeight); itemList.add(c2);
		c3 = sheet.crop(sWidth*2, 0, sWidth, sHeight); itemList.add(c3);
		c4 = sheet.crop(sWidth*3, 0, sWidth, sHeight); itemList.add(c4);
		c5 = sheet.crop(sWidth*4, 0, sWidth, sHeight); itemList.add(c5);
		c6 = sheet.crop(sWidth*5, 0, sWidth, sHeight); itemList.add(c6);
			
		c7 = sheet.crop(0, sHeight, sWidth, sHeight); itemList.add(c7);
		c8 = sheet.crop(sWidth, sHeight, sWidth, sHeight); itemList.add(c8);
		c9 = sheet.crop(sWidth*2, sHeight, sWidth, sHeight); itemList.add(c9);
		c10 = sheet.crop(sWidth*3, sHeight, sWidth, sHeight); itemList.add(c10);
		c11 = sheet.crop(sWidth*4, sHeight, sWidth, sHeight); itemList.add(c11);
		c12 = sheet.crop(sWidth*5, sHeight, sWidth, sHeight); itemList.add(c12);
			
		c13 = sheet.crop(0, sHeight*2, sWidth, sHeight); itemList.add(c13);
		c14 = sheet.crop(sWidth, sHeight*2, sWidth, sHeight); itemList.add(c14);
		c15 = sheet.crop(sWidth*2, sHeight*2, sWidth, sHeight); itemList.add(c15);
		c16 = sheet.crop(sWidth*3, sHeight*2, sWidth, sHeight); itemList.add(c16);
		c17 = sheet.crop(sWidth*4, sHeight*2, sWidth, sHeight); itemList.add(c17);
		c18 = sheet.crop(sWidth*5, sHeight*2, sWidth, sHeight); itemList.add(c18);
				
		c19 = sheet.crop(0, sHeight*3, sWidth, sHeight); itemList.add(c19);
		c20 = sheet.crop(sWidth, sHeight*3, sWidth, sHeight); itemList.add(c20);
		c21 = sheet.crop(sWidth*2, sHeight*3, sWidth, sHeight); itemList.add(c21);
		c22 = sheet.crop(sWidth*3, sHeight*3, sWidth, sHeight); itemList.add(c22);
		c23 = sheet.crop(sWidth*4, sHeight*3, sWidth, sHeight); itemList.add(c23);
		c24 = sheet.crop(sWidth*5, sHeight*3, sWidth, sHeight); itemList.add(c24);
				
		c25 = sheet.crop(0, sHeight*4, sWidth, sHeight); itemList.add(c25);
		c26 = sheet.crop(sWidth, sHeight*4, sWidth, sHeight); itemList.add(c26);
		c27 = sheet.crop(sWidth*2, sHeight*4, sWidth, sHeight); itemList.add(c27);
		c28 = sheet.crop(sWidth*3, sHeight*4, sWidth, sHeight); itemList.add(c28);
		c29 = sheet.crop(sWidth*4, sHeight*4, sWidth, sHeight); itemList.add(c29);
		c30 = sheet.crop(sWidth*5, sHeight*4, sWidth, sHeight); itemList.add(c30);
				
		c31 = sheet.crop(0, sHeight*5, sWidth, sHeight); itemList.add(c31);
		c32 = sheet.crop(sWidth, sHeight*5, sWidth, sHeight); itemList.add(c32);
		c33 = sheet.crop(sWidth*2, sHeight*5, sWidth, sHeight); itemList.add(c33);
		c34 = sheet.crop(sWidth*3, sHeight*5, sWidth, sHeight); itemList.add(c34);
		c35 = sheet.crop(sWidth*4, sHeight*5, sWidth, sHeight); itemList.add(c35);
		c36 = sheet.crop(sWidth*5, sHeight*5, sWidth, sHeight); itemList.add(c36);
				
		c37 = sheet.crop(0, sHeight*6, sWidth, sHeight); itemList.add(c37);
		c38 = sheet.crop(sWidth, sHeight*6, sWidth, sHeight); itemList.add(c38);
		c39 = sheet.crop(sWidth*2, sHeight*6, sWidth, sHeight); itemList.add(c39);
		c40 = sheet.crop(sWidth*3, sHeight*6, sWidth, sHeight); itemList.add(c40);
		c41 = sheet.crop(sWidth*4, sHeight*6, sWidth, sHeight); itemList.add(c41);
		c42 = sheet.crop(sWidth*5, sHeight*6, sWidth, sHeight); itemList.add(c42);
				
		c43 = sheet.crop(0, sHeight*7, sWidth, sHeight); itemList.add(c43);
		c44 = sheet.crop(sWidth, sHeight*7, sWidth, sHeight); itemList.add(c44);
		c45 = sheet.crop(sWidth*2, sHeight*7, sWidth, sHeight); itemList.add(c45);
		c46 = sheet.crop(sWidth*3, sHeight*7, sWidth, sHeight); itemList.add(c46);
		c47 = sheet.crop(sWidth*4, sHeight*7, sWidth, sHeight); itemList.add(c47);
		c48 = sheet.crop(sWidth*5, sHeight*7, sWidth, sHeight); itemList.add(c48);
				
		c49 = sheet.crop(0, sHeight*8, sWidth, sHeight); itemList.add(c49);
		c50 = sheet.crop(sWidth, sHeight*8, sWidth, sHeight); itemList.add(c50);
		c51 = sheet.crop(sWidth*2, sHeight*8, sWidth, sHeight); itemList.add(c51);
		c52 = sheet.crop(sWidth*3, sHeight*8, sWidth, sHeight); itemList.add(c52);
		c53 = sheet.crop(sWidth*4, sHeight*8, sWidth, sHeight); itemList.add(c53);
		c54 = sheet.crop(sWidth*5, sHeight*8, sWidth, sHeight); itemList.add(c54);
				
		c55 = sheet.crop(0, sHeight*9, sWidth, sHeight); itemList.add(c55);
		c56 = sheet.crop(sWidth, sHeight*9, sWidth, sHeight); itemList.add(c56);
		c57= sheet.crop(sWidth*2, sHeight*9, sWidth, sHeight); itemList.add(c57);
		c58 = sheet.crop(sWidth*3, sHeight*9, sWidth, sHeight); itemList.add(c58);
		c59 = sheet.crop(sWidth*4, sHeight*9, sWidth, sHeight); itemList.add(c59);
		c60 = sheet.crop(sWidth*5, sHeight*9, sWidth, sHeight); itemList.add(c60);
				
		c61 = sheet.crop(0, sHeight*10, sWidth, sHeight); itemList.add(c61);
		c62 = sheet.crop(sWidth, sHeight*10, sWidth, sHeight); itemList.add(c62);
		c63 = sheet.crop(sWidth*2, sHeight*10, sWidth, sHeight); itemList.add(c63);
		c64 = sheet.crop(sWidth*3, sHeight*10, sWidth, sHeight); itemList.add(c64);
		c65 = sheet.crop(sWidth*4, sHeight*10, sWidth, sHeight); itemList.add(c65);
		c66 = sheet.crop(sWidth*5, sHeight*10, sWidth, sHeight); itemList.add(c66);

		c67 = sheet.crop(0, sHeight*11, sWidth, sHeight); itemList.add(c67);
		c68 = sheet.crop(sWidth, sHeight*11, sWidth, sHeight); itemList.add(c68);
		c69 = sheet.crop(sWidth*2, sHeight*11, sWidth, sHeight); itemList.add(c69);
		c70 = sheet.crop(sWidth*3, sHeight*11, sWidth, sHeight); itemList.add(c70);
		c71 = sheet.crop(sWidth*4, sHeight*11, sWidth, sHeight); itemList.add(c71);
		c72 = sheet.crop(sWidth*5, sHeight*11, sWidth, sHeight); itemList.add(c72);
	}
	
	public static int getWidth() { return sWidth; }
	public static int getHeight() { return sHeight; }
	

	//STATIC STUFF
	public static ArrayList<BufferedImage> tileList = new ArrayList<BufferedImage>();
	public static ArrayList<BufferedImage> itemList = new ArrayList<BufferedImage>();
	
	public static BufferedImage menuImage, playImage, settingImage, creditsImage;
	
	//PLAYER
	public static BufferedImage[] pg_idle, pg_front, pg_back, pg_left, pg_right;
	public static BufferedImage[] pg2_idle, pg2_front, pg2_back, pg2_left, pg2_right;
	
	//TILES
	public static BufferedImage a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12,
								a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24,
								a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36,
								a37, a38, a39, a40, a41, a42, a43, a44, a45, a46, a47, a48,
								a49, a50, a51, a52, a53, a54, a55, a56, a57, a58, a59, a60,
								a61, a62, a63, a64, a65, a66, a67, a68, a69, a70, a71, a72;
	
	public static BufferedImage b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12,
								b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24,
								b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36,
								b37, b38, b39, b40, b41, b42, b43, b44, b45, b46, b47, b48,
								b49, b50, b51, b52, b53, b54, b55, b56, b57, b58, b59, b60,
								b61, b62, b63, b64, b65, b66, b67, b68, b69, b70, b71, b72;
	
	public static BufferedImage c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12,
								c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24,
								c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36,
								c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48,
								c49, c50, c51, c52, c53, c54, c55, c56, c57, c58, c59, c60,
								c61, c62, c63, c64, c65, c66, c67, c68, c69, c70, c71, c72;
	
}
