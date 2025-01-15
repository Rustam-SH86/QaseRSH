package wrappers;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Picklist {
    private final String label;
    private final String pickListPattern = "//label[text()='%s']/following-sibling::div[@role='combobox']";

    public Picklist(String label) {
        this.label = label;
    }

    public Picklist selectOptions(String option) {
        $x(String.format(pickListPattern, label))
                .shouldBe(Condition.visible)
                .click();
        $x(String.format("//div[@role='option' and text()='%s']", option))
                .shouldBe(visible)
                .click();
        return this;
    }
}
