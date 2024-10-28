package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckBoxesPage;
import pages.MainPage;

public class CheckboxesUiTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @ParameterizedTest
    @ValueSource(strings = {"first","last"})
    @DisplayName("Тест на проверку и вывод состояния чекбоксов на страницу чекбоксов с разными порядками нажатия")
    public void checkBoxesTest(String order) {
        mainPage.goToPage("checkboxes");
        checkBoxesPage.listCheckboxesCheck(order);
    }
}
