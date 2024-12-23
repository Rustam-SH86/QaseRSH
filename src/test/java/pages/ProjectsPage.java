package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {
    public SelenideElement createNewProjectButton = $(".B9YsTi");
    public SelenideElement projectNameField = $("#project-name");
    public SelenideElement projectCodeField = $("#project-code");
    public SelenideElement createProjectButton = $(byText("Create project"));

    public ProjectsPage openPage() {
        open("projects");
        return this;
    }
    public void waitTillOpened() {
        $(byText("Create new project")).shouldBe(Condition.exist).shouldBe(visible);
    }
    public void createNewProject() {
        createNewProjectButton.shouldBe(visible).click();
        projectNameField.shouldBe(visible).setValue("Rustam");
        projectCodeField.shouldBe(visible).setValue("123");
        createProjectButton.shouldBe(Condition.enabled).click();
    }
    public void deleteProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(By.xpath("//span[text() = 'Delete project']")).shouldBe(visible).click();
    }
}
