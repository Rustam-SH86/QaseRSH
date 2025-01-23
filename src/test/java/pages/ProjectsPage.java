package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dto.ProjectDTO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Log4j2
public class ProjectsPage {
    public SelenideElement createNewProjectButton = $(By.xpath("//span[text() = 'Create new project']"));
    public SelenideElement projectNameField = $("#project-name");
    public SelenideElement projectCodeField = $("#project-code");
    public SelenideElement createProjectButton = $(byText("Create project"));
    public SelenideElement invalidCodeErrorMessage = $(By.xpath("//div[@class='FKqFlv']"));
    @Getter
    private ProjectDTO project;

    public SelenideElement isProjectCreated(ProjectDTO projectDTO) {
        return $(By.xpath("//h1[contains(text(), '" + projectDTO.getProjectName() + "')]"));
    }

    public ProjectsPage openPage() {
        log.info("Open base page");
        open("projects");
        return this;
    }

    public void createNewProject(ProjectDTO project) {
        log.info("Create new project");
        this.project = project;
        createNewProjectButton.shouldBe(visible).click();
        projectNameField.shouldBe(visible).setValue(project.getProjectName());
        projectCodeField.shouldBe(visible).setValue(project.getProjectCode());
        createProjectButton.shouldBe(Condition.enabled).click();
    }

    public void deleteProject(ProjectDTO project) {
        $(byText(project.getProjectName()))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(By.xpath("//span[text() = 'Delete project']")).shouldBe(visible).click();
    }
}
