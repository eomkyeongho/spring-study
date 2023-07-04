package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void 덧셈_연산을_할_수_있다() {
        //given
        long num1 = 1;
        String operator = "+";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);

        //then
        assertEquals(3, result);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈_연산을_할_수_있다() {
        //given
        long num1 = 6;
        String operator = "-";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);

        //then
        assertEquals(4, result);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 나눗셈_연산을_할_수_있다() {
        //given
        long num1 = 6;
        String operator = "/";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);

        //then
        assertEquals(3, result);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈_연산을_할_수_있다() {
        //given
        long num1 = 1;
        String operator = "*";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, num2, operator);

        //then
        assertEquals(2, result);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 잘못된_연산자를_입력하면_예외가_발생한다() {
        //given
        long num1 = 1;
        String operator = "%";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        Assertions.assertThrows(InvalidOperatorException.class, () -> {
            calculator.calculate(num1, num2, operator);
        });
    }
}