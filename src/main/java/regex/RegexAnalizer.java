package regex;

import generators.*;
import helpers.Helper;

/**
 * Created by lagi on 8/11/17.
 */
public class RegexAnalizer {

    public String analize(String regEx){
        RegExGeneratorStrategy regExGenerator;
        String result = "";
        String original = "";
        int lenght = regEx.length();
        int i=0;
        while (i<lenght){
            String character = new StringBuilder().append(regEx.charAt(i)).toString();
            switch (character){
                case ".":
                    original = "";
                    regExGenerator = new RandomCharacterGenerator();
                    i++;
                    break;
                case "[":
                    original = regEx.substring(i,regEx.indexOf("]", i));
                    original = Helper.removeModifier(original, "[");
                    regExGenerator = new RandomCharacterFromASetGenerator();
                    i=regEx.indexOf("]", i)+1;
                    break;
                case "?":
                    original = regEx.substring(i-1, i);
                    original = Helper.removeModifier(original, "?");
                    regExGenerator = new ZeroOrOneCharacterGenerator();
                    i++;
                    break;
                case "*":
                    original = regEx.substring(i-1, i);
                    original = Helper.removeModifier(original, "*");
                    regExGenerator = new ZeroOrManyCharactersGenerator();
                    i++;
                    break;
                case "+":
                    original = regEx.substring(i-1, i+1);
                    original = Helper.removeModifier(original, "+");
                    regExGenerator = new OneOrManyCharactersGenerator();
                    i++;
                    break;
                case "\\":
                    original = regEx.substring(i, i+1);
                    original = Helper.removeModifier(original, "\\");
                    regExGenerator = new LiteralCharacterGenerator();
                    i++;
                    break;
                default:
                    if(i+1 < lenght){
                        String nextChar = new StringBuilder().append(regEx.charAt(i+1)).toString();
                        if (!nextChar.equals("?") && !nextChar.equals("*") && !nextChar.equals("+")){
                            original = regEx.substring(i, i+1);
                        }
                    }else{
                        original = regEx.substring(i);
                    }
                    regExGenerator = new LiteralCharacterGenerator();
                    i++;
                    break;
            }
            result+=regExGenerator.generateRegEx(original);
        }
        return result;
    }

}
