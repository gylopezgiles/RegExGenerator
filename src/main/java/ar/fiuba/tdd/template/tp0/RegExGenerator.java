package ar.fiuba.tdd.template.tp0;

import regex.RegexAnalizer;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    // TODO: Uncomment this field
    //private int maxLength;

    //public RegExGenerator(int maxLength) {
    //    this.maxLength = maxLength;
    //}

    // TODO: Uncomment parameters
    public List<String> generate(String regEx, int numberOfResults) {
        List<String> result = new ArrayList<String>();
        RegexAnalizer regexAnalizer = new RegexAnalizer();
        while (numberOfResults>0){
            result.add(regexAnalizer.analize(regEx));
            numberOfResults--;
        }
        return result;
    }


}