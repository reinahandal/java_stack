import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();

		// ArrayList<Integer> randomRolls = generator.getTenRolls();
		// System.out.println(randomRolls);
		
        // char randomLetter = generator.getRandomLetter();
        // System.out.println(randomLetter);

        // System.out.println(generator.generatePassword());

		// ArrayList<String> passwordSet = generator.getNewPasswordSet(4);
        // for (String password : passwordSet) {
        //     System.out.println(password);
        // }

        // SENSEI BONUS - SHUFFLE ARRAY 
        System.out.println("-- Array before swapping ---");
        ArrayList<String> passwordSet = generator.getNewPasswordSet(4);
        System.out.println(passwordSet);
        
        System.out.println("-- Array after swapping ---");
		ArrayList<String> shuffledArray = generator.shuffleArray(passwordSet);
        System.out.println(shuffledArray);
	}
}
