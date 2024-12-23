package tests;


import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {
    @Test
    public void logIn() {
        logInStep.logIn();
    }
    @Test
    public void createProject() {
        createNewProjectStep.createNewProject();
    }
    @Test
    public void deleteProject() {
        deleteProjectStep.deleteProject("Rustam");
    }
}
