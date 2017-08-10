package ar.fiuba.tdd.template.tp0;

/**
 * Created by lagi on 8/10/17.
 */
public interface StringGeneratorInterface {
    String generateRandomCharacter();
    String generateRandomCharacterFromASet(String original);
    String generateLiteralCharacter(String original);
    String generateZeroOrOneCharacter(String original);
    String generateZeroOrManyCharacters(String original);
    String generateOneOrManyCharacters(String original);
}
