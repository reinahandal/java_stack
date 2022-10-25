import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomTen = new ArrayList<Integer>();
        Random random = new Random();
        for (int i=0; i<10; i++) {
            int x = random.nextInt(20) + 1;
            randomTen.add(x);
        }
        return randomTen;
    }

    public char getRandomLetter() {
        char[] randomLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' ,'l' ,'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random random = new Random();
        int x = random.nextInt(26);
        return randomLetters[x];
    }

    public String generatePassword() {
        String password = "";
        for (int i=0; i<8; i++) {
            char letter = getRandomLetter();
            password+=letter;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i=0; i<length; i++) {
            String password = generatePassword();
            passwordSet.add(password);
        }
        return passwordSet;
    }
// SENSEI BONUS 
    public ArrayList<String> shuffleArray(ArrayList<String> arrayToShuffle) {
        Random random = new Random();
        for(int i=0; i<arrayToShuffle.size()*2; i++) {
            int x = random.nextInt(arrayToShuffle.size());
            int y = random.nextInt(arrayToShuffle.size());
            Collections.swap(arrayToShuffle, x, y);
        }
        return arrayToShuffle;
    }
}