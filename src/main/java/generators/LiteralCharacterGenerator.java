package generators;

/**
 * Created by lagi on 8/10/17.
 */
public class LiteralCharacterGenerator implements RegExGeneratorStrategy{
    @Override
    public String generateRegEx(String original) {
        return original;
    }
}
