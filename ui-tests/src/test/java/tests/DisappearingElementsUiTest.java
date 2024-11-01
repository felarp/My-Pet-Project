package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.RepeatedTest;
import pages.DisappearingElementsPage;
import pages.MainPage;

public class DisappearingElementsUiTest extends BaseTest{

    MainPage mainPage = new MainPage();
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @RepeatedTest(10)
    @Description("Тест на проверку наличия пяти элементов на страницу исчезающих элементов")

    public void disappearingElementsTest () {
        mainPage.goToPage("disappearing_elements");
        disappearingElementsPage.verifyFiveElements();
    }
         }