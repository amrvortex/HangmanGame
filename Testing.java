package eg.edu.alexu.csd.datastructure.hangman.cs22;
import java.util.*;
public class Testing {
	public static void main(String[] args) {
		Hangman myObject = new Hangman();
		String[] temporaryStrings= myObject.readFile("google-10000-english.txt");
		myObject.setDictionary(temporaryStrings);
		myObject.setMaxWrongGuesses(5);
		String word = myObject.selectRandomSecretWord();
		System.out.println(word);
		String temp = null;
		Scanner input = new Scanner(System.in);
		do {
			
			Character c = input.next().charAt(0);
			 try {
				temp = myObject.guess(c);
			} catch (Exception e) {
				System.out.println("please, enter a character");
				e.printStackTrace();
			}
			System.out.println(temp);
			
		}while(temp != null);
		input.close();
	}
}
