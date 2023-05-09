package com.fdmgroup.hangman;

import java.util.ArrayList;

public class Randomiser {

	/**
	* Returns an int depending on the length of the word list 
	* in order to generate a random word
	*
	* @param wordListLength (int) : length of the random word list 
	*/
	public int GenerateRandomInt(int wordListLength) {
		
		int min = 0;
		int max = wordListLength;
		
		return (int) Math.floor(Math.random() *(max - min + 1) + min);
	}

	/**
	* Generates and returns a random string on a pre-determined list
	*/
	
	public String GenerateRandomWord() {
		
		int randomWordInt;
		
		ArrayList<String> wordList= new ArrayList<>();
		
		wordList.add("PLAYGROUND");
		wordList.add("DESTRUCTION");
		wordList.add("SHOE");
		wordList.add("PRISON");
		wordList.add("KEY");
		wordList.add("TRAP");
		wordList.add("BEE");
		wordList.add("LAWYER");
		wordList.add("MOUNTAIN");
		wordList.add("HANDPHONE");
		
		randomWordInt = GenerateRandomInt(wordList.size()-1);
		
		return wordList.get(randomWordInt);
	}
	
}
