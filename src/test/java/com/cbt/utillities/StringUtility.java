package com.cbt.utillities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){

        if (expected.equals(actual)) {

            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }
}
