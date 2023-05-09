package com.fdmgroup.hangman;
import java.util.ArrayList;

public class Hangman {
	
//	###############################
//	######	Initalisation 	#######
//	###############################
	
	String CHOSEN_WORD;
	ArrayList<Character> wrongGuesses = new ArrayList<>();
	ArrayList<Character> rightGuesses = new ArrayList<>();
	final int MAX_ATTEMPTS;
	
	
	/**
	* Constructor for class 
	* 
	* @param maxAttempts (int) : max number of attempts possible before
	* 							game is over 
	*/
	public Hangman(int maxAttempts) {
		
		String word;
		Randomiser randomiser = new Randomiser();
		word = randomiser.GenerateRandomWord();
		
		this.CHOSEN_WORD = word.toLowerCase();
		this.MAX_ATTEMPTS = maxAttempts;
		
	}
	
	
	/**
	*  Calculates the figure that is drawn on the prompt
	*  based on the guesses and the chosen word
	*/
	public String DrawFigure() {
		
		char[] output = new char[CHOSEN_WORD.length()];
		
		for (int i =0; i < output.length; i++) {
				output[i] = '-';
			}
		
//		Subs the letters from dashes to alphabets from correct guesses
		for (int i=0;i<rightGuesses.size();i++) {
			for (int j =0; j <CHOSEN_WORD.length();j++) {
				if (rightGuesses.get(i)== CHOSEN_WORD.toCharArray()[j]) {
					output[j] = rightGuesses.get(i);
				}
			}
		}

		String outputString = new String (output);
		
		return outputString;
		
	}
	
	
	/**
	* Displays a standard prompt to the player after each guess
	*
	* @param attempts (int) : number of wrong attempts made by player
	*/
	public void Prompt (int attempts) {
		
		System.out.print("The word now looks like this:");
		System.out.println(DrawFigure());
		System.out.print("You have ");
		System.out.print(MAX_ATTEMPTS-attempts);
		System.out.println(" guesses left.");
	}
	
	
	/**
	* Processes the guess from input, checks if guess is found in the
	* chosenWord and adds the guess into an array for display later
	* also checks if the guess has already been done before
	* 
	* @param guess (char) : player's input 
	*/
	public int ProcessGuess(char guess) {
		char[] chosenWordCharArray= CHOSEN_WORD.toCharArray();

//		Guess is correct but made before
		for (int i =0; i < rightGuesses.size(); i++) {
			if (rightGuesses.contains(guess)) {
				return 1;
			}	
		}
		
//		Guess is found in the word, add to right guesses
		for (int i =0 ; i< chosenWordCharArray.length;i++) {
			if (chosenWordCharArray[i]==guess) {
				rightGuesses.add(guess);
				return 0;
			}
		}
//		Check if guess has been made before as a wrong guess
		for (int i =0; i < wrongGuesses.size(); i++) {
			if (wrongGuesses.contains(guess)) {
				return 1;
			}	
		}

//		Guess is incorrect
		wrongGuesses.add(guess);
		return 2;
	}
	
	
	/**
	* Determines the victory condition based on the number of attempt
	* 
	* @param attempt (int) : Number of guess attempts made by player so far
	*/
	public boolean VictoryCondition (int attempts) {
		
		
		if (attempts == MAX_ATTEMPTS) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	
	/**
	* Renders end messages depending on the outcome of the game
	*
	* @param victory (boolean) : outcome of the game 
	*/
	public void DisplayEndMsg(boolean victory) {
		if (victory) {
			System.out.println("You guessed the word: " + CHOSEN_WORD);
			System.out.println("You win.");
		}
		
		else {
			System.out.println("You're completely hung..");
			System.out.println("The word was: " + CHOSEN_WORD);
			System.out.println("You lose.");
		}
		
	}
	
}
