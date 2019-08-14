package main;

import java.util.*;

//This is my best attempt thus far at designing beforehand and working neatly and effectively. Not a clue how it rates, though. 

public class Nim {
	//To ensure these variables are available globally
	int matchesLeft = 11;
	int playerTurn = 1;
	int noOfPlayers = 0;
	
	public Nim() {	
	}
	
	public static void main(String[] args) {
		Nim start = new Nim(); //To ensure non-static variables can be accessed from main. Any better/other solutions?
		start.Game();
	}
	
	void Game() {
		System.out.println("Welcome to Nim. \nThere is a pile of 11 matches on a table. \nThe player who takes away the final match is the loser. \nYou can take either 1, 2, 3, or 4 matches at a time. \nGood luck.\n");
		noOfPlayers = numberOfPlayers();
		turnDecider(playerTurn, noOfPlayers);
	}
	
	int numberOfPlayers() {
		System.out.println("With how many players would you like to play this game?");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		return input;
	}
	
	void turnDecider(int playerTurn, int noOfPlayers) {
		if(matchesLeft > 0 && playerTurn == 1) playerOneMove(noOfPlayers);
		else if(matchesLeft > 0 && playerTurn == 2) playerTwoMove();
		else if(matchesLeft > 0 && playerTurn == 3) computerMove();
		else return;
 	}
	
	void playerOneMove(int noOfPlayers) {		
		System.out.println("\nThere are " + matchesLeft + " matches left.");
		System.out.println("How many many matches would you like to take, Player One?");
		int input = getInput();
		gameState(input,1);
		if(noOfPlayers == 1) playerTurn = 3;
		else if(noOfPlayers == 2) playerTurn = 2;
		turnDecider(playerTurn, noOfPlayers);
	}
	
	void playerTwoMove() {
		System.out.println("\nThere are " + matchesLeft + " matches left.");
		System.out.println("How many many matches would you like to take, Player Two?");
		int input = getInput();
		gameState(input,2);
		playerTurn = 1;
		turnDecider(playerTurn, 2);
	}
	
	int getInput() {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		if(input > 0 && input < 5 && checkInputVsMatchesLeft(input) == true) return input;
		else {
			System.out.println("\nYou can't pick up more than 4 matches. \nNor can you take none or put any back. \nNor can you take any more than there are left. \nPlease try again.");
			turnDecider(playerTurn,noOfPlayers);
		}
		return 1; //Should never return anything, but is required due to the conditional. Any more elegant ways of dealing with this?
					//2nd comment: originally 'returned' 0. However, when set to 0 it will somehow store the player and number of times that player made an error (too high or too low)
					//and go through gameState as many times as they had lost. Haven't a clue how or why, but having this higher than 0 somehow solves it. Obviously means that the code
					//can and will be reached, but I don't understand why.
	}
	
	boolean checkInputVsMatchesLeft(int input) {
		boolean valid = false;
		if(input <= matchesLeft) valid = true;
		return valid;
	}
	
	void computerMove() {
		int computerMatches = 0;
		if(matchesLeft == 10) computerMatches = 4;
		else if(matchesLeft == 9) computerMatches = 3;
		else if(matchesLeft == 8) computerMatches = 2;
		else if(matchesLeft == 7) computerMatches = 1;
		else if(matchesLeft == 6) computerMatches = 1;
		else if(matchesLeft == 5) computerMatches = 4;
		else if(matchesLeft == 4) computerMatches = 3;
		else if(matchesLeft == 3) computerMatches = 2;
		else if(matchesLeft == 2) computerMatches = 1;
		else if(matchesLeft == 1) computerMatches = 1;
		System.out.println("\nThe Computer takes " + computerMatches + " match(es).");
		gameState(computerMatches, 3);
		playerTurn = 1;
		turnDecider(playerTurn, 1);
	}
	
	void gameState(int matchesTaken, int turn) {
		matchesLeft = matchesLeft - matchesTaken;
		if(matchesLeft == 0 && turn == 1) System.out.println("\nSad days, Player One, you have lost!");
		else if(matchesLeft == 0 && turn == 2) System.out.println("\nSad days, Player Two, you have lost!");
		else if(matchesLeft == 0 && turn == 3) System.out.println("\nThe impossible has happened; the Computer lost! Glory to the player to the end of their days!");
	}
}