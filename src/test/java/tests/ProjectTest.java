import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTest extends BaseTest{
    @Test
    public void createProject() {
        open("https://app.qase.io/");
        $("[name=email]").setValue("sam024513@gmail.com");
        $("[name=password]").setValue("01101982adam");
        $(byText("Sigh in")).click();
    }
}
