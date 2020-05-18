package processing.test.androidgame;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AndroidGame extends PApplet {

int base = 40;
int x,y,i,gameScore=0;
int changeX=-5;
int changeY=-5;
int gameOver=0;
public void setup()
{

x=(int)random(width);
y=0;
background(255);
}

public void draw()
{
   if(gameOver==0)
   {
      background(255);
      fill(255,0,0);
      textSize(20);
      textAlign(CENTER);
      text("SCORE:"+gameScore+"00",width/2,height/2);
      fill(220);
      i=mouseX;
      rect(mouseX,height-base,200,base);
      ellipse(x,y,20,20);
      x=x+changeX;
      y=y+changeY;
      if(x<0 | x>width )
      {
        changeX=-changeX;
      }
      if( y< 0)
      {
         changeY=-changeY; 
      }
      if(y>height-base && y<height)
      {
          if(x<i+200 && x>i)
          {
             changeY=-changeY;
             gameScore++;
          }
          else
          {
               gameOver=1;
               gameScore=0;
          }
      }
   }
   else
   {
      background(200,200,255,10);
      fill(255,0,0);
      textSize(30);
      textAlign(CENTER);
      text("Game Over!",width/2,height/2);
      text("CLICK TO RESTART",width/2,height/2+30);
     
     
   }
  
}
  
  
 public void mousePressed()
 {
    if(x<mouseX+200 && x>mouseX && Y<height && y>height-base+5)
    {
        changeY=-changeY;
    }
    else if(gameOver==1 && mouseX<width/2+100 && mouseX>width/2-100 && mouseY >height/2-60 && mouseY<height/2+60)
    {
       gameScore=0;
       gameOver=0;
       x=(int)random(width);
       y=0;
    }
   
 }
  public void settings() { 
size(displayWidth,displayHeight); }
}
