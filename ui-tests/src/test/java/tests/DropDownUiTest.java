package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.DropDownPage;
import pages.MainPage;

public class DropDownUiTest extends BaseTest{
    MainPage mainPage = new MainPage();
    DropDownPage dropDownPage = new DropDownPage();

    @Test
    @Description("Тест для выбора опций в выпадающем списке на соответствующей странице")

    public void dropdownOptionsTest() {
        mainPage.goToPage("dropdown");
        dropDownPage.selectFirstOption();
        dropDownPage.selectSecondOption();
    }
}
