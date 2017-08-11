package generators;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class RandomCharacterGenerator implements RegExGeneratorStrategy{
    @Override
    public String generateRegEx(String original) {
        Random rand = new Random();
        int asciiCharacterEnd = 255;
        String character = new StringBuilder().append((char)(rand.nextInt( asciiCharacterEnd + 1) % 255)).toString();
        return character;
    }
}
