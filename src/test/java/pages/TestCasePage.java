package pages;

import DTO.ProjectDTO;
import DTO.TestCaseDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import wrappers.Picklist;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class TestCasePage {
    public SelenideElement createNewCaseButton = $(By.xpath("//span[text() = 'Create new case']"));
    public SelenideElement saveCaseButton = $(By.id("save-case"));
    public SelenideElement titleField = $("#title");
    public SelenideElement isTestCaseCreated(ProjectDTO projectDTO) {
     return $(By.cssSelector("a[aria-label='Open the test case " + projectDTO.getProjectCode() + "-1']"));
   }
    public void createTestCase(TestCaseDTO testCaseDTO) {
        log.info("Create new test case");
        createNewCaseButton.shouldBe(Condition.visible).click();
        titleField.shouldBe(Condition.visible).setValue("Creation of test case");
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