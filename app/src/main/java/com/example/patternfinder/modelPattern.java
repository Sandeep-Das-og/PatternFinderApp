package com.example.patternfinder;

public class modelPattern {
    private String patternID;
    private String pattern;
    private String formula;

    public modelPattern(String patternID, String pattern, String formula) {
        this.patternID = patternID;
        this.pattern = pattern;
        this.formula = formula;
    }

    public String getPatternID() {
        return patternID;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFormula() {
        return formula;
    }
}
