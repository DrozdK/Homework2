package CalculatorTests.Subtract;

import Helpers.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubtractTests {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","-", "0"),
                Arguments.of("-2147483648", "2147483647", "-", "-4294967295"),
                Arguments.of("2147483647", "-2147483648", "-", "4294967295"),
                Arguments.of("2147483647", "2147483647", "-", "0"),
                Arguments.of("1", "1", "-", "0"),
                Arguments.of("12", "6", "-", "6"),
                Arguments.of("333", "123", "-", "210"),
                Arguments.of("4879", "7785", "-", "-2906"),
                Arguments.of("87458", "85478", "-", "1980"),
                Arguments.of("123456","654321","-","-530865"),
                Arguments.of("1234567","7654321","-","-6419754"),
                Arguments.of("12345678","87654321","-","-75308643"),
                Arguments.of("987654321","123456789","-","864197532"),
                Arguments.of("1234567890","1987654321","-","-753086431"),
                Arguments.of("7", "-10", "-", "17"),
                Arguments.of("-7", "10", "-", "-17"),
                Arguments.of("10", "14", "-", "-4"),
                Arguments.of("252", "848", "-", "-596")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    @Tag("subtractTests")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first,second,operation));
    }
}