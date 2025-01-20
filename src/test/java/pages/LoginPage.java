package pages;

import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Log4j2
public class LoginPage {
    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_SIGN_IN = "Sign in";
    public void openPage() {
        log.info("Opening login page for authorization");
        open("login");
    }

    public void login() {
        log.info("Enter password and username");
        $(USER).setValue("rustam.shafikov87@gmail.com");
        $(PASSWORD).setValue("yw9tED49DSz@kcJ");
        $(byText(BUTTON_SIGN_IN)).click();
    }
}
