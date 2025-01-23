package steps;

import dto.ProjectDTO;
import dto.TestCaseDTO;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.TestCasePage;

public class CreateNewTestCaseStep {
    ProjectsPage projectsPage;
    LoginPage loginPage;
    TestCasePage testCasePage;
    CreateNewProjectStep createNewProjectStep;

    public CreateNewTestCaseStep(ProjectsPage projectsPage, LoginPage loginPage, TestCasePage testCasePage, CreateNewProjectStep createNewProjectStep) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
        this.testCasePage = testCasePage;
        this.createNewProjectStep = createNewProjectStep;
    }

    @Step("Create new test case")
    public void createTestCaseStep(ProjectDTO projectDTO, TestCaseDTO testCaseDTO) {
        createNewProjectStep.createNewProject(projectDTO);
        testCasePage.createTestCase(testCaseDTO);
    }
}
