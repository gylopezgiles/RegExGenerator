package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lagi on 8/10/17.
 */
public class RegExAnalizer {

    public RegExAnalizer(){
    }

    public List<String> analize(String regEx){
        StringGeneratorInterface stringGenerator = new StringGenerator();
        List<String> result = new ArrayList<String>();
        String original = "";
        int lenght = regEx.length();
        int i=0;
        while (i<lenght){
            String character = new StringBuilder().append(regEx.charAt(i)).toString();
            switch (character){
                case ".":
                    result.add(stringGenerator.generateRandomCharacter());
                    i++;
                    break;
                case "[":
                    original = regEx.substring(i,regEx.indexOf("]", i));
                    result.add(stringGenerator.generateRandomCharacterFromASet(original));
                    i=regEx.indexOf("]", i)+1;
                    break;
                case "?":
                    original = regEx.substring(i-1, i);
                    result.add(stringGenerator.generateZeroOrOneCharacter(original));
                    i++;
                    break;
                case "*":
                    original = regEx.substring(i-1, i);
                    result.add(stringGenerator.generateZeroOrManyCharacters(original));
                    i++;
                    break;
                case "+":
                    original = regEx.substring(i-1, i);
                    result.add(stringGenerator.generateOneOrManyCharacters(original));
                    i++;
                    break;
                case "\\":
                    original = regEx.substring(i, i+1);
                    result.add(stringGenerator.generateLiteralCharacter(original));
                    i++;
                    break;
                default:
                    if(i+1 < lenght){
                        String nextChar = new StringBuilder().append(regEx.charAt(i+1)).toString();
                        if (!nextChar.equals("?") && !nextChar.equals("*") && !nextChar.equals("+")){
                            original = regEx.substring(i, i+2);
                            result.add(stringGenerator.generateLiteralCharacter(original));
                        }
                    }else{
                        original = regEx.substring(i);
                        result.add(stringGenerator.generateLiteralCharacter(original));
                    }
                    i++;
                    break;
            }
        }
        return result;
    }
}
