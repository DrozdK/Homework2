import Helpers.Actions;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AdditionalTests {

    @Description("Параметризированный тест")

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("-2147483648","-2147483648","+", "-4294967296"),
                Arguments.of("-2147483648", "2147483647", "+", "-1"),
                Arguments.of("2147483647", "-2147483648", "+", "-1"),
                Arguments.of("2147483647", "2147483647", "+", "4294967294"),
                Arguments.of("2", "6", "+", "8"),
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

    @Description("Обычные тесты")

    @Test
    public void additionalMinTest() {
        Assertions.assertEquals((Actions.calculator(-2147483648, -2147483648, '+')), "-4294967296");
    }

    @Test
    public void additionalWithAllPositiveNumbersTest() {
        Assertions.assertEquals((Actions.calculator(2, 6, '+')), "8");
    }

    @Test
    public void additionalWithFirstNegativeNumberTest() {
        Assertions.assertEquals((Actions.calculator(-5, 4, '+')), "-1");
    }

    @Test
    public void additionalWithSecondNegativeNumberTest() {
        Assertions.assertEquals((Actions.calculator(8, -3, '+')), "5");
    }

    @Test
    public void additionalWithAllNegativeNumbersTest() {
        Assertions.assertEquals((Actions.calculator(-5, -8, '+')), "-13");
    }

    @Test
    public void additionalWithNegativeResultTest() {
        Assertions.assertEquals((Actions.calculator(-20, 4, '+')), "-16");
    }

    @Test
    public void additionalMaxTest() {
        Assertions.assertEquals((Actions.calculator(2147483647, 2147483647, '+')), "4294967294");
    }
}
