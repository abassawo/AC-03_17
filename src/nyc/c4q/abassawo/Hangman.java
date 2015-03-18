package nyc.c4q.abassawo;
/**
 * Created by c4q-Abass on 3/17/15.
 */

import java.util.Scanner;
public class Hangman {

    public static void main(String[] args) {

        SecretWord wordGuess = new SecretWord();   //Creates new missing word.
        Scanner userInput = new Scanner(System.in);
        char userGuess = 0;
        int wrongGuess = 6;  //Why did I start at 7?Y


        //System.out.println(wordGuess.reveal()); //for testing
        System.out.println("Hangman: Guess a letter: " + "\n");
        System.out.println(wordGuess.toString() + "\n");
        System.out.println(Drawing.get(6));   //Initial Hangman at 6. countdown to 1 for each missed trial

        while (!wordGuess.isGuessed()) {   //as long as guess isn't correct.
            userGuess = userInput.next().charAt(0);
            wordGuess.set(userGuess);   //determines if guess is correct or wrong

            if (wordGuess.isLowerCase(userGuess)) {
                //Convert to uppercase FIXME. //Could also add separate if statement to accept a full string.
            }
            if (wordGuess.isLetter(userGuess)){
                System.out.println(Drawing.get(wrongGuess));
                System.out.println(wordGuess.toString());

            } else {
                wrongGuess--;
                System.out.println(Drawing.get(wrongGuess));
            }

            if(wordGuess.isGuessed()) {
                System.out.println(wordGuess.reveal());
                System.out.println("You guessed it!");
            }

            if (wrongGuess == 1) {
                System.out.println("You lost. The correct word was " +wordGuess.reveal());
                System.out.println(Drawing.get(1));
            }


        }
    }
}