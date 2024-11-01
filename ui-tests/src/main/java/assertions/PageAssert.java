package assertions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class PageAssert {
    public void assertCheckboxState(SelenideElement checkbox, boolean expectedState) {
        if(expectedState) {
            checkbox.shouldBe(Condition.checked);

        } else{
            checkbox.shouldNotBe(Condition.checked);
        }
    }
}
