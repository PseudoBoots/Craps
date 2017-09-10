/**
* @author Victor Bieniek
* CSC 201
* Professor Tanes Kanchanawanchai
* 
* This class simulates a game of craps
*/
import java.util.Random;
import java.util.Scanner;

public class Craps
{
	public static void main(String[] args)
	{
		Craps craps = new Craps();
		boolean isPoint = false;
		int point = 0;
		int die1;
		int die2;
		int totalRoll;

		System.out.println("\nCraps:\nPress enter to roll");
		try{
			System.in.read();
		} catch(Exception e){
			//e.printStacktrace();
		}

		while(true)
		{
			die1 = craps.rollDie();
			die2 = craps.rollDie();
			totalRoll = die1 + die2;
			System.out.printf("You rolled a %d and a %d for a total of %d", die1, die2, totalRoll);

			if(isPoint){
				if(totalRoll == 7){
					System.out.println("\nYou loose!");
					isPoint = false;
					craps.askPlayAgain();
				}
				else if(totalRoll == point){
					System.out.println("\nYou win!");
					isPoint = false;
					craps.askPlayAgain();
				}
			}
			else{
				if(totalRoll == 7 || totalRoll == 11){
					System.out.println("\nYou win!");
					craps.askPlayAgain();
				}
				else{
					point = totalRoll;
					isPoint = true;
					System.out.print("\nPoint is " + point);
				}
			}
			System.out.print("\nPress enter to roll dice");
			try{
				System.in.read();
			} catch(Exception e){
				//e.printStacktrace();
			}
		}//end game loop
	}//end main

	public int rollDie()
	{
		Random rand = new Random();
		//returns a random number between 1 and 6
		return rand.nextInt(6) + 1;
	}

	private void askPlayAgain(){
		Scanner scan = new Scanner(System.in);
		String ans;

		System.out.print("Do you want to play again?(y/n) ");
		ans = scan.next();
		if(ans.charAt(0) == 'y' || ans.charAt(0) == 'Y'){
			//do nothing
		}
		else if(ans.charAt(0) == 'n' || ans.charAt(0) == 'N'){
			System.exit(0);
		}
		else{
			this.askPlayAgain();
		}

	}
}//end class