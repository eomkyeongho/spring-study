package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculationRequest calculationRequest = new CalculationRequestReader().read();

        long answer = new Calculator().calculate(
                calculationRequest.getNum1(),
                calculationRequest.getNum2(),
                calculationRequest.getOperator());

        System.out.println(answer);
    }
}