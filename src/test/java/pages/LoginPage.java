package pages;

import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {
    private static final String user = System.getProperty("user", PropertyReader.getProperty("user"));
    private static final String password = System.getProperty("password", PropertyReader.getProperty("password"));
    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_SIGN_IN = "Sign in";

    public void openPage() {
        log.info("Opening login page for authorization");
        open("login");
    }

    public void login() {
        log.info("Enter password and username");
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(BUTTON_SIGN_IN)).click();
    }
}
