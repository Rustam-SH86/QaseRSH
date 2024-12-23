package wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Picklist {
    private final String label;
    private final String pickListPattern = "//label[text()='%s']/following-sibling::div[@role='combobox']";


    public Picklist(String label) {
        this.label = label;
    }

    public void selectOptions(String option) {
        $x("//label[text()='Type']/following-sibling::div[@role='combobox']")
                .shouldBe(visible)
                .click();

        // Выбрать опцию из списка
   /*     $x(String.format("//label[text()='Type']/following-sibling::div[@role='combobox']//div[text()='%s']", option))
                .shouldBe(visible)
                .click();
    }
        $x(String.format("//label[text()='%s']/following-sibling::div[@role='combobox']//div[text()='%s']", label, option))
                .scrollTo()
                .click();*/

        Selenide.executeJavaScript(
                "arguments[0].click();",
                $x(String.format("//label[text()='%s']/following-sibling::div[@role='combobox']//div[text()='%s']", label, option))
                        .getWrappedElement()
        );

    }

}
