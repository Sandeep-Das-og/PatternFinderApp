package com.example.patternfinder;

public class modelPattern {
    private String patternID;
    private String pattern;
    private String formula;
    private String name;

    public modelPattern(String patternID, String pattern, String formula,String name) {
        this.patternID = patternID;
        this.pattern = pattern;
        this.formula = formula;
        this.name=name;
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

    public String getName() {
        return name;
    }
}
