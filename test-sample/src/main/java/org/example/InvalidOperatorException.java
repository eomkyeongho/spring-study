package org.example;

public class InvalidOperatorException extends RuntimeException{

    public InvalidOperatorException() {
        super("Invalid operator, please use +, -, *, /");
    }
}
