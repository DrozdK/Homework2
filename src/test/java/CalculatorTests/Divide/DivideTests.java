package CalculatorTests.Divide;

import Helpers.Actions;

import Helpers.DivisionByZeroException;
import Helpers.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class DivideTests {

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648", "-2147483648", "/", "1"),
                Arguments.of("-2147483648", "2147483647", "/", "-1.000000000465661287524579692410575"),
                Arguments.of("2147483647", "-2147483648", "/", "-0.9999999995343387126922607421875"),
                Arguments.of("2147483647", "2147483647", "/", "1"),
                Arguments.of("1", "2", "/", "0.5"),
                Arguments.of("55", "5", "/", "11"),
                Arguments.of("321", "123", "/", "2.609756097560975609756097560975610"),
                Arguments.of("4321", "1234", "/", "3.501620745542949756888168557536467"),
                Arguments.of("12345", "54321", "/", "0.2272601756226873584801457999668636"),
                Arguments.of("123456", "654321", "/", "0.1886780341758861476247896674567987"),
                Arguments.of("7654321", "1234567", "/", "6.200004536003311282417236164582400"),
                Arguments.of("87654321", "12345678", "/", "7.100000583200047822403921437121558"),
                Arguments.of("123456789", "987654321", "/", "0.1249999988609375000142382812498220"),
                Arguments.of("1012345678", "1098765432", "/", "0.9213483137682110843836594233153851"),
                Arguments.of("36", "-6", "/", "-6"),
                Arguments.of("-36", "6", "/", "-6"),
                Arguments.of("-36", "-6", "/", "6"),
                Arguments.of("60", "33", "/", "1.818181818181818181818181818181818")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    @Tag("divideTests")
    public void testSimpleAction(int first, int second, char operation, String expected) {
        Assertions.assertEquals(expected, Actions.calculator(first, second, operation));
    }

    @Test
    @Tag("divideTests")
    public void testDivideByZero () {
        Assertions.assertThrows(DivisionByZeroException.class, () -> Operations.divide(1,0));
    }
}

