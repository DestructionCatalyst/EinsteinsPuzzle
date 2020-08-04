package com.destructioncatalyst.einsteinspuzzle.model;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.model.logic.ConjunctiveForm;

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

    public String[] getFeatureHeaders() {
        return featureConverter.getFeatureHeaders();
    }

    public int getDimension() {
        return dimension;
    }

    public void addRule() {

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
