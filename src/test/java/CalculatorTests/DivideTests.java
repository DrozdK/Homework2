package CalculatorTests;

import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class DivideTests {

    //TODO Параметризированный метод

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648", "-2147483648", "/", "1"),
                Arguments.of("-2147483648", "2147483647", "/", "-1.000000000465661287524579692410575"),
                Arguments.of("2147483647", "-2147483648", "/", "-0.9999999995343387126922607421875"),
                Arguments.of("2147483647", "2147483647", "/", "1"),
                Arguments.of("55", "5", "/", "11"),
                Arguments.of("36", "-6", "/", "-6"),
                Arguments.of("-36", "6", "/", "-6"),
                Arguments.of("-36", "-6", "/", "6"),
                Arguments.of("60", "33", "/", "1.818181818181818181818181818181818")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first, second, operation));
    }
}

