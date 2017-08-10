package ar.fiuba.tdd.template.tp0;

import generators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegExGenerator {
    // TODO: Uncomment this field
    //private int maxLength;

    //public RegExGenerator(int maxLength) {
    //    this.maxLength = maxLength;
    //}

    // TODO: Uncomment parameters
    public List<String> generate(String regEx, int numberOfResults) {
        List<String> result = new ArrayList<String>();
        while (numberOfResults>0){
            result = analize(regEx);
            numberOfResults--;
        }
        return result;
    }

    public List<String> analize(String regEx){
        RegExGeneratorStrategy regExGenerator;
        List<String> result = new ArrayList<String>();
        String original = "";
        int lenght = regEx.length();
        int i=0;
        while (i<lenght){
            String character = new StringBuilder().append(regEx.charAt(i)).toString();
            switch (character){
                case ".":
                    original = "";
                    regExGenerator = new GenerateRandomCharacter();
                    i++;
                    break;
                case "[":
                    original = regEx.substring(i,regEx.indexOf("]", i));
                    regExGenerator = new GenerateRandomCharacterFromASet();
                    i=regEx.indexOf("]", i)+1;
                    break;
                case "?":
                    original = regEx.substring(i-1, i);
                    regExGenerator = new GenerateZeroOrOneCharacter();
                    i++;
                    break;
                case "*":
                    original = regEx.substring(i-1, i);
                    regExGenerator = new GenerateZeroOrManyCharacters();
                    i++;
                    break;
                case "+":
                    original = regEx.substring(i-1, i);
                    regExGenerator = new GenerateOneOrManyCharacters();
                    i++;
                    break;
                case "\\":
                    original = regEx.substring(i, i+1);
                    regExGenerator = new GenerateLiteralCharacter();
                    i++;
                    break;
                default:
                    if(i+1 < lenght){
                        String nextChar = new StringBuilder().append(regEx.charAt(i+1)).toString();
                        if (!nextChar.equals("?") && !nextChar.equals("*") && !nextChar.equals("+")){
                            original = regEx.substring(i, i+2);
                        }
                    }else{
                        original = regEx.substring(i);
                    }
                    regExGenerator = new GenerateLiteralCharacter();
                    i++;
                    break;
            }
            result.add(regExGenerator.generateRegEx(original));
        }
        return result;
    }


}