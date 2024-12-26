package steps;

import pages.LoginPage;
import pages.ProjectsPage;

public class LogInStep {
    LoginPage loginPage;
    ProjectsPage projectsPage;

    public LogInStep(LoginPage loginPage, ProjectsPage projectsPage) {
        this.loginPage = loginPage;
        this.projectsPage = projectsPage;
    }

    public void logIn() {
        loginPage.openPage();
        // projectsPage.waitTillOpened();
        loginPage.login();
    }
}
