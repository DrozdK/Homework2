package CalculatorTests;

import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubtractTests {

    //TODO Параметризированный метод

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","-", "0"),
                Arguments.of("-2147483648", "2147483647", "-", "-4294967295"),
                Arguments.of("2147483647", "-2147483648", "-", "4294967295"),
                Arguments.of("2147483647", "2147483647", "-", "0"),
                Arguments.of("12", "6", "-", "6"),
                Arguments.of("7", "-10", "-", "17"),
                Arguments.of("-7", "10", "-", "-17"),
                Arguments.of("10", "14", "-", "-4"),
                Arguments.of("252", "848", "-", "-596")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first,second,operation));
    }
}