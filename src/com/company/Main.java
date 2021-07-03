package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        Validate validate = new Validate();

        BufferedReader calc = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String cl = calc.readLine();
            ResultInfo resultInfo = parser.parse(cl);

            if (validate.checkTwoParameters(resultInfo.elements)) {
                if (validate.checkSimpleDigit(resultInfo.elements)) {
                    calculate(Integer.parseInt(resultInfo.elements[0]),
                            Integer.parseInt(resultInfo.elements[1]),
                            resultInfo.operationType);
                } else if (validate.checkRomanianDigits(resultInfo.elements)) {
                    calculate(validate.romanianDigits.get(resultInfo.elements[0]),
                            validate.romanianDigits.get(resultInfo.elements[1]),
                            resultInfo.operationType);
                }
            }
        }
    }

    private static void printResult(String result) {
        System.out.println(result);
    }

    private static void calculate(int one, int two, String operationType) {
        if (operationType.equals("add")) {
            printResult(String.valueOf(one + two));
        } else if (operationType.equals("subtract")) {
            printResult(String.valueOf(one - two));
        } else if (operationType.equals("multiply")) {
            printResult(String.valueOf(one * two));
        } else if (operationType.equals("divide")) {
            printResult(String.valueOf(one/two));
        }
    }
}
