package com.destructioncatalyst.einsteinspuzzle.model.logic;

import com.destructioncatalyst.einsteinspuzzle.exceptions.MultipleRepeatException;

import java.util.ArrayList;
import java.util.Arrays;

public class RawRule extends BasicRule {


    public RawRule(int dim, int objCount) {
        super(dim, objCount);
    }

    public RawRule(int dim, int objCount, byte[][] rule) {
        super(dim, objCount, rule);
    }

    private int findRepeatedLine(){

        int res = -2;

        boolean[] used = new boolean[objectCount];

        for (int i = 0; i < dimension; i++) {

            Arrays.fill(used, false);

            for (int j = 0; j < objectCount; j++) {
                if(data[i][j] != 0){

                    if(used[data[i][j] - 1])
                        if (res != -2)
                            return -1;
                        else
                            res = i;
                    else
                        used[data[i][j] - 1] = true;
                }
            }
        }

        return res;
    }

    private ArrayList<Integer> findRepeatIndexes(int line){

        ArrayList<Integer> res = new ArrayList<>();

        byte prev = 0;

        for (int i = 0; i < objectCount; i++) {

            if(data[line][i] != 0){
                if((data[line][i] != prev) && (prev != 0)){
                    throw new MultipleRepeatException("Repeated line has different numbers!");
                }
                res.add(i);
            }

            prev = data[line][i];
        }

        return res;
    }

    public DisjunctiveTerm splitControversial(){

        DisjunctiveTerm res = new DisjunctiveTerm();

        int targetLine = findRepeatedLine();

        if(targetLine == -2)
            return res.add(this.toRegular());

        if(targetLine == -1)
            throw new MultipleRepeatException("Multiple repeated lines!");

        ArrayList<Integer> indexes = findRepeatIndexes(targetLine);

        for(Integer index:indexes){

            res.add(copyExceptOfControversial(targetLine, index));
        }


        return res;
    }

    private Rule copyExceptOfControversial(int targetLine, int index){

        byte [][] newData = new byte[dimension][objectCount];

        for (int i = 0; i < targetLine; i++) {
            if (objectCount >= 0) System.arraycopy(data[i], 0, newData[i], 0, objectCount);
        }

        Arrays.fill(newData[targetLine], (byte) 0);
        newData[targetLine][index] = data[targetLine][index];

        for (int i = targetLine + 1; i < dimension; i++) {
            if (objectCount >= 0) System.arraycopy(data[i], 0, newData[i], 0, objectCount);
        }

        return new Rule(dimension, objectCount, newData);
    }

    public DisjunctiveTerm prepare(){
        return this.splitControversial().generateShifts();
    }

    private Rule toRegular(){
        if(checkRepeat())
            throw new ClassCastException("This RawRule has repeats, so in cannot be converted into regular Rule");
        return new Rule(this);
    }
}
