import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class wordleGame{
	public static void main(String[] args){
		//gets a random five-letter word 
		//ignores case by changing the random word into upper case
	String word = (WordList.getRandWord()).toUpperCase();
		//gets user guess
		Scanner input = new Scanner(System.in);
		int guessNum = 1;
		
		System.out.println("Welcome to Wordle! The mystery word is a 5-letter English word. You have 6 chances to guess it. Letter in the correct place, the letter will be printed. Letter present, but in the wrong place,letter will be enclosed in '[]'. Letter not in word, will print a ‘_’.");
		
	//will continue to run until any of the conditions within the loop becomes false	
		while(true){
			String res = "";
			System.out.print("guess " + guessNum + ": ");
			//ignores case
			String guess = input.nextLine().toUpperCase();
			
			if(guess.length() != 5){
				//prompts user to input a new word if their original word is not exactly five words
				System.out.println("ERROR! Your guess must be five letters long!");
			}
			
			if(guess.equals(word)){
				System.out.println(guess);
				System.out.println("Congrats! You guessed it!");
				//ends game if the word is correctly guessed
				break;
			}
			
//ends the game if the guesses used is greater than 6			
			if(guessNum == 6){
				System.out.println("Sorry! Better luck next time!");
				System.out.println("The word was " + word);
				break;
			}
			
			for(int i = 0; i < 5; i++){
				char letter = guess.charAt(i);
				if(letter == word.charAt(i)){
					res += letter;
				} else {
//if the letter is not in the word, an underline will be outputted
					res += "_";
				}
			}
			
			String newRes = "";
			
			for(int i = 0; i < 5; i++){
				char letter = guess. charAt(i);
//if the letter is in the word, but in the wrong place, it will be surrounded with brackets
				if(word.contains(letter + "") && res.contains(letter + "") == false){
					newRes += "[" + letter + "]";
					res += letter;
				} else {
					newRes += " " + res.charAt(i);
				}
			}
			res = newRes;
			
			System.out.println(res);
			guessNum++;
		}
	}
}