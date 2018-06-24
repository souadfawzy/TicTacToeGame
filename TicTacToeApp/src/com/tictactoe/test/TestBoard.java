package com.tictactoe.test;

import org.junit.Before;
import org.junit.Test;

import com.tictactoe.main.TicTacToaGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class TestBoard {
	 int[][] board  = new int[3][3];
	@Before
	public void init() {
		//1st row 
		// X O Z 
//		board[0][0]=1;//X
//		board[0][1]=2;//O
//		// Z O X
//		board[0][2]=3;//Z
//		board[1][2]=1;//x
//		board[1][1]=2;//O
//		board[1][0]=3;//z
//		
//		// O Z X
//		board[2][0]=2;//O
//		board[2][1]=3;//Z
//		board[2][2]=1;//X
		
		
	}

	@Test
	public void testGameIsOverNoWinner() {
		board[0][0]=1;//X
		board[0][1]=2;//O
		// Z O X
		board[0][2]=3;//Z
		board[1][2]=1;//x
		board[1][1]=2;//O
		board[1][0]=3;//z
		
		// O Z X
		board[2][0]=2;//O
		board[2][1]=3;//Z
		board[2][2]=1;//X
		
		assertFalse(new TicTacToaGame(board).hasWon(2, 1, 2));
	}

	@Test
	public void testRowWin() {
		
		board[0][0]=1;//X
		board[1][2]=2;//O
		board[2][0]=3;//Z
		
		
		board[0][1]=1;//X
		board[1][1]=2;//O
		board[2][1]=3;//Z
		
		//board[1][2]=1;//x
		
		new TicTacToaGame(board).printBoard();
		
		assertFalse(new TicTacToaGame(board).hasWon(1, 1, 2));
	}

	@Test
	public void testColWin() {
//		board[0][0] = 1;// X
//		board[0][1] = 2;// O
//		// Z O X
//		board[0][2] = 3;// Z
//		board[1][2] = 1;// x
//		board[1][1] = 2;// O
//		board[1][0] = 3;// z
//
//		// O Z X
//		board[2][0] = 2;// O
//		board[2][1] = 3;// Z
//		board[2][2] = 1;// X
//		assertTrue(new TicTacToaGame(board).hasWon(1, 1, 2));
	}

	@Test
	public void testDiagWin() {
//		board[0][0] = 1;// X
//		board[0][1] = 2;// O
//		// Z O X
//		board[0][2] = 3;// Z
//		board[1][2] = 1;// x
//		board[1][1] = 2;// O
//		board[1][0] = 3;// z
//
//		// O Z X
//		board[2][0] = 2;// O
//		board[2][1] = 3;// Z
//		board[2][2] = 1;// X
//		assertTrue(new TicTacToaGame(board).hasWon(1, 1, 2));
	}
	@Test
	public void testWrongMoveOutOfBoundsOrTakenCell() {
		assertFalse(new TicTacToaGame(board).checkMove(-1, 2));
	}
}
