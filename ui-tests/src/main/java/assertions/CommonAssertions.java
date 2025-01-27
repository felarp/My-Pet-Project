package assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class CommonAssertions {
    @Step("Проверяем, что значения {actual} и {expected} не равны")
    public static void assertNotEquals(Object actual, Object expected) {
        Assertions.assertNotEquals(actual,expected,"Значения не равны");
    }
    @Step("Првоеряем, что значения {actual} и {expected} равны")
    public static void assertEquals(Object actual, Object expected, String message) {
        Assertions.assertEquals(actual, expected, message);
    }
    @Step("Проверяем, что значения {expression} истинно")
    public static void assertTrue(boolean expression, String message) {
        Assertions.assertTrue(expression, message);
    }
}
