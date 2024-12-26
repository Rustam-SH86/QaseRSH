package steps;

import DTO.ProjectDTO;
import pages.LoginPage;
import pages.ProjectsPage;

public class CreateNewProjectStep {
    private final ProjectsPage projectsPage;
    private final LoginPage loginPage;

    public CreateNewProjectStep(ProjectsPage projectsPage, LoginPage loginPage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
    }

    public void createNewProject(ProjectDTO project) {
        projectsPage.openPage();
        loginPage.login();
        projectsPage.createNewProject(project);
    }
}
