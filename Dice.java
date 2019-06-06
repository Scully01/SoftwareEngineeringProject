import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
public class Dice
{
   int n = -1;
   Board sl;
   boolean isBoard = true;
   boolean b = true;
   private static boolean isTrap = true;
   
   public void draw(Graphics g)
   {
	   g.setColor(Color.BLACK);
       g.drawRoundRect(500,400,45,45,10,10);
       g.setColor(Color.WHITE);
       g.fillRoundRect(501, 401, 44, 44, 10, 10);
       g.setColor(Color.red);
       if ( n == 1)
       {
          g.fillOval(520,420,5,5);
       }          
       else if ( n == 2 )
       {
          g.fillOval(510,420,5,5);
          g.fillOval(530,420,5,5);
       }          
       else if ( n == 3 )
       {
          g.fillOval(520,410,5,5);
          g.fillOval(510,430,5,5);
          g.fillOval(530,430,5,5);
       }          
       else if ( n == 4 )
       {
          g.fillOval(510,410,5,5);
          g.fillOval(530,410,5,5);
          g.fillOval(510,430,5,5);
          g.fillOval(530,430,5,5);
       }          
       else if ( n == 5 )
       {
          g.fillOval(510,410,5,5);
          g.fillOval(530,410,5,5);
          g.fillOval(520,420,5,5);
          g.fillOval(510,430,5,5);
          g.fillOval(530,430,5,5);
       }          
       else if ( n == 6 )
       {
          g.fillOval(510,410,5,5);
          g.fillOval(530,410,5,5);
          g.fillOval(510,420,5,5);
          g.fillOval(530,420,5,5);
          g.fillOval(510,430,5,5);
          g.fillOval(530,430,5,5);
       }          
   }

   public Dice(Board sl)
   {
      this.sl = sl;
   }
   public Dice() {
	   isBoard =false;
   }

   public int roll()
   {
      int n = 0;
      for (int i=1; i<=20; i++) {
         n = (int) (Math.random()*6) + 1;
         set(n);
         try {
           Thread.sleep(100);
         }
         catch(Exception e) {}
      }
      return n;
   }
   public int roll(int playeri)
   {
	      int n = 0;
	      for (int i=1; i<=20; i++) {
	         n = (int) (Math.random()*6) + 1;
	         set(n);
	         try {
	           Thread.sleep(100);
	         }
	         catch(Exception e) {}
	      }
	  switch(playeri) {
	  case 1:
		  if(SLGame.player1Trap) {
			  n = 0;
			  JOptionPane.showMessageDialog(null,"Player " +playeri + " is trapped for 1 turn");
//			  SLGame.player1Trap = false;
		  }

		  break;
	  case 2:
		  if(SLGame.player2Trap) {
			  n = 0;
			  JOptionPane.showMessageDialog(null,"Player " +playeri + " is trapped for 1 turn");
//			  SLGame.player2Trap = false;
		  }
		  break;
	  case 3:
		  if(SLGame.player3Trap) {
			  n = 0;
			  JOptionPane.showMessageDialog(null,"Player " +playeri + " is trapped for 1 turn");
//			  SLGame.player3Trap = false;
		  }
		  break;
	  case 4:
		  if(SLGame.player4Trap) {
			  n = 0;
			  JOptionPane.showMessageDialog(null,"Player " +playeri + " is trapped for 1 turn");
//			  SLGame.player4Trap = false;
		  }
		  break;
	  default:
		  isTrap = false;
		  break;
	  }
	  
	  
	  
	  	  
      return n;
   }

   public int set(int val)
   {
      if ( val >= 1 && val <= 6)
         n = val;  
      else if (val < 1)
    	 n = 1;
      else n = 6;
      try {
          sl.repaint();  
      }catch(NullPointerException e) {
//    	  System.out.println("No board class: " + e);
      }

      return n;
   }
   static int getThrow() { return (int) (Math.random()*6) + 1;    }         
}