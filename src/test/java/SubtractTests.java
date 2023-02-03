import Helpers.Actions;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubtractTests {

    @Description("Параметризированный тест")

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

    @Description("Обычные тесты")

    @Test
    public void subtractMinTest() {
        Assertions.assertEquals((Actions.calculator(-2147483648, -2147483648, '-')), "0");
    }

    @Test
    public void subtractWithPositiveResultTest() {
        Assertions.assertEquals((Actions.calculator(12, 6, '-')), "6");
    }

    @Test
    public void subtractWithFirstPositiveNumberTest() {
        Assertions.assertEquals((Actions.calculator(7, -10, '-')), "17");
    }

    @Test
    public void subtractWithSecondPositiveNumberTest() {
        Assertions.assertEquals((Actions.calculator(-7, 10, '-')), "-17");
    }

    @Test
    public void subtractWithNegativeResultTest() {
        Assertions.assertEquals((Actions.calculator(10, 14, '-')), "-4");
    }

    @Test
    public void subtractBoundaryValueTest() {
        Assertions.assertEquals((Actions.calculator(2147483647, -2147483648, '-')), "4294967295");
    }

    @Test
    public void subtractMaxTest() {
        Assertions.assertEquals((Actions.calculator(2147483647, 2147483647, '-')), "0");
    }
}