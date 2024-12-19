import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
    }
}