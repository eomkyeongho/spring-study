package org.example;

public class BadRequestException extends RuntimeException{

        public BadRequestException() {
            super("Invalid input size, please use 3 arguments");
        }
}
