package pages;

import DTO.TestCaseDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import wrappers.Picklist;

import static com.codeborne.selenide.Selenide.$;

public class TestCasePage {
    public SelenideElement createNewCaseButton = $(By.xpath("//span[text() = 'Create new case']"));
    public SelenideElement saveCaseButton = $(By.id("save-case"));
    public SelenideElement titleField = $("#title");

    public void createTestCase(TestCaseDTO testCaseDTO) {
        createNewCaseButton.shouldBe(Condition.visible).click();
        titleField.shouldBe(Condition.visible).setValue("Creation test case");
        new Picklist("Status").selectOptions(testCaseDTO.getStatus());
        new Picklist("Type").selectOptions(testCaseDTO.getType());
        new Picklist("Severity").selectOptions(testCaseDTO.getSeverity());
        new Picklist("Layer").selectOptions(testCaseDTO.getLayer());
        new Picklist("Behavior").selectOptions(testCaseDTO.getBehavior());
        new Picklist("Priority").selectOptions(testCaseDTO.getPriority());
        new Picklist("Is flaky").selectOptions(testCaseDTO.getIsFlaky());
        new Picklist("Automation status").selectOptions(testCaseDTO.getAutomationStatus());
        saveCaseButton.click();
    }
}