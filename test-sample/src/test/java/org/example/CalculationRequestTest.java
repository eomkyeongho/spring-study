package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationRequestTest {

    @Test
    public void 유효한_숫자를_파싱할_수_있다() {
        //given
        String[] parts = new String[]{"1", "+", "2"};

        //when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        //then
        assertEquals(1, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(2, calculationRequest.getNum2());
    }

    @Test
    public void 세자리_숫자가_넘어가는_유효한_숫자를_파싱할_수_있다() {
        //given
        String[] parts = new String[]{"100", "+", "200"};

        //when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        //then
        assertEquals(100, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(200, calculationRequest.getNum2());
    }

    @Test
    public void 유효한_길이의_숫자가_들어오지_않으면_예외가_발생한다() {
        //given
        String[] parts = new String[]{"1", "+", "2", "3"};

        //when
        assertThrows(BadRequestException.class, () -> {
            new CalculationRequest(parts);
        });
    }
}