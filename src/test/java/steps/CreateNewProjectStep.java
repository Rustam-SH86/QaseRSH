package steps;

import pages.LoginPage;
import pages.ProjectsPage;
import tests.BaseTest;

public class CreateNewProjectStep {
    ProjectsPage projectsPage;
    LoginPage loginPage;

    public CreateNewProjectStep(ProjectsPage projectsPage, LoginPage loginPage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
    }
    public void createNewProject() {
        projectsPage.openPage();
       // projectsPage.waitTillOpened();
        loginPage.login();
        projectsPage.createNewProject();
    }

}
