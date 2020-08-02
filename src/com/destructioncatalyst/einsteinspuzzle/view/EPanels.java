package com.destructioncatalyst.einsteinspuzzle.view;

public enum EPanels {

    START{
        public EPanels next(){
            //instance = FEATURE;
            return FEATURE;
        }
    },
    FEATURE{
        public EPanels next(){
            //instance = RULE;
            return RULE;
        }
    },
    RULE{
        public EPanels next(){
            //instance = RULE;
            return RULE;
        }
    };

    /*
    private static EPanels instance = null;

    public static EPanels getInstance() {
        if (instance == null)
            instance = START;

        return instance;
    }


     */
    public abstract EPanels next();
}
