import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {
	SLGame game;
	Dice d;
	Board b;

	public void testDiceRoll() {

		d = new Dice();

		int roll = d.roll();
		
		try {
			assertTrue((roll > 0 && roll < 7),"Roll test failure");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testDiceRollOutside() {
		d = new Dice();
		int roll = d.roll();
		
		try {
			assertFalse((roll <= 0 && roll >= 7),"message");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	//test that all snake heads are higher than snake tails
	@Test
	public void testSnakePositions() {
		game = new SLGame();
		b = new Board();
		game.setup(b);
		int tempSnakeHead;
		int tempSnakeTail;
		for(int i =0; i< game.snakesCount;i++) {
			tempSnakeHead = game.snakeHs[i];
			tempSnakeTail = game.snakeTs[i];
			try {
				assertTrue(tempSnakeHead > tempSnakeTail,"");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	@Test
	public void testSnakePositionsOutside() {
		game = new SLGame();
		b = new Board();
		game.setup(b);
		int tempSnakeHead;
		int tempSnakeTail;
		for(int i =0; i< game.snakesCount;i++) {
			tempSnakeHead = game.snakeHs[i];
			tempSnakeTail = game.snakeTs[i];
			try {
				assertFalse(tempSnakeHead <= tempSnakeTail,"");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	//test number of ladders >=0 and less than 10 
	@Test
	public void testNumberofLadders() {
		game = new SLGame();
		b = new Board();
		game.setup(b);
		try {
			assertTrue(game.laddersCount>=0 && game.laddersCount<10,"");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void testNumberofLaddersOutside() {
		game = new SLGame();
		b = new Board();
		game.setup(b);
		try {
			assertFalse(b.laddersCount<0 && b.laddersCount>=10,"");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
