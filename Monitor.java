package Project;

public class Monitor extends Othello{
	
	public void gameRules(){
		System.out.println("*******************************************************************");
		System.out.println("\t\tOthello Board Game\n");
		System.out.println("\tBrief description of the game:\n");								 
		System.out.println("\tOthello is a strategy game played by two players");
		System.out.println("\ton a 8x8 board using colors black and white.\n");
		System.out.println("\tHow to win the game:");
		System.out.println("\tGet as much of your color on the board by");
		System.out.println("\tthe end of the game.\n");
		System.out.println("\tHow it works:");
		System.out.println("\tWhenever you place a piece on the board, your ");
		System.out.println("\topponent's pieces will change over to your color ");
		System.out.println("\tif they are between the piece that you just placed ");
		System.out.println("\tand another one of your pieces.\n");
		System.out.println("\tIf a player has no available moves that would ");
		System.out.println("\tflip at least one of their opponents pieces, ");
		System.out.println("\ttheir turn is skipped.\n");
		System.out.println("\tThe game ends when there are either no more");
		System.out.println("\tavalable moves for either player or when there");
		System.out.println("\tare no more spaces left on the board.\n");
		System.out.println("*******************************************************************");
	}
	
	public void displayBoard(Othello game){ System.out.println(turn);
		for (int k = 0; k < 8; k++){
			System.out.printf("   %c", letters[k]);				//prints column letters
		}
		
		if (game.lastMove != null){
			System.out.print("\t\t" + "Last move: " + game.lastMove);	//shows last move 
			if (game.turn == "WHITE")
				System.out.print(" (BLACK)");
			else 
				System.out.print(" (WHITE)");
		}
		
		System.out.println();
			for(int i = 0; i < 8; i++){			//row loop
				System.out.print((i+1) + " ");				//prints row numbers
				
				for(int j = 0; j < 8; j++){		//column loop
					if (game.board[i][j] == 0)
						System.out.print("[ ] ");
					else if (game.board[i][j] == 1)
						System.out.print("[W] ");
					else if (game.board[i][j] == 2)
						System.out.print("[B] ");
					//System.out.print("[" + board[i][j] + "]  "); //"[ø]  ");
				}
				
				if (i == 0)
					System.out.print("\t\t" + "Turn: " + game.turn);	
				
				countColor(game);
				if (i == 1)
					System.out.print("\t\tWhite Pieces: " + game.countWhite);
				if (i == 2)
					System.out.print("\t\tBlack Pieces: " + game.countBlack);
				
				
				if (i == 3 && game.skippedLastTurn == true)
				System.out.print("\t\t" + "Last turn skipped : no moves available");
				
				System.out.println();
			}
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
	
	public void declareWinner(){
		/*int whitePieces = 0, blackPieces = 0;
		
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] == 1)
					whitePieces++; 
				else if (board[i][j] == 2)
					blackPieces++;
			}
		}
		
		System.out.println("\nWhite pieces : " + whitePieces);
		System.out.println("Black pieces : " + blackPieces);*/

		if (countWhite > countBlack)
			System.out.println("White Wins!");
		else if (countBlack > countWhite)
			System.out.println("Black Wins!");
		else if (countBlack == countWhite)
			System.out.println("Tie Game!");
					
	}

	public void countColor(Othello game)
	{
		game.countWhite = 0;
		game.countBlack = 0; 
		for (int i = 0; i < 8 ; i++)
				for  (int j = 0; j<8; j++)
				{
					if(game.board[i][j] == 1)
						game.countWhite++;
						//System.out.printf("There are currently " + countWhite + " White color on the board\n");
					if(game.board[i][j] == 2) 
						game.countBlack++;
						//System.out.printf("There are currently " + countBlack + " Black color on the board\n");
					
						
				}
			
		//System.out.printf("There are currently " + countWhite + " White color on the board\n");
		//System.out.printf("There are currently " + countBlack + " Black color on the board\n");
	}
	
}
