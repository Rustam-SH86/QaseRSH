package tests;

import DTO.ProjectDTO;
import DTO.TestCaseDTO;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class TestCaseTest extends BaseTest {

    @Test
    public void createNewTestCase() {
        ProjectDTO project = ProjectDTO.builder()
                .projectName("TestProject")
                .projectCode("TP123")
                .build();
        createNewProjectStep.createNewProject(project);
        TestCaseDTO testCaseDTO = TestCaseDTO.builder()
                .Status("Draft")
                .Type("Smoke")
                .Severity("Major")
                .Layer("API")
                .Behavior("Negative")
                .Priority("High")
                .IsFlaky("Yes")
                .AutomationStatus("Automated")
                .build();
        testCasePage.createTestCase(testCaseDTO);
        $(By.cssSelector("a[aria-label='Open the test case " + project.getProjectCode() + "-1']")).shouldBe(Condition.visible);
    }
}
