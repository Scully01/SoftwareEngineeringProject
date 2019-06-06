import java.util.Random;

public class Snake
{
   private int head;
   private int tail;
   private int red;
   private int green;
   private int blue;
   public Snake(int h, int t)
   {
       head = h;
       tail = t;

   }
   public int getRed() {
	   return red;
   }
   public int getGreen() {
	   return green;
   }
   public int getBlue() {
	   return blue;
   }
   public int getHead() { return head; }
   public int getTail() { return tail; } 
}
