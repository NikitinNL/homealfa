package homealfa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://alfabank.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "firefox";
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 120000;

    }
}
