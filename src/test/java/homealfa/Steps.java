package homealfa;

import homealfa.utils.RandomUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class Steps extends TestBase{
    StepsOptions stepsOptions = new StepsOptions();
    RandomUtils randomUtils = new RandomUtils();

    String fullName = RandomUtils.getRandomFullName(),
            birthday = RandomUtils.getRandomBirthday(),
            telephone = RandomUtils.getRandomTelephone(),
            emailAdress = RandomUtils.getRandomMailAdress();

    @Test  // Вариант 1
    @Tag("alfahome")
    @Feature("Проверка")
    @Story("Проверка отдельных модулей")
    @Owner("Nikitin")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing..../")
    @DisplayName("Проверка отдельных модулей")


    void Steps () {

        step("Открыть страницу", ()-> {
            stepsOptions
                    .openPage();  // открыли страницу и проверили наличие текста на стрнице
        });

        step("Проверка наличия разделов на странице", ()-> {
            stepsOptions
                    .blockOptoins();

                });

        step ("Стать клиентом", ()-> {
            stepsOptions
                    .clientOptions()
                    .benifitsCalculat();
        });

        step ("Заявка на карту", ()-> {
            stepsOptions
                    .bid()
                    .fio(fullName)
                    .date(birthday)
                    .number(telephone)
                    .mail(emailAdress);
        });

        step ("Навести курсор не нажимая и выбрать ипотеку", ()-> {
            stepsOptions
                    .menu()
                    .ipotecaClik();
        });
    }



    @Test  // Вариант 2
    @Tag("alfahome")
    @Feature("Проверка")
    @Story("Проверка отдельных модулей")
    @Owner("Nikitin")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing..../")
    @DisplayName("Проверка отдельных модулей")
    public void testAnnotatedSteps() {

        WebSteps steps = new WebSteps();

        steps.openPage();
        steps.blockOptoins();
        steps.clientOptions();
        steps.benifitsCalculat();
        steps.bid();
        steps.fio();
        steps.date();
        steps.number();
        steps.mail();
        steps.menu();
        steps.ipotecaClik();
    }

}
