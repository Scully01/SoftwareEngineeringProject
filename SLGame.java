import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;

public class SLGame {

	Snake snakes[] = new Snake[10];
	Ladder ladders[] = new Ladder[10];
	Trap traps[] = new Trap[10];
	String name[] = new String[4];
	int snakesCount = 0;
	int laddersCount = 0;
	int trapsCount = 0;
	
	public static boolean player1Trap = false;
	public static boolean player2Trap = false;
	public static boolean player3Trap = false;
	public static boolean player4Trap = false;

	public static int[] ladderBs = new int[10];
	public static int[] snakeHs = new int[10];
	public static int[] ladderTs = new int[10];
	public static int[] snakeTs = new int[10];
	
	public static int[] trapPos = new int[10];
	
	ArrayList<Integer> ghostSnakes = new ArrayList<Integer>();
	ArrayList<Integer> ghostLadders = new ArrayList<Integer>();

	public static int[] playerLocations = new int[4];
	public static boolean keyPressed = false;
	private int playerIterator = 0;

	enum status {
		PLAYER1, PLAYER2, PLAYER3, PLAYER4, PAUSE,
	}

	// Creating a Board, dice and a Scanner objects
	Board bd;
	Dice dice;
	Scanner scan;

	// If the design rules are not violated users must re-enter values
	public void setup(Board bd) {
		// Declaring variables to be used for random generation of pieces

		int trapL;

		int trapT;

		int snakeH;

		int snakeT;

		int ladderH;

		int ladderT;

		int choice = 0;

		// Creating a random number for each trap to be placed at the start of the game

		Random trapRandom = new Random();

		int trapR = trapRandom.nextInt(97) + 2;

		trapL = trapR;

		bd.add(new Trap(trapL, 1));
		trapPos[0] = trapL;
		trapRandom = new Random();

		trapR = trapRandom.nextInt(97) + 2;

		trapL = trapR;

		bd.add(new Trap(trapL, 1));
		trapPos[1] = trapL;
		trapRandom = new Random();

		trapR = trapRandom.nextInt(97) + 2;

		trapL = 16;
				//trapR;

		bd.add(new Trap(trapL, 1));
		trapPos[2] = trapL;
		// Creating random snake spawn locations for the head and the tail

		bd.add(new Snake(12, 8));
		snakeHs[0] = 12;
		snakeTs[0] = 8;
		bd.add(new Ladder(3, 40));
		ladderBs[0] = 40                                                                                                                                        ;
		ladderTs[0] = 3;

		Random snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;

		Random snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeHs[1] = snakeH;
		snakeTs[1] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;

		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeHs[2] = snakeH;
		snakeTs[2] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;
		snakeHs[3] = snakeH;

		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeTs[3] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;
		snakeHs[4] = snakeH;
		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeTs[4] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;
		snakeHs[5] = snakeH;
		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeTs[5] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;
		snakeHs[6] = snakeH;
		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeTs[6] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		snakeHRandom = new Random();

		snakeH = snakeHRandom.nextInt(98) + 1;
		snakeHs[7] = snakeH;
		snakeTRandom = new Random();

		snakeT = snakeTRandom.nextInt(98) + 1;
		snakeTs[7] = snakeT;
		if ((snakeH <= 10) || (snakeT >= 91))

		{
			ghostSnakes.add(snakeT
					
					);
		}

		else if (snakeH > snakeT)

		{

			bd.add(new Snake(snakeH, snakeT));

		}

		// Creating random ladder spawn locations for the head and the tail

		Random ladderHRandom = new Random();

		ladderH = ladderHRandom.nextInt(98) + 1;

		Random ladderTRandom = new Random();

		ladderT = ladderTRandom.nextInt(98) + 1;
		ladderBs[1] = ladderT;
		ladderTs[1] = ladderH;
		if ((ladderT <= 1) || (ladderH > 99))

		{
			ghostLadders.add(ladderT);
		}

		else if (ladderT > ladderH)

		{

			bd.add(new Ladder(ladderT, ladderH));

		}

		ladderHRandom = new Random();

		ladderH = ladderHRandom.nextInt(98) + 1;

		ladderTRandom = new Random();

		ladderT = ladderTRandom.nextInt(98) + 1;
		ladderBs[2] = ladderT;
		ladderTs[2] = ladderH;
		if ((ladderT <= 1) || (ladderH > 99))

		{
			ghostLadders.add(ladderT);
		}

		else if (ladderT > ladderH)

		{

			bd.add(new Ladder(ladderT, ladderH));

		}

		ladderHRandom = new Random();

		ladderH = ladderHRandom.nextInt(98) + 1;

		ladderTRandom = new Random();

		ladderT = ladderTRandom.nextInt(98) + 1;
		ladderBs[3] = ladderT;
		ladderTs[3] = ladderH;
		if ((ladderT <= 1) || (ladderH > 99))

		{
			ghostLadders.add(ladderT);
		}

		else if (ladderT > ladderH)

		{

			bd.add(new Ladder(ladderT, ladderH));

		}

		ladderHRandom = new Random();

		ladderH = ladderHRandom.nextInt(98) + 1;

		ladderTRandom = new Random();

		ladderT = ladderTRandom.nextInt(98) + 1;
		ladderBs[4] = ladderT;
		ladderTs[4] = ladderH;
		if ((ladderT <= 1) || (ladderH > 99))

		{
			ghostLadders.add(ladderT);
		}

		else if (ladderT > ladderH)

		{

			bd.add(new Ladder(ladderT, ladderH));

		}

	}

	// A method to print a message and to read an int value in the range specified
	int getInt(String message, int from, int to) {
		String s;
		int n = 0;
		boolean invalid;
		do {
			invalid = false;
			s = (String) JOptionPane.showInputDialog(bd, message, "Customized Dialog", JOptionPane.PLAIN_MESSAGE);
			try {
				n = Integer.parseInt(s);
				if (n < from || n > to)
					plainMessage("Re-enter: Input not in range " + from + " to " + to);
			} catch (NumberFormatException nfe) {
				plainMessage("Re-enter: Invalid number! ");
				invalid = true;
			}
		} while (invalid || n < from || n > to);
		return n;
	}

	// A method to print a message and to read a String
	String getString(String message) {
		String s;
		boolean noName;
		do {
			noName = false;
			s = (String) JOptionPane.showInputDialog(bd, message, "Enter Name", JOptionPane.PLAIN_MESSAGE);
			try {
				if (s == null)
					plainMessage("Re-enter: Name can't be Empty! ");
				} catch (Exception e1) {
					plainMessage("Invalid name! ");
				}
		}while (noName || s == null);
		return s;
	}

	// A method to print a message
	void plainMessage(String message) {
		JOptionPane.showMessageDialog(bd, message, "Message", JOptionPane.PLAIN_MESSAGE);
	}

	public void control() {
		
		int playernumber = getInt("Enter the number of players (2-4)", 2, 4);
		Board.playerCount = playernumber;
		String name1;
		String name2;
		String name3;
		String name4;
		
		do {
		name1 = getString("Player 1 name : ");
		name2 = getString("Player 2 name : ");
		name3 = "";
		name4 = "";
		if (playernumber > 2) {
			name3 = getString("Player 3 name : ");
			if (playernumber > 3) {
				name4 = getString("Player 4 name : ");
			}
		}
		} while(name1 == null || name2 == null || name3 == null || name4 == null);
		bd = new Board();
		dice = bd.getDice();
		scan = new Scanner(System.in);
		
		setup(bd); // setup method currently hard-codes the values

		bd.clearMessages(); // clears the display board

		bd.clearMessages();
		bd.addMessage("Current Players are");
		bd.addMessage("Player 1 : " + name1);
		bd.addMessage("Player 2 : " + name2);
		if (playernumber > 2) {
			bd.addMessage("Player 3 : " + name3);
			if (playernumber > 3) {
				bd.addMessage("Player 4 : " + name4);
			}
		}
		int p1Location = 1;
		int p2Location = 1;
		bd.setPiece(1, p1Location, 1, 0);
		bd.setPiece(2, p2Location, 1, 0);
		playerLocations[0] = p1Location;
		playerLocations[1] = p2Location;
		if (playernumber > 2) {
			playerLocations[2] = 1;
			if (playernumber > 3) {
				playerLocations[3] = 1;
			}
		}
		rollDice(bd);
		// plainMessage("The rest is up to you. You may have to introduce additional
		// variables.");

		// Complete the game logic
		// throwing or setting the dice
		// moving by dice value and showing the pieces at new position
		// moving up the ladder, going down the snake or being trapped (lose 3 moves)

//		bd.addMessage("Continue until");
//		bd.addMessage("a player gets to 100");
//		bd.addMessage("Danger: Traps,Snakes");
//		bd.addMessage("Trap: lose 3 moves");
	}

	// The very first method to be called
	// This method constructs a SLGame object and calls its control method
	public void rollDice(Board bd) {

		bd.setPiece(1, playerLocations[0], 1, 0);
		bd.setPiece(2, playerLocations[1], 1, 0);
		while (true) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (keyPressed == true) {
				rollPlayer(playerIterator + 1, playerLocations[playerIterator], 0);
				playerIterator++;
				if (playerIterator > Board.playerCount - 1) {
					playerIterator = 0;
				}
				keyPressed = false;
			}

		}

	}

	public void rollPlayer(int i, int loc, int rolled) {
		// bd.addMessage("Rolling Player " + i + " : " + loc);
		int roll = dice.roll(i);
		for (int j = 1; j <= 30; j++) {
			if (roll == 6) {
				roll += dice.roll();
			} else
				break;
		}
		if(loc + roll >100) {
			playerLocations[i - 1] = bd.setPiece(i, loc, rolled, 100-loc);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int diff = (100 - loc) - roll;
			playerLocations[i - 1] = bd.setPiece(i, 100, rolled, diff);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			playerLocations[i - 1] = bd.setPiece(i, loc, rolled, roll);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(playerLocations[i - 1] == 100) {
			JOptionPane.showMessageDialog(null,"Congratulations! Player " +i + " has won the game !!!");
			System.exit(0);
		}
		int co = checkPlayerPosition(i - 1, playerLocations[i - 1]);
	}

	public int checkPlayerPosition(int playeri, int location) {
		int ind = 0;
		boolean isCol = false;
		// 0 = no collision
		// 1 = snake head
		// 2 = ladder bottom
		// 3 = trap

		// check snake positions
		int tempSnakePos;
		for (int i = 0; i <= bd.snakesCount; i++) {
			tempSnakePos = snakeHs[i];
//			System.out.println("Player" + playeri + ": " + playerLocations[playeri] + " | Snake" + i + ": " + tempSnakePos);
			if (playerLocations[playeri] == tempSnakePos) {
				if (!(ghostSnakes.contains(tempSnakePos))) {
					isCol = true;
//					System.out.println("Snake collision: "+ tempSnakePos);					
					snakeCollision(i, playeri, playerLocations[playeri]);
				}
			} else {
			}
		}

		// check ladders
		if (!isCol) {

			int tempLadderPos;
			for (int i = 0; i <= bd.laddersCount; i++) {
				tempLadderPos = ladderTs[i];
//				System.out.println("Player" + playeri + ": " + playerLocations[playeri] + " | Ladder" + i + ": " + tempLadderPos);
				if (playerLocations[playeri] == tempLadderPos) {
					if(!(ghostLadders.contains(tempLadderPos))) {
						isCol = true;
//						System.out.println("Ladder collision: "+tempLadderPos);
						ladderCollision(i, playeri, playerLocations[playeri]);
					}
				} else {

				}
			}
			if (!isCol) {
				for(int i=0; i <= 3; i++) {
					if(playerLocations[playeri] == trapPos[i]) {
						switch(playeri + 1) {
						case 1:
							player1Trap = !player1Trap;
							break;
						case 2:
							player2Trap = !player2Trap;
							break;
						case 3:
							player3Trap = !player3Trap;
							break;
						case 4:
							player4Trap = !player4Trap;
							break;
						}
					}
				}
			}
		}

		return ind;
	}

	public char getSingular(String s) {
		char c = 'a';
		// determine length
		c = s.charAt(s.length() - 1);
		return c;
	}

	public void snakeCollision(int snakeIndex, int playerIndex, int position) {
		playerLocations[playerIndex] = bd.glide(playerIndex + 1, position, snakeTs[snakeIndex]);
	}

	public void ladderCollision(int ladderIndex, int playerIndex, int position) {
		playerLocations[playerIndex] = bd.glide(playerIndex + 1, position, ladderBs[ladderIndex]);
//		boolean topInverse = false;
//		boolean bottomInverse = false;
//		Integer bottom = position;
//		Integer top = ladderBs[ladderIndex];
//		String bottomString = bottom.toString();
//		String topString = top.toString();
//		char bottomChar = getSingular(bottomString);
//		char topChar = getSingular(topString);
//		System.out.println(bottomChar);
//		//check if inverse starting position
//		char b;
//		if(bottomString.length()<2) {
//			b = '0';
//		}else {
//			b = bottomString.charAt(0);
//		}
//		int bottomValue = Character.getNumericValue(bottomChar);
//		int bottomRow = 0;
//		if(bottomValue == 0) {
//			bottomRow = Character.getNumericValue(b)-1;
//		}else {
//			bottomRow = Character.getNumericValue(b);
//		}
//		if(bottomRow % 2 ==0) {
//			bottomInverse = false;
//		}else {
//			bottomInverse = true;
//		}
//
//		//get distance between top and bottom
//		int topRow = 0;
//		char t;
//		if(topString.length()<2) {
//			t = '0';
//		}else {
//			t = topString.charAt(0);
//		}
//		int topValue = Character.getNumericValue(topChar);
//		if(topValue == 0) {
//			topRow = Character.getNumericValue(t)-1;
//		}else {
//			topRow = Character.getNumericValue(t);
//		}
//		int rowDiff = t - b;
//		if(topRow % 2 ==0) {
//			topInverse = false;
//		}else {
//			topInverse = true;
//		}
//	
//		//check ladder direction (left/direct/right)
//		if(bottomInverse) {
//			if(bottomValue == 0) {
//				bottomValue = 10;
//			}
//			bottomValue = 11 - bottomValue;
//		}
//		if(topInverse) {
//			if(topValue == 0) {
//				topValue = 10;
//			}
//			topValue = 11 - topValue;
//		}
//		int pathLength;
//		int xLength;
//		int yLength = rowDiff;
//		
//		int dir = 0;
//		// 0 : straight
//		// 1 : left
//		// 2 : right
//		
//		// gradient formula: (y2 - y1)|(x2 - x1)
//		int gradient;		
//		if(topValue > bottomValue) {
//			//right
//			xLength = topValue - bottomValue;
//			pathLength = xLength + yLength;
//			dir = 2;
//		}else if(bottomValue > topValue){
//			//left
//			xLength = bottomValue - topValue;
//			pathLength = xLength + yLength;
//			dir = 1;
//		}else {
//			//straight
//			xLength = 0;
//			pathLength = xLength + yLength;
//		}
//		gradient = xLength / (yLength+1);
////		System.out.print("Gradient: " + gradient);
//		int limit = 0;
//		Integer tempValue = bottomValue;
//		Integer tempY = Character.getNumericValue(b);
//		int destValue = topValue;
//		boolean tempInverse = bottomInverse;
//		for(int i =0; i <= pathLength;i++) {
//			if(limit < gradient) {
//				//move x
//				
//				if(tempInverse) {
//					if(tempValue == 0) {
//						tempValue = 10;
//					}
//					tempValue = 11 - tempValue;	
//					tempValue--;
//				}else {
//					//tempValue = 11- tempValue;
//					tempValue++;
//				}
//				String fLoc = tempY.toString() + tempValue.toString();
//				System.out.println("(X)Loc " + i + ": " + fLoc);
//				playerLocations[playerIndex] = bd.glide(playerIndex+1, tempValue, Integer.parseInt(fLoc));
//				// bd.addMessage("Roll: " + roll);
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				limit++;
//			}else {
//				tempInverse = !tempInverse;
//				limit = 0;
//				if(tempInverse) {
//					if(tempValue == 0) {
//						tempValue = 10;
//					}
//					tempValue = 11 - tempValue;	
//					tempValue--;
//				}else {
//					//tempValue = 11- tempValue;
//					tempValue++;
//				}
//				//move y
//				tempY++;
//				String fLoc = tempY.toString() + tempValue.toString();
//				System.out.println("(Y)Loc " + i + ": " + fLoc);
//				playerLocations[playerIndex] = bd.glide(playerIndex+1, tempY, Integer.parseInt(fLoc));
//				// bd.addMessage("Roll: " + roll);
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				
//			}
//			
//		}
	}

	public static void main(String args[]) {
		SLGame slg = new SLGame();
		slg.control();

	}
}

