package steps;

import dto.ProjectDTO;
import pages.LoginPage;
import pages.ProjectsPage;

public class DeleteProjectStep {
    private final ProjectsPage projectsPage;
    private final LoginPage loginPage;

    public DeleteProjectStep(ProjectsPage projectsPage, LoginPage loginPage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
    }

    public void deleteProjectStep(ProjectDTO project) {
        projectsPage.openPage();
        loginPage.login();
        projectsPage.deleteProject(project);
    }
}

