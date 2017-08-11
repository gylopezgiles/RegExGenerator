package regex;

/**
 * Created by lagi on 8/11/17.
 */
public enum Modifier {
    PUNTO("."),
    CONJUNTOA("["),
    CONJUNTOC("]"),
    LITERAL("\\"),
    CEROUNO("?"),
    CEROMUCHOS("*"),
    UNOMUCHOS("+");
    private String code;

    Modifier(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
