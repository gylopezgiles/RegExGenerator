package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by lagi on 8/10/17.
 */
public class StringGenerator implements StringGeneratorInterface{

    final static int MAXIMUM = 10;
    @Override
    public String generateRandomCharacter() {
        Random rand = new Random();
        int asciiCharacterEnd = 255;
        String character = new StringBuilder().append((char)(rand.nextInt( asciiCharacterEnd + 1) % 255)).toString();
        return character;
    }

    @Override
    public String generateRandomCharacterFromASet(String original) {
        Random r = new Random();
        String character = new StringBuilder().append(original.charAt(r.nextInt(original.length()))).toString();
        return character;
    }

    @Override
    public String generateLiteralCharacter(String original) {
        if(original.startsWith("\\")){
            original.replace("\\", "");
        }
        return original;
    }

    @Override
    public String generateZeroOrOneCharacter(String original) {
        original.replace("?", "");
        String zeroCharacter = " "+original;
        Random r = new Random();
        String character = new StringBuilder().append(original.charAt(r.nextInt(zeroCharacter.length())-1)).toString();
        return character;
    }

    @Override
    public String generateZeroOrManyCharacters(String original) {
        original.replace("*", "");
        Random r = new Random();
        String zeroCharacter = " "+original;
        String result = "";
        String character = new StringBuilder().append(original.charAt(r.nextInt(zeroCharacter.length()))).toString();
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

    @Override
    public String generateOneOrManyCharacters(String original) {
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
