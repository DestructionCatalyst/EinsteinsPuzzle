package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import java.util.HashSet;

public class FeatureNumerator {

    private final String[] features;

    public FeatureNumerator(String[] featureList){
        features = featureList;

        if(!checkRepeat())
            throw new IllegalArgumentException("The feature list has repeated values!");

        if(containsEmpty())
            throw new IllegalArgumentException("The feature list has empty values!");
    }

    public int encode(String str){

        if ((str == null) || (str.equals("")))
            return 0;

        int index = linearSearch(features, str);

        if (index == -1)
            throw new IllegalArgumentException("String not found!");

        return index + 1;
    }

    private int linearSearch(String[] strings, String key){

        for (int i = 0; i < strings.length; i++) {

            if(strings[i].equals(key))
                return i;
        }
        return -1;
    }

    public byte[] encodeLine(String[] line){

        byte[] res = new byte[line.length];

        for (int i = 0; i < line.length; i++) {
            res[i] = (byte) encode(line[i]);
        }
        return res;
    }

    public String decode(int number){

        return number == 0 ? "" : features[number - 1];
    }

    public String[] decodeLine(byte[] numbers){

        String[] res = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            res[i] = decode(numbers[i]);
        }

        return res;
    }

    private boolean checkRepeat(){

        HashSet<String> strings = new HashSet<>();

        for (String s: features) {
            if(!strings.add(s))
                return false;
        }

        return true;
    }

    private boolean containsEmpty(){

        for (String s: features) {
            if((s == null) || (s.equals("")))
                return true;
        }

        return false;
    }

    public int getObjectCount(){
        return features.length;
    }

}
