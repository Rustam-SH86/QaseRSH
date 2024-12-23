package steps;

import pages.LoginPage;
import pages.ProjectsPage;

public class DeleteProjectStep {
    ProjectsPage projectsPage;
    LoginPage loginPage;

    public DeleteProjectStep(ProjectsPage projectsPage, LoginPage loginPage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
    }
    public void deleteProject(String projectName) {
        projectsPage.openPage();
        loginPage.login();
        projectsPage.deleteProject(projectName);

    }
}
