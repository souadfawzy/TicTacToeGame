package com.mg.main;

import java.util.Scanner;

public class TicTacToaGame {

	private static Config cfg;
	static {
		cfg = new Config();
	}

	public  int[][] board  = new int[BoardConstants.ROWS][BoardConstants.COLS]; // game board in 2D array containing (EMPTY,CROSS, NOUGHT,COMPUTER)
	public  int currentState; // the current state of the game
									// (PLAYING, DRAW, CROSS_WON,
									// NOUGHT_WON,COMPUTER_WON)
	public  int currentPlayer; // the current player (CROSS or NOUGHT or COMPUTER)
	public  int currntRow, currentCol; // current seed's row and column

	public  Scanner in = new Scanner(System.in);

	public TicTacToaGame() {
			play();
	}
	public TicTacToaGame(int[][] board) {
		this.board=board;
    }
	
	/*use to test*/
	public static void main(String[] args) {
		new TicTacToaGame();

	}

	/**
	 * template method for all steps if XOs game
	 * check first if board size is between max and min range if ok start playing
	 */
	public  void play() {
		if (BoardConstants.ROWS < BoardConstants.MIN_BOARD_SIZE || BoardConstants.ROWS > BoardConstants.MIN_BOARD_SIZE)
			System.out.print("Board size isn't correct Kindly povide value between 3*3 and 10*10");
		else {
			initGame();
			do {

				playerMove(currentPlayer); // update currentRow and currentCol
				updateGame(currentPlayer, currntRow, currentCol); // update
																	// currentState
				printBoard();
				// Print message if game-over
				if (currentState == BoardConstants.CROSS_WON) {
					System.out.println(BoardConstants.CROSS_PLAYER + " won! Thanks for playing!");
				} else if (currentState == BoardConstants.NOUGHT_WON) {
					System.out.println(BoardConstants.NOUGHT_PLAYER + " won! Thanks for playing!");
				} else if (currentState == BoardConstants.COMPUTER_WON) {
					System.out.println(BoardConstants.COMPUTER_PLAYER + " won! Thanks for playing!");
				} else if (currentState == BoardConstants.DRAW) {
					System.out.println("No one win! Thanks for playing!");
				}
				// Switch player
				if (currentPlayer == BoardConstants.CROSS)
					currentPlayer = BoardConstants.NOUGHT;
				else if (currentPlayer == BoardConstants.NOUGHT)
					currentPlayer = BoardConstants.COMPUTER;
				else
					currentPlayer = BoardConstants.CROSS;
			} while (currentState == BoardConstants.PLAYING); // repeat if not
																// game-over
		}
	}

	/** Initialize the game-board contents and the current states
	 * 
	 */
	public  void initGame() {
		System.out.println("Input Formate like Row , Column  like 1,2 in range from 1 to "+BoardConstants.ROWS);
		currentState = BoardConstants.PLAYING; // ready to play
//		board = new int[BoardConstants.ROWS][BoardConstants.COLS];
		// select who is starting randomly
		currentPlayer = (int) (Math.random() * 3 + 1);
	}

	/**
	 * Player with the "theSeed" makes one move, with input validation. Update
	 * global variables "currentRow" and "currentCol".
	 *
	 *
	 * @param theSeed
	 */
	public  void playerMove(int theSeed) {
		boolean validInput = false; // for input validation
		
		do {
			
			if (theSeed == BoardConstants.CROSS) {
				System.out.println("Player '" + BoardConstants.CROSS_PLAYER + "', enter your move (row[1-"
						+ BoardConstants.ROWS + "] column[1-" + BoardConstants.COLS + "]): ");
			} else if (theSeed == BoardConstants.NOUGHT) {
				System.out.println("Player '" + BoardConstants.NOUGHT_PLAYER + "', enter your move (row[1-"
						+ BoardConstants.ROWS + "] column[1-" + BoardConstants.COLS + "]): ");
			} else
				System.out.println("Player '" + BoardConstants.COMPUTER_PLAYER + "', enter your move (row[1-"
						+ BoardConstants.ROWS + "] column[1-" + BoardConstants.COLS + "]): ");
			String input = in.next();

			if (input != null && input.split(",").length != 2) {
				System.out.println("invalid input");
			} else {

				int row = Integer.parseInt(input.split(",")[0].trim()) - 1;
				// int row = in.nextInt() - 1; // array index starts at 0
				// instead of 1
				int col = Integer.parseInt(input.split(",")[1].trim()) - 1;
				if (checkMove(row, col)) {
					currntRow = row;
					currentCol = col;
					board[currntRow][currentCol] = theSeed; // update game-board
															// content
					validInput = true; // input okay, exit loop
				} else {
					System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
				}
			}
		} while (!validInput); // repeat until input is valid
	}

	public boolean checkMove(int row,int col){
		if (row >= 0 && row < BoardConstants.ROWS && col >= 0 && col < BoardConstants.COLS
				&& board[row][col] == 0) {
			return true;
			
		}
		return false;
		
		
	}
	
	/**
	 * Update the "currentState" after the player with "theSeed" has placed on
	 * (currentRow, currentCol).
	 *
	 *
	 * @param theSeed
	 * @param currentRow
	 * @param currentCol
	 */
	public  void updateGame(int theSeed, int currentRow, int currentCol) {
		if (hasWon(theSeed, currentRow, currentCol)) { // check if winning move
			if (theSeed == BoardConstants.CROSS)
				currentState = BoardConstants.CROSS_WON;
			else if (theSeed == BoardConstants.NOUGHT)
				currentState = BoardConstants.NOUGHT_WON;
			else
				currentState = BoardConstants.COMPUTER_WON;
		} else if (isDraw()) { // check for draw
			currentState = BoardConstants.DRAW;
		}
		// Otherwise, no change to currentState (still PLAYING).
	}

	/** Return true if it is a draw (no more empty cell) 
	 * @return
	 */
	public  boolean isDraw() {
		for (int row = 0; row < BoardConstants.ROWS; ++row) {
			for (int col = 0; col < BoardConstants.COLS; ++col) {
				if (board[row][col] == 0) {
					return false; // an empty cell found, not draw, exit
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	/**
	 * Return true if the player with "theSeed" has won after placing at
	 * (currentRow, currentCol)
	 *
	 * @param theSeed
	 * @param currentRow
	 * @param currentCol
	 * @return
	 */
	public  boolean hasWon(int theSeed, int currentRow, int currentCol) {
		int col = 0;
		int row = 0;
		int diag = 0;
		int rdiag = 0;

		for (int i = 0; i < BoardConstants.ROWS; i++) {
			if (board[currentRow][i] == theSeed)
				row++;
			if (board[i][currentCol] == theSeed)
				col++;
			if (board[i][i] == theSeed)
				diag++;
			if (board[i][(BoardConstants.ROWS - 1) - i] == theSeed)
				rdiag++;

		}
		if (row == BoardConstants.ROWS || col == BoardConstants.ROWS || rdiag == BoardConstants.ROWS
				|| diag == BoardConstants.ROWS)
			return true;

		return false;

	}

	/** Print the game board 
	 * 
	*/
	public  void printBoard() {
		for (int row = 0; row < BoardConstants.ROWS; ++row) {
			for (int col = 0; col < BoardConstants.COLS; ++col) {
				printCell(board[row][col]); // print each of the cells
				if (col != BoardConstants.COLS - 1) {
					System.out.print("|"); // print vertical partition
				}
			}
			System.out.println();
			if (row != BoardConstants.ROWS - 1) {
				System.out.println("-----------"); // print horizontal partition
			}
		}
		System.out.println();
	}

	/** Print a cell with the specified "content" 
	 * @param content
	 */
	public  void printCell(int content) {
		switch (content) {
		case 0:
			System.out.print("   ");
			break;
		case BoardConstants.NOUGHT:
			System.out.print(cfg.getProperty("player2"));
			break;
		case BoardConstants.CROSS:
			System.out.print(cfg.getProperty("player1"));
			break;
		case BoardConstants.COMPUTER:
			System.out.print(cfg.getProperty("computer"));
			break;
		}
	}

	public  int[][] getBoard() {
		return board;
	}

	public  void setBoard(int[][] board) {
		this.board = board;
	}
}
