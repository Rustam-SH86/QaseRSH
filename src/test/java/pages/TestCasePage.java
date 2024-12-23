package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import wrappers.Picklist;
import DTO.TestCase;


import static com.codeborne.selenide.Selenide.$;

public class TestCasePage {
    public SelenideElement createNewCaseButton = $(By.xpath("//span[text() = 'Create new case']"));
    TestCase testCase = TestCase.builder()
            .Type("Smoke")

            /*  .Status("Draft")
             .Severity("Major")
             .Layer("API")
             .Behavior("Negative")
             .Priority("High")
             .IsFlaky("Yes")
             .AutomationStatus("Automated") */
            .build();


    public void createTestCase() {
        createNewCaseButton.click();
       // new Picklist("Status").selectOptions(testCase.getStatus());
        new Picklist("Type").selectOptions(testCase.getType());
        new Picklist("Severity").selectOptions(testCase.getSeverity());
        new Picklist("Layer").selectOptions(testCase.getLayer());
        new Picklist("Behavior").selectOptions(testCase.getBehavior());
        new Picklist("Priority").selectOptions(testCase.getPriority());
        new Picklist("Is Flaky").selectOptions(testCase.getIsFlaky());
        new Picklist("Automation Status").selectOptions(testCase.getAutomationStatus());
    }
}