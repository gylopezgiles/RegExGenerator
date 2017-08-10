package generators;

/**
 * Created by lagi on 8/10/17.
 */
public class GenerateLiteralCharacter implements RegExGeneratorStrategy{
    @Override
    public String generateRegEx(String original) {
        if(original.startsWith("\\")){
            original.replace("\\", "");
        }
        return original;
    }
}
