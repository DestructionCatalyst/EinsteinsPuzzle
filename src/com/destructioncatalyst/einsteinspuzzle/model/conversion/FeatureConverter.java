package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import com.destructioncatalyst.einsteinspuzzle.exceptions.EmptyRuleException;

public class FeatureConverter {

    private final int dimension;
    private final String[] featureHeaders;
    private final FeatureNumerator[] numerators;

    @SuppressWarnings("unused")
    public FeatureConverter(int dimension){

        this.dimension = dimension;
        featureHeaders = new String[dimension];
        numerators = new FeatureNumerator[dimension];

    }

    public FeatureConverter(String[] headers, String[][] lines){

        //if (headers.length != lines[0].length)
            //throw new IllegalArgumentException("Mismatch of sizes between arrays!");

        this.dimension = headers.length;

        featureHeaders = headers;

        numerators = new FeatureNumerator[dimension];

        for (int i = 0; i < dimension; i++) {

            //System.out.println(lines[i]);
            numerators[i] = new FeatureNumerator(lines[i]);
        }

    }

    private boolean isEmpty(String[][] lines){

        for (String[] line : lines) {

            if (!(isEmptyLine(line))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEmptyLine(String[] line){

        for (String s: line) {

            if(!((s == null) || s.equals("")))
                return false;
        }

        return true;
    }

    public byte[][] encode(String[][] lines){

        //if (featureHeaders.length != lines[0].length)
            //throw new IllegalArgumentException("Mismatch of sizes");
        if (isEmpty(lines))
            throw new EmptyRuleException();

        byte[][] res = new byte[dimension][];

        for (int i = 0; i < dimension; i++) {

            res[i] = numerators[i].encodeLine(lines[i]);
        }

        return res;
    }

    public String[][] decode(byte[][] numbers){

        String[][] lines = new String[dimension][];

        for (int i = 0; i < dimension; i++) {

            lines[i] = numerators[i].decodeLine(numbers[i]);
        }

        return lines;
    }

    public String[] getFeatureHeaders() {
        return featureHeaders;
    }
}
