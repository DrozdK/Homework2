package CalculatorTests;

import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MultiplyTests {

    //TODO Параметризированный тест

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","*", "4611686018427387904"),
                Arguments.of("-2147483648", "2147483647", "*", "-4611686016279904256"),
                Arguments.of("2147483647", "-2147483648", "*", "-4611686016279904256"),
                Arguments.of("2147483647", "2147483647", "*", "4611686014132420609"),
                Arguments.of("7", "7", "*", "49"),
                Arguments.of("7", "-7", "*", "-49"),
                Arguments.of("-7", "7", "*", "-49"),
                Arguments.of("-7", "-7", "*", "49"),
                Arguments.of("20", "848", "*", "16960")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first,second,operation));
    }
}
