package com.destructioncatalyst.einsteinspuzzle.model.logic;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;

public class Rule extends BasicRule{

    private static int instanceCount = 0;

    public Rule(int dim, int objCount){
        super(dim, objCount);

        instanceCount++;
    }

    protected Rule(int dim, int objCount, byte[][] rule){
        super(dim, objCount, rule);

        instanceCount++;
    }

    protected Rule(RawRule rawRule){
        super(rawRule.dimension, rawRule.objectCount, rawRule.data);

        instanceCount++;
    }

    public Rule conjunction(Rule r){
        if (!checkSize(r))
            throw new IllegalArgumentException("Mismatch of sizes between two rules");

        byte[][] newData = new byte[dimension][objectCount];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < objectCount; j++) {

                if((data[i][j] * r.data[i][j]) == 0)
                    newData[i][j] = (byte) Math.max(data[i][j], r.data[i][j]);
                else if(data[i][j] == r.data[i][j])
                    newData[i][j] = data[i][j];
                else return null;
            }
        }
        Rule res = new Rule(dimension, objectCount, newData);

        System.out.println("Exists " + getInstanceCount() + " rules");

        return res.checkRepeat() ? null : res;
    }

    public DisjunctiveTerm generateShifts(){

        DisjunctiveTerm res = new DisjunctiveTerm();

        if(isEmpty())
            return res;

        res.add(this);

        Rule last = this;


        while (last.hasEmptyLeftEdge()){
            last = last.shiftLeft();
            res.add(last);
        }

        last = this;

        while (last.hasEmptyRightEdge()){
            last = last.shiftRight();
            res.add(last);
        }

        return res;
    }

    private boolean hasEmptyColumn(int index){

        for (int i = 0; i < dimension; i++) {
            if (data[i][index] != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean hasEmptyLeftEdge(){
        return hasEmptyColumn(0);
    }

    private boolean hasEmptyRightEdge(){
        return hasEmptyColumn(objectCount - 1);
    }

    private Rule shiftLeft(){
        byte[][] newData = new byte[dimension][objectCount];

        for (int i = 0; i < dimension; i++) {
            if (objectCount - 1 >= 0) System.arraycopy(data[i], 1, newData[i], 0, objectCount - 1);
        }
        for (int i = 0; i < dimension; i++) {
            newData[i][objectCount - 1] = 0;
        }

        return new Rule(dimension, objectCount, newData);
    }

    private Rule shiftRight(){
        byte[][] newData = new byte[dimension][objectCount];

        for (int i = 0; i < dimension; i++) {
            if (objectCount - 1 >= 0) System.arraycopy(data[i], 0, newData[i], 1, objectCount - 1);
        }
        for (int i = 0; i < dimension; i++) {
            newData[i][0] = 0;
        }

        return new Rule(dimension, objectCount, newData);
    }

    public String[][] toStringArray(FeatureConverter converter){

        return converter.decode(data);
    }


    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        instanceCount--;
    }
}
