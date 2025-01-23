package tests.api.tests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import adapters.ProjectApi;
import models.CreateProjectQase;
import models.CreateProjectResponse;
import models.DeleteProjectResponse;
import static org.testng.Assert.*;

public class ProjectApiTest {
    @Test(testName = "Создание проекта через API", description = "Задаем параметры для создания нового проекта")
    @Tag("Smoke")
    public void testCreateProject() {
        CreateProjectQase createProjectRequest = CreateProjectQase.builder()
                .title("TestProject")
                .code("QA")
                .description("This is a test project.")
                .access("all")
                .build();
        CreateProjectResponse response = ProjectApi.createProject(createProjectRequest);
        assertNotNull(response, "Response should not be null.");
        assertTrue(response.getStatus(), "Response status should be true.");
        assertNotNull(response.getResult(), "Result should not be null.");
    }
    @Test(testName = "Удаление проекта через API", description = "Задаем имя проекта и удаляем его по средством API запроса")
    @Tag("Smoke")
    public void testDeleteProject() {
        DeleteProjectResponse response = ProjectApi.deleteProject("QA");
        assertNotNull(response, "Response should not be null.");
        assertTrue(response.getStatus(), "The deletion status should be true.");
    }
}

