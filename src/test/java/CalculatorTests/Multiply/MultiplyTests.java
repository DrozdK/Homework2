package CalculatorTests.Multiply;

import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MultiplyTests {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","*", "4611686018427387904"),
                Arguments.of("-2147483648", "2147483647", "*", "-4611686016279904256"),
                Arguments.of("2147483647", "-2147483648", "*", "-4611686016279904256"),
                Arguments.of("2147483647", "2147483647", "*", "4611686014132420609"),
                Arguments.of("7", "7", "*", "49"),
                Arguments.of("71", "17", "*", "1207"),
                Arguments.of("123", "321", "*", "39483"),
                Arguments.of("4321", "1234", "*", "5332114"),
                Arguments.of("12345", "54321", "*", "670592745"),
                Arguments.of("654321", "123456", "*", "80779853376"),
                Arguments.of("1234567", "7654321", "*", "9449772114007"),
                Arguments.of("12345678", "87654321", "*", "1082152022374638"),
                Arguments.of("987654321", "123456789", "*", "121932631112635269"),
                Arguments.of("1012345678", "1098765432", "*", "1112330436221002896"),
                Arguments.of("7", "-7", "*", "-49"),
                Arguments.of("-7", "7", "*", "-49"),
                Arguments.of("-7", "-7", "*", "49"),
                Arguments.of("20", "848", "*", "16960")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    @Tag("multiplyTests")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first,second,operation));
    }
}
