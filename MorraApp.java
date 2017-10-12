/*
MorraApp.java
@authors Craig Sullivan
21/04/2017
*/


import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class MorraApp{
	public static void main (String[] args){ //Main method

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		//Variables
		int roundAccum;
		int roundOdds;
		int roundEvens;
		int roundEvensLost;
		int roundOddsLost;
		boolean isRunning = true;
		int evensPoint;
		int oddsPoint;
		int evensExtra;
		int oddsExtra;
		ArrayList<ArrayList<Integer>> gameAccum;
		ArrayList<Integer> roundAccumulator;
		ArrayList<String> statusAccumulator;
		ArrayList<ArrayList<ArrayList<Integer>>> tryAccumulator;


		///Users name input
		System.out.println("Please enter your name - ");

		String name = scan.nextLine();
		Morra morr = new Morra(name);


		//Intro note
		morr.print("\nHi " + morr.getName() + "! Welcome to the world of Morra - Odds and Evens!\n\nRULES OF MORRA - ODDS AND EVENS" +
					"\n________________________________" +
                    "\n\nEach player uses between 0-10 fingers. " +
                    "\nEach player then guesses the total sum of fingers (0-20) at the end of each round to win a BONUS POINT." +
                    "\nIf both players guess wrong, neither player gets the bonus point!" +
                    "\nThe first player to reach 6 points wins! \nGAME ON!\n" +
                    "\n________________________________");


		//Arrays
		gameAccum = new ArrayList<ArrayList<Integer>>();
		roundAccumulator = new ArrayList<Integer>();
		tryAccumulator = new ArrayList<ArrayList<ArrayList<Integer>>>();
		statusAccumulator = new ArrayList<String>();


		//While loop to begin the game
		while (isRunning) {
		try{
		morr.getOptions();
		int input = scan.nextInt();
		tryAccumulator.add(gameAccum);
			do {
				switch(input) {
				case 3:
					return;


		//Scenario 1:(Odds/Evens)
		case 1:
			morr.setOdds(input);
			morr.setEvens(2);
			morr.setEven("CPU");
			morr.setOdd(morr.getName());

			System.out.println("\n"+ morr.getName() + ": Odds\n" + morr.getEven() + ": Evens\n");
			System.out.println("Round: " + morr.getRoundAccum() + "\n\n");

		//User picks their number
			System.out.println(morr.getName() + ", please pick a number (0-10)");
			morr.setOddsNumber(scan.nextInt());
			morr.setEvensNumber(rand.nextInt((10-1) + 1) + 1);
			morr.computeTotal();

		//Output
			System.out.println("The CPU chose: " + morr.getEvensNumber());
			System.out.println("The total sum is: " + morr.getTotalNumber());

		//Computes
			morr.compute();
			roundAccumulator.add(morr.getRoundAccum());
			statusAccumulator.add("Odds");
			morr.computeOdds();

		//Storing the game history
			roundAccumulator.add(morr.getOddsExtra());
			roundAccumulator.add(morr.getOddsPoint());
			roundAccumulator.add(morr.getRoundOdds());
			roundAccumulator.add(morr.getRoundOddsLost());
			gameAccum.add(roundAccumulator);
			roundAccumulator = new ArrayList<Integer>(roundAccumulator);

			gameAccum = new ArrayList<ArrayList<Integer>>(gameAccum);
			break;


		//Scenario 2:(Evens/Odds)
		case 2:
			morr.setEvens(input);
			morr.setOdds(1);
			morr.setOdd("CPU");
			morr.setEven(morr.getName());

			System.out.println("\n\n" + morr.getName() + ": Evens\n" + morr.getOdd() + ": Odds\n");
			System.out.println("Round: " + morr.getRoundAccum() + "\n\n");


			System.out.println(morr.getName() + ", please pick a number (0-10)");
			morr.setEvensNumber(scan.nextInt());
			morr.setOddsNumber(rand.nextInt((10-1) + 1) + 1);
			morr.computeTotal();


			System.out.println("CPU chose: " + morr.getOddsNumber());
			System.out.println("The Sum of both numbers is: " + morr.getTotalNumber());


			morr.compute();
			statusAccumulator.add("Evens");
			roundAccumulator.add(morr.getRoundAccum());
			morr.computeEvens();


			roundAccumulator.add(morr.getEvensExtra());
			roundAccumulator.add(morr.getEvensPoint());
			roundAccumulator.add(morr.getRoundEvens());
			roundAccumulator.add(morr.getRoundEvensLost());
			gameAccum.add(roundAccumulator);
			roundAccumulator = new ArrayList<Integer>(roundAccumulator);
			gameAccum = new ArrayList<ArrayList<Integer>>(gameAccum);
			break;

				default:
					System.out.println("Please try again. Pick between 1 and 2");
					return;

				}roundAccumulator = new ArrayList<Integer>();
			} 	while (morr.getEvensPoint() <= 6 && morr.getOddsPoint() <= 6);
		}

				//Exception if error input
				catch (IndexOutOfBoundsException exce){
					System.out.println("Please try again. Pick between 1 or 2");
					return;
				}

		Scanner nacs = new Scanner(System.in);
		boolean answer = true;

		while (answer) {
			morr.getPlayAgain();
			String playAgain = nacs.nextLine();

			if (playAgain.equalsIgnoreCase("n")){
				morr.print("GAME OVER!/nThe game history is as follows:\n");
				try{

						for(ArrayList<Integer> innerList : gameAccum) {
							System.out.println("Game: ");
					        System.out.println("Round:"+innerList.get(0));
					        System.out.println("Your Extra Points:"+innerList.get(1));
					        System.out.println("Your Total Points:"+innerList.get(2));
					        System.out.println("Rounds You Won:"+innerList.get(3));
					        System.out.println("Rounds You Lost:"+innerList.get(4));
					        System.out.println("________________________________");
					}

				}
				catch (IndexOutOfBoundsException exce){
				};
			}
			else if (playAgain.equalsIgnoreCase("1")) {
			answer = false;
			isRunning = playAgain.equalsIgnoreCase("1");
			morr.getPlayReset();
			}
			else {
			morr.print("Please try again!");
			continue;
			}
		}
	}
}
}