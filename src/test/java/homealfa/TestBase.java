package homealfa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import homealfa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://alfabank.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "firefox";
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 120000;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; // при локальном запуске, запуск будет в selenoid с логиным и паролем

        DesiredCapabilities capabilities = new DesiredCapabilities();    // Задаем для селиноида набор опций,
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVidio", true
        ));   // enableVNC - потоковое видео, демонстрация при запуске.  enableVidio - запись видео

        Configuration.browserCapabilities = capabilities;   // передали настройки в этот блок
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());   // Детализированные шаги в аллюр отчете
    }

    @AfterEach   // вызываем функции Attachments:
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");   // скриншот
        Attach.pageSource();            // код страницы
        Attach.browserConsoleLogs();   // Логи
        Attach.addVideo();             // Видео
    }
}
