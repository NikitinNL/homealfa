package homealfa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsOptions {

    // SelenideElements / locator / etc

    SelenideElement clientText = $("#retail-link"),
            block = $(".avQWkTE#content[data-widget-name='Block']"),
            client = $("a.button__component_lr48d[data-widget-uid='01973fb6-4451-7ee7-bca0-07a6fd0c1aaa']"),
            savings = $(".aR7Oy1.KR7Oy1[data-test-id='TabsHeader-nakop-title']"),
            nacopit = $("#nakop").$(byText("Накопительный Альфа‑Счёт")),
            openSchet = $("a[href='/make-money/savings-account/alfa/?platformId=alfasite']"),
            benefits = $("div[style='min-width:1200px']").$(byText("Рассчитайте свою выгоду")),
            summ = $("input[inputmode='decimal']"),
            deyRemainder = $("div.brZeZZ").$(byText("% на ежедневный остаток")),
            clubA = $("div.brZeZZ").$(byText("Клиентам А-Клуба")),
            expenses = $("div.brZeZZ").$(byText("≥ 30 000 ₽")),
            togl = $(".switch__switch_q0g3u.switch__switch_1ksul"),
            bidChet = $("div.aZQWkTE[style='background-color:#F2F3F5']"),
            type = $("div[style='width:558px;padding-left:97px;padding-right:97px']").$(byText("Альфа-Карта")),
            bidFio = $("input[name='fullName']"),
            birthdayDate = $("input[aria-label='Дата рождения']"),
            telephoneNumber = $("input[name='phone']"),
            email = $("input[name='email']"),
            menuUp = $("#retail-link"),
            ipoteca = $(".btAB5o").$(byText("Ипотека"));


    // Actions

    public StepsOptions openPage() {
        open("/");    // открыли страницу

        clientText.shouldHave(text("Частным лицам"));  // проверили наличие текта на странице
        return this;
    }

    public StepsOptions blockOptoins() {
        block.shouldHave(text("Рассчитайте выгоду"), text("Выбирайте лучшее"), text("Получайте больше \n" +
                "с Альфа-Банком"), text("Сервисы"), text("О банке"));
        return this;
    }

    public StepsOptions clientOptions() {
        client.click();
        savings.click();
        nacopit.shouldHave(text("Накопительный Альфа‑Счёт"));
        openSchet.click();
        return this;
    }

    public StepsOptions benifitsCalculat() {
        benefits.shouldHave(text("Рассчитайте свою выгоду"));
        summ.clear();
        summ.setValue("2000000");
        deyRemainder.click();
        clubA.click();
        expenses.click();
        togl.click();
        return this;
    }

    public StepsOptions bid() {
        bidChet.shouldHave(text("Заполните заявку на Альфа‑Счёт"));
        type.click();
        return this;
    }

    public StepsOptions fio(String fullName) {
        bidFio.setValue(fullName);
        return this;
    }

    public StepsOptions date(String birthday) {
        birthdayDate.setValue(birthday);
        return this;
    }

    public StepsOptions number(String telephone) {
        telephoneNumber.setValue(telephone);
        return this;
    }

    public StepsOptions mail(String emailAdress) {
        email.setValue(emailAdress).pressEnter();
        return this;
    }

    public StepsOptions menu () {
        menuUp.hover();
        return this;
    }

    public StepsOptions ipotecaClik() {
        ipoteca.click();
        return this;
    }

}
