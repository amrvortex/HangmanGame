package eg.edu.alexu.csd.datastructure.hangman.cs22;
import java.util.*;
import java.io.*;
public class Hangman implements IHangman{
	
 private static int maxWrongGuesses;
 private static String[] dictionary;
 private static String secretWord;
 private static char[] filler;
 private static String newFiller;
 
	public  String[] readFile(String path){
		String[] arrayOfStrings = new String[10000];
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			for(int i=0;i<10000;i++) {
				arrayOfStrings[i]=in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println("an error occurred");
			e.printStackTrace();
		}
		return arrayOfStrings;	
	}
	public void setDictionary(String[] arrayOfStrings) {
		dictionary=arrayOfStrings;
	}
	public String selectRandomSecretWord() {
		Random randomObject = new Random();
		int randomNumber=randomObject.nextInt(10001);
		String temporaryWord = dictionary[randomNumber];
		secretWord=temporaryWord;
		filler = new char[secretWord.length()];
		for(int i=0;i<secretWord.length();i++) {
			 filler[i]='-';
			 if(secretWord.charAt(i)==' ') {
				 filler[i]=' ';
			 }
		 }
		return temporaryWord;
	}
	public String guess(Character c) throws Exception {
		if(c >= 'A' && c <= 'z') {
			
				if(secretWord.contains(Character.toLowerCase(c)+"")) {
					for(int j=0;j<secretWord.length();j++) {
						if(secretWord.toLowerCase().charAt(j)==Character.toLowerCase(c))
							filler[j]=Character.toLowerCase(c); 
					}
				}else {
					maxWrongGuesses--;
				}
			 newFiller = new String(filler);
			if(newFiller.equals(secretWord)) {
				System.out.println("Congratulation, You Have Won ^_^");
				return null;
			} 
			if(maxWrongGuesses==0) {
				System.out.println("Unfortunately, You have lost :(");
				return null;
			}
		return newFiller; }
		else {
			throw new Exception("Enter a character from A to z ,please");
		}
	}
	public void setMaxWrongGuesses(Integer max) {
		maxWrongGuesses=max;
		if(max == null || max <1)
			maxWrongGuesses=1;
	}
	
 }
