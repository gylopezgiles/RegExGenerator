package generators;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class OneOrManyCharactersGenerator implements RegExGeneratorStrategy{
    final static int MAXIMUM = 10;
    @Override
    public String generateRegEx(String original) {
        Random r = new Random();
        String result = "";
        int cantOfChars = r.nextInt(MAXIMUM);
        for(int i=0; i<cantOfChars; i++){
            result += original;
        }
        return result;
    }
}
