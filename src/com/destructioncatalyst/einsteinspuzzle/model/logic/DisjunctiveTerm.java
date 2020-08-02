package com.destructioncatalyst.einsteinspuzzle.model.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class DisjunctiveTerm implements Comparable<DisjunctiveTerm>{

    private final HashSet<Rule> rules;

    private int dimension = 0;
    private int objectCount = 0;

    public DisjunctiveTerm() {
        rules = new HashSet<>();
    }

    public DisjunctiveTerm(int dimension, int objectCount){
        rules = new HashSet<>();

        this.dimension = dimension;
        this.objectCount = objectCount;
    }

    public DisjunctiveTerm add(Rule r){

        if((dimension == 0) || (objectCount == 0)){
            this.dimension = r.getDimension();
            this.objectCount = r.getObjectCount();
        }
        else if (!checkSize(r)){
            throw new IllegalArgumentException("Wrong rule size!");
        }

        rules.add(r);
        return this;
    }

    private boolean checkSize(Rule r){
        return (this.dimension == r.getDimension()) && (this.objectCount == r.getObjectCount());
    }


    private DisjunctiveTerm addAll(DisjunctiveTerm d){
        rules.addAll(d.rules);
        return this;
    }

    public int size(){
        return rules.size();
    }

    public DisjunctiveTerm conjunction(DisjunctiveTerm d){

        DisjunctiveTerm res = new DisjunctiveTerm();
        Rule tmp;

        for (Rule r1: rules) {
            for (Rule r2: d.rules) {

                tmp = r1.conjunction(r2);

                if (tmp != null)
                    res.add(tmp);
            }
        }

        return res;
    }

    public DisjunctiveTerm generateShifts(){

        DisjunctiveTerm res = new DisjunctiveTerm();

        for (Rule r: rules) {
            res.addAll(r.generateShifts());
        }

        return res;
    }

    public DisjunctiveTerm splitControversial(){

        DisjunctiveTerm res = new DisjunctiveTerm();

        for (Rule r: rules) {
            res.addAll(r.splitControversial());
        }

        return res;
    }

    public DisjunctiveTerm fillGaps(){

        ConjunctiveForm form = elementaryRules();

        form.add(this);

        return form.toDisjunctive();
    }

    private DisjunctiveTerm generateElementary(int line, byte number){

        byte[][] arr = new byte[dimension][objectCount];

        for (int i = 0; i < dimension; i++) {
            Arrays.fill(arr[i], (byte)0);
        }

        arr[line][0] = number;

        return new Rule(dimension, objectCount, arr).generateShifts();
    }

    private ConjunctiveForm elementaryRules(){

        ConjunctiveForm form = new ConjunctiveForm();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < objectCount; j++) {
                form.add(generateElementary(i, (byte)(j + 1)));
            }
        }

        return form;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisjunctiveTerm that = (DisjunctiveTerm) o;
        return Objects.equals(rules, that.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rules);
    }

    @Override
    public String toString() {
        return "DisjunctiveTerm{" +
                "rules=" + rules.toString() +
                '}';
    }

    @Override
    public int compareTo(DisjunctiveTerm o) {

        return this.size() - o.size();
    }

}
