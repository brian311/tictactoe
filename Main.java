package tictactoe;

import java.util.Scanner;

class Main {
	
	public static void main(String[] args) { 
		
		Scanner in = new Scanner(System.in);
		
		//Get the player's names
		System.out.print("Player 1, what's your name? ");
		String p1 = in.nextLine();
		System.out.print("Player 2, what's your name? ");
		String p2 = in.nextLine();
		
		//Create a 3x3 Tic-Tac-Toe board
		//- empty space
		//x for player 1
		//o for player 2
		char[][] board = new char [3][3];
		
		//Fill the board with dashes/empty spaces
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			board [i][j] = '-'; 	
			
			}			
		}
			
		//Keep track of player's turns
				boolean isPlayer1 = true;
		
				
				//Keep track if the game has ended
				boolean gameEnded=false;
				
				while(!gameEnded) {
					
			//Draw the board
			drawBoard(board);
			
			//Keep track of what symbol we're using to play
			char symbol = ' '; 
			if (isPlayer1) {
				symbol = 'x';
			} else {
				symbol = 'o';
			}
			
			//Print out the player's turn
			if(isPlayer1) {
			System.out.println(p1 + "'s turn (x):");
			} else {
				System.out.println(p2 + "'s turn (o):");
			}
			
			//Row and col variables
			int row = 0;
			int col = 0;
			
			while(true) {
				//Get row and column from the player
				System.out.print("Enter a row (0, 1, or 2): ");
				row = in.nextInt();
				System.out.print("Enter a col (0, 1, or 2): ");
				col = in.nextInt();
				
				
				//Check if row and col are valid
				if(row < 0 || col < 0 || row > 2 || col > 2) {
					//Row and col are out of bounds
					System.out.println("Your row and col are out of bounds!");
				} else if(board[row] [col] != '-') {
				
					//Board position has an x or an o
					System.out.println("A player has already made a move there!");
				
				} else {
					//Row and col are valid
					break;
				}
		}
			
			//Setting the position on the board to the player's symbol
			board[row][col] = symbol;
			
			
			//Check if a player has won
			if(hasWon(board) == 'x') {
				//Player 1 has won
				System.out.println(p1 + " wins!");
				gameEnded = true;
			} else if(hasWon(board) == 'o') {
				//Player 2 has won
				System.out.println(p2 + " wins!");
				gameEnded = true;
			}	
			else {
				//Nobody has won
				if(hasTied(board)) {
					//Tied
					System.out.println("It's a tie!");
					gameEnded = true;
				} else {
					//Continues the game and toggles the turn
					isPlayer1 = !isPlayer1;
					
				}
			}
	}
				
				//Print out final board
				drawBoard(board);
				
	}
	
	//Print out the board
	public static void drawBoard (char [][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
}
}
	
	public static char hasWon(char[][] board) {
	//Row
		for(int i = 0; i < 3; i++) {
		if(board[i][0] == board[i][1] && board[i][1] == board [i][2] && board[i][0] != '-') {
			return board[i][0];
		}
		}
		
	//Col
		for(int j = 0; j < 3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board [2][j] && board[0][j] != '-') {
				return board[0][j];
			}
			}
		
	//Diagonals
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
		return board [0][0];
	}	
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
			return board [2][0];
		}	
		
		//Nobody wins; it's a draw
		return '-';
		
	}
	
	
	
	//Check if the board is full
	public static boolean hasTied(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; i++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
	}
		return true;
	}
