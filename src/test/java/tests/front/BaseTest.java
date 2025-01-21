package tests.front;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.TestCasePage;
import steps.CreateNewProjectStep;
import steps.CreateNewTestCaseStep;
import steps.DeleteProjectStep;
import steps.LogInStep;
import utils.TestListener;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    public LogInStep logInStep;
    public CreateNewProjectStep createNewProjectStep;
    public DeleteProjectStep deleteProjectStep;
    public CreateNewTestCaseStep createNewTestCaseStep;
    protected ProjectsPage projectsPage;
    protected TestCasePage testCasePage;
    private LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Step("Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            Configuration.browserCapabilities = options;
            Configuration.browser = "chrome";
            Configuration.headless = false;
            Configuration.timeout = 100000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = "https://app.qase.io/";
        } else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions options = new SafariOptions();
            driver = new SafariDriver(options);
            Configuration.browser = "safari";
            Configuration.timeout = 100000;
            Configuration.baseUrl = "https://app.qase.io/";
            //Configuration.assertionMode = AssertionMode.valueOf("SOFT");
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

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