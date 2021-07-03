package com.company;

import java.util.Arrays;
import java.util.Map;

public class Validate {
    private final String[] digits = new String[]{"1","2","3","4","5","6","7","8","9","10"};
    public final Map<String, Integer> romanianDigits = Map.of(
            "I",1,
            "II",2,
            "III",3,
            "IV",4,
            "V",5,
            "VI",6,
            "VII",7,
            "VIII",8,
            "IX",9,
            "X",10
    );


    /**
     * проверка что на входе есть два параметра
     * @param elements
     * @return
     */
    public boolean checkTwoParameters(String[] elements) {
        return elements != null && elements.length == 2;
    }

    /**
     * проверка что введенные параметры являются арабскими цифрами 1-10
     * @param elements
     * @return - true если все цифры арабские
     */
    public boolean checkSimpleDigit(String[] elements) {
        boolean result = false;
        if (contains(digits, elements[0]) && contains(digits, elements[1])) {
            int first = Integer.parseInt(elements[0]);
            int second = Integer.parseInt(elements[1]);
            if (first > 0 && first < 11 && second > 0 && second < 11) {
                result = true;
            }
        }
        return result;
    }

    /**
     * проверка что все введенные символы римские
     * @param elements
     * @return
     */
    public boolean checkRomanianDigits(String[] elements) {
        return romanianDigits.containsKey(elements[0]) && romanianDigits.containsKey(elements[1]);
    }

    /**
     * проверка что массив содержит искомый символ
     * @param array
     * @param v
     * @return
     */
    private boolean contains(String[] array, String v) {
        boolean result = false;
        for(String i : array){
            if(i.equals(v)){
                result = true;
                break;
            }
        }
        return result;
    }
}
