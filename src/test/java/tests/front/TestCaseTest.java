package tests.front;

import DTO.ProjectDTO;
import DTO.TestCaseDTO;
import com.codeborne.selenide.Condition;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import tests.api.adapters.ProjectApi;


public class TestCaseTest extends BaseTest {
    @Test(testName = "Создание нового тест-кейса", description = "Сначала создаем новый проект и далее новый тест-кейс, в конце " +
            "удаляем проект через API")
    @Tag("Smoke")
    public void createNewTestCase() {
        try {
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
            testCasePage.isTestCaseCreated(project).shouldBe(Condition.visible);
        }
        finally {
            ProjectApi.deleteProject("TP123");
        }
    }
}
