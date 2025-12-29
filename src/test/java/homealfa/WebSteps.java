package homealfa;

import homealfa.utils.RandomUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {


    String fullName = RandomUtils.getRandomFullName(),
            birthday = RandomUtils.getRandomBirthday(),
            telephone = RandomUtils.getRandomTelephone(),
            emailAdress = RandomUtils.getRandomMailAdress();

    @Step("Открыть страницу")
    public void openPage() {
        open("/");
        $("#retail-link").shouldHave(text("Частным лицам"));  // проверили наличие текта на странице
    }

    @Step("Проверка наличия разделов на стене")
    public void blockOptoins() {
        $(".avQWkTE#content[data-widget-name='Block']").shouldHave(text("Рассчитайте выгоду"), text("Выбирайте лучшее"), text("Получайте больше \n" +
                "с Альфа-Банком"), text("Сервисы"), text("О банке"));
    }

    @Step("Стать клиентом")
    public void clientOptions() {
        $("a.button__component_lr48d[data-widget-uid='01973fb6-4451-7ee7-bca0-07a6fd0c1aaa']").click();
        $(".aR7Oy1.KR7Oy1[data-test-id='TabsHeader-nakop-title']").click();
        $("#nakop").$(byText("Накопительный Альфа‑Счёт")).shouldHave(text("Накопительный Альфа‑Счёт"));
        $("a[href='/make-money/savings-account/alfa/?platformId=alfasite']").click();
    }

    @Step("Расчитать доход по депозиту")
    public void benifitsCalculat() {
        $("div[style='min-width:1200px']").$(byText("Рассчитайте свою выгоду")).shouldHave(text("Рассчитайте свою выгоду"));
        $("input[inputmode='decimal']").clear();
        $("input[inputmode='decimal']").setValue("2000000");
        $("div.brZeZZ").$(byText("% на ежедневный остаток")).click();
        $("div.brZeZZ").$(byText("Клиентам А-Клуба")).click();
        $("div.brZeZZ").$(byText("≥ 30 000 ₽")).click();
        $(".switch__switch_q0g3u.switch__switch_1ksul").click();
    }

    @Step("Заявка на карту")
    public void bid() {
        $("div.aZQWkTE[style='background-color:#F2F3F5']").shouldHave(text("Заполните заявку на Альфа‑Счёт"));
        $("div[style='width:558px;padding-left:97px;padding-right:97px']").$(byText("Альфа-Карта")).click();
    }

    @Step("Полное имя")
    public void fio() {
        $("input[name='fullName']").setValue(fullName);
    }

    @Step("Дата рождения")
    public void date() {
        $("input[aria-label='Дата рождения']").setValue(birthday);
    }

    @Step("Номер телефлна")
    public void number() {
        $("input[name='phone']").setValue(telephone);
    }

    @Step("Почта")
    public void mail() {
        $("input[name='email']").setValue(emailAdress).pressEnter();
    }

    @Step("Верхнее меню Частным лицам")
    public void menu() {
        $("#retail-link").hover();
    }

    @Step("Раздел Ипотека")
    public void ipotecaClik() {
        $(".btAB5o").$(byText("Ипотека")).click();
    }


}
