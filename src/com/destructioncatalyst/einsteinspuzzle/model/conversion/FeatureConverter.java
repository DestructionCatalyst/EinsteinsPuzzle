package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import com.destructioncatalyst.einsteinspuzzle.exceptions.EmptyRuleException;

import java.util.ArrayList;

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

    public FeatureConverter(String[] headers, ArrayList<String>[] lines){

        if (headers.length !=lines.length)
            throw new IllegalArgumentException("Mismatch of sizes between arrays!");
        if (isEmpty(lines))
            throw new EmptyRuleException();

        this.dimension = headers.length;

        featureHeaders = headers;

        numerators = new FeatureNumerator[dimension];

        for (int i = 0; i < dimension; i++) {

            //System.out.println(lines[i]);
            numerators[i] = new FeatureNumerator(lines[i]);
        }

    }

    private boolean isEmpty(ArrayList<String>[] lines){

        for (ArrayList<String> line : lines) {

            if (!((line.isEmpty()) || isEmptyLine(line))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEmptyLine(ArrayList<String> line){

        for (String s: line) {

            if(!((s == null) || s.equals("")))
                return false;
        }

        return true;
    }

    public byte[][] encode(ArrayList<String>[] lines){

        if (featureHeaders.length !=lines.length)
            throw new IllegalArgumentException("Mismatch of sizes");
        if (isEmpty(lines))
            throw new EmptyRuleException();

        byte[][] res = new byte[lines.length][];

        for (int i = 0; i < lines.length; i++) {

            res[i] = numerators[i].encodeLine(lines[i]);
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String>[] decode(byte[][] numbers){

        ArrayList<String>[] lines = new ArrayList[featureHeaders.length];

        for (int i = 0; i < lines.length; i++) {

            lines[i] = numerators[i].decodeLine(numbers[i]);
        }

        return lines;
    }

    public String[] getFeatureHeaders() {
        return featureHeaders;
    }
}
