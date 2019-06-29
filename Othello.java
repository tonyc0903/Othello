package Project;

import java.util.Scanner;

public class Othello {
	
	protected char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	protected int[][] board = new int[8][8]; 
	protected String turn;
	protected String lastMove; 
	protected int color = 1, oppColor = 2;
	protected boolean skippedLastTurn = false;
	protected boolean twoSkippedTurns = false;
	protected char columnChar;
	protected int column, row, rowInput;
	protected int countWhite, countBlack;
	  
	
	public Othello(){
		board[3][3] = 1;
		board[3][4] = 2;
		board[4][3] = 2;
		board[4][4] = 1;
		turn = "WHITE";
	}

	public void getBoard(){
		System.out.println("************" + board[0][0]);
	}
	
	public void countColor()
	{
		countWhite = 0;
		countBlack = 0; 
		for (int i = 0; i < 8 ; i++)
				for  (int j = 0; j<8; j++)
				{
					if(board[i][j] == 1)
						countWhite++;
						//System.out.printf("There are currently " + countWhite + " White color on the board\n");
					if(board[i][j] == 2) 
						countBlack++;
						//System.out.printf("There are currently " + countBlack + " Black color on the board\n");
					
						
				}
			
		//System.out.printf("There are currently " + countWhite + " White color on the board\n");
		//System.out.printf("There are currently " + countBlack + " Black color on the board\n");
	}
	
	public void changeTurn(){
		
		if (turn == "WHITE"){
			turn = "BLACK";
			color = 2;		
			oppColor = 1;	
		} 
		else {
			turn = "WHITE";
			color = 1;
			oppColor = 2;	
		}System.out.println("***" + turn + "***");
	}
	
	public void takeTurn(Monitor monitor,Othello game){
		//int columnInt = game.convertColumn(column);
		if (turn == "WHITE")
			board[row][column] = 1;			//places white piece 
		else if (turn == "BLACK")			
			board[row][column] = 2;			//places black piece
		//System.out.println(row + letters[column] + board[row][column]);
		lastMove = "" + rowInput + columnChar ;	
		changeTurn();
		skippedLastTurn = false;
		monitor.displayBoard(game); //System.out.println(turn);
	}
	
	public void flipPieces(Tester test, Othello game){
		if (test.checkNorth(false, game))		// if direction is true 
			test.checkNorth(true, game);	// flip pieces in that direction 
								// repeat for each direction
		if (test.checkNorthEast(false, game))
			test.checkNorthEast(true, game);

		if (test.checkEast(false, game))
			test.checkEast(true, game);

		if (test.checkSouthEast(false, game))
			test.checkSouthEast(true, game);

		if (test.checkSouth(false, game))
			test.checkSouth(true, game);

		if (test.checkSouthWest(false, game))
			test.checkSouthWest(true, game);

		if (test.checkWest(false, game))
			test.checkWest(true, game);

		if (test.checkNorthWest(false, game))
			test.checkNorthWest(true, game);
		
	}

	public boolean emptySpaces(){		//check if board is full
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == 0)
					return true;
			}
		}

		return false;
	}
	
	public boolean gameOver(Tester test, Othello game){
		if (!emptySpaces())		//if there are no more empty spaces
			return true;			//GAME OVER

		else if (twoSkippedTurns == true && !test.moveAvailable(game))	//if neither player has an available move
			return true; 						//GAME OVER

		else 
			return false;	
	}

	public void skipTurn(Monitor monitor, Othello game){
		if (skippedLastTurn == true)
			twoSkippedTurns = true;
			
		skippedLastTurn = true;
		changeTurn();
		monitor.displayBoard(game);
	}

	public static void main (String args[]){ 
		Scanner scan = new Scanner(System.in);  //input
		Othello game = new Othello();			//creates new instance of Othello 
		
		Input input = new Input();
		Monitor monitor = new Monitor();
		Tester test = new Tester();
		
		monitor.gameRules();
		monitor.displayBoard(game);
		
		do{
			
			if (test.moveAvailable(game) == false)			//if there is no possible move
				game.skipTurn(monitor, game);					//skip turn 
		
		else{											//else take turn

				input.getInput(scan, game);					// get input //row and column
				
				System.out.println("*" + test.spotIsAvailable(input.getRow(game), input.getColumn(game), game) + "*");
				if (test.spotIsAvailable(input.getRow(game), input.getColumn(game), game)){		//if spot is available 
					game.flipPieces(test, game);				//flip pieces
					System.out.print("\n\n");	
					System.out.println((input.getRow(game) + 1) + " " + input.getColumnChar(game));	
					game.takeTurn(monitor, game);			//take turn 
				}
				else  																	//if spot is unavailable
					System.out.println("Invalid spot");
				
			}
			
		}while (game.gameOver(test, game) == false);			//loop while game isn't over	
		
		monitor.declareWinner();
		
		
		
		
		/*game.gameRules();						
		game.displayBoard();  
		
		do{
			
		if (game.moveAvailable(game) == false)			//if there is no possible move
				game.skipTurn(game);					//skip turn 
		
		else{											//else take turn

				game.input(scan); 						// get input //row and column
				
				if (game.spotIsAvailable(game, game.getRow(), game.getColumn())){		//if spot is available 
					game.flipPieces(game);				//flip pieces
					System.out.print("\n\n");	
					game.takeTurn(game);				//take turn 
				}
				else  																	//if spot is unavailable
					System.out.println("Invalid spot");
				
			}
			 
		}while (game.gameOver(game) == false);			//loop while game isn't over	
		 
		game.declareWinner();
		
		scan.close();*/
	} 
}

