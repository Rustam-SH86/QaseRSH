package steps;

import pages.LoginPage;
import pages.ProjectsPage;
import pages.TestCasePage;

public class CreateNewTestCaseStep {
    ProjectsPage projectsPage;
    LoginPage loginPage;
    TestCasePage testCasePage;

    public CreateNewTestCaseStep(ProjectsPage projectsPage, LoginPage loginPage,TestCasePage testCasePage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
        this.testCasePage = testCasePage;
    }
    public void createNewTestCase() {
        projectsPage.openPage();
        loginPage.login();
        projectsPage.createNewProject();
        testCasePage.createTestCase();

    }
}
