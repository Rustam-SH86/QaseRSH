package tests.front;
import DTO.ProjectDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import tests.api.adapters.ProjectApi;
import tests.api.models.CreateProjectQase;
import tests.api.models.CreateProjectResponse;
import utils.Retry;

import static org.testng.Assert.*;

public class ProjectTest extends BaseTest {
    @Test(testName = "Авторизация", description = "Авторизация валидными данными")
    //@Tag("Smoke")
    public void logIn() {
        logInStep.logIn();
        String pageTitle = Selenide.title();
        System.out.println("Title of the page: " + pageTitle);
        assertEquals(pageTitle, "Qase", "Title does not match!");
    }

   // @Tag("Smoke")
    @Test(testName = "Создание проекта UI", description = "Создаем новый проект и после удаляем его через API")
    public void createProject() {
        try {
            ProjectDTO project = ProjectDTO.builder()
                    .projectName("TestProject")
                    .projectCode("QAB")
                    .build();
            createNewProjectStep.createNewProject(project);
            projectsPage.isProjectCreated(project).shouldBe(Condition.visible);

        } finally {
            ProjectApi.deleteProject("QAB");
        }
    }

   // @Tag("Smoke")
    @Test(testName = "Создание проекта UI с одинаковым значением в поле Code", description = "Создаем новый проект через API," +
            " а потом создаем такой же через UI. Ждем валидационную ошибку", retryAnalyzer = Retry.class)
    public void createProjectWithExistingName() {
        try {
            CreateProjectQase createProjectRequest = CreateProjectQase.builder()
                    .title("TestProject")
                    .code("QA")
                    .build();
            CreateProjectResponse response = ProjectApi.createProject(createProjectRequest);
            assertNotNull(response, "Response should not be null.");
            assertTrue(response.getStatus(), "Response status should be true.");
            assertNotNull(response.getResult(), "Result should not be null.");

            ProjectDTO project = ProjectDTO.builder()
                    .projectName("TestProject")
                    .projectCode("QA")
                    .build();
            createNewProjectStep.createNewProject(project);
            projectsPage.invalidCodeErrorMessage.shouldBe(Condition.visible)
                    .shouldHave(Condition.text("The selected project code is already in use."));
        } finally {
            ProjectApi.deleteProject("QA");
        }
    }

   // @Tag("Smoke")
    @Test(testName = "Удаление проекта UI", description = "Удаляем проект по кнопке Remove")
    public void deleteProject() {
        ProjectDTO project = ProjectDTO.builder()
                .projectName("TestProject")
                .projectCode("QA")
                .build();
        deleteProjectStep.deleteProjectStep(project);
        projectsPage.isProjectCreated(project).shouldNot(Condition.visible);
    }
}