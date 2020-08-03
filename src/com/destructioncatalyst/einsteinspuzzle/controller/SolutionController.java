package com.destructioncatalyst.einsteinspuzzle.controller;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.model.logic.ConjunctiveForm;

public class SolutionController {

    private int dimension;
    private int objectCount;

    private FeatureConverter featureConverter;

    private ConjunctiveForm conjunctiveForm;

    private static SolutionController instance = null;

    private SolutionController(){

        conjunctiveForm = new ConjunctiveForm();
    }

    public static SolutionController getInstance(){

        if (instance == null) {
            instance = new SolutionController();
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
