package CalculatorTests;
import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AdditionalTests {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","+", "-4294967296"),
                Arguments.of("-2147483648", "2147483647", "+", "-1"),
                Arguments.of("2147483647", "-2147483648", "+", "-1"),
                Arguments.of("2147483647", "2147483647", "+", "4294967294"),
                Arguments.of("2", "6", "+", "8"),
                Arguments.of("25", "36", "+", "61"),
                Arguments.of("123", "321", "+", "444"),
                Arguments.of("4874", "4987", "+", "9861"),
                Arguments.of("12345", "54321", "+", "66666"),
                Arguments.of("652874", "777777", "+", "1430651"),
                Arguments.of("8765421", "12345678", "+", "21111099"),
                Arguments.of("141414141", "414141414", "+", "555555555"),
                Arguments.of("1234567890", "1987654321", "+", "3222222211"),
                Arguments.of("-5", "4", "+", "-1"),
                Arguments.of("8", "-3", "+", "5"),
                Arguments.of("-5", "-8", "+", "-13"),
                Arguments.of("-20", "4", "+", "-16")
                );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first,second,operation));
    }
    }
