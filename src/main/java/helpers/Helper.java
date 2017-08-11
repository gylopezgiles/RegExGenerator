package helpers;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class Helper {

    public static String getRandomFromAString(String original){
        Random r = new Random();
        String result = new StringBuilder().append(original.charAt(r.nextInt(original.length()))).toString();
        return result;
    }

    public static String removeModifier(String original, String modifier){
        original = original.replace(modifier, "");
        return original;
    }


}
