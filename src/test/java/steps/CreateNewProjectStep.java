package steps;

import dto.ProjectDTO;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;
import pages.ProjectsPage;


@Log4j2
public class CreateNewProjectStep {
    private final ProjectsPage projectsPage;
    private final LoginPage loginPage;

    public CreateNewProjectStep(ProjectsPage projectsPage, LoginPage loginPage) {
        this.projectsPage = projectsPage;
        this.loginPage = loginPage;
    }

    public void createNewProject(ProjectDTO project) {
        log.info("Starting the process of creating a new project: {}", project.getProjectName());
        try {
            log.info("Opening projects page...");
            projectsPage.openPage();
            log.info("Logging into the application...");
            loginPage.login();
            log.info("Creating a new project with the provided details.");
            projectsPage.createNewProject(project);
            log.info("New project '{}' created successfully.", project.getProjectName());
        } catch (Exception e) {
            log.error("Failed to create a new project '{}'. Error: {}", project.getProjectName(), e.getMessage(), e);
        }
    }
}
