package tests;

import DTO.TestCase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestCaseTest extends BaseTest {

    @Test
    public void createNewTestCase() {
        createNewTestCaseStep.createNewTestCase();
        $(By.cssSelector("a[aria-label='Open the test case 123-1']")).shouldBe(Condition.visible);
    }
}
