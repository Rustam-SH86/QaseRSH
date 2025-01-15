package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.TestCasePage;
import steps.CreateNewProjectStep;
import steps.CreateNewTestCaseStep;
import steps.DeleteProjectStep;
import steps.LogInStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public LogInStep logInStep;
    public CreateNewProjectStep createNewProjectStep;
    public DeleteProjectStep deleteProjectStep;
    public CreateNewTestCaseStep createNewTestCaseStep;
    protected ProjectsPage projectsPage;
    protected TestCasePage testCasePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 100000;
        Configuration.clickViaJs = true;
        Configuration.baseUrl = "https://app.qase.io/";
        //Configuration.assertionMode = AssertionMode.valueOf("SOFT");
        //WebDriver driver = new ChromeDriver();
        //setWebDriver(driver);
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        testCasePage = new TestCasePage();

        logInStep = new LogInStep(loginPage, projectsPage);
        createNewProjectStep = new CreateNewProjectStep(projectsPage, loginPage);
        deleteProjectStep = new DeleteProjectStep(projectsPage, loginPage);
        createNewTestCaseStep = new CreateNewTestCaseStep(projectsPage, loginPage, testCasePage, createNewProjectStep);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}