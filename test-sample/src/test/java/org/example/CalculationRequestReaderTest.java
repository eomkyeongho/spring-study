package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationRequestReaderTest {

    @Test
    public void System_in으로_데이터를_읽어들일_수_있다() {
        //given
        CalculationRequestReader calculationRequestReader = new CalculationRequestReader();

        //when
        System.setIn(new java.io.ByteArrayInputStream("1 + 2".getBytes()));
        CalculationRequest result = calculationRequestReader.read();

        //then
        assertEquals(1, result.getNum1());
        assertEquals("+", result.getOperator());
        assertEquals(2, result.getNum2());
    }
}