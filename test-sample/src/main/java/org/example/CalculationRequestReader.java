package org.example;

import java.util.Scanner;

public class CalculationRequestReader {

    public CalculationRequest read() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        String[] parts = result.split(" ");
        return new CalculationRequest(parts);
    }
}
