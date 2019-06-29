package Project;

public class Tester extends Othello{

	public boolean checkNorth(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.row - i) >= 0; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row -i][game.column] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row -i][game.column] = game.color;			//flip piece and continue loop
			
			else if (game.board[game.row - i][game.column] == 0 || game.board[game.row - 1][game.column] == game.color){	//if empty space is reached before oppColor || same game.color above 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			}

			else if (game.board[game.row -i][game.column] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
				
		}
		return false;
	}
	 
	public boolean checkSouth(boolean flip, Othello game) {
	//row = game.row - 1;		
	
	for (int i = 1; (game.row + i) < 8; i++){
		
		if (game.board[game.row +i][game.column] == game.oppColor && flip == true)
              game.board[game.row +i][game.column] = game.color;
		
		else if (game.board[game.row + i][game.column] == 0 || game.board[game.row +1][game.column] == game.color)
		{
                     // space above || same game.color above 
		      flip = false;
		      return false;	                      
		}
 
		else if (game.board[game.row +i][game.column] == game.color)
              return true;
        
	}
	
		return false;
}

	public boolean checkEast(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.column + i) < 8; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
			// (row + 2) is the space immediately above
			if (game.board[game.row][game.column + i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row][game.column + i] = game.color;			//flip piece and continue loop
			 
			else if (game.board[game.row][game.column + i] == 0 || game.board[game.row][game.column + 1] == game.color){	//if empty space is reached before oppColor || same game.color above 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			}

			else if (game.board[game.row][game.column + i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
			
		}
		return false;
	}
	
	public boolean checkWest(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.column - i) >= 0; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row][game.column - i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row][game.column - i] = game.color;			//flip piece and continue loop
			 
			else if (game.board[game.row][game.column - i] == 0 || game.board[game.row][game.column - 1] == game.color){	//if empty space is reached before oppColor || same game.color above 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			}

			else if (game.board[game.row][game.column - i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
			
		}
		return false;
	}
	
	public boolean checkNorthEast(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.row - i) >= 0 && (game.column + i) < 8; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row -i][game.column + i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row -i][game.column + i] = game.color;			//flip piece and continue loop
			
			else if (game.board[game.row - 1][game.column + i] == 0 || game.board[game.row - 1][game.column + 1] == game.color){	//if empty space is reached before oppColor || same game.color above 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is OFF (checking if spot is an available move)
			} 

			else if (game.board[game.row -i][game.column + i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
			
			
				 
		}
		return false;
	}
	
	public boolean checkSouthEast(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.row + i) < 8 && (game.column + i) < 8; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row +i][game.column + i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row +i][game.column + i] = game.color;			//flip piece and continue loop
			
			else if (game.board[game.row + i][game.column + i] == 0 || game.board[game.row + 1][game.column + 1] == game.color){	//if empty space is reached before oppColor or same game.color is next
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			} 

			else if (game.board[game.row +i][game.column + i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
			
		}
		return false;
	}

	public boolean checkNorthWest(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.row - i) >= 0 && (game.column - i) >= 0; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row -i][game.column - i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row -i][game.column - i] = game.color;			//flip piece and continue loop
			
			else if (game.board[game.row - i][game.column - i] == 0 || game.board[game.row - 1][game.column - 1] == game.color){	//if empty space is reached before oppColor or same game.color is next 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			} 

			else if (game.board[game.row -i][game.column - i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
		
		}
		return false;
	}
	
	public boolean checkSouthWest(boolean flip, Othello game){
		//row = game.row - 1;								//adjust row for array
		for (int i = 1; (game.row + i) < 8 && (game.column - i) >= 0; i++){		//array(row) starts at 0, so row 1 is actually (row + 1)
		
			// (row + 2) is the space immediately above
			if (game.board[game.row +i][game.column - i] == game.oppColor && flip == true)	//if flip is ON and next piece is oppColor
				game.board[game.row +i][game.column - i] = game.color;			//flip piece and continue loop
			
			else if (game.board[game.row + i][game.column - i] == 0 || game.board[game.row + 1][game.column - 1] == game.color){	//if empty space is reached before oppColor or same game.color next 
				flip = false;					//reset flip to false if it was true;
				return false;					//returns false for when flip is of (checking if spot is an available move)
			} 

			else if (game.board[game.row +i][game.column - i] == game.color)		//if there is at least one oppColor between two pieces and second piece is reached
				return true;					//returns true for when flip is OFF (checking if spot is an available move)
		
		}
		return false;
	}

	public boolean spotIsAvailable(int i, int j, Othello game){	//checks availability of one spot
		//System.out.print(i + " " + j + " ");
		int tempRow = game.row; int tempColumn = game.column;
		game.row = i; game.column = j;	//row and column must change so that 
								//the direction function have same values for row and column
		
		if ((game.board[game.row][game.column] == 0) &&		// if spot is empty
		    (checkNorth(false, game) == true ||		// and at least one direction is true
		    checkNorthEast(false, game) == true ||
		    checkEast(false, game) == true ||
		    checkSouthEast(false, game) == true ||
		    checkSouth(false, game) == true ||
		    checkSouthWest(false, game) == true ||
		    checkWest(false, game) == true ||
		    checkNorthWest(false, game) == true)){
			//System.out.printf("%d%c, ",row + 1, letters[game.column]);
				game.row = tempRow;
				
				game.column = tempColumn;
				return true;			
			// then spot is valid	
		}

		else {
			game.row = tempRow;
			game.column = tempColumn;
			return false;
		}
	}

	public boolean moveAvailable(Othello game){
		boolean available = false;
		System.out.print("Possible Moves : ");
		for (int i = 0; i < 8; i++){					//loops go through the whole board
			for(int j = 0; j < 8; j++){		
				if (spotIsAvailable(i,j, game)){	// if there is at least 1 spot available
					System.out.printf("%d%c, ",i + 1, letters[j]);	//prints possible move
					available = true;	//return true;		// there is an available move (turn is possible)
				}
			}
		}
		System.out.println();
		if (available == true)
			return true;			//move is available 
		return false; 				//move is not available 
	}

}
