import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class TicTacToe {

	static ArrayList<Integer> playerpositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpupositions = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] [] gameBoard = {{' ','|',' ','|',' '},
								{'-','+','-','+','-'},
								{' ','|',' ','|',' '},
								{'-','+','-','+','-'},
								{' ','|',' ','|',' '}};
		
		printGameBoard(gameBoard);
		
		while(true) {
		Scanner Scan = new Scanner(System.in);
		System.out.println("Enter your placement(1-9)");
		int playerpos = Scan.nextInt();
		
		while(playerpositions.contains(playerpos) || cpupositions.contains(playerpositions)) {
			playerpos = Scan.nextInt();
		}

		placePiece(gameBoard,playerpos,"player");
		String	 result =checkWinner();
		
		
		Random rand =new Random();
		int cpupos =rand .nextInt(9) + 1;
		while(playerpositions.contains(cpupos)||cpupositions.contains(cpupos)) {
		System.out.println("position taken Enter correct position");
		 cpupos =rand .nextInt(9) + 1;
		}
		
		placePiece(gameBoard,cpupos,"cpu");
		
		
		printGameBoard(gameBoard);
		
 result =checkWinner();
	System.out.println(result);
		
		 }
		 
	}
	
		
		public static void printGameBoard (char [][] gameBoard) {

			for(char [] row : gameBoard) {
				for(char c : row){
				System.out.print(c);
			}
				System.out.println();
			}
	}
		
		public static void placePiece(char [][] gameBoard, int pos, String user) {
		char symble =' ';
	if (user.equals("player")) {
		playerpositions.add(pos);
		symble= 'x' ;
	}
	else if(user.equals("cpu")) {
		cpupositions.add(pos);
		symble = 'o';
	}
		
			switch(pos) {
			case 1:
				gameBoard [0][0]=symble;
				break;
			case 2:
				gameBoard [0][2]=symble;
				break;
			case 3:
				gameBoard [0][4]=symble;
				break;
			case 4:
				gameBoard [2][0]=symble;
				break;
			case 5:
				gameBoard [2][2]=symble;
				break;
			case 6:
				gameBoard [2][4]=symble;
				break;
			case 7:
				gameBoard [4][0]=symble;
				break;
			case 8:
				gameBoard [4][2]=symble;
				break;
			case 9:
				gameBoard [4][4]=symble;
				break;
				default :
				break;
			}
		
		}	
		
		public static String checkWinner () {
			
			List toprow = Arrays.asList(1,2,3);
			List midrow = Arrays.asList(4,5,6);
			List botrow = Arrays.asList(7,8,9);
			List leftcol = Arrays.asList(1,4,7);
			List midcol = Arrays.asList(2,5,8);
			List ritecol = Arrays.asList(3,6,9);
			List cross1 = Arrays.asList(1,5,9);
			List cross2 = Arrays.asList(3,5,7);
			
			List<List> winning=new ArrayList<List>();
			
			winning.add(toprow);
			winning.add(midrow);
			winning.add(botrow);
			winning.add(leftcol);
			winning.add(midcol);
			winning.add(ritecol);
			winning.add(cross1);
			winning.add(cross2);
			
			for(List l : winning) {
				if( playerpositions.containsAll(l)) {
					return "congratulation you win";
				}
				else if(cpupositions.containsAll(l)) {
					return "CPU win SORRY :)" ;
							}
				
					else if( playerpositions.size() + cpupositions.size() == 9) {
						
					return"CAT!";
				}
			}
			
			
			
			
			return " ";
		}
		
		
}	
		
		
		
		
		
		