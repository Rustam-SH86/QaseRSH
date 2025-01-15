package tests;


import DTO.ProjectDTO;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class ProjectTest extends BaseTest {
    @Test
    public void logIn() {
        logInStep.logIn();
    }

    @Test
    public void createProject() {
        ProjectDTO project = ProjectDTO.builder()
                .projectName("TestProject")
                .projectCode("TP123")
                .build();
        createNewProjectStep.createNewProject(project);
        $(By.xpath("//h1[contains(text(), '" + project.getProjectCode() + "')]")).shouldBe(Condition.visible);
    }

    @Test
    public void deleteProject() {
        ProjectDTO project = ProjectDTO.builder()
                .projectName("TestProject")
                .build();
        deleteProjectStep.deleteProjectStep(project);
        $(By.xpath("//h1[contains(text(), '" + project.getProjectName() + "')]"))
                .shouldNot(Condition.visible);
    }
}