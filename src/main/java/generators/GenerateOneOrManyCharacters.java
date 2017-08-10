package generators;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class GenerateOneOrManyCharacters implements RegExGeneratorStrategy{
    final static int MAXIMUM = 10;
    @Override
    public String generateRegEx(String original) {
        original.replace("+", "");
        Random r = new Random();
        String result = "";
        int cantOfChars = r.nextInt(MAXIMUM);
        for(int i=0; i<cantOfChars; i++){
            result = result + original;
        }
        return result;
    }
}
