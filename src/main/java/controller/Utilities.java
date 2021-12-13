package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public static Matcher getCommandMatcher(String enteredCommand , String regex){
        Pattern enteredRegexPattern = Pattern.compile(regex);
        Matcher enteredCommandMatcher = enteredRegexPattern.matcher(enteredCommand);
        return enteredCommandMatcher;
    }
}

