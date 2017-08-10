package generators;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class GenerateZeroOrManyCharacters implements RegExGeneratorStrategy{
    final static int MAXIMUM = 10;
    @Override
    public String generateRegEx(String original) {
        original.replace("*", "");
        Random r = new Random();
        String zeroCharacter = " "+original;
        String result = "";
        String character = getRandom(zeroCharacter);
        if(!character.equals(" ")){
            int cantOfChars = r.nextInt(MAXIMUM);
            for(int i=0; i<cantOfChars; i++){
                result = result + character;
            }
        } else {
            result = character;
        }
        return result;
    }

    private String getRandom(String original){
        Random r = new Random();
        String result = new StringBuilder().append(original.charAt(r.nextInt(original.length()))).toString();
        return result;
    }

}
