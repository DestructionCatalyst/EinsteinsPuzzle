package com.destructioncatalyst.einsteinspuzzle.model.logic;

import java.util.Arrays;
import java.util.Objects;

public abstract class BasicRule {

    protected final int dimension;
    protected final int objectCount;

    protected final byte[][] data;

    public BasicRule(int dim, int objCount){

        dimension = dim;
        objectCount = objCount;

        data = new byte[dimension][objectCount];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < objectCount; j++) {
                data[i][j] = 0;
            }
        }

    }

    public BasicRule(int dim, int objCount, byte[][] rule){

        if(dim <= 0)
            throw new IllegalArgumentException("dim = " + dim + " <= 0");

        if (objCount <= 0)
            throw new IllegalArgumentException("objCount = " + objCount + " <= 0");

        dimension = dim;
        objectCount = objCount;

        data = rule;

        //instanceCount++;
    }

    protected boolean checkSize(BasicRule r){
        return ((dimension == r.dimension) && (objectCount == r.objectCount));
    }

    protected boolean checkRepeat(){

        boolean[] used = new boolean[objectCount];

        for (int i = 0; i < dimension; i++) {

            Arrays.fill(used, false);

            for (int j = 0; j < objectCount; j++) {
                if(data[i][j] != 0){

                    if(used[data[i][j] - 1])
                        return true;
                    used[data[i][j] - 1] = true;
                }
            }
        }

        return false;

    }

    public boolean isEmpty(){

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < objectCount; j++) {
                if (data[i][j] != 0)
                    return false;
            }
        }
        return true;

    }

    public int getDimension() {
        return dimension;
    }

    public int getObjectCount() {
        return objectCount;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "dimension=" + dimension +
                ", objectCount=" + objectCount +
                ", map=" + Arrays.deepToString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicRule rule = (BasicRule) o;
        return dimension == rule.dimension &&
                objectCount == rule.objectCount &&
                Arrays.deepEquals(data, rule.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dimension, objectCount);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }
}
