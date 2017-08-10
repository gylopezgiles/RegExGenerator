package ar.fiuba.tdd.template.tp0;

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
        RegExAnalizer regExAnalizer = new RegExAnalizer();
        while (numberOfResults>0){
            regExAnalizer.analize(regEx);
            numberOfResults--;
        }
        return result;
    }


}