package com.treasure.hunt.game.util;

/**
 * Its consits of error message to be shown in response.
 */
public class ErrorConstant {

    public static final String EMPTY_MAP;
    public static final String INVALID_ROW;
    public static final String INVALID_COLUMN;
    public static final Integer SIZE;
    public static final String OUT_OF_LIMIT;
    public static final String ARRAY_INDEX_OUT_OF_BOUND;
    public static final String EMPTY_USER;

    static {
        INVALID_ROW = "Please provide valid row [There must be 5 rows nor less nor more]!";
        INVALID_COLUMN = "Please provide valid row [There must be 5 column nor less nor more]!";
        EMPTY_MAP = "Please provide the input for treasure hunt!!!";
        SIZE = 5;
        OUT_OF_LIMIT = "Value cannot be less the 10 or greater than 55 of row : ";
        ARRAY_INDEX_OUT_OF_BOUND = "Row Value cannot be greater than 5(Unit Value). The Value is  : ";
        EMPTY_USER = "Please provide user ID";
    }
}
