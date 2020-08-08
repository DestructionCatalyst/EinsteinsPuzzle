package com.destructioncatalyst.einsteinspuzzle.model.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ConjunctiveForm {

    private final ArrayList<DisjunctiveTerm> terms;

    public ConjunctiveForm(){

        terms = new ArrayList<>();
    }


    @SuppressWarnings("UnusedReturnValue")
    public ConjunctiveForm add(DisjunctiveTerm disjunctiveTerm){

        terms.add(disjunctiveTerm);
        return this;
    }

    public DisjunctiveTerm get(int index) {
        return terms.get(index);
    }

    public int size() {
        return terms.size();
    }

    public ConjunctiveForm addAll(ConjunctiveForm conjunctiveForm){

        terms.addAll(conjunctiveForm.terms);
        return this;
    }

    @Deprecated
    private DisjunctiveTerm pop() {
        return pop(terms.size() - 1);
    }

    @Deprecated
    private DisjunctiveTerm pop(int index){
        return terms.remove(index);
    }

    public void sort(){
        Collections.sort(terms);
    }

    public DisjunctiveTerm toDisjunctive(){

        sort();

        DisjunctiveTerm res = get(0);

        for (int i = 1; i < size(); i++) {

            res = res.conjunction(get(i));
        }

        System.gc();

        return res;
    }


    @Override
    public String toString() {
        return "ConjunctiveForm{" +
                "terms=" + terms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConjunctiveForm that = (ConjunctiveForm) o;
        return Objects.equals(terms, that.terms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms);
    }
}
