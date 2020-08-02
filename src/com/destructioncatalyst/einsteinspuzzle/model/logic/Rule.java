package com.destructioncatalyst.einsteinspuzzle.model.logic;

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

    /*

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
    }//R

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
    }//R

    public DisjunctiveTerm splitControversial(){

        DisjunctiveTerm res = new DisjunctiveTerm();

        int targetLine = findRepeatedLine();

        if(targetLine == -2)
            return res.add(this);

        if(targetLine == -1)
            throw new MultipleRepeatException("Multiple repeated lines!");

        ArrayList<Integer> indexes = findRepeatIndexes(targetLine);

        for(Integer index:indexes){

            res.add(copyExceptOfControversial(targetLine, index));
        }


        return res;
    }//R

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
    }//R

    public DisjunctiveTerm prepare(){
        return this.splitControversial().generateShifts();
    }//R


     */
    public static int getInstanceCount() {
        return instanceCount;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        instanceCount--;
    }
}
