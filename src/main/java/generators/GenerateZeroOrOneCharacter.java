package generators;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class GenerateZeroOrOneCharacter implements RegExGeneratorStrategy{
    @Override
    public String generateRegEx(String original) {
        original.replace("?", "");
        String zeroCharacter = " "+original;
        String character = getRandom(zeroCharacter);
        return character;
    }

    private String getRandom(String original){
        Random r = new Random();
        String result = new StringBuilder().append(original.charAt(r.nextInt(original.length()))).toString();
        return result;
    }

}
