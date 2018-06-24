# TicTacToeGame
This a simple TicTacToe game for 3 players with cusom sympols i.e X,O,Z can be changes
all configuration comes from config.properties  file
player who starts the game is random
Board size also configurable and size configured between 3 and 10 as max and min baord size
input and output appears on console
next position must be entered in a formate like 2,3
columns and rows index is one based 

Code
-------------
1-in code i use 1,2,3 numbers to map player characters to int in board array
2-TicTacToaGame : the main class which contain all game methods and each method has it's own description 
3-BoardConstants : this interface contan all constans used in this game 
4-Config : this class to load configurations from porperty file
5-IllegalMoveException: this is custom exception to throw in case on wrong move 
6-TestBoard:this is Junit test class to test the game
I made it very simple because it is simple not need for complex design aspects

I use Junit for testing but also i made it very simple 

to run this code just impot code as java project and then run main class as java pplication as this is sample for one run


Input Formate like Row , Column  like 1,2 in range from 1 to 3
Player 'Z', enter your move (row[1-3] column[1-3]): 
1,1
Z|   |   
-----------
   |   |   
-----------
   |   |   

Player 'X', enter your move (row[1-3] column[1-3]): 
2,2
Z|   |   
-----------
   |X|   
-----------
   |   |   

Player 'O', enter your move (row[1-3] column[1-3]): 
3,1
Z|   |   
-----------
   |X|   
-----------
O|   |   

Player 'Z', enter your move (row[1-3] column[1-3]): 
1,2
Z|Z|   
-----------
   |X|   
-----------
O|   |   

Player 'X', enter your move (row[1-3] column[1-3]): 
2,2
This move at (2,2) is not valid. Try again...
Player 'X', enter your move (row[1-3] column[1-3]): 
2,1
Z|Z|   
-----------
X|X|   
-----------
O|   |   

Player 'O', enter your move (row[1-3] column[1-3]): 
3,2
Z|Z|   
-----------
X|X|   
-----------
O|O|   

Player 'Z', enter your move (row[1-3] column[1-3]): 
1,3
Z|Z|Z
-----------
X|X|   
-----------
O|O|   

Z won! Thanks for playing!
