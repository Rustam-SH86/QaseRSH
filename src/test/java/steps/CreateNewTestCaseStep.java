package steps;

import DTO.ProjectDTO;
import DTO.TestCaseDTO;
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

    public void createNewTestCase(ProjectDTO projectDTO, TestCaseDTO testCaseDTO) {
        projectsPage.openPage();
        loginPage.login();
        projectsPage.createNewProject(projectDTO);
        testCasePage.createTestCase(testCaseDTO);
    }
}
