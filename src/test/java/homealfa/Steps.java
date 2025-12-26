package homealfa;

import homealfa.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class Steps extends TestBase{
    StepsOptions stepsOptions = new StepsOptions();
    RandomUtils randomUtils = new RandomUtils();

    String fullName = RandomUtils.getRandomFullName(),
            birthday = String.valueOf(RandomUtils.getRandomBirthday()),
            telephone = RandomUtils.getRandomTelephone(),
            emailAdress = RandomUtils.getRandomMailAdress();

    @Test
    @Tag("alfahome")
    @DisplayName("Проверка главной страницы")

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

}
