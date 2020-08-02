package com.destructioncatalyst.einsteinspuzzle.model;

import com.destructioncatalyst.einsteinspuzzle.model.logic.ConjunctiveForm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.DisjunctiveTerm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjunctiveFormTest {

    ConjunctiveForm form = new ConjunctiveForm();

    //@BeforeEach
    void setUpEasy() {

        byte[][] a = {
                {0, 0, 0, 4},
                {0, 0, 0, 0}};
        form.add(new DisjunctiveTerm().add(new Rule(2, 4, a)));

        byte[][] b = {
                {0, 4, 0, 0},
                {2, 0, 2, 0}};
        form.add(new Rule(2, 4, b).prepare());

        byte[][] c = {
                {2, 0, 0, 0},
                {3, 0, 0, 0}};
        form.add(new Rule(2, 4, c).prepare());

        byte[][] d = {
                {0, 3, 0, 0},
                {1, 0, 1, 0}};
        form.add(new Rule(2, 4, d).prepare());

        byte[][] e = {
                {1, 2, 0, 0},
                {0, 0, 0, 0}};
        form.add(new Rule(2, 4, e).prepare());

    }

    void setUpHard() {

        //1 - желтый, 2 - синий, 3 - красный, 4 - белый, 5 - зеленый
        //1 - норвержец, 2 - украинец, 3 - англичанин, 4 - испанец, 5 - японец
        //1 - вода, 2 - чай, 3 - молоко, 4 - сок, 5 - кофе
        //1 - Kool, 2 - Chesterfield, 3 - Old Gold, 4 - Lucky Strike, 5 - Parliament
        //1 - лиса, 2 - лошадь, 3 - улитки, 4 - собака, 5 - зебра

        byte[][] a2 = {
                {3, 0, 0, 0, 0},
                {3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a2).prepare());

        byte[][] a3 = {
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a3).prepare());

        byte[][] a4 = {
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a4).prepare());

        byte[][] a5 = {
                {0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0},
                {2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a5).prepare());

        byte[][] a6 = {
                {4, 5, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a6).prepare());

        byte[][] a7 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0},
                {3, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a7).prepare());

        byte[][] a8 = {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a8).prepare());

        byte[][] a9 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a9).splitControversial());

        byte[][] a10 = {
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a10).splitControversial());

        byte[][] a11 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };
        form.add(new Rule(5, 5, a11).prepare());

        byte[][] b = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 2, 0, 0, 0}
        };
        form.add(new Rule(5, 5, b).prepare());

        byte[][] a13 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0},
                {4, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a13).prepare());

        byte[][] a14 = {
                {0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a14).prepare());

        byte[][] a15 = {
                {2, 0, 2, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        form.add(new Rule(5, 5, a15).prepare());
    }

    @Test
    void testToDisjunctive() {

        setUpEasy();

        byte[][] expected = {
                {1, 2, 3, 4},
                {4, 3, 2, 1}};

        assertEquals(new DisjunctiveTerm().add(new Rule(2, 4, expected)), form.toDisjunctive().fillGaps());

        System.out.println("\nExists " + Rule.getInstanceCount() + " rules");
    }

    @Test
    void testToDisjunctiveHard(){

        setUpHard();

        byte[][] expected = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        assertEquals(new DisjunctiveTerm().add(new Rule(5, 5, expected)), form.toDisjunctive().fillGaps());

    }
}