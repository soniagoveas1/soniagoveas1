import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class WordList{
	static File file = new File("words.txt");
	
	public static int getWordCount(){
		int words = 0;
		//returns five-letter words from the words.txt file
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				String word = input.next();
				if(word.length() == 5){
					words++;
				}
			}
		} catch(FileNotFoundException error){
			System.err.println("ERROR! words.txt cannot be accessed :( ");		
		}
		return words;
	}
	
	public static String[] getWordList(){
		String[] wordList = new String[getWordCount()];
		try {
			int i = 0;
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				String word = input.next();
				if(word.length() == 5){
					//adds five-letter words into an array
					wordList[i] = word;
					i++;
				}
			}
		} catch(FileNotFoundException error) {
			System.err.println("ERROR! words.txt cannot be accessed :( ");	
		}
		return wordList;
	}
	
	public static String getRandWord(){
		Random rand = new Random();
		int randomIndex = rand.nextInt(getWordCount());
		String wordList[] = getWordList();
		return wordList[randomIndex];
	}
}