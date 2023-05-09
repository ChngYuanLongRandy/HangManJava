package com.fdmgroup.hangman;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		
//		###############################
//		######	Initalisation 	#######
//		###############################
		
		Scanner myObj = new Scanner(System.in);
		
		char input;
		int attempts =0;
		int MAXATTEMPTS =8;
		int guessResult;

		boolean victory;
		
		Hangman hangman = new Hangman(MAXATTEMPTS);
		String WELCOMEMSG = "Welcome to Hangman!";
		
		
//		###############################
//		######	Main Loop	 	#######
//		###############################
		
/**		Start game
*		Display Welcome Msg
*		While victory condition not satisfied i.e if there are still letters left to guess
*		or if the max number of attempts have yet to finish
*		Ask for player's input
*		Process player's input
*		Display end message
*/		
		System.out.println(WELCOMEMSG);
		
		while((hangman.DrawFigure().contains("-")) && (attempts < hangman.MAX_ATTEMPTS)) {
			hangman.Prompt(attempts);
			
			input = myObj.nextLine().toLowerCase().charAt(0);
			
			System.out.println("Your guess:" + input);
			
//			Check guess
			guessResult = hangman.ProcessGuess(input);
			
			switch(guessResult) {
//				Guess is correct
				case 0:
					System.out.println("That guess is correct.");
					break;
//				Guess is repeated
				case 1:
					System.out.println("You have already made this guess, please try again");
					break;
//				Guess is wrong, increment attempt
				case 2:
					System.out.println("There are no " + input + "'s in the word.");
					attempts++;
					break;
			}
			
		}
//		Checks victory condition
		victory = hangman.VictoryCondition(attempts);

		hangman.DisplayEndMsg(victory);
	}
}
