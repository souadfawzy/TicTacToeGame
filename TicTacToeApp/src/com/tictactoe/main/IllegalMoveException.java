package com.tictactoe.main;

public class IllegalMoveException extends RuntimeException {
	  public IllegalMoveException(String message) {
		    super(message);
		  }
}
