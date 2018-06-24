package com.mg.main;

public interface BoardConstants {
	// Name-constants to represent the seeds and cell contents
		public static final int EMPTY = 0;

		// Name-constants to represent the various states of the game
		//playing status
		public static final int PLAYING = 0;
		public static final int DRAW = 1;
		public static final int CROSS_WON = 2;
		public static final int NOUGHT_WON = 3;
		public static final int COMPUTER_WON = 4;
		public static Config cfg = new Config();
		
		public static final int CROSS = 1;
		public static final int NOUGHT = 2;
		public static final int COMPUTER = 3;

		public static final String CROSS_PLAYER = cfg.getProperty("player1");
		public static final String NOUGHT_PLAYER = cfg.getProperty("player2");
		public static final String COMPUTER_PLAYER = cfg.getProperty("computer");

		// The game board and the game status
		// number of rows and columns
		public static final int ROWS = Integer.parseInt(cfg.getProperty("board_size")),
				COLS = Integer.parseInt(cfg.getProperty("board_size"));
		public static final int MIN_BOARD_SIZE = Integer.parseInt(cfg.getProperty("min_size"));
		public static final int MAX_BOARD_SIZE = Integer.parseInt(cfg.getProperty("max_size"));
		
}
