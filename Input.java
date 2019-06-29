package Project;
import java.util.Scanner;

public class Input extends Othello{

	public void getInput(Scanner scan, Othello game){ 
		boolean invalidInput = false;
		  
		do {
			try{
				do
				{
					System.out.print("Enter the column and row (Do not separate by spaces):  ");
					String line = scan.next();
					game.rowInput = Character.getNumericValue(line.charAt(0)); 
					game.columnChar = line.charAt(1);
					//System.out.println(rowInput - 1);
				
				}while (checkColumn(game.columnChar) == false || checkRow(game.rowInput) == false);
				game.row = game.rowInput - 1; //offset row for array
				invalidInput = false;	//System.out.println(rowInput + " " + columnChar);
			}
			catch (Exception e){
				invalidInput = true;
				System.out.println("Invalid input. (Please follow the guidelines)");
			}
		}while(invalidInput == true);		
			
		game.column = convertColumn(game.columnChar);
		
	}

	public int convertColumn(char columnChar){
		for (int i = 0; i < 8; i++){
			if (columnChar == letters[i])
				return i;
		}
		return 0;
	}
	
	public boolean checkColumn(char columnChar){
		for (int i = 0; i < 8; i++){
			if (columnChar == letters[i])	//checks if column matches a column letter 
				return true;			//input is valid  
		}
		System.out.println("Invalid input. (Uppercase only)");
		return false;					//if no match is found, input is invalid 
	}

	public boolean checkRow(int row){
		if (row >= 1 && row <= 8)			//row must be between 1 & 8
			return true;
		else {
			System.out.println("Invalid input. (Row must be between 1-8)");
			return false;					//input is invalid 
		}
	}

	public char getColumnChar(Othello game){
		return game.columnChar;
	}
	
	public int getColumn(Othello game){
		return game.column;
	}

	public int getRow(Othello game){
		return game.row;
	}
	
}
