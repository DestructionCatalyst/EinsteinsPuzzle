package com.destructioncatalyst.einsteinspuzzle.model;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.model.logic.ConjunctiveForm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.DisjunctiveTerm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.RawRule;

public class Solver {

    private int dimension;
    private int objectCount;

    private FeatureConverter featureConverter;

    private ConjunctiveForm conjunctiveForm;

    private static Solver instance = null;

    private Solver(){

        conjunctiveForm = new ConjunctiveForm();
    }

    public static Solver getInstance(){

        if (instance == null) {
            instance = new Solver();
        }

        return instance;
    }

    public void addFeatureConverter(FeatureConverter converter){

        featureConverter = converter;
    }

    public int getDimension() {
        return dimension;
    }


    public void addRule(String[][] ruleTable, boolean fixed) {

        RawRule rawRule = new RawRule(dimension, objectCount, featureConverter.encode(ruleTable));

        if(fixed)
            conjunctiveForm.add(rawRule.splitControversial());
        else
            conjunctiveForm.add(rawRule.prepare());

        System.out.println(conjunctiveForm);


    }

    public DisjunctiveTerm solve(){

        return conjunctiveForm.toDisjunctive();
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setDimensions(int dimension, int objectCount){

        this.dimension = dimension;
        this.objectCount = objectCount;
    }

    public void reset(){

        dimension = objectCount = 0;
        featureConverter = null;
        conjunctiveForm = new ConjunctiveForm();
    }
}
