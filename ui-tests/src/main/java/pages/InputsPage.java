package pages;

import assertions.CommonAssertions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class InputsPage extends BasePage{

    private final SelenideElement inputField = $x("//input[@type = 'number']");

    @Step("Вводим число {number}")
    public void enterNumber(int number) {
        inputField.clear();
        inputField.sendKeys(String.valueOf(number));
    }

    @Step("Вводим текст: {text}")
    public void enterText(String text){
        inputField.clear();
        inputField.sendKeys(text);
    }

    @Step("Получаем значения из поля ввода")
    public String getInputValue() {
        return inputField.getValue();
    }
    @Step("Проверяем, что поле ввода пустое или содержит {expectedNumber}")
    public void verifyIsEmptyOrContains(int expectedNumber) {
        String actualValue = getInputValue();
        if(!actualValue.isEmpty()) {
            CommonAssertions.assertEquals(String.valueOf(expectedNumber), actualValue, String.format("Ожидалось: %d, но было: %s"
                    ,expectedNumber, actualValue));
        };
    }
    @Step("Тестируем ввод значения {number}")
    public void testNumber(int number) {
        enterNumber(number);
        CommonAssertions.assertEquals(String.valueOf(number), getInputValue(), String.format("Ожидалось: %d, но было %s"
                , number, getInputValue()));
    }
    @Step("Тестируем ввод невалидных значений")
    public void testInvalidInput(String text, int expectedNumber) {
        enterText(text);
        verifyIsEmptyOrContains(expectedNumber);
    }
}
