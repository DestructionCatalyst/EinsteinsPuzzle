package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import java.util.ArrayList;
import java.util.HashSet;

public class FeatureNumerator {

    private final ArrayList<String> features;

    public FeatureNumerator(ArrayList<String> featureList){
        features = featureList;

        if(!checkRepeat())
            throw new IllegalArgumentException("The feature list has repeated values!");

        if(containsEmpty())
            throw new IllegalArgumentException("The feature list has empty values!");
    }

    public int encode(String str){

        if ((str == null) || (str.equals("")))
            return 0;

        return features.indexOf(str) + 1;
    }

    public byte[] encodeLine(ArrayList<String> line){

        byte[] res = new byte[line.size()];

        for (int i = 0; i < line.size(); i++) {
            res[i] = (byte) encode(line.get(i));
        }
        return res;
    }

    public String decode(int number){

        return number == 0 ? "" : features.get(number - 1);
    }

    public ArrayList<String> decodeLine(byte[] numbers){

        ArrayList<String> res = new ArrayList<>();

        for (byte number : numbers) {

            res.add(decode(number));
        }

        return res;
    }

    public boolean contains(String s) {
        return features.contains(s);
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


}
